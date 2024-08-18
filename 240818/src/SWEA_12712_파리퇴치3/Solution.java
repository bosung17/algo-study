package SWEA_12712_파리퇴치3;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int t = 1; t <= T; t++) {
			
			int N = sc.nextInt();
			
			int M = sc.nextInt();
			
			int[][] board = new int[N][N];
			
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					board[r][c] = sc.nextInt();
				}
			}
			
			int maxCount = 0;
			
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					int count = board[r][c];
					for (int d = -M+1; d < M; d++) {
						if (r + d >= 0 && r + d < N && d != 0) {
							count += board[r + d][c];
						}
						if (c + d >= 0 && c + d < N && d != 0) {
							count += board[r][c + d];
						}
					}
					if (count > maxCount) {
						maxCount = count;
					}
				}
			}
			
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					int count = board[r][c];
					for (int d = -M+1; d < M; d++) {
						if (r + d >= 0 && r + d < N && c + d >= 0 && c + d < N && d != 0) {
							count += board[r + d][c + d];
						}
						if (r + d >= 0 && r + d < N && c - d >= 0 && c - d < N && d != 0) {
							count += board[r + d][c - d];
						}
					}
					if (count > maxCount) {
						maxCount = count;
					}
				}
			}
			
			System.out.println("#" + t + " " + maxCount);
		}
	}
}
