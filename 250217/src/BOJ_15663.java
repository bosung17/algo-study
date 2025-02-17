import java.util.Arrays;
import java.util.Scanner;

public class BOJ_15663 {
	static int N, M;
	static int[] arr;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();

		arr = new int[N];

		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}

		Arrays.sort(arr);

	}
}
