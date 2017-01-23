package skj_task1;

import java.util.Scanner;

public class CommandListener {
	private Scanner scan;
	
	public CommandListener (){
		scan = new Scanner(System.in);
		System.out.println(" . set command listener");
	}
	public void close(){
		scan.close();
	}
	public String read(){
		String str = scan.nextLine();
		return str;
	}
}
