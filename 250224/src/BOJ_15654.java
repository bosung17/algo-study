import java.util.Arrays;
import java.util.Scanner;

public class BOJ_15654 {
	static int N, M;
	static int[] arr, ans;
	static boolean[] visited;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		arr = new int[N];
		ans = new int[M];
		visited = new boolean[N];
		
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		
		Arrays.sort(arr);
		
		dfs(0);
	}
	static void dfs(int depth) {
		if (depth == M) {
			for (int i = 0; i < M; i++) {
				System.out.print(ans[i] + " ");
			}
			System.out.println();
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if (visited[i]) continue;
			
			ans[depth] = arr[i];
			visited[i] = true;
			dfs(depth+1);
			visited[i] = false;
		}
		
	}
}
