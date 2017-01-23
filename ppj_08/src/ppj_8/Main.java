package ppj_8;

public class Main {

	public static void main(String[] args) {
		
		{
			int wrt = 1;
			
			for(int i=1; i<=10; i++){
				System.out.print(i + "|");
				wrt *= i;
			}
			System.out.println();
			System.out.println("multiplication: " + wrt);
			System.out.println();
		}
		
		{
			boolean bool = false;
			while(bool){
				System.out.println("Never be done");
			}
			
			do{
				System.out.println("Did it onece");
			}while(bool);
			System.out.println();
		}
		
		{
			for(int i = 0; i < 10; i++){
				System.out.print(1/Math.pow(2, i) + " | ");
			}
			System.out.println();
			System.out.println();
		}
		
		{
			for(int i = 1; i <= 5; i++){
				for(int j = 0; j < i; j++){
					System.out.print("*");
				}
				System.out.println();
			}
			System.out.println();
		}
		
		{
			int x = 0; 
			while(x++ < 10) {} 
			String msg = x > 10 ? "Większe niż" : "false"; 
			System.out.println( msg + "," + x) ;
			System.out.println();
		}
		
		{
			// do { 
			//	 int y = 3; 
			//	 System.out.println(++y + " ") ; 
			//} while(y <= 10) ;
			
			//exception
			//no local variable 
			//infinity cycle
		}
		
		{
			boolean wykonuj = true; 
			int res = 15, i = 10; 
			do { 
				i--; 
				if( i == 6) 
					wykonuj = false; 
				res -= 2; 
			} while(wykonuj) ; 
			System.out.println(res) ;
		}
	}

}
