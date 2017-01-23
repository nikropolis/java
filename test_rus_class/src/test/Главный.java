package test;

public class Главный {
	public static void main(String[] args){
		
		класс1 cl = new класс1(800);
		System.out.println(cl.z);
		
		класс1 cl2 = new класс1();
		cl2.setX(900);
		System.out.println(cl2.getX());
	}
}
