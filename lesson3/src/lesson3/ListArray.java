package lesson3;

public class ListArray {
	int length;
	int [] arr;
	Object [] o;
	int o_length;
	
	public ListArray(){
		length = 0;
		o_length = 0;		
	}
	
	public void add(int a){
		if(length == 0){
			arr = new int[1];
		} else {
			int [] tmp = new int [length];
			for(int i = 0 ; i < length; i++){
				tmp[i] = arr[i];
			}
			arr = new int [length+1];
			for(int i = 0 ; i < length; i++){
				arr[i] = tmp[i];
			}
		}
		
		arr[ length ] = a;
		length++;
		
	}
	public void addObj(Object a){
		if(o_length == 0){
			o = new Object[1];
		} else {
			Object [] tmp = new Object[o_length];
			for(int i = 0 ; i < o_length; i++){
				tmp[i] = o[i];
			}
			o = new Object [o_length+1];
			for(int i = 0 ; i < o_length; i++){
				o[i] = tmp[i];
			}
		}
		
		o[ o_length ] = a;
		o_length++;
		
	}
	
	public void show(){
		for(int i = 0; i < length; i++){
			System.out.print(arr[i]+" ");
		}
	}
	public void showObjs(){
		for(int i = 0; i < o_length; i++){
			System.out.print(o[i]+" ");
		}
	}
	
	public int get(int index){
		if(index >= 0 && index < length )
			return arr[index];
		return 0;
	}
	
	public int [] get(){
		return arr;
	}
	public int length(){
		return length;
	}
	

}