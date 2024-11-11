package SWEA_8382_방향_전환;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int t = 1; t <= T; t++) {
			int[] start = new int[2];
			int[] end = new int[2];
			
			start[0] = sc.nextInt();
			start[1] = sc.nextInt();
			end[0] = sc.nextInt();
			end[1] = sc.nextInt();
			
			end[0] = Math.abs(end[0] - start[0]);
			end[1] = Math.abs(end[1] - start[1]);
			start = new int[] {0, 0};
			
			Arrays.sort(end);
			
			int ans = 0;
			if ((end[1] - end[0]) % 2 == 0) {
				ans = end[1] * 2;
			}
			else {
				ans = end[1] * 2 - 1;
			}
			
			System.out.println("#" + t + " " + ans);
		}
	}
}
