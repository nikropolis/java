package test;

import java.io.FileNotFoundException;
import java.util.Formatter;
import java.util.Scanner;

//import java.io.FileWriter;
//import java.io.IOException;

public class WriteFile {

	static Formatter f;
	static Scanner scn;
	
	public static void main(String[] args) throws FileNotFoundException {

		System.out.println("write a string:");
      
		f = new Formatter("src//test//file.txt");
		scn = new Scanner(System.in);
		
		String str = scn.next();
		
		f.format("строка: %s", str);

		f.close();
		scn.close();
		System.out.println("ready");
		
		//	C:\\SomeDir\\notes3.txt
		//		try(FileWriter writer = new FileWriter("test.tmp\\file.txt", false))
		//        {
		//           // запись всей строки
		//            String text = "ћама мыла раму, раму мыла мама";
		//            writer.write(text);
		//            // запись по символам
		//            writer.append('\n');
		//            writer.append('E');
		//             
		//            writer.flush();
		//        }
		//        catch(IOException ex){
		//            System.out.println(ex.getMessage());
		//        } 
		

	}

}
