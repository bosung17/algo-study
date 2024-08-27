import java.util.Arrays;

public class practice {
	static int[] nums = {1, 2, 3, 4};
	static int N = nums.length;
	static int[] sum = new int[1<<N];

	public static void main(String[] args) {

		for (int i = 0; i < 1<<N; i++) {
			for (int j = 0; j < N; j++) {
				if ((i & 1<<j) > 0) {
					sum[i] += nums[j];
				}
			}
		}
		
		System.out.println(Arrays.toString(sum));
	}
}
