import java.util.Arrays;
import java.util.Scanner;

public class 순열_비트마스킹 {
	static int[] nums;
	static int N;
	static int[] results;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		nums = new int[N];
		results = new int[N];
		for (int i = 0; i < N; i++) {
			nums[i] = sc.nextInt();			
		}
		perm(0,0);
	}
	
	static void perm(int idx, int visited) {
		if (idx == N) {
			System.out.println(Arrays.toString(results));
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if ((visited & 1 << i) > 0) {
				continue;
			}
			results[idx] = nums[i];
			perm(idx+1, visited | 1 << i);
		}
	}
}
