package ppj_5;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		{
			long l;
			float f;
		}
		
		{
			char a = 'a' + 1;
			
			int b = 2 + 'b';
			
			float c1 = 4; 
			double c2 = 0.4;
			//float c = c1 + c2; exception
			
			byte d1 = 10;
			int d2 = 1;
			//byte d = d1 + d2; exception
			
		}
		
		{
			boolean czyPada =true;
			System.out.println( czyPada ? "Pada" : "Nie Pada" );
		}
		
		{
			System.out.print("pase a value (int): ");
			int wrt = scan.nextInt();
			String str = (wrt >= 0) ? "A" : ( (wrt <= 1) ? "B" : ((wrt >= 0 && wrt <= 1) ? "C" : "not real") );
			System.out.println(str);
		}
		
		{
			byte x = 5;
			byte y = 10;
			int z = x + y; //INT
		}
	}

}
