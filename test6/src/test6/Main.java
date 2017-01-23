package test6;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int a, b;
		a = s.nextInt();
		b = s.nextInt();
		char n = s.next().charAt(0);

		switch (n) {
		case '+':
			System.out.println(a + b);
			break;
		case '-':
			System.out.println(a - b);
			break;
		case '/':
			System.out.println(a / b);
			break;
		case '*':
			System.out.println(a * b);
			break;
		default:
			System.out.println("error");
			break;
		}
	}

}
