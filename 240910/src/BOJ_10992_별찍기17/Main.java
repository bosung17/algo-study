package BOJ_10992_별찍기17;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		// 첫 줄
		System.out.print(" ".repeat(N-1));
		System.out.print("*");
		System.out.println();
		
		// 중간
		for (int i = 2; i < N; i++) {
			System.out.print(" ".repeat(N-i));
			System.out.print("*");
			System.out.print(" ".repeat(i*2-3));
			System.out.print("*");
			System.out.println();
		}
		
		// 막 줄
		if (N != 1)
		System.out.print("*".repeat(N*2-1));
	}
}
