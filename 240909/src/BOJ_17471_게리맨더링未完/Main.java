package BOJ_17471_게리맨더링未完;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int[] arr = new int[N+1];
		for (int i = 1; i <= N; i++) {
			arr[i] = sc.nextInt();
		}
		
		int board[][] = new int[N+1][];
		for (int i= 1; i <= N; i++) {
			int length = sc.nextInt();
			board[i] = new int[length];
			for (int j = 0; j < length; j++) {
				board[i][j] = sc.nextInt();
			}
		}
		
		int ans = 987654321;
		
		for (int i = 1; i < ((1<<N)-1); i++) {
			boolean[] sel = new boolean[N+1];
			for (int j = 0; j < N; j++) {
				if ((i & (1 << j)) > 0) {
					sel[j+1] = true;
				}
			}
			// j지역이 다른 어느지역과 하나라도 이어져있고 그 지역과 같은 그룹이면 linked[j] = true
			boolean[] linked = new boolean[N+1];
			for (int j = 1; j <= N; j++) {
				for (int k = 1; k <= N; k++) {
					if (sel[k] == sel[j]) {
						for (int l = 0; l < board[j].length; l++) {
							if (board[j][l] == k) {
								linked[j] = true;
							}
						}
					}
				}
			}
			// 가능한 경우
			// 1. 모든 linked가 true일 때
			// 2. 하나의 sel만 나머지와 다르면서(여기선 얘만 true면서) 얘의 linked만 false일 때
			boolean sep = true;
			for (int j = 1; j <= N; j++) {
				if (!linked[j]) {
					sep = false;
				}
			}
			int countS = 0; // sel을 셀 countS
			int countL = 0; // linked를 셀 countL
			int count = 0;
			for (int j = 1; j <= N; j++) {
				if (sel[j]) {
					countS++;
				}
				if (!linked[j]) {
					countL++;
				}
				if (sel[j] && !linked[j]) {
					count++;
				}
			}
			if (countS == 1 && countL == 1 && count == 1) {
				sep = true;
			}
			if (sep) {
				int sumA = 0;
				int sumB = 0;
				for (int j = 1; j <= N; j++) {
					if (sel[j]) sumA += arr[j];
					else sumB += arr[j];
				}
				ans = Math.min(ans, Math.abs(sumA-sumB));
			}
		}
		if (ans == 987654321) ans = -1;
		System.out.println(ans);
	}
}
