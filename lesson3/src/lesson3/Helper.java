package lesson3;

public class Helper {
	
	public void print(String str){
		System.out.println(str);
	}
	public void space(){
		System.out.println();
	}
	public String parser(String str){
		str = "."+ str+".";
		
		parser(str);
		return " " ;
	}
	
}
