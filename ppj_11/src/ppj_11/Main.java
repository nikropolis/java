package ppj_11;

public class Main {
	// ____________________________________________________
	static int[][] kw_arr = new int[4][5];
	// tab 4 x 5
	static int min_int;
	static String ind;

	static int[][] tab = { { 1, 0, 0 }, { 0, 1, 0 }, { 0, 0, 1 } };
	// diagonalna tab
	static int iter;
	static Boolean tab_bool;

	static int[][] inn_kw_arr = new int[5][5];
	static int[] tmp = new int[5];
	static Boolean inn_bool;

	static int f_sum;
	static int s_sum;
	static int line_quantity;
	static Boolean sum_bool;

	// ____________________________________________________
	public static void main(String[] args) {
		
		// I ------------------------------------
		System.out.println(". I .");
		for (int i = 0; i < kw_arr.length; i++) {
			System.out.print("[ ");
			for (int j = 0; j < kw_arr[i].length; j++) {
				kw_arr[i][j] = (int) (Math.random() * 50 + 1);
				System.out.print(kw_arr[i][j] + " ");
			}
			System.out.println("]");
		}
		System.out.println();

		// II ------------------------------------
		System.out.println(". II .");
		min_int = kw_arr[0][0];
		ind = "0 , 0";
		for (int i = 0; i < kw_arr.length; i++) {
			for (int j = 1; j < kw_arr[i].length; j++) {
				if (kw_arr[i][j] < min_int) {
					min_int = kw_arr[i][j];
					ind = (i + 1) + " , " + (j + 1);
				}
			}
		}
		System.out.println("min var ind - (" + ind + ")");
		System.out.println("min var val = " + min_int);
		System.out.println();

		// III ------------------------------------
		System.out.println(". III .");
		for (int i = 0; i < tab.length; i++) {
			System.out.print("[ ");
			for (int j = 0; j < tab[i].length; j++) {
				System.out.print(tab[i][j] + " ");
			}
			System.out.println("]");
		}
		iter = 0;
		tab_bool = true;
		for (int i = 0; i < tab.length; i++) {
			for (int j = 1; j < tab[i].length; j++) {
				if (j == i)
					continue;
				if (tab[i][j] != 0) {
					System.out.println("tabelka nie jest diagonalna");
					tab_bool = false;
					//break;
				}
				iter++;
			}
		}
		if (tab_bool)
			System.out.println("tabelka jest diagonalna");
		System.out.println();

		// IV ------------------------------------
		System.out.println(". IV .");
		// creating arr 5x5
		for (int i = 0; i < inn_kw_arr.length; i++) {
			System.out.print("[ ");
			for (int j = 0; j < inn_kw_arr[i].length; j++) {
				inn_kw_arr[i][j] = (int) (Math.random() * 10);
				System.out.print(inn_kw_arr[i][j] + " ");
			}
			System.out.println("]");
		}
		System.out.println();

		// collect tab elements po diagonali z leva na pravo
		for (int i = 0; i < inn_kw_arr.length; i++) {
			tmp[i] = inn_kw_arr[i][i];
		}
		inn_bool = false;

		for (int i = 0; i < tmp.length - 1; i++) {
			for (int j = i + 1; j < tmp.length; j++) {
				if (tmp[i] == tmp[j]) {
					inn_bool = true;
				}
			}
		}
		if (inn_bool)
			System.out.println("from left to right");

		// collect tab elements po diagonali z prava na levo
		for (int i = 0; i < inn_kw_arr.length; i++) {
			tmp[i] = inn_kw_arr[i][inn_kw_arr.length - (1 + i)];
		}
		inn_bool = false;

		for (int i = 0; i < tmp.length - 1; i++) {
			for (int j = i + 1; j < tmp.length; j++) {
				if (tmp[i] == tmp[j]) {
					inn_bool = true;
				}
			}
		}
		if (inn_bool)
			System.out.println("from right to left");
		System.out.println();

		// V ------------------------------------
		System.out.println(". V .");
		sum_bool = false;
		for (int i = 0; i < inn_kw_arr.length; i++) {
			f_sum = 0;
			line_quantity = 0;
			
			//line
			for (int j = 0; j < inn_kw_arr[i].length; j++) {
				f_sum += inn_kw_arr[i][j];
				line_quantity++;
			}
			
			//row
			for(int a = 0; a < line_quantity; ){
				s_sum = 0;
				for (int b = 0; b < inn_kw_arr.length; b++){
					s_sum += inn_kw_arr[b][a];
				}
				if( f_sum == s_sum){
					sum_bool = true;
					System.out.println(f_sum + " == " + s_sum);
					break;
				}
			}
			if (sum_bool)
				break;
		}

		if (sum_bool)
			System.out.println("bingo! some line == some row");
		System.out.println();

	}

}
