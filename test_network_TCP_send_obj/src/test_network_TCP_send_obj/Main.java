package test_network_TCP_send_obj;

public class Main {

	public static void main(String[] args) {
		// 127.0.0.1 || localhost
		
			new Thread(new Server(6660)).start();
			new Thread(new Client(6660,"127.0.0.1")).start();
	}

}
