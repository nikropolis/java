package skj_task1;

import java.io.*;
import java.net.*;

public class TCPClient {

	private Socket clientSocket;
	private InetSocketAddress sockaddr;
	private BufferedReader inFromServer;
//	private String ip;
//	private int port;
	private String ServerSentence;
	
	public TCPClient(String ip , int port ){
//		this.ip = ip;
//		this.port = port;
		
		sockaddr = new InetSocketAddress(ip, port);
		clientSocket = new Socket();
	}


	public void sendMOD(Pack pack) throws ClassNotFoundException {
		try {
			clientSocket.connect(sockaddr, 5000);
			ServerSentence = "";
			
			ObjectOutputStream objectOutput = new ObjectOutputStream(clientSocket.getOutputStream());
			objectOutput.writeObject(pack);
			//we send our modifycations to our neighbour
			
			inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			ServerSentence = inFromServer.readLine();
			System.out.println(" : FROM SERVER: " + ServerSentence);

			clientSocket.close();
			
		} catch (IOException e) {System.out.println(" ! Error: " + e);}
	}//sendMOD
	
	public Tree sendALT(Pack pack) {
		Tree tmpTree = null;
		try {
			clientSocket.connect(sockaddr, 5000);
			ServerSentence = "";
			
			ObjectOutputStream objectOutput = new ObjectOutputStream(clientSocket.getOutputStream());
			objectOutput.writeObject(pack);
			//we send our Ask for his Local Tree
			
			ObjectInputStream objectInput = new ObjectInputStream(clientSocket.getInputStream());
            Object object = (Tree) objectInput.readObject();
            tmpTree = (Tree) object;
            // now we have a localtree of your neighbour 
            
            clientSocket.close();
			
		} catch (IOException e) {System.out.println(" ! Error: " + e);
		} catch (ClassNotFoundException e) {System.out.println(" ! Error: " + e);}

        return tmpTree;
	}//sendALT

}
