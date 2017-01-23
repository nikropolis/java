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
import java.security.PublicKey;
import java.util.ArrayList;

public class UDPListener implements Runnable {
	private byte[] receiveData;
	private DatagramSocket socket;
	private DatagramPacket packet;
	private Handler handler;
	private boolean running;
	private Thread thread;
	public String ip;
	public int port;

	public UDPListener(int port, Handler handler) {
		this.handler = handler;
		this.port = port;
		try {
			receiveData = new byte[1024];
			socket = new DatagramSocket(port);
			this.ip = socket.getLocalAddress().getHostAddress();
		} catch (SocketException e) {
		}
		running = true;
		System.out.println("[listener][" + this.ip + "][" + this.port + "]: start to listen");
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
				case 'l': // list
					handler.list = (ArrayList<Persona>) pack.obj;
					handler.gui.refresh_list();
					break;
				case 'e': // enter
					String enter = handler.rsa.decrypt(pack.msg);
					handler.server.publicKey = (PublicKey) pack.obj;
					if (enter.equals("enter")) {
						handler.gui.enter();
					}
					break;
				case 'q': // quest
					String nonce = handler.rsa.decrypt(pack.msg);

					Pack a_pack = new Pack();
					a_pack.type = 'a'; // answer
					a_pack.msg = handler.rsa.encrypt(nonce, handler.server.publicKey);
					//////////////////////////////// SEND
					ByteArrayOutputStream baos1 = new ByteArrayOutputStream();
					ObjectOutputStream oos1 = new ObjectOutputStream(baos1);
					oos1.writeObject(a_pack);
					oos1.flush();
					// get the byte array of the object
					String s_ip = handler.server.ip;
					InetAddress adress = InetAddress.getByName(s_ip);
					int s_port = handler.server.port;
					
					byte[] Buf = baos1.toByteArray();
					int number = Buf.length;
					byte[] data = new byte[4];
					// int -> byte[]
					for (int i = 0; i < 4; ++i) {
						int shift = i << 3; // i * 8
						data[3 - i] = (byte) ((number & (0xff << shift)) >>> shift);
					}
					DatagramPacket packet = new DatagramPacket(data, 4, adress, s_port);
					socket.send(packet);
					// now send the payload
					packet = new DatagramPacket(Buf, Buf.length, adress, s_port);
					socket.send(packet);
					break;
				case 'm': // message
					String sender = pack.alias;
					String msg = handler.rsa.decrypt(pack.msg);
					String text = "[ " + sender + " ]:\t" + msg + "\n";
					if(text.length()>75)
						text = text.substring(0, 75) + '\n' + text.substring(76);
					handler.gui.add_to_display(text);
					break;
				default:
					break;
				}
				// String modifiedSentence = new String(packet.getData());
				// System.out.println("FROM SERVER:" + modifiedSentence);
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
