package test_network_TCP_send_obj;

import java.io.*;
import java.net.*;

public class Server implements Runnable {

	private String clientSentence;
	private String capitalizedSentence;
	private ServerSocket welcomeSocket;
	private Socket connectionSocket;
//	private BufferedReader inFromClient;
	private DataOutputStream outToClient;
	
	public Server(int port) {
		try {
			welcomeSocket = new ServerSocket(port);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		while (true) {
			try {
				connectionSocket = welcomeSocket.accept();
//				inFromClient = new BufferedReader(
//						new InputStreamReader(connectionSocket.getInputStream()));
				outToClient = new DataOutputStream(connectionSocket.getOutputStream());
//				clientSentence = inFromClient.readLine();
				
	                try {
	                	ObjectInputStream objectInput = new ObjectInputStream(
	                			connectionSocket.getInputStream());
	                    Object object = (Pack) objectInput.readObject();
	                    Pack tmp = (Pack) object;
	                    clientSentence = tmp.ip;
	                    
	                } catch (ClassNotFoundException e) {
	                    e.printStackTrace();
	                }
				
				System.out.println("Received: " + clientSentence);
				capitalizedSentence = clientSentence.toUpperCase() + '\n';
				outToClient.writeBytes(capitalizedSentence);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
}
