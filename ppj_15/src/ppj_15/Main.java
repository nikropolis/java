package ppj_15;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		{
			double [][] arr = {
					{1},
					{0},
					{0}
			};
			
			double [][] arr2 ={
					{0,-1,0},
					{1,0,0},
					{0,0,1}
			};
			
			double [][] rezultat = new double[3][1];
			
			for(int i = 0; i < arr2.length; i++){
				for(int j = 0; j < arr2[i].length; j++){
					rezultat[i][0] += arr[j][0] * arr2[i][j];
				}
			}
			for(int i=0; i<rezultat.length; i++ ){
				System.out.println(Arrays.toString(rezultat[i]));
			}
			System.out.println();
		}//	I END
		{// II
			int [][] arr = new int[10][10];
			
			for(int i = 0; i < arr.length; i++){
				for(int j = 0; j < arr[i].length; j++){
					arr[i][j] = (int)(Math.random()*10);
					System.out.print(arr[i][j]+"|");
				}
				System.out.println();
			}
			
			int max = arr[1][1] + arr[0][1] + arr[1][0];
			
			for(int i = 0; i < arr.length; i++){
				for(int j = 0; j < arr[i].length; j++){
					int tmp = 0;
					//////////////////////////////
					if( i == 0  )
					{
						if(j == 0){
							tmp += arr[i+1][j];
							tmp += arr[i+1][j+1];
						}
						else if(j == arr[i].length-1){
//							tmp += arr[i-1][j];
							tmp += arr[i+1][j-1];
						}
						else
						{
							tmp += arr[i+1][j];
//							tmp += arr[i-1][j];
							tmp += arr[i+1][j+1];
							tmp += arr[i+1][j-1];
						}
						tmp += arr[i+1][j];
					}
					else if (i == arr.length-1)
					{
						if(j == 0){
//							tmp += arr[i+1][j];
							tmp += arr[i-1][j+1];
						}
						else if(j == arr[i].length-1){
							tmp += arr[i-1][j];
							tmp += arr[i-1][j-1];
						}
						else
						{
//							tmp += arr[i+1][j];
							tmp += arr[i-1][j];
							tmp += arr[i-1][j+1];
							tmp += arr[i-1][j-1];
						}
						tmp += arr[i-1][j];
					}
					else
					{
						if(j == 0){
							tmp += arr[i+1][j];
							tmp += arr[i-1][j+1];
							tmp += arr[i+1][j+1];
						}
						else if(j == arr[i].length-1){
							tmp += arr[i-1][j-1];
							tmp += arr[i+1][j-1];
						}
						else
						{
							tmp += arr[i+1][j];
							tmp += arr[i-1][j];
							tmp += arr[i-1][j+1];
							tmp += arr[i-1][j-1];
							tmp += arr[i+1][j+1];
							tmp += arr[i+1][j-1];
						}
						tmp += arr[i+1][j];
						tmp += arr[i-1][j];
					}
					
					if(tmp > max)
						max = tmp;
				}
			}
			System.out.println(max);
			System.out.println();
		}
		{
			char [][] arr = {
					{'k','a','l','a'},
					{'k','l','k','a'},
					{'k','a','k','l'},
					{'k','k','k','a'}
			};
			
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
		{
			int n = 5;
			int [][] arr = new int[n][n];
			
			for(int i = 0; i < arr.length; i++)
				for(int j = 0; j < arr.length; j++){
					
				}
		}
	}

}
