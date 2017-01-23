package skj_task1;

import java.util.ArrayList;

public class NeighbourCheck {

	private ArrayList<Agent> globalForest;
	private Tree neighbours;
	
	public NeighbourCheck(ArrayList<Agent> GF){
		globalForest = GF;
		neighbours = globalForest.get(0).tree.getChild("neighbours");
	}
	
	public void set(){
		int  length = neighbours.getChildSize();
		
		for(int i = 0; i < length; i++){
			Agent neighbour = new Agent();
			Tree tmpTree = neighbours.getChild(i);
			
			neighbour.ip = tmpTree.getChild("ip").getValue();
			neighbour.port = Integer.parseInt( tmpTree.getChild("port").getValue() );
			
			globalForest.add(neighbour);
			System.out.println(" . add neighbour ["+neighbour.ip+"]["+neighbour.port+"]");
		}
	}
	
	public void check(){
		String ourIp = globalForest.get(0).ip;
		int ourPort = globalForest.get(0).port;
		
		for(int i = 1; i < globalForest.size(); i++){
			if( globalForest.get(i).tree == null )
			{
				String client_ip = globalForest.get(i).ip;
				int client_port = globalForest.get(i).port;
				
				// make ALT (Ask for a Local Tree) packege
        		Pack tmp_pack = new Pack(ourIp, ourPort);
        		tmp_pack.setType("ALT");
        		
        		// send it  
				TCPClient client = new TCPClient(client_ip, client_port);
				globalForest.get(i).tree = client.sendALT(tmp_pack);
			}
		}
	}
}
