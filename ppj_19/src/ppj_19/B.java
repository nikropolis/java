package ppj_19;

public class B {
	private static B str;
	
	public B(){
		System.out.println(this);
		str = this;
	}
	
	public static void sShowThis(){
		System.out.println(str);
	}
	
	public void nsShowThis(){
		System.out.println(this);
	}
}
