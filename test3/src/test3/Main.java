package test3;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int a = scan.nextInt();
		int b = scan.nextInt();
		int c = scan.nextInt();
		// System.out.println(a + " " + b + " " + c);
		int l, m = 0, s;

		l = a;
		if (l < b)
			l = b;
		if (l < c)
			l = c;
		// System.out.println(l);

		s = a;
		if (s > b)
			s = b;
		if (s > c)
			s = c;
		// System.out.println(s);

		if (l > a && a > s)
			m = a;
		else if (l > b && b > s)
			m = b;
		else if (l > c && c > s)
			m = c;
		else if(a==b)
			m=a;
		else if(a==c)
			m=a;
		else m=b;
		System.out.println(m);

		a = l;
		b = m;
		c = s;

		System.out.println(a + " " + b + " " + c);

	}

}
