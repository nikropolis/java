package network_TCP;

import java.io.*;
import java.net.*;

public class Server implements Runnable {

	private String clientSentence;
	private String capitalizedSentence;
	private ServerSocket welcomeSocket;
//	private Socket connectionSocket;
//	private BufferedReader inFromClient;
//	private DataOutputStream outToClient;

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
				Socket connectionSocket;
				try {
					connectionSocket = welcomeSocket.accept();

					BufferedReader inFromClient = new BufferedReader(
							new InputStreamReader(connectionSocket.getInputStream()));
					DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());

					clientSentence = inFromClient.readLine();
					System.out.println("Received: " + clientSentence);

					capitalizedSentence = clientSentence.toUpperCase() + '\n';
					outToClient.writeBytes(capitalizedSentence);

				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
	}
}
