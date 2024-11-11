package SWEA_10966_물놀이를_가자;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	static char[][] board;
	static boolean[][] visited;
	static int N, M, ans;
	static Queue<int[]> qu;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int t = 1; t <= T; t++) {
			
			N = sc.nextInt();
			M = sc.nextInt();
			ans = 0;
			
			board = new char[N][M];
			visited = new boolean[N][M];
			
			for (int r = 0; r < N; r++) {
				String str = sc.next();
				for (int c = 0; c < M; c++) {
					board[r][c] = str.charAt(c);
				}
			}
			
			qu = new LinkedList<>();
			
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < M; c++) {
					if (board[r][c] == 'W') {
						qu.add(new int[] {r, c, 0});
						visited[r][c] = true;
					}
				}
			}
			
			BFS();
			
			System.out.println("#" + t + " " + ans);
		}
	}
	static void BFS() {
		while (!qu.isEmpty()) {
			int[] temp = qu.poll();
			if (board[temp[0]][temp[1]] == 'L') {
				ans += temp[2];
			}
			int[] dr = {0, 1, 0, -1};
			int[] dc = {1, 0, -1, 0};
			for (int dir = 0; dir < 4; dir++) {
				int nr = temp[0] + dr[dir];
				int nc = temp[1] + dc[dir];
				if (nr >= 0 && nr < N && nc >= 0 && nc < M && !visited[nr][nc]) {
					qu.add(new int[] {nr, nc, temp[2] + 1});
					visited[nr][nc] = true;
				}
			}
		}
	}
}
