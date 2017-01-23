package lesson3;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		String str = "hello world";
//		
//		Helper h = new Helper();
//		h.print(str);
//		
//		Student s = new Student("Mark", 18, 0);
//		s.addMark(5);
//		s.addMark(5);
//		s.addMark(4);
//		s.addMark(2);
//		s.addMark(0);
//		
//		h.space();
//		Student.hello();
//		h.print(s.name + " " + s.showAge());
//		h.print( s.showMarks() );
//		
		NewClass n = new NewClass(5);
		NewClass n2 = new ChildClass();
		
		
		ChildClass c = new ChildClass();
		c.func();
	}
}

class NewClass {
	private int a;
	
	public int a2;
	protected int a3=10;
	
	public NewClass(int num){
		a = num;
	}
	public NewClass(){
		a = 0;
	}
	public void func(){
		System.out.println("hi");
	}
}

class ChildClass extends NewClass{
	public ChildClass(){
//		a3 = 0;
		a2 = 0;
	}
	public void func(){
		System.out.println("hello"+ a3);
	}
}