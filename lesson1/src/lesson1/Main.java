package lesson1;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan = new Scanner(System.in);
		
		int remembered = scan.nextInt(); //��������� ������ ����� //������������
		
		int longest�ount = 0;// longest sequence 
		int current = 0;// current number
		int max = 0;//
		int num = 0;
		
//		longest = current; //�� � ��� ���������������� ��� ���������� ������
		
		int count = 1; //�������� � �������
//		int count = 0; 
		//_______________ ���������� ����������������  
		// 1 1 1
		//longest�ount 3
		//num 1
		
		// 2 2
		//longest�ount 3
		//num 1
		
		// 4 4 4 4
		//longest�ount 4
		//num 4
		
		// 6 6 6 6 6
		//longest�ount 5
		//num 6
		
		// 6
		//longest�ount 6
		//num 6
		//_______________		
		
		//��� ������ ������� � ����, ������ ����������� �� ������� �����
		while (current != 0) {//�� ������, ���� ����� ������ ������ 
			current = scan.nextInt(); 
			
			//��� �������� ����� ������� ����� �� ��� ��� �������������� current 
			if (current == 0) {
				break;
			}
			
			if (remembered == current) {
				count++;
			} else {
				
//				if (count >= longest�ount) { 
////					count += 1;
//					longest�ount = count;
//					max = previous;
//				} // ������� ��� �������� �� ������� ����
				
//				count = 0;
				count = 1;
				
				remembered = current;// 1 1 1 [2] �������� ����� �����...
			}
			
			if (count >= longest�ount) {
//				count += 1;
				longest�ount = count;
				num = remembered;
//				������� ������� ���, � ����� �������� ����������������� ����. ������ println...
//				System.out.println("["+longest�ount+ " " +num+"]");
				
//				max = previous; // ������ �� �������
			}
			
//			if (current == 0) {
//				break;
//			}//���������� � ������
			remembered = current;
		}
		System.out.println("Longest sequence: " + longest�ount + "times number: " + num);
		scan.close();
	}

}
