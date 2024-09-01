import java.util.Arrays;

public class 순열 {
	static int[] arr = {1,2,3,4,5,6,7,8,9};
	static int N = arr.length;
	static boolean[] visited = new boolean[N];
	static int[] result = new int[N];
	
	public static void main(String[] args) {
		perm(0);
	}
	
	static void perm(int idx) {
		
		if (idx == N) {
			System.out.println(Arrays.toString(result));
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if(visited[i]) continue;
			result[idx] = arr[i];
			visited[i] = true;
			perm(idx+1);
			visited[i] = false;
		}
	}
}
