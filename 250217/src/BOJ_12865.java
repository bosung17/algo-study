import java.util.Arrays;
import java.util.Scanner;

public class BOJ_12865 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int K = sc.nextInt();

		int[][] board = new int[N][2];

		for (int r = 0; r < N; r++) {
			for (int c = 0; c < 2; c++) {
				board[r][c] = sc.nextInt();
			}
		}
		
		int[] dp = new int[K+1];
		
		for (int i = 0; i < N; i++) {
			for (int j = K; j >= board[i][0]; j--) {
				dp[j] = Math.max(dp[j], dp[j - board[i][0]] + board[i][1]);
			}
        }

		System.out.println(dp[K]);
	}
}