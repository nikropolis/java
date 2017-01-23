package lesson3;

public class Main2 {

	public static void main(String[] args) {
		String s = "hallo";
		Magic(2, "KY");
		String s2 = Magic2();
		
		M m = new M();
		
//		System.out.println(23%12);

		int a =6;
		System.out.println(++a);
		a = 6;

		System.out.println(a++);
//		System.out.println(a);	
		
		System.out.println();
		System.out.println();
		
		M m1 = new M();
		M m2 = new M();
		
		System.out.println( m1.equals(m2) );
	}
	
	
	
	public static void Magic(int a, String s){
		String tmp = "";
		for(int i = 0; i < a; i++){
			tmp += s;
		}
		System.out.println(tmp);
	}
	
	public static String Magic2(){
		return "it magic";
	}
}
class M{
//	M m = this;
	private int n;
	private String name;
	
	public M(int n){
		this.n = n;
	}
	public M(){
		n = 0;
		name = "";
	}
	
	public M func(){
		return this;
	}
	
	public int getN(){
		return n;
	}
	public String getName(){
		return name;
	}
	
	
	public boolean equals(M p){
		if( this.n == p.getN() && this.name.equals(p.getName())  )
			return true;
		
		return false;
	}
}
//public static void func1(){
//	System.out.println("hello");
//}