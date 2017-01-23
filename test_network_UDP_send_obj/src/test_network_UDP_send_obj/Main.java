package test_network_UDP_send_obj;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Pack pack = new Pack();
		pack.id = 007;
		pack.str = "Jamse, Jamse Bond";
		
		new Thread ( new Server(8888) ).start();
		Client c = new Client("127.0.0.1", 8888);
		c.send(pack);
	}

}
