package SWEA_5356_의석이의_세로로_말해요;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int test_case = 1; test_case <= T; test_case++) {
			
			// 행의 개수는 5개, 열의 개수는 지정되지 않음
			char[][] board = new char[5][];
			
			// 5개의 단어를 나누어 2차원 char 배열에 저장
			for (int r = 0; r < 5; r++) {
				// 각 행의 단어를 문자열로 받은 후 문자열의 길이를 세서 열 배열의 길이 설정
				String str = sc.next();
				board[r] = new char[str.length()];
				// 행마다 길이가 다른 열을 고려하여 2차원 배열에 저장
				for (int c = 0; c < str.length(); c++) {
					board[r][c] = str.charAt(c);
				}
			}
			
			// 가장 긴 열의 길이를 저장할 maxLength 생성
			int maxLength = 0;
			
			// 모든 행을 돌며 가장 긴 열의 길이를 maxLength에 저장
			for (int i = 0; i < 5; i++) {
				if (board[i].length > maxLength) {
					maxLength = board[i].length;
				}
			}
			
			System.out.print("#" + test_case + " ");
			
			// 가장 긴 열의 길이까지 세로로 출력
			for (int c = 0; c < maxLength; c++) {
				for (int r = 0; r < 5; r++) {
					// 각 행마다 열의 최대 길이를 넘으면 출력되지 않도록 함
					if (c < board[r].length) {
						System.out.print(board[r][c]);
					}
				}
			}
			
			System.out.println();
			
		}
	}
}
