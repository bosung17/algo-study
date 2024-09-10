import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int[][] board = new int[N][];
		
		for (int r = 0; r < N; r++) {
			int length = sc.nextInt();
			board[r] = new int[length];
			for (int c = 0; c < length; c++) {
				board[r][c] = sc.nextInt();
			}
		}
		
		System.out.println(Arrays.deepToString(board));
	}
}
