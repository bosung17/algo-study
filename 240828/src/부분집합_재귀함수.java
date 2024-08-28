import java.util.ArrayList;
import java.util.List;

public class 부분집합_재귀함수 {
	static int[] arr = {8, 4, 2, 1};
	static int N = arr.length;
	static boolean sel[] = new boolean[N];
	
	public static void main(String[] args) {
		powerset(0);
	}
	
	static void powerset(int idx) {
		
		if (idx == N) {
			List<Integer> arrs = new ArrayList<>();
			int sum = 0;
			for (int i = 0; i < N; i++) {
				if(sel[i]) {
					arrs.add(arr[i]);
					sum += arr[i];
				}
			}
			System.out.print(sum + " ");
			System.out.println(arrs);
			return;
		}
		
		sel[idx] = false;
		powerset(idx+1);
		sel[idx] = true;
		powerset(idx+1);
	}
}
