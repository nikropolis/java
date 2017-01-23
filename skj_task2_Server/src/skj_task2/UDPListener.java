package skj_task2;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class UDPListener implements Runnable {
	private byte[] receiveData;
	private DatagramSocket socket;
	private DatagramPacket packet;
	private Handler handler;
	private Thread thread;
	private boolean running;

	public UDPListener(int port, Handler handler) {
		this.handler = handler;
		try {
			receiveData = new byte[1024];
			socket = new DatagramSocket(port);
		} catch (SocketException e) {
		}
		running = true;
		System.out.println("[listener]: start to listen");
	}

	public void run() {
		while (running) {

			try {
				packet = new DatagramPacket(receiveData, receiveData.length);

				socket.receive(packet);

				int len = 0;
				// byte[] -> int
				for (int i = 0; i < 4; ++i) {
					len |= (receiveData[3 - i] & 0xff) << (i << 3);
				}

				// now we know the length of the payload
				byte[] buffer = new byte[len];
				packet = new DatagramPacket(buffer, buffer.length);
				socket.receive(packet);

				ByteArrayInputStream baos = new ByteArrayInputStream(buffer);
				ObjectInputStream oos = new ObjectInputStream(baos);
				Pack pack = (Pack) (oos.readObject());

				System.out.println("[receive pack]:"+pack.type);
				switch (pack.type) {
				case 'c': 
					Persona persona = (Persona) pack.obj;
					String new_alias = persona.alias;
					boolean persona_bool = true;
					for (int i = 0; i < handler.list.size(); i++) {
						Persona p = handler.list.get(i);
						if (p.alias.equals(new_alias)) {
							persona_bool = false;
							System.out.println("[system]: alias already in use");
							break;
						}
					}
					if(persona_bool){
						handler.list.add(persona);
						UDPSender sender = new UDPSender(persona.ip, persona.port);
						Pack confirm_pack = new Pack();
						confirm_pack.type = 'e';
						confirm_pack.msg = handler.rsa.encrypt("enter", persona.publicKey);
						confirm_pack.obj = handler.rsa.publicKey;
						
						System.out.println("[new alias]: "+new_alias);
						sender.send(confirm_pack);
						
						handler.delivery.close(); 
						handler.delivery.start();
					}
					break;
					
				case 'r': { // refresh
					Persona old_persona = null;
					String alias = pack.alias;
					
					
					int persona_id = 0;
					for (int i = 0; i < handler.list.size(); i++) {
						Persona p = handler.list.get(i);
						if (p.alias.equals(alias)) {
							old_persona = p;
							persona_id = i;
						}
					}

					System.out.println("[chamged] "+ old_persona.alias +" -> " + alias);
					if (old_persona != null) {
						int rand = (int) (Math.random() * 1000);
						String nonce = "srvr" + rand;
						
						Pack r_pack = new Pack();
						r_pack.type = 'q';
						r_pack.msg = handler.rsa.encrypt(nonce, old_persona.publicKey);
//						r_pack.obj = handler.rsa.publicKey;
						
						Persona new_persona = (Persona) pack.obj;
						String ip = old_persona.ip;
						InetAddress adress = InetAddress.getByName(ip);
						int port = new_persona.port;
						////////////////////////////// send request
						ByteArrayOutputStream baos1 = new ByteArrayOutputStream();
						ObjectOutputStream oos1 = new ObjectOutputStream(baos1);
						oos1.writeObject(r_pack);
						oos1.flush();
						// get the byte array of the object
						byte[] Buf = baos1.toByteArray();
						int number = Buf.length;
						byte[] data = new byte[4];
						// int -> byte[]
						for (int i = 0; i < 4; ++i) {
							int shift = i << 3; // i * 8
							data[3 - i] = (byte) ((number & (0xff << shift)) >>> shift);
						}
						DatagramPacket packet = new DatagramPacket(data, 4, adress, port);
						socket.send(packet);
						// now send the payload
						packet = new DatagramPacket(Buf, Buf.length, adress, port);
						socket.send(packet);
						///////////////////////////////////////////////////// now
						///////////////////////////////////////////////////// resieve
						packet = new DatagramPacket(receiveData, receiveData.length);
						socket.receive(packet);
						len = 0;
						// byte[] -> int
						for (int i = 0; i < 4; ++i) {
							len |= (receiveData[3 - i] & 0xff) << (i << 3);
						}
						// now we know the length of the payload
						buffer = new byte[len];
						packet = new DatagramPacket(buffer, buffer.length);
						socket.receive(packet);

						baos = new ByteArrayInputStream(buffer);
						oos = new ObjectInputStream(baos);
						pack = (Pack) (oos.readObject());

						String result = handler.rsa.decrypt(pack.msg);
						if (result.equals(nonce)){
							handler.list.set(persona_id, new_persona);
							
							handler.delivery.close(); 
							handler.delivery.start();
						}
					}
				}
					break;
					
				default:
					break;
				}
				
			} catch (IOException | ClassNotFoundException e) {
			}
		}
	}

	public void start(){
		thread = new Thread(this);
		thread.start();
	}
	public void close() {
		running = false;
		thread.interrupt();
	}
	public boolean isActive(){
		return thread != null;
	}
}
