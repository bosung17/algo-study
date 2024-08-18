package BAEK_2563_색종이;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int[][] board = new int[100][100];
		
		for (int p = 0; p < N; p++) {
			int paperX = sc.nextInt();
			int paperY = sc.nextInt();
			for (int r = paperX; r < paperX + 10; r++) {
				for (int c = paperY; c < paperY + 10; c++) {
					board[r][c]++;
				}
			}
		}
		
		int count = 0;
				
		for (int r = 0; r < 100; r++) {
			for (int c = 0; c < 100; c++) {
				if (board[r][c] != 0) {
					count++;
				}
			}
		}
		System.out.println(count);
	}
}
