public class 부분집합_비트마스킹 {
	static String arr[] = {"1", "2", "3", "4"};
	static int N = arr.length;
	
	public static void main(String[] args) {
		
		for (int i = 0; i < 1<<N; i++) {
			String str = "";
			for (int j = 0; j < N; j++) {
				if ((i & 1<<j) != 0) {
					str += arr[j];
				}
			}
			System.out.println(str);
		}
	}
}
