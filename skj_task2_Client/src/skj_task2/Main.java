package skj_task2;

//import java.util.ArrayList;

//import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		String server_ip = "localhost";
		int server_port = 6666;
		
		if(args.length > 0)
		{
			server_ip = args[0];
			if(args.length > 1)
				server_port = Integer.parseInt(args[1]);
		}
		
		
		Handler handler = new Handler();
		handler.server = new Persona();
		handler.server.ip = server_ip;
		handler.server.port = server_port;
		
		RSA rsa = new RSA();
		handler.rsa = rsa;
		
		GUI window = new GUI(handler);
//		window.open();
		handler.gui = window;
		handler.gui.open();
		
	}

}
