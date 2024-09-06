package BOJ_2225_합분해;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
//		int K = sc.nextInt();
		
		int[] dp = new int[N+1]; 
		
//		for (int i = 0; i <= N; i++) {
//			dp[i] = i;
//		}
		
		dp[1] = 1;
		
		for (int i = 2; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (i > j)
				dp[i] += dp[i-j] * dp[j];
			}
		}
		
		System.out.println(Arrays.toString(dp));
	}
}
// 하다 지쳤음 내일 해야지