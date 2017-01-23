package network_TCP;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// 127.0.0.1 || localhost
		
//		Scanner scan = new Scanner(System.in);
//		System.out.println("give me ip");
//		String ip = scan.nextLine();
//		System.out.println("give me port");
//		int port = Integer.parseInt( new String(scan.nextLine()) );
//		scan.close();
		
		int port = 6660;
		String ip = "127.0.0.1";
		
		
		new Thread(new Server(port)).start();
		new Thread(new Client(port, ip)).start();
		
		
	}

}
