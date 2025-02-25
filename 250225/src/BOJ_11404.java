import java.util.Scanner;

public class BOJ_11404 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();

		int[][] city = new int[n + 1][n + 1];

		for (int i = 0; i < m; i++) {
			int start = sc.nextInt();
			int end = sc.nextInt();
			int cost = sc.nextInt();
			if (city[start][end] == 0) {
				city[start][end] = cost;
			} else {
				city[start][end] = Math.min(city[start][end], cost);
			}
		}

		for (int repeat = 0; repeat < n - 1; repeat++) {
			for (int r = 1; r <= n; r++) {
				for (int c = 1; c <= n; c++) {
					if (r == c)
						continue;
					for (int i = 1; i <= n; i++) {
						if (city[r][c] == 0 && city[r][i] != 0 && city[i][c] != 0) {
							city[r][c] = city[r][i] + city[i][c];
						}
						if (city[r][c] != 0 && city[r][i] != 0 && city[i][c] != 0) {
							city[r][c] = Math.min(city[r][c], city[r][i] + city[i][c]);
						}
					}
				}
			}
		}

		for (int r = 1; r <= n; r++) {
			for (int c = 1; c <= n; c++) {
				System.out.print(city[r][c] + " ");
			}
			System.out.println();
		}
	}
}
