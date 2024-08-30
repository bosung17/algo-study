package SWEA_2806_NQueen;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	static int[][] board;
	static int N;
	static boolean[] setQ;
	static int[] Q;
	static int count;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int t = 1; t <= T; t++) {
			
			N = sc.nextInt();
			
			board = new int[N][N];
			setQ = new boolean[N];
			Q = new int[N];
			count = 0;
			
			putQ(0);
			
			System.out.println(count);
		}
	}
	
	static void putQ(int idx) {
		
		// idx행에서 퀸을 놓을 수 있는 곳을 찾아 퀸을 놓고 아래 방향과 아래 대각선으로 보드에 1 더하기
		for (int i = Q[idx]; i < N; i++) {
			if (board[idx][i] == 0) {
				board[idx][i] = N+1; // (idx, i)에 퀸 두기
				setQ[idx] = true;
				Q[idx] = i; // Q[idx]: idx행에서 퀸을 둔 열
				for (int j = 1; j + idx < N; j++) {
					board[idx + j][i] += 1;
					if (i - j >= 0) {
						board[idx + j][i - j] += 1;
					}
					if (i + j < N) {
						board[idx + j][i + j] += 1;
					}
				}
				for (int r = 0; r < N; r++) {
					for (int c = 0; c < N; c++) {
						System.out.print(board[r][c] + " ");
					}
					System.out.println();
				}
				System.out.println();
			}
			if (setQ[idx]) break;
		}
		
		if (!setQ[idx]) {
			System.out.println("이건 아니다 전 행으로 ㄱㄱ");
			for (int j = 1; j + idx - 1 < N; j++) {
				board[idx + j - 1][Q[idx-1]] -= 1;
				if (Q[idx-1] - j >= 0) {
					board[idx + j - 1][Q[idx-1] - j] -= 1;
				}
				if (Q[idx-1] + j < N) {
					board[idx + j - 1][Q[idx-1] + j] -= 1;
				}
			}
			board[idx-1][Q[idx-1]] = 0;
			setQ[idx-1] = false;
//			if (Q[idx-1] < N-1)
			Q[idx-1]++;
			Q[idx] = 0;
			putQ(idx - 1);
		}
		
		if (setQ[N-1]) {
			System.out.println("찾았다!");
			count++;
			setQ[N-1] = false;
			board[N-1][Q[N-1]] = 0;
			Q[N-1-1]++;
			putQ(idx - 1);
		}
//		if (idx + 1 < N)
		putQ(idx + 1);
	}
}
// 기저조건, 인덱스 넘는 거 두 개 정리하면 풀릴 거 같은디..