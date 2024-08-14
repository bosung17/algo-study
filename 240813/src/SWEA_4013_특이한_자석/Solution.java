package SWEA_4013_특이한_자석;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int t = 1; t <= T; t++) {
			
			// 자석을 회전시키는 횟수
			int K = sc.nextInt();
			
			// 처음 자석 상태 입력
			int[] m1 = new int[8];
			int[] m2 = new int[8];
			int[] m3 = new int[8];
			int[] m4 = new int[8];
			
			for (int i = 0; i < 8; i++) {
				m1[i] = sc.nextInt();
			}
			for (int i = 0; i < 8; i++) {
				m2[i] = sc.nextInt();
			}
			for (int i = 0; i < 8; i++) {
				m3[i] = sc.nextInt();
			}
			for (int i = 0; i < 8; i++) {
				m4[i] = sc.nextInt();
			}
			
			// 자석 회전시키기
			for (int i = 0; i < K; i++) {
				
				// 돌릴 자석의 번호와 돌리는 방향 입력
				int m = sc.nextInt();
				int dir = sc.nextInt();
				
				// 돌리는 자석 번호에 따라 다르게 돌아감
				// 자석의 극을 입력한 배열을 2차원배열로 하여
				// m1, m2, m3, m4를 m[1], m[2], m[3], m[4]로 하였다면
				// 조금 더 길이가 짧은 코딩이 되었을수도?
				switch (m) {
				case 1:
					if (m1[2] != m2[6]) {
						if (m2[2] != m3[6]) {
							if (m3[2] != m4[6]) {
								spin(m1, dir);
								spin(m2, -dir);
								spin(m3, dir);
								spin(m4, -dir);
							}
							else {
								spin(m1, dir);
								spin(m2, -dir);
								spin(m3, dir);
							}
						}
						else {
							spin(m1, dir);
							spin(m2, -dir);
						}
					}
					else {
						spin(m1, dir);
					}
					break;
				case 2:
					if (m2[6] != m1[2]) {
						spin(m1, -dir);
					}
					if (m2[2] != m3[6]) {
						if (m3[2] != m4[6]) {
							spin(m2, dir);
							spin(m3, -dir);
							spin(m4, dir);
						}
						else {
							spin(m2, dir);
							spin(m3, -dir);
						}
					}
					else {
						spin(m2, dir);
					}
					break;
				case 3:
					if (m3[6] != m2[2]) {
						if (m2[6] != m1[2]) {
							spin(m2, -dir);
							spin(m1, dir);
						}
						else {
							spin(m2, -dir);
						}
					}
					if (m3[2] != m4[6]) {
						spin(m4, -dir);
						spin(m3, dir);
					}
					else {
						spin(m3, dir);
					}
					break;
				case 4:
					if (m4[6] != m3[2]) {
						if (m3[6] != m2[2]) {
							if (m2[6] != m1[2]) {
								spin(m4, dir);
								spin(m3, -dir);
								spin(m2, dir);
								spin(m1, -dir);
							}
							else {
								spin(m4, dir);
								spin(m3, -dir);
								spin(m2, dir);
							}
						}
						else {
							spin(m4, dir);
							spin(m3, -dir);
						}
					}
					else {
						spin(m4, dir);
					}
					break;
				}
			}
			
			System.out.println("#" + t + " " + (m1[0] + m2[0]*2 + m3[0]*4 + m4[0]*8));
			
		}
	}
	
	static void spin(int[] m, int dir) {
		
		if (dir == 1) {
			int temp = m[7];
			for (int i = 6; i >= 0; i--) {
				m[i+1] = m[i];
			}
			m[0] = temp;
		}
		
		if (dir == -1) {
			int temp = m[0];
			for (int i = 0; i <= 6; i++) {
				m[i] = m[i+1];
			}
			m[7] = temp;
		}
		
	}
	
}
