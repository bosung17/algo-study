import java.util.Scanner;

public class BOJ_2851 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int sum = 0;
		boolean find = false;
		
		for (int i = 0; i < 10; i++) {
			int preSum = sum;
			sum += sc.nextInt();
			if (sum >= 100) {
				find = true;
				if (sum - 100 <= 100 - preSum) {
					System.out.println(sum);
					break;
				}
				else {
					System.out.println(preSum);
					break;
				}
			}
		}
		if (!find) {
			System.out.println(sum);
		}
	}
}
