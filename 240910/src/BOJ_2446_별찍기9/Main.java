package BOJ_2446_별찍기9;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int input = sc.nextInt();
		
		int N = input*2-1;
		
		for (int i = 0; i <= N/2; i++) {
			for (int j = 0; j < i; j++) {
				System.out.print(" ");
			}
			for (int j = (N-i*2); j > 0; j--) {
				System.out.print("*");
			}
			System.out.println();
		}
		for (int i = N/2 - 1; i >= 0; i--) {
			for (int j = 0; j < i; j++) {
				System.out.print(" ");
			}
			for (int j = (N-i*2); j > 0; j--) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}
