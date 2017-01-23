package lesson2;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [][] arr = {
				{1,2,3},
				{4,5},
				{6,7,8},
				{9,10}
		};
		
		for(int i = 0; i < arr.length; i++){
			System.out.println(Arrays.toString(arr[i]));
		}
		System.out.println();
		
		Magic2(arr, 1, 2);
		
		for(int i = 0; i < arr.length; i++){
			System.out.println(Arrays.toString(arr[i]));
		}
	}
	
	public static void Magic (int [][] arr, int a, int b){
		int [] tmp = arr[b];
		arr[b] = arr[a];
		arr[a] = tmp;
	}

	public static void Magic2 (int [][] arr, int a, int b){
		arr[a][2] = arr[b][2];
	}
}
