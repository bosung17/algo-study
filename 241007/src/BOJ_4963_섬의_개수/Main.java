package BOJ_4963_섬의_개수;

//import java.util.LinkedList;
//import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int[][] board;
//	static boolean[][] visited;
	static int count;
	static int[] dr = {0, 1, 1, 1, 0, -1, -1, -1};
	static int[] dc = {1, 1, 0, -1, -1, -1, 0, 1};
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		while (true) {
			int[] curr = {sc.nextInt(), sc.nextInt()};
			if (curr[0] + curr[1] == 0) {
				break;
			}
			
			board = new int[curr[1]][curr[0]];
//			visited = new boolean[curr[1]][curr[0]];
			count = 0;
			
			for (int r = 0; r < board.length; r++) {
				for (int c = 0; c < board[0].length; c++) {
					board[r][c] = sc.nextInt();
				}
			}

			for (int r = 0; r < board.length; r++) {
				for (int c = 0; c < board[0].length; c++) {
//					if (board[r][c] == 1 && !visited[r][c]) {
//						BFS(r, c);
//					}
					if (board[r][c] == 1) {
						DFS(r, c);
						count++;
					}
				}
			}
			System.out.println(count);
		}
	}
	
//	static void BFS(int r, int c) {
//		Queue<int[]> qu = new LinkedList<>();
//		qu.add(new int[] {r, c});
//		while(!qu.isEmpty()) {
//			int[] curr = qu.poll();
////			visited[curr[0]][curr[1]] = true;
//			board[curr[0]][curr[1]] = 0;
//			for (int dir = 0; dir < 8; dir++) {
//				int nr = curr[0] + dr[dir];
//				int nc = curr[1] + dc[dir];
////				if (nr >= 0 && nr < board.length && nc >= 0 && nc < board[0].length && board[nr][nc] == 1 && !visited[nr][nc]) {
////					qu.add(new int[] {nr, nc});
////				}
//				if (nr >= 0 && nr < board.length && nc >= 0 && nc < board[0].length && board[nr][nc] == 1) {
//					qu.add(new int[] {nr, nc});
//				}
//
//			}
//		}
//		count++;
//	}
	static void DFS(int r, int c) {
//		visited[r][c] = true;
		board[r][c] = 0;
		for (int dir = 0; dir < 8; dir++) {
			int nr = r + dr[dir];
			int nc = c + dc[dir];
			if (nr >= 0 && nr < board.length && nc >= 0 && nc < board[0].length && board[nr][nc] == 1) {
				DFS(nr, nc);
			}
		}
	}
}
