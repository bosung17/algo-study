package SWEA_4615_재미있는_오셀로_게임;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int test_case = 1; test_case <= T; test_case++) {
			
			// 보드의 크기 입력
			int N = sc.nextInt();
			
			// N*N의 2차원 배열 만들기
			int[][] board = new int[N][N];
			
			// 시작 전 배치에 따라 흑돌과 백돌 배치
			board[N/2 -1][N/2 -1] = 2;
			board[N/2 -1][N/2] = 1;
			board[N/2][N/2 -1] = 1;
			board[N/2][N/2] = 2;
			
			// 돌을 놓는 횟수 입력
			int M = sc.nextInt();
			
			// 돌을 놓을 때마다 오셀로 규칙에 맞게 보드 위의 돌 설정
			for (int i = 0; i < M; i++) {
				
				// 돌을 놓는 위치와 놓는 돌의 색깔 입력
				int r = sc.nextInt();
				int c = sc.nextInt();
				int color = sc.nextInt();
				
				// index에 맞게 1씩 빼서 돌 위치와 색깔 설정
				board[r-1][c-1] = color;
				
				// 8방향을 탐색하기 위한 방향 설정
				int[] dr = {0, 1, 1, 1, 0, -1, -1, -1};
				int[] dc = {1, 1, 0, -1, -1, -1, 0, 1};
				
				// 각 방향마다 한 칸씩 증가시키며 탐색 후
				// 같은 색의 돌을 만나면 만나기 전까지의 돌들을 같은 색으로 변경
				// 빈 곳을 만나면 다른 방향으로 탐색
				for (int dir = 0; dir < 8; dir++) {
					// 정해진 방향으로 1칸 옆부터 보드판의 끝까지 탐색
					// 조건에 맞는 돌을 찾으면 다음 방향
					for (int j = 1; j < N; j++) {
						// 보드판을 나가지 않는 선에서
						if (r-1+j*(dr[dir]) >= 0 && r-1+j*(dr[dir]) < N && c-1+j*(dc[dir]) >= 0 && c-1+j*(dc[dir]) < N) {
							// 빈 곳을 만나면 다른 방향으로 탐색하기 위해 break
							if (board[r-1+j*(dr[dir])][c-1+j*(dc[dir])] == 0) {
								break;
							}
							// 같은 색의 돌을 만나면
							else if (board[r-1+j*(dr[dir])][c-1+j*(dc[dir])] == color) {
								// 만나기 전까지의 돌을 같은 색의 돌로 바꾼 후 다른 방향으로 탐색하기 위해 break
								for (int k = 1; k < j; k++) {
									board[r-1+k*(dr[dir])][c-1+k*(dc[dir])] = color;
								}
								break;
							}
						}
					}
				}
			}
			
			// M번의 착수 후 흑돌과 백돌의 개수를 저장할 변수 생성
			int countBlack = 0;
			int countWhite = 0;
			
			// 보드판 전체를 탐색하여 흑돌과 백돌의 개수 저장
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					if (board[r][c] == 1) {
						countBlack++;
					}
					else if (board[r][c] == 2){
						countWhite++;
					}
				}
			}
			
			// 테스트 케이스 번호와 흑돌, 백돌의 개수 출력
			System.out.println("#" + test_case + " " + countBlack + " " + countWhite);
		}
	}
}
