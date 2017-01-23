package lesson3;

import java.util.Arrays;

public class Student  {
	public String name;
	private int age;
	private int id;
	private int[] marks;
	private int free_space;
	
	public Student(String name, int age, int id){
		this.name = name;
		this.age = age;
		this.id = id;
		marks = new int [10];
		free_space = 0;
	}
	
	public void addMark(int m){
		if(free_space < 10){
			marks[free_space] = m;
			free_space++;
		}
	}
	
	public String showMarks(){
		return Arrays.toString(marks);
	}
	
	public String showAge(){
		return ""+age;
	}
	
	public static void hello(){
		System.out.println("Hello Student");
	}
	
}
