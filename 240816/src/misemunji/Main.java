package misemunji;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int R = sc.nextInt();
		int C = sc.nextInt();
		int T = sc.nextInt();
		
		int[][] room = new int[R][C];
		
		int cleaner = 0;
		
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				room[r][c] = sc.nextInt();
				if (room[r][c] == -1) {
					cleaner = r - 1;
					room[r][c] = 0;
				}
			}
		}
		
		int[] dr = {0, 1, 0, -1};
		int[] dc = {1, 0, -1, 0};
		
		for (int time = 0; time < T; time++) {
			// 확산
			int[][] tempRoom = new int[R][C];
			for (int r = 0; r < R; r++) {
				for (int c = 0; c < C; c++) {
					for (int dir = 0; dir < 4; dir++) {
						if (r + dr[dir] >= 0 && r + dr[dir] < R && c + dc[dir] >= 0 && c + dc[dir] < C && !(r + dr[dir] == cleaner && c + dc[dir] == 0) && !(r + dr[dir] == cleaner + 1 && c + dc[dir] == 0)) {
							tempRoom[r + dr[dir]][c + dc[dir]] += room[r][c]/5;
							tempRoom[r][c] -= room[r][c]/5;
						}
					}
				}
			}
			for (int r = 0; r < R; r++) {
				for (int c = 0; c < C; c++) {
					room[r][c] += tempRoom[r][c];
				}
			}
			// 여기부터 공기 순환
			// 위쪽 반시계
			for (int r = cleaner; r > 0; r--) {
				room[r][0] = room[r-1][0];
 			}
			room[cleaner][0] = 0;
			for (int c = 0; c < C-1; c++) {
				room[0][c] = room[0][c+1];
			}
			for (int r = 0; r < cleaner; r++) {
				room[r][C-1] = room[r+1][C-1];
			}
			for (int c = C-1; c > 0; c--) {
				room[cleaner][c] = room[cleaner][c-1];
			}
			// 아래쪽 시계
			for (int r = cleaner + 1; r < R; r++) {
				room[r][0] = room[r-1][0];
			}
			room[cleaner+1][0] = 0;
			for (int c = 0; c < C-1; c++) {
				room[R-1][c] = room[R-1][c+1];
			}
			for (int r = R-1; r >= cleaner; r--) {
				room[r][C-1] = room[r-1][C-1];
			}
			for (int c = C-1; c > 0; c--) {
				room[cleaner+1][c] = room[cleaner+1][c-1];
			}
		}
		
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				System.out.print(room[r][c] + " ");
			}
			System.out.println();
		}
		
		int sum = 0;
		
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				sum += room[r][c];
			}
		}
		
		System.out.println(sum);
		
//		System.out.println(Arrays.deepToString(room));
//		System.out.println(cleaner);
	}
}
