public class 조합_재귀함수 {
	static String arr[] = {"1", "2", "3", "4"};
	static int N = arr.length;
	static int R = 3;
	static boolean sel[] = new boolean[N];
	
	public static void main(String[] args) {
		combination(0,0);
	}
	
	static void combination(int idx, int sidx) {
		
		if (sidx == R) {
			for (int i = 0; i < N; i++) {
				if(sel[i]) {
					System.out.print(arr[i]);
				}
			}
			System.out.println();
			return;
		}
		if(idx == N) return;
		
		sel[idx] = true;
		combination(idx+1, sidx+1);
		sel[idx] = false;
		combination(idx+1, sidx);
	}
}
