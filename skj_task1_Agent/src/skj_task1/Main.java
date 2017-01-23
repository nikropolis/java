package skj_task1;

import java.util.ArrayList;

public class Main {
	public static void main(String[] args){
		
		String path;
		if(args.length > 0 && args[0] != null){
			path = args[0];
		}
		else
			path = "config.txt";
		//	"src//skj_task1//config.txt"

		//	read config file
	    MyFileReader fr = new MyFileReader(path);
	    String sentence = fr.getString(); //string from config file
	    
	    
	    //	make local tree from the config string
	    String2Tree s2t = new String2Tree(sentence);
	    Tree localTree = s2t.getTree();
	    
	    
	    //	set ip and port from our localTree and create an obj. Then push it to globalTree
	    String ourIp = localTree.getChild("ip").getValue();
	    int    ourPort = Integer.parseInt( localTree.getChild("port").getValue() );
	    
	    //	what for? we need localTree and ip and port of Agents in a same time
		ArrayList<Agent> globalForest = new ArrayList<>();
	    globalForest.add( new Agent(ourIp, ourPort, localTree) );
	    System.out.println(" . set ip [" + ourIp + "] and port [" + ourPort + "]");
	    
	    
	    //	TCP agent network
	    //	set the Server Listener for requests on our port //6660
	    TCPServer server = new TCPServer( ourPort , globalForest );//and send the global forest to server thread
	    Thread input = new Thread(server);
	    input.start();
	    
	    
	    //	Get Trees from your neighbours
	    NeighbourCheck nc = new NeighbourCheck(globalForest);
	    nc.set();
	    nc.check();
	    
	    //	open the server to show (HTML) global knowledge on the localhost:8080
	    WebServer ws = new WebServer(globalForest); //you can chenge the port!!! new WebServer(globalForest, 8181)
	    Thread thread = new Thread(ws);
	    thread.start();
	    
	    
	    //	command listener
	    CommandParser cp = new CommandParser(globalForest, localTree, true);
	    CommandListener cl = new CommandListener();
	    for(;;){
	    	String command;
	    	command = cl.read();
	    	if(command.equals("exit"))
	    	{
	    		cl.close();
	    		server.terminate();
	    		ws.terminate();
	    		break;
	    	}
	    	else{
		    	cp.parse( command );
		    	localTree.showFamily();
	    	}
	    }

	    
	    //	die!
	    System.exit(0);
	}
}
