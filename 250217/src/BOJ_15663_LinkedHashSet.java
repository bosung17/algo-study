import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class BOJ_15663_LinkedHashSet {
	static int N, M;
	static int[] nums, perm;
	static boolean[] visited;
	static LinkedHashSet<String> ans;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();

		nums = new int[N];
		perm = new int[M];
		visited = new boolean[N];
		ans = new LinkedHashSet<>();

		for (int i = 0; i < N; i++)
			nums[i] = sc.nextInt();

		Arrays.sort(nums);
		permutation(0);
		ans.forEach(System.out::println);
	}

	static void permutation(int cnt) {
		if (cnt == M) {
			StringBuilder sb = new StringBuilder();
            for (int p : perm)
                sb.append(p).append(' ');
            ans.add(sb.toString());
            return;
		}

		for (int i = 0; i < N; i++) {
			if (visited[i])
				continue;
			visited[i] = true;
			perm[cnt] = nums[i];
			permutation(cnt + 1);
			visited[i] = false;
		}
	}
}