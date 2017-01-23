package test_network_TCP_send_obj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.net.Socket;


public class Client implements Runnable  {

//	private String sentence;
	private String modifiedSentence;
//	private BufferedReader inFromUser;
	private Socket clientSocket;
//	private DataOutputStream outToServer;
	private BufferedReader inFromServer;
	
	public Client(int port, String ip){
		try {
//			inFromUser = new BufferedReader(new InputStreamReader(System.in));
			clientSocket = new Socket(ip, port);
//			outToServer = new DataOutputStream(clientSocket.getOutputStream());
			inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		try {
//			sentence = inFromUser.readLine();
//			outToServer.writeBytes(sentence + '\n');
//			modifiedSentence = inFromServer.readLine();
			
			ObjectOutputStream objectOutput = new ObjectOutputStream(clientSocket.getOutputStream());
			Pack s_pack = new Pack("client pack",1);
			s_pack.setType("TEST");
			objectOutput.writeObject(s_pack);
			
			modifiedSentence = inFromServer.readLine();	
			System.out.println("FROM SERVER: " + modifiedSentence);
			clientSocket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
