package lesson2;

public class Main2 {

	public static void main(String[] args) {
		int n = 7;
		
		for(int i = 0; i < n; i++){
			
			for(int j = 0; j < n*2-i-1; j++){
				
				if(j == i || j == n*2-i-2)
					System.out.print("x");
				else
					System.out.print("_");
			}
			System.out.println();
		}
	}

}
