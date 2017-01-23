package test;

import java.io.*;

public class ReadFile {
 
    public static void main(String[] args) throws IOException {
    	
    	File f = new File("src//test//file.txt");
    	
    	FileReader reader = new FileReader(f);
    	
    	    char[] buffer = new char[ (int)f.length() ];
    	    
    	    // считаем файл полностью
    	    reader.read(buffer);
    	    System.out.println(new String(buffer));

    		System.out.println("ready");
    }
}