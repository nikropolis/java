package test_String_operations;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		if('A' <= chars[i] && chars[i] <= 'z')

		//String resultStr = str.substring(str.indexOf('.') + 1, str.indexOf(':'));
		//String [] words = str.split(" ");
		// command.equals("ADD")  
		//command == "ADD"

//	    System.out.println(sentence.charAt(28));
		
//		String hexDigits = "0123456789ABCDEF";	
//		System.out.print("pase hex digit: ");
//		char hexDigit = scan.next().charAt(0);
//		int result = hexDigits.indexOf(hexDigit);
//		if(result != -1)
//			System.out.println(" result: " + result);
//		else
//			System.out.println(" wrong digit ");
//		System.out.println();
		

//		words.set(i, words.get(i).replaceAll("\"", "") ) ; //replase all .". 

//		System.out.println(Arrays.toString(words.toArray())); //for ArrayList
		
		int num;
		try{
			String str = "str12";
		
			num = Integer.parseInt(str.trim());
		}catch(NumberFormatException e){
			System.out.println("o-o");
			num = 0;
		}
		System.out.println(num);
	}

}
