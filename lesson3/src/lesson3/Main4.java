package lesson3;

public class Main4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Integer i = new Integer(7);
		
		NewStudent s = new NewStudent("Max", 001);
		NewStudent s2 = new NewStudent("Klark", 001);
		Person p = new NewStudent("Max", 002);
		System.out.println( p.equals(s) ) ;
		System.out.println( s2.equals(s) ) ;
		System.out.println( s2.equals(p) ) ;
		
	}
	

}

class Person{
	private String name;
	
	public Person(String name){
		this.name = name;
		System.out.println("������� "+name+" ������");
	}
	public String getName(){
		return this.name;
	}
	public boolean equals(Person p){
		return this.name.equals(p.getName());
	}
}

class NewStudent extends Person{
	private int id;
	
	public NewStudent(String name, int id) {
		super(name);
		this.id = id;
		System.out.println("������� "+id+" ������");
	}
	
	public int getId(){
		return id;
	}
	public boolean equals(NewStudent s){
		return ( this.id==s.getId() && this.getName().equals(s.getName()) );
	}
}

class MyException extends Exception {
    public MyException(String message) {
        super(message);
    }
}