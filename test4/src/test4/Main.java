package test4;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		boolean h = true;
		int a, b, c;
		Scanner f = new Scanner(System.in);

		a = f.nextInt();
		b = f.nextInt();
		c = f.nextInt();
		if (a <= 0 || b <= 0 || c <= 0)
			h = false;
		if ( !(a + b > c && b + c > a && a + c > b) )
			h = false;

		if (h)
			System.out.print("OK");
		else 
			System.out.println("Not ok");
	}

}
