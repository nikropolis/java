package test5;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		int a, b, c;
		int m;

		a = scan.nextInt();
		b = scan.nextInt();
		c = scan.nextInt();
		if (a > b) {
			// a b c
			// c a b
			// a c b
			if (b > c) {
				m=b;
			} else if (c > a) {
				m=a;
			} else {
				m=c;
			}
		}
		else if (b > a) {
			// bac 
			// cba
			// bca
			if (a > c) {// b>a>c
				m=a;    
			} else if (c > b) {//    c>b>a
				m=b;
			} else { // b > c > a 
				m=c;
			}
		}
		else {//a == b   abc || bac ||cab || cba  
			m = a;
		}
		
		System.out.println(m);
	}

}
