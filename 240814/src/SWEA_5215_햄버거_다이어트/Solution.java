package SWEA_5215_햄버거_다이어트;

import java.util.Scanner;

public class Solution {
	
	static int score = 0;
	static int cal = 0;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int t = 1; t <= T; t++) {
			
			int N = sc.nextInt();
			int L = sc.nextInt();
			
			int[][] burger = new int[N][2];
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < 2; j++) {
					burger[i][j] = sc.nextInt();
				}
			}
			
//			for (int i = 0; i < N; i++) {
//				eat(burger[i]);
//				if (cal > 1000) {
//					score -= burger[i][0];
//					break;
//				}
//			}
			
			System.out.println(score);
			score = 0;
			cal = 0;
		}
	}
	
	static void eat(int[] burgerNum) {
		
		score += burgerNum[0];
		cal += burgerNum[1];
	}
}
