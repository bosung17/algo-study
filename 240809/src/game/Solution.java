package game;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int test_case = 1; test_case <= T; test_case++) {
			
			int N = sc.nextInt();
			
			int[][] board = new int[N][N];
			
			board[N/2 -1][N/2 -1] = 2;
			board[N/2 -1][N/2] = 1;
			board[N/2][N/2 -1] = 1;
			board[N/2][N/2] = 2;
			
			int M = sc.nextInt();
			
			for (int i = 0; i < M; i++) {
				
				int r = sc.nextInt();
				int c = sc.nextInt();
				int color = sc.nextInt();
				
				board[r-1][c-1] = color;
				
				int[] dr = {0, 1, 1, 1, 0, -1, -1, -1};
				int[] dc = {1, 1, 0, -1, -1, -1, 0, 1};
				
				for (int dir = 0; dir < 8; dir++) {
					for (int j = 1; j < N; j++) {
						if (r-1+j*(dr[dir]) >= 0 && r-1+j*(dr[dir]) < N && c-1+j*(dc[dir]) >= 0 && c-1+j*(dc[dir]) < N) {
							if (board[r-1+j*(dr[dir])][c-1+j*(dc[dir])] == 0) {
								break;
							}
							else if (board[r-1+j*(dr[dir])][c-1+j*(dc[dir])] == color) {
								for (int k = 1; k < j; k++) {
									board[r-1+k*(dr[dir])][c-1+k*(dc[dir])] = color;
								}
								break;
							}
						}
					}
				}
			}
			
			int countBlack = 0;
			int countWhite = 0;
			
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					if (board[r][c] == 1) {
						countBlack++;
					}
					else if (board[r][c] == 2){
						countWhite++;
					}
				}
			}
			
			System.out.println("#" + test_case + " " + countBlack + " " + countWhite);
		}
	}
}
