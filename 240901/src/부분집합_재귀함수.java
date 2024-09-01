public class 부분집합_재귀함수 {
	static String arr[] = {"1", "2", "3", "4"};
	static int N = arr.length;
	static boolean sel[] = new boolean[N];
	
	public static void main(String[] args) {
		
		powerset(0);
	}
	
	static void powerset(int idx) {
		
		if (idx == N) {
			for (int i = 0; i < N; i++) {
				if(sel[i]) {
					System.out.print(arr[i]);
				}
			}
			System.out.println();
			return;
		}
		
		sel[idx] = true;
		powerset(idx+1);
		
		sel[idx] = false;
		powerset(idx+1);
	}
}
