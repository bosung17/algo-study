package BOJ_16236_아기_상어;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	static int N;
	static int[][] board;
	static boolean[][] visited;
	static int BS = 2;
	static int eatCount;
	static int move;
	static int[] dr = { -1, 0, 0, 1 };
	static int[] dc = { 0, -1, 1, 0 };
	static Queue<int[]> qu = new LinkedList<>();
	static List<int[]> list = new ArrayList<>();
	static int dist;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		board = new int[N][N];
		visited = new boolean[N][N];
		eatCount = 0;
		move = 0;

		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				board[r][c] = sc.nextInt();
			}
		}

		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				if (board[r][c] == 9) {
					eat(r, c);
				}
			}
		}

		System.out.println(move);
	}

	static void eat(int r, int c) {
		qu.add(new int[] { r, c, 0 });
		board[r][c] = 0;
		visited[r][c] = true;
		dist = 1;
		while (!qu.isEmpty()) {
			int[] curr = qu.poll();
			for (int dir = 0; dir < 4; dir++) {
				int nr = curr[0] + dr[dir];
				int nc = curr[1] + dc[dir];
				if (nr >= 0 && nr < N && nc >= 0 && nc < N && !visited[nr][nc] && board[nr][nc] <= BS) {
					qu.add(new int[] { nr, nc, curr[2] + 1 });
					visited[nr][nc] = true;
				}
			}
			
			if (curr[2] == dist) {
				list.add(curr);
			}
			// 1. 지금 위치에서도 조건에 맞는지 확인할 수 있게 하기 위해 peek해서 dist와 비교
			// 2. 큐가 비어있어 peek이 null인 경우에도 조건에 맞는지 확인
			// 3. 2의 경우를 위해 qu.isEmpty()를 넣었는데 while문이 처음 시작하는 곳에서 qu가 비어있어 원치 않게 if 문으로 들어가길래 큐에 집어넣는 과정을 위로 올림
			if (qu.isEmpty() || qu.peek()[2] > dist) {
				Collections.sort(list, new Comparator<int[]>() {
					@Override
					public int compare(int[] o1, int[] o2) {
						if (o1[0] > o2[0]) {
							return 1;
						} else if (o1[0] == o2[0]) {
							return o1[1] - o2[1];
						} else {
							return -1;
						}
					}
				});
				for (int i = 0; i < list.size(); i++) {
					int[] temp = list.get(i);
					if (board[temp[0]][temp[1]] < BS && board[temp[0]][temp[1]] != 0) {
						eatCount++;
						if (eatCount == BS) {
							BS++;
							eatCount = 0;
						}
						move += temp[2];
						visited = new boolean[N][N];
						list.clear();
						qu.clear();
						eat(temp[0], temp[1]);
						break;
					}
				}
				list.clear();
				dist++;
			}
		}
	}
}
