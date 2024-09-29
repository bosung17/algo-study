package SWEA_1226_미로1_다시풀기;

import java.util.Scanner;

public class Solution {
	static int[][] board;
	static boolean[][] visited;
	static boolean find;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		for (int t = 1; t <= 10; t++) {
			
			sc.nextInt();
			
			board = new int[16][16];
			visited = new boolean[16][16];
			find = false;
			
			for (int r = 0; r < 16; r++) {
				String str = sc.next();
				for (int c = 0; c < 16; c++) {
					board[r][c] = (int) str.charAt(c) - '0';
				}
			}
			
			miro(1, 1);
			
			if (find) {
				System.out.println("#" + t + " " + 1);
			}
			else {
				System.out.println("#" + t + " " + 0);
			}
		}
	}
	
	static void miro(int r, int c) {
		
		if (board[r][c] == 3) {
			find = true;
			return;
		}
		
		visited[r][c] = true;
		
		int[] dr = {0, 1, 0, -1};
		int[] dc = {1, 0, -1, 0};
		
		for (int dir = 0; dir < 4; dir++) {
			int nr = r + dr[dir];
			int nc = c + dc[dir];
			
			if (board[nr][nc] != 1 && !visited[nr][nc]) {
				miro(nr, nc);
			}
		}
	}
}
