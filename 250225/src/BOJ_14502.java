import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_14502 {

	static int N, M, count, ans;
	static int[][] lab;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();

		lab = new int[N][M];

		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				lab[r][c] = sc.nextInt();
			}
		}

		for (int r1 = 0; r1 < N; r1++) {
			for (int c1 = 0; c1 < M; c1++) {
				if (lab[r1][c1] == 0) {
					lab[r1][c1] = 1;
					for (int r2 = 0; r2 < N; r2++) {
						for (int c2 = 0; c2 < M; c2++) {
							if (r2 > r1 || (r2 == r1 && c2 > c1)) {
								if (lab[r2][c2] == 0) {
									lab[r2][c2] = 1;
									for (int r3 = 0; r3 < N; r3++) {
										for (int c3 = 0; c3 < M; c3++) {
											if (r3 > r2 || (r3 == r2 && c3 > c2)) {
												if (lab[r3][c3] == 0) {
													lab[r3][c3] = 1;
													virus();
													lab[r3][c3] = 0;
												}
											}
										}
									}
									lab[r2][c2] = 0;
								}
							}
						}
					}
					lab[r1][c1] = 0;
				}
			}
		}
		System.out.println(ans);
	}

	static void virus() {
		int[][] tempLab = new int[N][M];
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				tempLab[r][c] = lab[r][c];
			}
		}
		Queue<int[]> qu = new LinkedList<>();
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				if (tempLab[r][c] == 2) {
					qu.add(new int[] { r, c });
				}
			}
		}
		count = 0;
		while (!qu.isEmpty()) {
			int[] curr = qu.poll();
			int[] dr = { 0, 1, 0, -1 };
			int[] dc = { 1, 0, -1, 0 };
			for (int dir = 0; dir < 4; dir++) {
				int nr = curr[0] + dr[dir];
				int nc = curr[1] + dc[dir];
				if (nr >= 0 && nr < N && nc >= 0 && nc < M && tempLab[nr][nc] == 0) {
					tempLab[nr][nc] = 2;
					qu.add(new int[] { nr, nc });
				}
			}
		}
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				if (tempLab[r][c] == 0) {
					count++;
				}
			}
		}
		ans = Math.max(ans, count);
	}
}