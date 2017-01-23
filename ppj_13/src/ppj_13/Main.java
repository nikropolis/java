package ppj_13;

import java.util.Scanner;

public class Main {
	
	public static void BubbleSort( int [ ] num, boolean bool )
	{
	     int j;
	     boolean flag = true;   // set flag to true to begin first pass
	     int temp;   //holding variable

	     while ( flag )
	     {
	            flag= false;    //set flag to false awaiting a possible swap
	            for( j=0;  j < num.length -1;  j++ )
	            {
	            	if(bool)
	            	{
	                   if ( num[ j ] < num[j+1] )   // change to > for ascending sort
	                   {
	                           temp = num[ j ];                //swap elements
	                           num[ j ] = num[ j+1 ];
	                           num[ j+1 ] = temp;
	                          flag = true;              //shows a swap occurred  
	                  } 
	            	}
	                else
	                {
	                	  if ( num[ j ] > num[j+1] )   // change to > for ascending sort
		                   {
		                           temp = num[ j ];                //swap elements
		                           num[ j ] = num[ j+1 ];
		                           num[ j+1 ] = temp;
		                          flag = true;              //shows a swap occurred  
		                  } 
	                }
	            } 
	      } 
	} 

	public static void main(String[] args) {

		{
			int [] arr = new int [10];
			for(int i=0; i<arr.length; i++){
				arr[i] = (int)(Math.random()*2 );
				System.out.print(arr[i]+"|");
			}
			System.out.println();
			
			int iterator = 0;
			
			for(int i=0; i<arr.length-2; i++){
				if(arr[i] == 1)
					if(arr[i+1] == 0)
						if(arr[i+2] == 1)
							iterator++;
			}
			System.out.println(iterator + " times");
			System.out.println();
		}
		
		{
			double [] arr1 = new double[3];
			double [] arr2 = new double[3];
			double [] result = new double[3];
			
			for(int i = 0; i < arr1.length; i++){
				arr1[i] = Math.random()*5.0;
				System.out.println(arr1[i]);
			}
			System.out.println();
			
			for(int i = 0; i < arr2.length; i++){
				arr2[i] = Math.random()*5.0;
				System.out.println(arr2[i]);
			}
			System.out.println();
			
			for(int i = 0; i < result.length; i++){
				result[i] = arr1[i] + arr2[arr2.length-i-1];
				System.out.println(result[i]);
			}
		}
		{
			char [] word = {'H','E','L','L','O'};
			
			for(int i = 0; i < word.length; i++){
				System.out.print(word[i]);
			}
			System.out.println();
			
			for(int i = 0; i < word.length; i++){
				word[i] += i;
				System.out.print(word[i]);
			}
			System.out.println();
			
			for(int i = 0; i < word.length; i++){
				word[i] -= i;
				System.out.print(word[i]);
			}
			System.out.println();
		}
		{
			Scanner scan = new Scanner(System.in);
			String sentence = scan.next();
			scan.close();
			
			char [] chars = sentence.toCharArray();
			int char_length = 0;
			
			for(int i=0; i < chars.length; i++){
				char letter = 0;
				char sign = 0;
				
				if('A' <= chars[i] && chars[i] <= 'z')
					letter = chars[i];
				else
					sign = chars[i];

				
				for(int j=0; j < chars.length; j++){
					if(j == i)
						continue;
					
					if('A' <= chars[j] && chars[j] <= 'z'){
						if( letter == chars[j])
							System.out.println("more then one letters: "+chars[j]);
					}
					else{
						if( sign == chars[j])
							System.out.println("more then one signs: "+chars[j]);							
					}
				}
				
				char_length += chars[i];
				
				if(chars[i] == 'i'){
					System.out.println("there is some .i. in the sentence");
				}	
			}
			System.out.println(char_length);
			System.out.println();
		}		
		{
			int random_int = (int)(Math.random()*9);
			int [] arr = new int [random_int];
			int [] arr2 = new int [random_int * 2];
			
			for(int i = 0; i < arr.length; i++){
				arr[i] = (int)Math.random()*10;
				System.out.print(arr[i]);
			}
			
			BubbleSort( arr, true );
			
			for(int i = 0; i < arr.length; i++){
				arr2[i] = arr[i];
			}
			
			BubbleSort( arr, false );
			int it = 0;
			for(int i = arr.length; i < arr2.length; i++){
				arr2[i] = arr[it];
				it++;
			}
			
			for(int i =0; i<arr2.length; i++){
				System.out.print(arr2[i]);
			}
		}
	}

}
