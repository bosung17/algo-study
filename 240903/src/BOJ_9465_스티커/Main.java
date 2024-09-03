package BOJ_9465_스티커;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int t = 1; t <= T; t++) {
			
			int n = sc.nextInt();
			
			int[][] board = new int[2][n];
			
			for (int r = 0; r < 2; r++) {
				for (int c = 0; c < n; c++) {
					board[r][c] = sc.nextInt();
				}
			}
			
			int[] dp = new int[n];
			
			dp[0] = Math.max(board[0][0], board[1][0]);
		}
	}
}
