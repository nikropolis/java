package ppj_9;

import java.util.Scanner;

public class Main {

	static boolean isprime(int n) {
		if (n == 1)
			return false;

		// from 2 to sqrt(n)
		for (int i = 2; i * i <= n; i++) {

			if (n % i == 0)
				return false;
		}

		return true;
	}

	public static void main(String[] args) {
		{
			for (int i = 0; i < 100; i++) {
				if (i % 2 == 0)
					System.out.print(i + "|");
			}
			System.out.println();
		}

		{
			int s = 0;
			int i = 1;

			while (i <= 10) {
				s += i;
				i++;
			}
		}

		{
			int[] arr = new int[10];
			int iter = 0;

			for (int i = 1; i <= 10; i++) {
				for (int j = 1; j <= 10; j++) {
					int result = i * j;

					if (result < 10)
						System.out.print(" " + result + " ");
					else
						System.out.print(result + " ");

					if (isprime(result)) {
						arr[iter] = result;
						iter++;
					}
				}
				System.out.println();
			}
			System.out.println();

			for (int i = 0; i < arr.length; i++) {
				System.out.print(arr[i] + " ");
			}
			System.out.println();
			System.out.println();
		}

		{
			
			Scanner scan = new Scanner(System.in);
			System.out.print("Pase the number: ");
			int n = scan.nextInt();
			scan.close();

			boolean flag = true;
			int num = n;

			if (flag)
				for (int i = 0; i < n; i++) {
					for (int j = 0; j < i; j++) {
						System.out.print(" ");
					}
					for (int k = 0; k < num; k++) {
						System.out.print("*");
						if (k < 2)
							flag = false;
						else
							flag = true;
					}
					System.out.println();
					if (num > 1)
						num -= 2;
					else
						break;
				}
			if (flag == false) {
				num += 2;
				for (int i = n / 2; i > 0; i--) {
					for (int j = 1; j < i; j++) {
						System.out.print(" ");
					}
					for (int k = 0; k < num; k++) {
						System.out.print("*");
					}
					System.out.println();
					num += 2;
				}
			}
		}
		
	}// end main void

}
