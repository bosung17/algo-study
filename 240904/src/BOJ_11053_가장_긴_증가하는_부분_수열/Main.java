package BOJ_11053_가장_긴_증가하는_부분_수열;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int[] arr = new int[N];
		
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		
		int[] dp = new int[N];
		dp[0] = 1;
		int[] max = new int[N]; // max에 저장하고 싶은 것 : j까지 가장 긴 부분수열을 이루는 수 중에 가장 큰 값
		max[0] = arr[0];
		
		for (int i = 1; i < N; i++) {
			for (int j = 0; j < i; j++) {
				if (arr[i] > max[j]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
					max[i] = Math.max(max[j], arr[i]);
				}
				else {
					dp[i] = Math.max(dp[i], dp[j]);
					max[i] = max[j];
				}
			}
		}
		
		System.out.println(Arrays.toString(dp));
		System.out.println(Arrays.toString(max));
		
//		System.out.println(dp[N-1]);
	}
}
// dp[i]와 max[i]만 저장 잘 하면 풀릴 거 같은데 dp[i]가 여러 경우에서 같은 낮은 값이 나올 때 max[i]를 낮은 놈으로 저장해야 함.. 이것조차 틀릴 수도 있지만.. 흑