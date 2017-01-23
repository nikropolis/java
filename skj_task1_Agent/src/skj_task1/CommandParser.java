package skj_task1;

import java.util.ArrayList;
import java.util.Arrays;

public class CommandParser {
	private ArrayList<Agent> globalForest;
	private Tree localtree;
	private boolean itIsOutLocalTree;
	public CommandParser(ArrayList<Agent> GF, Tree tree){
		this.localtree = tree;
		this.globalForest = GF;
		itIsOutLocalTree = false;
	}
	public CommandParser(ArrayList<Agent> GF, Tree tree, boolean bool){
		this.localtree = tree;
		this.globalForest = GF;
		itIsOutLocalTree = bool;
	}
	
	public void parse(String str){
		char [] chars = str.toCharArray();
		ArrayList<String> words = new ArrayList<>();

		//parse the command
		String command = "";
		for(int i = 0; i < str.length(); i++){
			if(chars[i] == ' ')
				break;
			command += chars[i];	
		}
		System.out.print(" . "+command+" ");
		//check the command
	    if( !command.equals("ADD")  && !command.equals("REMOVE") && !command.equals("MODIFY") )
	    {
	    	System.out.println(" ! wrond command");
	    	return;
	    }
	    //parse the after-words
		for(int i = command.length(); i < chars.length; i++){
			if(chars[i] == '"'){
				i++;	//start "
				String word = "";
				while(chars[i] != '"') 
				{	
					word += chars[i];
					i++;
				}		//end "
				words.add(word);
			}
		}
		System.out.println(Arrays.toString(words.toArray()));
	    //check for correct ROOT name
	    if( !words.get(0).equals(localtree.getName()) )
	    {
	    	System.out.println(" ! wrong ROOT NODE name");
	    	return;
	    }
    	Tree tree_link = localtree;
    	String value = words.get(words.size()-1);
    	
	    switch(command){
		    case "ADD":
		    	Tree new_tree = new Tree(value);
		    	
			    if(words.size() == 1)
			    {
			    	System.out.println(" ! can not ADD another local ROOT NODE");
			    	return;
			    }
			    for(int i = 1; i < words.size()-1; i++){ //start from the second word to the penultimate
			    	tree_link = tree_link.getChild(words.get(i));
			    	
			    	if(tree_link == null){
			    		System.out.println(" ! wrong path");
			    		return;
			    	}
			    }		    
			    tree_link.setChild(new_tree);
			    break;
		    
		    case "REMOVE":
		    	
		    	if(words.size() == 1)
			    {
			    	System.out.println(" ! can not REMOVE the ROOT NODE");
			    	return;
			    }
		    	for(int i = 1; i < words.size()-1; i++){ //start from the second word to the penultimate
			    	tree_link = tree_link.getChild(words.get(i));
			    	
			    	if(tree_link == null){
			    		System.out.println(" ! wrong path");
			    		return;
			    	}
			    }	
		    	tree_link.removeChild(value);
		    	break;
		    
		    case "MODIFY":
		    	for(int i = 1; i < words.size()-1; i++){ 
			    	tree_link = tree_link.getChild(words.get(i));
			    	
			    	if(tree_link == null){
			    		System.out.println(" ! wrong path");
			    		return;
			    	}
			    }	
		    	tree_link.setName(value);
		    	break;
		    	
		    default:
		    	System.out.println(" ! wrond comand");
		    	return;
	    }
	    
	    if(itIsOutLocalTree){
	    	String ourIp = globalForest.get(0).ip;
			int ourPort = globalForest.get(0).port;
			Pack tmp_pack = new Pack(ourIp, ourPort);
    		tmp_pack.setType("MOD");
    		tmp_pack.setPack(str);
    		
	    	Tree neighbours = globalForest.get(0).tree.getChild("neighbours");
	    	int  length = neighbours.getChildSize();
	    	
	    	for(int i = 1; i < length; i++){
	    		String client_ip = globalForest.get(i).ip;
				int client_port = globalForest.get(i).port;
				
	    		TCPClient client = new TCPClient(client_ip, client_port);
				try {
					client.sendMOD(tmp_pack);
				} catch (ClassNotFoundException e) {e.printStackTrace();}
	    	}
	    }
	} // command_parser() END
}
