package ppj_19;

public class Cylinder {
	private int r;
	private int h;
	
	public Cylinder(int radius, int height){
		r = radius ;
		h = height ;
	}
	
	public void Show(){
		double pi = 3.14;
		double V = pi*r*r*2 + 2*pi*r*h;
		double P = pi*r*r*h;
		System.out.println("full area: " + V);
		System.out.println("value: " + P);
	}
}
