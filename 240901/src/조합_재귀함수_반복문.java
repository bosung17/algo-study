public class 조합_재귀함수_반복문 {
	static String arr[] = {"1", "2", "3", "4"};
	static int N = arr.length;
	static int R = 2;
	static String sel[] = new String[N];
	
	public static void main(String[] args) {
		combination(0,0);
	}
	
	static void combination(int idx, int sidx) {
		
		if (sidx == R) {
			for (int i = 0; i < N; i++) {
				if(sel[i] != null) {
					System.out.print(sel[i]);
				}
			}
			System.out.println();
			return;
		}
		
		for (int i = idx; i <= N-R+sidx; i++) {
			sel[sidx] = arr[i];
			combination(idx+1, sidx+1);
		}
	}
}
