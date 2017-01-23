package lesson1;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan = new Scanner(System.in);
		
		int remembered = scan.nextInt(); //сканируем первое число //переименовал
		
		int longestСount = 0;// longest sequence 
		int current = 0;// current number
		int max = 0;//
		int num = 0;
		
//		longest = current; //ты ж уже инициализировала эти переменные нулями
		
		int count = 1; //начинаем с первого
//		int count = 0; 
		//_______________ сымитируем последовательные  
		// 1 1 1
		//longestСount 3
		//num 1
		
		// 2 2
		//longestСount 3
		//num 1
		
		// 4 4 4 4
		//longestСount 4
		//num 4
		
		// 6 6 6 6 6
		//longestСount 5
		//num 6
		
		// 6
		//longestСount 6
		//num 6
		//_______________		
		
		//как только попадем в цыкл, начнес сканировать со второго числа
		while (current != 0) {//на случай, если певым числом ввести 
			current = scan.nextInt(); 
			
			//эту проверку лучше вынести сразу за тем как просканировали current 
			if (current == 0) {
				break;
			}
			
			if (remembered == current) {
				count++;
			} else {
				
//				if (count >= longestСount) { 
////					count += 1;
//					longestСount = count;
//					max = previous;
//				} // вынесем эту проверку на уровень выше
				
//				count = 0;
				count = 1;
				
				remembered = current;// 1 1 1 [2] запомним новое число...
			}
			
			if (count >= longestСount) {
//				count += 1;
				longestСount = count;
				num = remembered;
//				запусти сначало так, а потом попробуй расскаментировать след. строку println...
//				System.out.println("["+longestСount+ " " +num+"]");
				
//				max = previous; // назвал по другому
			}
			
//			if (current == 0) {
//				break;
//			}//перенесено в начало
			remembered = current;
		}
		System.out.println("Longest sequence: " + longestСount + "times number: " + num);
		scan.close();
	}

}
