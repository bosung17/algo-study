package SWEA_5215_햄버거_다이어트;

import java.util.Scanner;

public class Solution {
	static boolean[] sel;
	static int[][] board;
	static int N;
	static int L;
	static int max;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int t = 1; t <= T; t++) {
			
			// 각 테스트 케이스의 재료 수와 제한 칼로리 입력 받기
			N = sc.nextInt();
			L = sc.nextInt();
			
			// 각 재료의 점수와 칼로리를 저장할 2차원 배열 만들기
			board = new int[N][2];
			sel = new boolean[N];
			
			// 각 햄버거마다 점수와 칼로리 저장하기
			for (int i = 0; i < N; i++) {
				board[i][0] = sc.nextInt(); // 점수
				board[i][1] = sc.nextInt(); // 칼로리
			}
			
			max = 0;
			
			hamsel(0);
			
			System.out.println("#" + t + " " + max);
			
		}
	}
	
	static void hamsel(int idx) {
		
		if (idx == N) {
			int score = 0;
			int cal = 0;
			for (int i = 0; i < N; i++) {
				if (sel[i]) {
					score += board[i][0];
					cal += board[i][1];
				}
			}
			if (cal <= L) {
				if (score > max) {
					max = score;
				}
			}
			return;
		}
		
		sel[idx] = true;
		hamsel(idx + 1);
		sel[idx] = false;
		hamsel(idx + 1);
	}
}
