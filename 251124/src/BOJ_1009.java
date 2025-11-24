import java.util.Scanner;

public class BOJ_1009 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int t = 0; t < T; t++) {

			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = 1;

			for (int i = 0; i < b; i++) {
				c = c * a % 10;
			}

			if (c == 0)
				c = 10;

			System.out.println(c);
		}
	}
}
