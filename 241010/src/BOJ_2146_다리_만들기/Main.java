package BOJ_2146_다리_만들기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
//import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[][] board;
	static boolean[][] visited;
	static int num = 2;
	static int count;
	static int[] dr = {0, 1, 0, -1};
	static int[] dc = {1, 0, -1, 0};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		Scanner sc = new Scanner(System.in);
		
		N = Integer.parseInt(br.readLine());
		board = new int[N][N];
		visited = new boolean[N][N];
		
		StringTokenizer st;
		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < N; c++) {
				board[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				if (board[r][c] == 1) {
					island(r, c);
					num++;
				}
			}
		}
		
		count = Integer.MAX_VALUE;
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				if (board[r][c] != 0) {
					for (int dir = 0; dir < 4; dir++) {
						int nr = r + dr[dir];
						int nc = c + dc[dir];
						if (nr >= 0 && nr < N && nc >= 0 && nc < N && board[nr][nc] == 0) {
							bridge(nr, nc, board[r][c]);
							visited = new boolean[N][N];
						}
					}
				}
			}
		}
		
		System.out.println(count);
	}
	
	// 각 섬마다 다른 숫자로 이루어지게 하기
	static void island(int r, int c) {
		Queue<int[]> qu = new LinkedList<>();
		qu.add(new int[] {r, c});
		board[r][c] = num;
		while (!qu.isEmpty()) {
			int[] curr = qu.poll();
			for (int dir = 0; dir < 4; dir++) {
				int nr = curr[0] + dr[dir];
				int nc = curr[1] + dc[dir];
				if (nr >= 0 && nr < N && nc >= 0 && nc < N && board[nr][nc] == 1) {
					qu.add(new int[] {nr, nc});
					board[nr][nc] = num;
				}
			}
		}
	}
	
	// 다리 놓아서 가장 짧은 길이를 count에 저장
	static void bridge(int r, int c, int islandNum) {
		Queue<int[]> qu = new LinkedList<>();
		qu.add(new int[] {r, c, 1});
		visited[r][c] = true;
		while (!qu.isEmpty()) {
			int[] curr = qu.poll();
			// 다리 놓는데 이미 count보다 많이 놓으면 할 필요 없으니 리턴
			// 이거 안 하면 시간 초과 남
			if (curr[2] - 1 >= count) {
				return;
			}
			if (board[curr[0]][curr[1]] != 0 && board[curr[0]][curr[1]] != islandNum) {
				count = Math.min(count, curr[2] - 1);
			}
			for (int dir = 0; dir < 4; dir++) {
				int nr = curr[0] + dr[dir];
				int nc = curr[1] + dc[dir];
				if (nr >= 0 && nr < N && nc >= 0 && nc < N && (board[nr][nc] == 0 || board[nc][nc] != islandNum) && !visited[nr][nc]) {
					qu.add(new int[] {nr, nc, curr[2] + 1});
					visited[nr][nc] = true;
				}
			}
		}
	}
}
