import java.util.Arrays;
import java.util.Scanner;

public class BOJ_15663 {
	static int N, M;
	static int[] arr, ans;
	static boolean[] visited;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();

		arr = new int[N];
		visited = new boolean[N];
		ans = new int[M];

		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}

		Arrays.sort(arr);
		dfs(0);
	}

	static void dfs(int depth) {
		if (depth == M) {
			for (int i : ans) {
				System.out.print(i + " ");
			}
			System.out.println();
			return;
		}

		for (int i = 0; i < N; i++) {
			if (visited[i])
				continue;
			// 이전과 같은 값이 아직 사용되지 않았다면, 중복되는 순열을 방지하기 위해 건너뜁니다.
			if (i > 0 && arr[i] == arr[i - 1] && !visited[i - 1])
				continue;

			visited[i] = true;
			ans[depth] = arr[i];
			dfs(depth + 1);
			visited[i] = false;
		}
	}
}
