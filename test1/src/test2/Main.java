package test2;

//import java.lang.reflect.WildcardType;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner( System.in);
		double weight;
		double height;
		System.out.println("put your w and h: ");
		
//		String s = scan.nextLine();
//		System.out.println(s);
		weight = scan.nextDouble();
		height = scan.nextDouble();
		
		System.out.println(weight+","+height);
		double BMI=weight/Math.pow(height, 2);
		System.out.println(BMI);
		JOptionPane.showMessageDialog(null, BMI);
		scan.close();
	}

}
