package network_TCP;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class Client implements Runnable {

	private String sentence;
	private String serverSentence;
	private BufferedReader inFromUser;
	private Socket clientSocket;
	private DataOutputStream outToServer;
	private BufferedReader inFromServer;
	private boolean on;
	private int port;
	private String ip;

	public Client(int port, String ip) {
		this.port = port;
		this.ip = ip;
		on = true;
	}

	@Override
	public void run() {

		while (on) {
			try {
				try {
					clientSocket = new Socket(ip, port);
				} catch (IOException e) {
					e.printStackTrace();
				}
				inFromUser = new BufferedReader(new InputStreamReader(System.in));
				outToServer = new DataOutputStream(clientSocket.getOutputStream());
				inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
				sentence = inFromUser.readLine();
				
				if (sentence.equals("exit"))
					on = false;
				
				outToServer.writeBytes(sentence + '\n');
				serverSentence = inFromServer.readLine();
				System.out.println("FROM SERVER: " + serverSentence);

				// clientSocket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}

}
