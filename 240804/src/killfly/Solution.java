package killfly;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();

		int[] maxarr = new int[t];
		
		for (int i=0; i<t; i++) {
			
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			int[][] arr = new int[N][N];
			
			for (int r=0; r<N; r++) {
				for (int c=0; c<N; c++) {
					arr[r][c] = sc.nextInt();
				}
			}
			
			int max = 0;
			int maybemax = 0;
			
			for (int r=0; r<N; r++) {
				for (int c=0; c<N; c++) {
					maybemax = 0;
					for (int j=0; j<M; j++) {
						for (int k=0; k<M; k++) {
							if (r+j<N && c+k<N) {
								maybemax += arr[r+j][c+k];
							}
						}
					}
					if (maybemax > max) {
						max = maybemax;
					}
				}
			}
			
			maxarr[i] = max;
		}
		
		for (int i=0; i<t; i++) {
			System.out.println("#" + (i+1) + " " + maxarr[i]);
		}
	}
}
