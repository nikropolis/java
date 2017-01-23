package ppj_7;

import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Main {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		
		{
			boolean czyPada = true;
			boolean czySwieciSlonce = false;
			
			if(czyPada)
				if(czySwieciSlonce)
					System.out.println("tecza");
				else
					System.out.println("plucha");
			else
				if(czySwieciSlonce)
					System.out.println("slonecznie");
				else
					System.out.println("pochmurno");
			System.out.println();
		}

		{
			String hexDigits = "0123456789ABCDEF";
			
			System.out.print("pase hex digit: ");
			char hexDigit = scan.next().charAt(0);
			int result = hexDigits.indexOf(hexDigit);
			if(result != -1)
				System.out.println(" result: " + result);
			else
				System.out.println(" wrong digit ");
			System.out.println();
		}
		
		{
			Calendar c = new GregorianCalendar();
			//wanted to take the current time, instead of writing the constants...
			int dzien = c.get(Calendar.DAY_OF_MONTH);
			int miesiac = c.get(Calendar.MONTH)+1;
			int result = 0;
			
			System.out.println("today: "+ dzien + " the " + miesiac + " month");
			
			for(int i = 1; i <= miesiac; i++){
				//formula to find out the quantity of days in the month
				//https://cmcenroe.me/2014/12/05/days-in-month-formula.html
				//little trick =)
				result += 28 + (i + i/8)%2 + 2%i + 2*(1/i); 
				//i think its easy and fast...
			}
			result += dzien;
			System.out.println("its " + result +" days past from the begining of the year");
			System.out.println();
		}
		
		{
			 int x = (int)(Math.random()*10) ; 
			 int y = (int)(Math.random()*10) ;  
			 int z = (int)(Math.random()*10) ;
			 System.out.println("x = " + x + " y = " + y + " z = " + z);
			 if(x > y)
				 if( x > z)
					 System.out.println("x is max");
				 else
					 System.out.println("z is max");
			 else
				 if( y > z)
					 System.out.println("y is max");
				 else
					 System.out.println("z is max");
		}
	}

}
