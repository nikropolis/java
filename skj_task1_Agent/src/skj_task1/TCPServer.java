package skj_task1;

import java.io.*;
import java.net.*;
import java.util.ArrayList;

public class TCPServer implements Runnable {

	private String serverSentence;
	private ServerSocket welcomeSocket;
	private Socket connectionSocket;
	private DataOutputStream outToClient;
	private ObjectOutputStream objectOutput;
	private ArrayList<Agent> globalForest;
	private boolean running;
	
	public TCPServer(int port, ArrayList<Agent> GT) {
		running = true;
		this.globalForest= GT;
		
		try {
			welcomeSocket = new ServerSocket(port);
		} catch (IOException e) {
			System.out.println(" ! Error: " + e);
			return;
		}finally{
			System.out.println(" . set agent server on port:" + port);
		}
		
	}
	
    public void terminate() {
        running = false;
    }
    
	@Override
	public void run() {
		while (running) {
			try {
				//catch new connection
				connectionSocket = welcomeSocket.accept();
				
				//need to know who you are!
				String ourIp = globalForest.get(0).ip;
				int ourPort = globalForest.get(0).port;
				Tree ourTree = globalForest.get(0).tree;
				
				System.out.println(" . accept ["+connectionSocket.getInetAddress().getHostAddress()+"]["+connectionSocket.getPort()+"]");
				
				//receive tha package
            	ObjectInputStream objectInput = new ObjectInputStream(
            			connectionSocket.getInputStream());
                Object object = (Pack) objectInput.readObject();
                Pack pack = (Pack) object;
                
                //set the client data
                String client_ip = pack.ip;
                int client_port = pack.port;
                
				//check if it your neighbour
                Agent neighbour = null;
                for(int i = 0; i < globalForest.size(); i++) // do we know you?
                {                	
                	if( globalForest.get(i).ip.equals( client_ip ) ) // Agent with your ip
                		if( globalForest.get(i).port == client_port ){ // and your port
                			neighbour = globalForest.get(i); // if yes, cool! Now we know you. So breack and continue

                			System.out.println(" . Hi neighbour ["+client_ip+"]["+client_port+"]");
                			break;
                		}
                	
                	if(i == globalForest.size()-1){	 //if not, create a new Agent for your new neighbour
                		neighbour = new Agent();
                		neighbour.ip = client_ip;
                		neighbour.port = client_port;
                		
                		// make ALT (Ask for a Local Tree) packege
                		Pack tmp_pack = new Pack(ourIp, ourPort);
                		tmp_pack.setType("ALT");
                		
                		// send it to unknown neighbour 
                		TCPClient client = new TCPClient(client_ip, client_port);
                		neighbour.tree = client.sendALT(tmp_pack); //put recieved Tree
                		
                		// and add new Agent to our GL (Global Tree)
                		globalForest.add( neighbour );
                		
                		// add him to our locatTree
            			int number = ourTree.getChild("neighbours").getChildSize()+1;
            			Tree tmpTree = new Tree("agent " + number);
            			tmpTree.setChild( new Tree("ip") );
            			tmpTree.getChild("ip").setChild( new Tree (client_ip) );
            			tmpTree.setChild( new Tree("port") );
            			tmpTree.getChild("port").setChild( new Tree (""+client_port) );
            			ourTree.getChild("neighbours").setChild(tmpTree);
                	}	
                }
                
				//answer
                String packType = pack.getType();
                
				if( packType.equals("ALT") ){ //ask for Sending a Local Tree
					objectOutput = new ObjectOutputStream(connectionSocket.getOutputStream());
					objectOutput.writeObject( ourTree ); // send our localTree
				}
				else if( packType.equals("MOD") ){ // report about agent modifycations 
					Object tmp_obj = pack.getPack();
					String modifycation = (String) tmp_obj;

					//add modification to naighbour tree
					if(neighbour.tree != null){
						CommandParser cp = new CommandParser(globalForest,neighbour.tree);
						cp.parse(modifycation);
					}
					serverSentence = "resieved modifycations";
					outToClient = new DataOutputStream(connectionSocket.getOutputStream());
					outToClient.writeBytes( serverSentence  + '\n');
				}
				else{
					serverSentence = "#!@/.";
					outToClient = new DataOutputStream(connectionSocket.getOutputStream());
					outToClient.writeBytes(serverSentence + '\n');
				}
				
			} catch (IOException e) {System.out.println(" ! Error: " + e);
			} catch (ClassNotFoundException e) {System.out.println(" ! Error: " + e);}
		}//while()
	}//run()

}
