package test;

import java.util.Scanner;

import javax.swing.JOptionPane;
//import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		double a, b, c, d;
		double x1, x2;
		String str = "";
		
		x1 = x2 = 0;


//		JOptionPane.showMessageDialog(null, "start");
		
		// String s = (String) JOptionPane.showInputDialog(frame, "������� �: ",
		// "Customized Dialog",
		// JOptionPane.PLAIN_MESSAGE, icon);
		// // System.out.println("������� �: ");
		// a = in.nextDouble();
		// // System.out.println("������� b: ");
		// String l = (String) JOptionPane.showInputDialog(frame, "������� b: ",
		// "Customized Dialog",
		// JOptionPane.PLAIN_MESSAGE, icon);
		// b = in.nextDouble();
		// // System.out.println("������� c: ");
		// String n = (String) JOptionPane.showInputDialog(frame, "������� c: ",
		// "Customized Dialog",
		// JOptionPane.PLAIN_MESSAGE, icon);
		//
		a = in.nextDouble();
		b = in.nextDouble();
		c = in.nextDouble();

		System.out.println(a + " " + b + " " + c);

		d = Math.pow(b, 2) - (4 * a * c);
		System.out.println("D = " + d);
		if (d > 0) {
			x1 = ((-1) * b + Math.sqrt(d)) / (2 * a);
			x2 = ((-1) * b - Math.sqrt(d)) / (2 * a);
			
			str = ("x1 = " + x1 + " x2 = " + x2);
		} else if (d == 0) {
			x1 = (-1) * b / (2 * a);
			
			str = ("x1, x2 = " + x1);
		} else {
			str = ("there is no x1, x2");
		}
		
		JOptionPane.showMessageDialog(null, str);
	}

}