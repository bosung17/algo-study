package BOJ_2178_미로_탐색;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int N, M, count;
	static int[][] board;
//	static boolean[][] visited;
	static int[] dr = {0, 1, 0, -1};
	static int[] dc = {1, 0, -1, 0};
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		board = new int[N][M];
//		visited = new boolean[N][M];
		count = Integer.MAX_VALUE;
		
		for (int r = 0; r < N; r++) {
			String str = sc.next();
			for (int c = 0; c < M; c++) {
				board[r][c] = str.charAt(c) - '0';
			}
		}
		BFS(0, 0);
//		DFS(0, 0, 1);
		System.out.println(count);
	}
	static void BFS(int r, int c) {
		Queue<int[]> qu = new LinkedList<>();
		qu.add(new int[] {r, c, 1});
		board[r][c] = 0;
		while(!qu.isEmpty()) {
			int[] curr = qu.poll();
			if (curr[0] == N-1 && curr[1] == M-1) {
				count = curr[2];
				return;
			}
			for (int dir = 0; dir < 4; dir++) {
				int nr = curr[0] + dr[dir];
				int nc = curr[1] + dc[dir];
				if (nr >= 0 && nr < board.length && nc >= 0 && nc < board[0].length && board[nr][nc] == 1) {
					qu.add(new int[] {nr, nc, curr[2]+1});
					board[nr][nc] = 0;
				}
			}
		}
	}
//	static void DFS(int r, int c, int n) {
//		if (r == N-1 && c == M-1) {
//			count = Math.min(count, n);
////			visited = new boolean[N][M];
//			return;
//		}
//		visited[r][c] = true;
//		int[] dr = {0, 1, 0, -1};
//		int[] dc = {1, 0, -1, 0};
//		for (int dir = 0; dir < 4; dir++) {
//			int nr = r + dr[dir];
//			int nc = c + dc[dir];
//			if (nr >= 0 && nr < N && nc >= 0 && nc < M && board[nr][nc] == 1 && !visited[nr][nc]) {
//				DFS(nr, nc, n+1);
//			}
//		}
//	}
}
