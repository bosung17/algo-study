package SWEA_6808_규영이와_인영이의_카드게임;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	static int[] kyu = new int[9];
	static int[] iny = new int[9];
	static int winCount = 0;
	static int loseCount = 0;
	static boolean[] visited = new boolean[9];
	static int[] result = new int[9];
	static int kS, iS;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int t = 1; t <= T; t++) {
			
			for (int i = 0; i < 9; i++) {
				kyu[i] = sc.nextInt();
			}
			
			int idx = 0;
			for (int i = 1; i <= 18; i++) {
				boolean contain = false;
				for (int j = 0; j < 9; j++) {
					if (kyu[j] == i) {
						contain = true;
					}
				}
				if (!contain) iny[idx++] = i;
			}
			
			game(0);
			System.out.println("#" + t + " " + winCount + " " + loseCount);
			winCount = 0;
			loseCount = 0;
		}
	}
	static void game(int idx) {
		// 기저조건
		if (idx == 9) {
			int kS = 0;
			int iS = 0;
            for (int i = 0; i < 9; i++) {
            	if (kyu[i] > result[i]) {
            		kS += kyu[i] + result[i];
            	}
            	else iS += kyu[i] + result[i];
            }
            if (kS > iS) winCount++;
            if (iS > kS) loseCount++;
            return;
		}
		// 재귀부분
		for (int i = 0; i < 9; i++) {
			if (visited[i])
				continue;
			result[idx] = iny[i];
			visited[i] = true;
            game(idx + 1);
			visited[i] = false;
		}

	}
}
