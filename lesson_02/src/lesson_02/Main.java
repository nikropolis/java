package lesson_02;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		{}
		{}
		{
			int a,b,c,d;
			int l,s;
			
			System.out.println("write 4 numbers:");
			a = scan.nextInt();
			b = scan.nextInt();
			c = scan.nextInt();
			d = scan.nextInt();
			
			l = a;
			if(l < b) l = b;
			if(l < c) l = c;
			if(l < d) l = d;
			
			s = a;
			if(s > b) s = b;
			if(s > c) s = c;
			if(s > d) s = d;
			
			System.out.println(l-s);
			System.out.println();
		}
		{
			int num, l, s;
			l = s = 0;
			System.out.println("write numbers until '0':");
			do{
				num = scan.nextInt();
//				if(num == 0) 
//					break;
				if(num > l)
					l = num;
				if(num < s)
					s = num;
			}while(num != 0);
			System.out.println(s + " " + l);
		}
		scan.close();
	}

}
