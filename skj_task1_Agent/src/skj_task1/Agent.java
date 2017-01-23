package skj_task1;

public class Agent {
	public String ip;
	public int port;
	public Tree tree;
	
	public Agent(){
		this.tree = null;
	}
	public Agent(String ip, int port, Tree tree){
		this.ip = ip;
		this.port = port;
		this.tree = tree;
	}
}
