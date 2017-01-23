package test_network_UDP_send_obj;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class Server  implements Runnable {
	private byte[] receiveData;
	private DatagramSocket socket;
	private DatagramPacket packet;

	public Server(int port) {
		try {
			receiveData = new byte[1024];
			socket = new DatagramSocket(port);
		} catch (SocketException e) {}
	}

	public void run() {
		while (true) {
			
			try {
				packet = new DatagramPacket(receiveData, receiveData.length);
				
				socket.receive(packet);
			
				int len = 0;
				// byte[] -> int
				for (int i = 0; i < 4; ++i) {
				    len |= (receiveData[3-i] & 0xff) << (i << 3);
				}
			    
				// now we know the length of the payload
			    byte[] buffer = new byte[len];
			    packet = new DatagramPacket(buffer, buffer.length );
			    socket.receive(packet);

			    ByteArrayInputStream baos = new ByteArrayInputStream(buffer);
			    ObjectInputStream oos = new ObjectInputStream(baos);
			    Pack pack = (Pack)oos.readObject();
				  
				String modifiedSentence = "[str: "+pack.str + ", id: "+pack.id+"]";
				System.out.println("FROM Client:" + modifiedSentence);
			} catch (IOException | ClassNotFoundException e) {}
			
		}
	}
}
