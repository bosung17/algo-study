package sero;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int test_case = 1; test_case <= T; test_case++) {
			
			char[][] board = new char[5][];
			
			for (int r = 0; r < 5; r++) {
				String str = sc.next();
				board[r] = new char[str.length()];
				for (int c = 0; c < str.length(); c++) {
					board[r][c] = str.charAt(c);
				}
			}
			
			int maxLength = 0;
			
			for (int i = 0; i < 5; i++) {
				if (board[i].length > maxLength) {
					maxLength = board[i].length;
				}
			}
			
			System.out.print("#" + test_case + " ");
			
			for (int c = 0; c < maxLength; c++) {
				for (int r = 0; r < 5; r++) {
					if (c < board[r].length) {
						System.out.print(board[r][c]);
					}
				}
			}
			
			System.out.println();
			
		}
	}
}
