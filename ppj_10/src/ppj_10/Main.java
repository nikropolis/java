package ppj_10;

public class Main {

	public static void main(String[] args) {
		
		{
			int [] arr = new int[10];
			int jeden = 0;
			int zero = 0;
			
			for(int i=0; i < arr.length; i++){
				arr[i] = (int) Math.round( Math.random() * 1) ;
				
				if(arr[i] == 1)
					jeden++;
				else
					zero++;
				System.out.print(arr[i] + " ");
			}
			System.out.println();
			System.out.println("jeden : " + jeden + ", zero : " + zero);
			System.out.println();
		}
		
		{
			int randomer = (int) (Math.random() * 10 + 1);
			int [] arr = new int[randomer];
			System.out.println("random arr length is " + arr.length);
			System.out.println();
		}
		
		{
			double [] arr = new double[10];
			
			for (int i = 0; i < arr.length; i++){
				arr[i] = Math.random() * 10;
				System.out.print(arr[i] + "|");
			}
			System.out.println();
			System.out.println("arr[0] == " + arr[0]);
			
			for (int i = 0; i < arr.length; i++){
				if( ((int)arr[i])%2 != 0 ){
					System.out.print((int)arr[i] + " ");
				}
			}
			System.out.println();
			System.out.println();
		}
		
		{
			 int tab [] = {1, 0, 0, 0, 2, 0, 0, 0, 3}; 
			 
			 for(int i=1; i<=tab.length; i++){
				 System.out.print(tab[i-1] + " ");
				 if(i%3 == 0)
					 System.out.println();
			 }
			 System.out.println();

			 for(int i=tab.length; i >= 1; i-=3){
				 for(int j = 3; j > 0; j--){
					 System.out.print(tab[i-j] + " ");
				 }
				 System.out.println();
			 }
			 System.out.println();
			 
			 for(int i=tab.length-1; i>=0; i--){
				 System.out.print(tab[i] + " ");
				 if(i%3 == 0)
					 System.out.println();
			 }
			 System.out.println();
			 System.out.println();
		}
		
		{
			int tab []; 	
			//System.out.println(tab) ; exception
		}
		
		{
			 int tab [] = { 789, 678, 567}; 

			 for (int i = 0; i < tab.length; i++) 
				 for (int j = i; j < tab.length; j++) 
					 System.out.println(tab[i] - tab[j]) ;
		}
		
	}

}
