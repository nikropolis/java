package ppj_17;

public class Main {
	
	public static void rysuj(int x, boolean bool){
		char[] tmp = new char[2]; 
		if(bool){
			tmp[0] = 'x';
			tmp[1] = '0';
		}
		else{
			tmp[0] = '0';
			tmp[1] = 'x';
		}
		int it = 1;
		for(int i = 0; i < x; i++){
			for(int j = 0; j < x; j++){
				if(it%2 == 0)
					System.out.print(tmp[1]);
				else 
					System.out.print(tmp[0]);
				it++;
			}
			System.out.println();
		}
	}
	
	
	public static void isDiagonal(int [][] tab){
		boolean tab_bool = true;
		
		System.out.println("["+tab.length+"]["+tab[0].length+"]");
		
		for(int i = 0; i < tab.length; i++){
			if(tab.length != tab[i].length){
				System.out.println("tabelka have different kol and wirth");
				return;
			}
		}
		
		for (int i = 0; i < tab.length; i++) {
			for (int j = 0; j < tab[i].length; j++) {
				if (j == i)
					continue;
				if (tab[i][j] != 0) {
					System.out.println("tabelka nie jest diagonalna");
					tab_bool = false;
					break;
				}
			}
			if(!tab_bool)
				break;
		}
		if (tab_bool)
			System.out.println("tabelka jest diagonalna");
	}
	
	public static void isAlaHear(char[][]arr){
		for(int i = 0; i < arr.length; i++){
			for(int j = 0; j < arr[i].length; j++){
				if(arr[i][j] == 'a'){
					
					if( j <= arr[i].length-3){
						if(arr[i][j+1] == 'l')
							if(arr[i][j+2] == 'a')
								System.out.println("There is 'ala' to the right: ["+i+","+j+"]" );
					}
					if(i <= arr.length-3){
						if(arr[i+1][j] == 'l')
							if(arr[i+2][j] == 'a')
								System.out.println("There is 'ala' to the down: ["+i+","+j+"]" );	
					}
					if(i <= arr.length-3 && j <= arr.length-3)
						if(arr[i+1][j+1] == 'l')
							if(arr[i+2][j+2] == 'a')
								System.out.println("There is 'ala' to the right: ["+i+","+j+"]" );	
				}
			}
		}
	}
	public static int Euklides(int a, int b){
		while (a != b){
			if (a > b)
				a -= b;
			else
				b -= a;
			}
		return a;
		//System.out.println("Największy wspólny dzielnik to: "+a);
	}
	public static void main(String [] args){

		{ //I
			rysuj(5, false);
			System.out.println();
		}
		{ //III
			int [][] tab = {{1,0,0},
							{0,1,0},
							{0,0,1}};
			isDiagonal(tab);
			System.out.println();
		}
		{ //II
			char [][] tab = new char [5][5];
			
			String letters = "abcdefghijklmnopqrstuvwxyz";
			char [] c_letters = letters.toCharArray();
			
			for(int i = 0; i < tab.length; i++){
				for(int j = 0; j < tab[i].length; j++){
					int ind = (int)(Math.random()*letters.length()-1);
					tab[i][j] = c_letters[ind];
					System.out.print(tab[i][j]);
				}
				System.out.println();
			}
			isAlaHear(tab);
			System.out.println();
		}
		{ //IV
			int [][] tab = new int [10][2];
			
			for(int i = 0; i < tab.length; i++){
				for(int j = 0; j < tab[i].length; j++){
					tab[i][j] = (int)(Math.random()*100);
					System.out.print("["+tab[i][j]+"]");
				}
				System.out.println();
			}
			
			int max = 0;
			for(int i = 0; i < tab.length; i++){
				int delnik = Euklides(tab[i][0],tab[i][1]);
				if( max < delnik )
					max = delnik;
			}
			System.out.println(max);
		}

	}
	
}
