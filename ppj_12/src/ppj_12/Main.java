package ppj_12;
//V
public class Main {
	
	public static void BubbleSort( int [ ] num )
	{
	     int j;
	     boolean flag = true;   // set flag to true to begin first pass
	     int temp;   //holding variable

	     while ( flag )
	     {
	            flag= false;    //set flag to false awaiting a possible swap
	            for( j=0;  j < num.length -1;  j++ )
	            {
	                   if ( num[ j ] < num[j+1] )   // change to > for ascending sort
	                   {
	                           temp = num[ j ];                //swap elements
	                           num[ j ] = num[ j+1 ];
	                           num[ j+1 ] = temp;
	                          flag = true;              //shows a swap occurred  
	                  } 
	            } 
	      } 
	} 
	
	public static void main(String[] args) {
		
		int [][] arr = new int [9][9];
		int [] tmp1 = new int[9];
		int [] tmp2 = new int[9];
		boolean bool1 = false;
		boolean bool2 = false;
		
		for(int i = 0; i < arr.length; i++){
			for(int j = 0; j < arr[i].length; j++){
				arr[i][j] = (int)(Math.random()*10);
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
		
		for(int i = 0; i < arr.length; i++){
			tmp1[i] = arr[i][i];
		}
		for(int j=0, i = arr.length-1; i >= 0 ; i--){
			tmp2[i] = arr[j][i];
			j++;
		}
		
		BubbleSort(tmp1);
		BubbleSort(tmp2);

		for(int i = 0; i < tmp1.length; i++){
			System.out.print(tmp1[i] + " ");
			if(i < tmp1.length-2)
				if(tmp1[i] == tmp1[i+1] && tmp1[i] == tmp1[i+2])
					bool1 = true;
		}
		if(bool1)
			System.out.print("from left to right there are 3 same numbers");
		
		System.out.println();
		
		for(int i = 0; i < tmp2.length; i++){
			System.out.print(tmp2[i] + " ");
			if(i < tmp2.length-2)
				if(tmp2[i] == tmp2[i+1] && tmp2[i] == tmp2[i+2])
					bool2 = true;
		}
		if(bool2)
			System.out.print("from rigth to left there are 3 same numbers");
		
	}

}
