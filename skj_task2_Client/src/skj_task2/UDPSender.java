package skj_task2;

import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class UDPSender {
	private DatagramSocket socket;
	private InetAddress adress;
	private int port;

	public UDPSender(String ip, int port) {
		try {
			this.port = port;
			socket = new DatagramSocket();
			adress = InetAddress.getByName(ip);

		} catch (SocketException | UnknownHostException e) {
			e.printStackTrace();
		}
	}

	public void send(Pack pack) {
		try {
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			ObjectOutputStream oos = new ObjectOutputStream(baos);
			oos.writeObject(pack); 
			oos.flush();
			// get the byte array of the object
			byte[] Buf = baos.toByteArray();

			int number = Buf.length;
			;
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

			System.out.println("[sender]: the sending is done");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
