package SWEA_2806_NQueen;

import java.util.Scanner;

public class Solution {
	static int[][] board;
	static int N;
	static boolean[] setQ;
	static int[] Q;
	static int count;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		// 테스트 케이스 수
		int T = sc.nextInt();
		
		for (int t = 1; t <= T; t++) {
			
			// 각 테스트 케이스의 N
			N = sc.nextInt();
			
			// N에 맞게
			// 체스판 2차원 배열 board,
			// 각 행에 퀸을 놓았는지 저장할 boolean 배열 setQ,
			// 각 행의 퀸의 위치를 저장할 배열 Q,
			// 답을 저장할 count 변수 초기화
			board = new int[N][N];
			setQ = new boolean[N];
			Q = new int[N];
			count = 0;
			
			putQ(0);
			
			// 서로 다른 퀸끼리 공격하지 못하도록 놓는 경우의 수 출력
			System.out.println("#" + t + " " + count);
		}
	}

	// 퀸을 놓는 방법의 수를 구하기 위한 재귀함수 putQ
	static void putQ(int idx) {
		
		// idx행에서 퀸을 놓을 수 있는 곳을 찾아 퀸을 놓고 아래 방향과 아래 대각선으로 보드에 1 더하기
		for (int i = Q[idx]; i < N; i++) {
			// 보드에서 idx행의 i열이 0이면 놓을 수 있는 위치
			if (board[idx][i] == 0) {
				board[idx][i] = N+1; // (idx, i)에 퀸 두기
				setQ[idx] = true;
				Q[idx] = i; // Q[idx]: idx행에서 퀸을 둔 열
				// 퀸을 둔 후 아래 방향과 아래쪽 두 대각선 방향으로 보드에 1 더하기
				for (int j = 1; j + idx < N; j++) {
					board[idx + j][i] += 1;
					// 인덱스가 넘어가지 않도록 하기
					if (i - j >= 0) {
						board[idx + j][i - j] += 1;
					}
					if (i + j < N) {
						board[idx + j][i + j] += 1;
					}
				}
				// 퀸을 놓을 때마다 확인용으로 board 출력해봄
				for (int r = 0; r < N; r++) {
					for (int c = 0; c < N; c++) {
						System.out.print(board[r][c] + " ");
					}
					System.out.println();
				}
				System.out.println();
			}
			// 퀸을 놓을 위치를 찾았으면 break
			if (setQ[idx]) break;
		}
		
		// 퀸을 놓을 위치를 찾지 못했거나 마지막 행까지 퀸을 두었을 경우
		if (!setQ[idx] || setQ[N-1]) {
			// idx가 0일 때 인덱스 에러가 나지 않도록 함
			if (idx != 0) {
				// 이전의 행에서 퀸을 두며 더했던 것들 다시 빼줌
				for (int j = 1; j + idx - 1 < N; j++) {
					board[idx + j - 1][Q[idx-1]] -= 1;
					if (Q[idx-1] - j >= 0) {
						board[idx + j - 1][Q[idx-1] - j] -= 1;
					}
					if (Q[idx-1] + j < N) {
						board[idx + j - 1][Q[idx-1] + j] -= 1;
					}
				}
				// 이전 행의 퀸 놓았던 것도 초기화
				board[idx-1][Q[idx-1]] = 0;
				setQ[idx-1] = false;
				// 이전 행의 다음 열부터 파악하기 위해 Q[idx-1]에 1 더하기
				Q[idx-1]++;
			}
//			if (!setQ[idx]) {
//				System.out.println("이건 아니다 전 행으로 ㄱㄱ");
//			}
			// 마지막 행에도 퀸을 놓는 데 성공했으면 count에 1 증가 후 다음 탐색을 위해 마지막행 초기화
			if (setQ[N-1]) {
//				System.out.println("찾았다!");
				count++;
				setQ[N-1] = false;
				board[N-1][Q[N-1]] = 0;
			}
			// 이전 행으로 돌아가기 전 현재 행의 퀸 위치도 초기화
			Q[idx] = 0;
			return;
		}
		
		// 각 행에서 수행할 것이 끝났으면 다음 행으로 넘어감
		putQ(idx + 1);
		// 다음 행으로 갔다가 return해서 돌아오면 다시 수행
		putQ(idx);
	}
}