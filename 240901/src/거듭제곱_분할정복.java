public class 거듭제곱_분할정복 {

	public static void main(String[] args) {
		System.out.println(pow(2, 5));
	}
	
	static int pow(int C, int N) {
		
		if (N == 0) return 1;

		int temp = pow(C, N/2);
		
		if (N % 2 == 0) {
			return temp * temp;
		}
		else {
			return temp * temp * C;
		}
	}
}
