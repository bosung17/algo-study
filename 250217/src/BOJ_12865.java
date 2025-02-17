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

		// 1, 2, 3의 무게로 가치가 10, 15, 20인 애가 있을 때 dp[3]을 1과 2를 사용해서 25로 저장하면 dp[4]를 구할 때 3의 무게로 20의 가치를 가진 놈의 정보를 얻을 수 없어 25가 되어버린다.
		// 이를 해결하기 위해 dp[3]을 20으로 저장하면 후에 에러가 나지 않지만 dp[3]이 틀린 값이 되어버림
		// 해결하기 위해선 dp[3]을 두 개로 나누어야 하나..? -> 처음 입력받는 놈들을 어떻게 해야 할 듯
		
		
		int[] dp = new int[100001];
		boolean[][] used = new boolean[100001][N];

		for (int i = 0; i < N; i++) {
			dp[board[i][0]] = Math.max(dp[board[i][0]], board[i][1]);
			used[board[i][0]][i] = true;
		}

		for (int i = 0; i < 100001; i++) {
			boolean stop = false;
			for (int l = 0; l < N; l++) {
				if (board[l][0] == i) {
					stop = true;
				}
			}
			if (!stop) {
				for (int j = 0; j < N; j++) {
					if (i >= board[j][0]) {
						if (dp[board[j][0]] + dp[i - board[j][0]] > dp[i]) {
							boolean clean = true;
							for (int k = 0; k < N; k++) {
								if (used[board[j][0]][k] && used[i - board[j][0]][k]) {
									clean = false;
									break;
								}
							}
							if (clean) {
								for (int k = 0; k < N; k++) {
									used[i][k] = (used[board[j][0]][k] || used[i - board[j][0]][k]);
									dp[i] = dp[board[j][0]] + dp[i - board[j][0]];
								}
							}
						}
					}
				}
				if (i > 0) {
					if (dp[i] < dp[i - 1]) {
						dp[i] = dp[i - 1];
						for (int j = 0; j < N; j++) {
							used[i][j] = used[i - 1][j];
						}
					}
				}
			}
		}
		System.out.println(dp[K]);
//		System.out.println(Arrays.toString(dp));
//		for (int r = 0; r < K + 1; r++) {
//			System.out.print(r + "번째: [ ");
//			for (int c = 0; c < N; c++) {
//				System.out.print(board[c][0]);
//				System.out.print(used[r][c] + ", ");
//			}
//			System.out.println("]");
//		}
	}
}

/*
 * 4 10 2 65 4 46 1 45 3 54
 */
