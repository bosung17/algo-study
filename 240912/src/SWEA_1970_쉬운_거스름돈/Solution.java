package SWEA_1970_쉬운_거스름돈;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int t = 1; t <= T; t++) {
			
			// 거슬러 줄 금액
			int N = sc.nextInt();
			
			// 답 저장할 배열 ans
			int[] ans = new int[8];
			// 돈의 종류 배열 money
			int[] money = {50000, 10000, 5000, 1000, 500, 100, 50, 10};
			
			// ans의 0번째 인덱스는 N/50000
			ans[0] = N/50000;
			// ans의 i번째 인덱스는 N을 money 배열의 이전 인덱스로 나눈 나머지를 money 배열의 i번째 인덱스로 나눈 몫
			for (int i = 1; i < 8; i++) {
				ans[i] = (N%money[i-1]/money[i]);
			}
			
			// 문제의 요구대로 ans 배열 출력
			System.out.println("#" + t);
			for (int i = 0; i < 8; i++) {
				System.out.print(ans[i] + " ");
			}
			System.out.println();
		}
	}
}
