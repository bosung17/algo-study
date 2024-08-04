package snailnumber;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();

		int[][][] snail = new int[t][][];
		
		for (int i=0; i<t; i++) {
			
			int N = sc.nextInt();
			
			int[][] arr = new int[N][N];
			
			int r=0;
			int c=0;
			
			int[] dr = {1, 0, -1, 0};
			int[] dc = {0, 1, 0, -1};
			
			int dir = 0;

			for (int j=0; j<N*N; j++) {
				
				arr[r][c] = j+1;
				
				int nr = r+dr[dir];
				int nc = c+dc[dir];
				
				if (nr == N || nr < 0 || nc == N || nc < 0 || arr[nr][nc] != 0) {
					dir = (dir+1)%4;
					nr = r+dr[dir];
					nc = c+dc[dir];
				}
				
				r = nr;
				c = nc;
			}
			snail[i] = arr;
		}
		for (int i=0; i<t; i++) {
			System.out.println("#" + (i+1));
			for (int r=0; r<snail[i][0].length;r++) {
				for (int c=0; c<snail[i][0].length; c++) {
					System.out.print(snail[i][r][c] + " ");
				}
				System.out.println();
			}
		}
	}
}
