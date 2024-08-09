package SWEA_4613_러시아_국기_같은_깃발;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int test_case = 1; test_case <= T; test_case++) {
			
			int N = sc.nextInt();
			int M = sc.nextInt();

			char[][] color = new char[N][M];
			
			for (int r = 0; r < N; r++) {
				String str = sc.next();
				for (int c = 0; c < M; c++) {
					color[r][c] = str.charAt(c);
				}
			}
			
			int count = 0;
			
			// 첫 행
			for (int c = 0; c < M; c++) {
				if (color[0][c] != 'W') {
					count += 1;
					
				}
			}
			
			// 마지막 행
			for (int c = 0; c < M; c++) {
				if (color[N-1][c] != 'R') {
					count += 1;
				}
			}
			
			// 그 외
			for (int boundary = 1; boundary <= N-2; boundary++) {
				for (int w = 1; w < boundary; w++) {
					
				}
				for (int b = boundary; b <= N-2; b++) {
					
				}
			}
			
//			System.out.println(count);
			
		}
	}
}
