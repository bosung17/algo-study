package SWEA_1952_수영장_dp;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int t = 1; t <= T; t++) {
			
			int D = sc.nextInt();
			int M = sc.nextInt();
			int Q = sc.nextInt();
			int Y = sc.nextInt();
			
			int[] plan = new int[12];
			
			for (int i = 0; i < 12; i++) {
				plan[i] = sc.nextInt() * D;
				if (plan[i] > M) {
					plan[i] = M;
				}
			}
			
			int[] dp = new int[12];
            
            dp[0] = plan[0];
            dp[1] = dp[0] + plan[1];
            dp[2] = Math.min(dp[1]+plan[2],Q);
            
            for (int i = 3; i < 12; i++) {
            	dp[i] = Math.min(dp[i-1] + plan[i], dp[i-3] + Q);
            }
            
            int min = dp[11];
            if (Y < min) {
            	min = Y;
            }
            
            System.out.println("#" + t + " " + min);
		}
	}
}