import java.util.Scanner;

public class BOJ_12865_Top_down {

	static int[][] dp, board;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int K = sc.nextInt();

		board = new int[N][2];

		for (int r = 0; r < N; r++) {
			for (int c = 0; c < 2; c++) {
				board[r][c] = sc.nextInt();
			}
		}

		dp = new int[N][K + 1];

		System.out.println(knapsack(N - 1, K));
	}

	public static int knapsack(int n, int k) {
		if (n < 0) { // 아이템이 없을 때
			return 0;
		}

		int currW = board[n][0]; // 현재 아이템의 무게
		int currV = board[n][1]; // 현재 아이템의 가치

		if (dp[n][k] == 0) { // 메모이제이션 확인
			if (currW > k) { // 현재 아이템을 배낭에 넣을 수 없음
				dp[n][k] = knapsack(n - 1, k);
			} else { // 현재 아이템을 넣을지 말지 결정
				dp[n][k] = Math.max(knapsack(n - 1, k), // 현재 아이템을 선택하지 않는 경우
						knapsack(n - 1, k - currW) + currV); // 현재 아이템을 선택하는 경우
			}
		}
		return dp[n][k];
	}
}