package SWEA_4013_특이한_자석;

import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int t = 1; t <= T; t++) {
			
			int K = sc.nextInt();
			
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
			
			
			
		}
	}
	
	static void spin(int mNum, int dir, int[] m1, int[] m2, int[] m3, int[] m4) {
		
		if (mNum == 1 && dir == 1) {
			int temp = m1[7];
			for (int i = 6; i >= 0; i--) {
				m1[i+1] = m1[i];
			}
			m1[0] = temp;
		}
		
	}
	
	
	
}
