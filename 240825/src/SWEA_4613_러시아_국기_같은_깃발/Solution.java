package SWEA_4613_러시아_국기_같은_깃발;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int test_case = 1; test_case <= T; test_case++) {
			
			// 행과 열의 개수 입력
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			// 색이 입력될 배열 color 생성
			char[] color = new char[M];

            int[][] paint_number = new int[N][3]; // 흰, 파, 빨
			
			// 색을 입력받아 color 배열에 저장
			for (int r = 0; r < N; r++) {
				String str = sc.next();
				for (int c = 0; c < M; c++) {
					color[c] = str.charAt(c);
                    if (color[c] == 'W')
                        paint_number[r][0]++;
                    if (color[c] == 'B')
                        paint_number[r][1]++;
                    if (color[c] == 'R')
                        paint_number[r][2]++;
				}
			}
			
			// 새로 칠해야 하는 칸의 개수의 최솟값을 저장할 answer를 Integer의 최댓값으로 생성
            int answer = Integer.MAX_VALUE;
			
			for (int i = 1; i < N - 1; i++) {
                for (int j = 1; j < N - 1; j++) {
                    for (int k = 1; k < N - 1; k++) {
  
                        int temp = 0;
  
                        if (i + j + k == N) {
  
                            for (int a = 0; a < i; a++) { // 흰
                                temp = temp + paint_number[a][1] + paint_number[a][2];
                            }
  
                            for (int a = i; a < i + j; a++) { // 파
                                temp = temp + paint_number[a][0] + paint_number[a][2];
                            }
  
                            for (int a = i + j; a < N; a++) { // 빨
                                temp = temp + paint_number[a][0] + paint_number[a][1];
                            }
  
                            if (temp < answer) {
                                answer = temp;
                            }
  
                        }
                    }
                }
            }
			
			// 테스트 케이스 번호와 최솟값 출력
			System.out.println("#" + test_case + " " + answer);
		}
	}
}