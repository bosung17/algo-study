import java.util.Scanner;

public class BOJ_9251 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		String fir = sc.next();
		String sec = sc.next();

		int N = fir.length();
		int M = sec.length();

		char[] arr1 = new char[N + 1];
		char[] arr2 = new char[M + 1];

		for (int i = 1; i <= N; i++) {
			arr1[i] = fir.charAt(i - 1);
		}

		for (int i = 1; i <= M; i++) {
			arr2[i] = sec.charAt(i - 1);
		}

		int[][] dp = new int[N + 1][M + 1];

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				if (arr2[j] == arr1[i]) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
			}
		}
		System.out.println(dp[N][M]);
	}
}
