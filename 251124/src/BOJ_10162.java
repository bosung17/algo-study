import java.util.Scanner;

public class BOJ_10162 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		if (T % 10 != 0) {
			System.out.println(-1);
			return;
		}
		
		int a = T / 300;
		int b = (T % 300) / 60;
		int c = (T % 60) / 10;
		
		System.out.println(a + " " + b + " " + c);
	}
}
