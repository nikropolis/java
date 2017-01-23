package ppj_6;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		 Scanner scan = new Scanner(System.in);
		 
		 {
			 byte a = 40, b = 50;  
			 byte suma = (byte) (a + b);  
			 System.out.println(suma);
		 }
		 
		 {
			 Boolean czyPada = true;
			 if(czyPada)
				 System.out.println(czyPada);
		 }
		 
		 {
			 int wrt;
			 
			 System.out.print("pase a value (int): ");
			 wrt = scan.nextInt();
			 
			 // A = (−15,−10]V(−5,0)V(5,10) 
			 // B = (inf,−13]V(−8,−3] 
			 // C = [−4,inf)
			 if( (wrt > -15) && (wrt <= -10) || (wrt > -5) && (wrt < 0) || (wrt > 5) && (wrt < 10) )
			 {
				 System.out.println("wrt is in A");
			 }
			 if( (wrt <= -13) || (wrt > -8) && (wrt <= -3) )
			 {
				 System.out.println("wrt is in B");
			 }
			 if( (wrt >= -4) )
			 {
				 System.out.println("wrt is in C");
			 }			 
		 }
		 
		 {
			 // A = (−15,−10) 
			 // B = (−inf,−13)
			 int wrt2;
			 boolean bool = false;
			 //Scanner scan2 = new Scanner(System.in);
			 
			 System.out.print("pase a value (int): ");
			 wrt2 = scan.nextInt();
			 
			 if( (wrt2 > -15) && (wrt2 < -10) )
			 {
				 bool = true;
			 }
			 if( wrt2 < -13 )
			 {
				 if(bool){
					 System.out.println("wrt is in A and B");
				 }
				 else
					 System.out.println("wrt is in B");
			 }
			 else
				 System.out.println("wrt is in A");				 
		 }
		 
		 {
			 System.out.println( (Math.pow(Math.sqrt(2), 2))-2 );
			 System.out.println( (int)(Math.pow(Math.sqrt(2), 2))-2 );
		 }
		 
		 {
			 int x = 4; 
			 long y = x * 4 - x++; 
			 if(y<10) System.out.println("za mało") ; 
			 else System.out.println("w sam raz") ;
		 }
		 
		 {
			 boolean x = true , z = true; 
			 int y = 20; 
			 x = ( y!= 10) ^ (z=false) ; 
			 System.out.println(x+", "+y+", "+z) ;

		 }
	}

}
