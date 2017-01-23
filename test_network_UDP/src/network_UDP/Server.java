package network_UDP;

import java.io.*;
import java.net.*;

public class Server {

	public static class reciever implements Runnable {
		private byte[] receiveData;
		private DatagramSocket sock;
		private DatagramPacket pack;

		public reciever(int port) {
			try {
				receiveData = new byte[1024];
				sock = new DatagramSocket(port);
				pack = new DatagramPacket(receiveData, receiveData.length);
			} catch (SocketException e) {}
		}

		public void run() {
			while (true) {
				DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
				try {
					sock.receive(receivePacket);
				} catch (IOException e) {}
				
				String modifiedSentence = new String(receivePacket.getData());
				System.out.println("FROM sender:" + modifiedSentence);
			}
		}
	}
	
	public static class sender implements Runnable {		
		private byte[] sendData;
		private BufferedReader inFromUser;
		private DatagramSocket sock;
		private InetAddress IPAddress;
		private int port;
		
		public sender(int port, String ip) {
			try {
				sendData = new byte[1024];
				inFromUser = new BufferedReader(new InputStreamReader(System.in));
				sock = new DatagramSocket();
				IPAddress = InetAddress.getByName(ip);
				this.port = port;
			} catch (SocketException e) {
			} catch (UnknownHostException e) {}
		}

		public void run() {
			while (true) {
				String sentence;		
				try {
					sentence = inFromUser.readLine();
					sendData = sentence.getBytes();
					DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, port);
					sock.send(sendPacket);
				} catch (IOException e) {}
			}
		}
	}
	
	public static void main(String args[]) throws Exception {
		// 172.22.232.21
		// 127.0.0.1
		InetAddress ip = InetAddress.getLocalHost();
		System.out.println(ip.getHostName());
		System.out.println(ip.getHostAddress());
		
		new Thread(new reciever(20000)).start();
		new Thread(new sender(20000,"127.0.0.1")).start();
		
	}
}