package SWEA_5658_보물상자_비밀번호;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int t = 1; t <= T; t++) {
			
			// 숫자의 개수 N과 크기 순서 K 입력 받기
			int N = sc.nextInt();
			int K = sc.nextInt();
			
			// N개의 숫자를 문자열로 받기
			String nums = sc.next();
			
			// 문자열을 시계방향으로 돌리기 위해 queue 배열 numsQ 생성
			Queue<Character> numsQ = new LinkedList<>();
			
			// nums 문자열을 numsQ 배열에 복사하기
			for (int i = 0; i < N; i++) {
				numsQ.offer(nums.charAt(i));
			}
			
			// char 배열을 N/4개씩 나누어 저장한 sep 배열을 all 배열에 차례대로 넣기 위해 변수 m 생성
			int m = 0;
			
			// N/4 번 넘게 회전시키면 같은 배열을 반복하므로 repeat을 N/4로 설정
			int repeat = N/4;
			
			// 2차원 배열인 all의 행, 열의 개수를 쉽게 쓰기 위해 p, q 설정
			int p = repeat*4;
			int q = N/4;
			
			// N/4번의 회전 후 만들어진 모든 배열을 넣기 위한 2차원 배열 all 생성
			char[][] all = new char[p][q];
			
			// 회전하며 생성이 가능한 수를 모두 저장하기 위해 N/4번 회전
			for (int k = 0; k < repeat; k++) {
				
				// 회전할 때마다 나올 수 있는 4개의 숫자를 저장하기 위한 2차원 배열 sep 생성
				char[][] sep = new char[4][N/4];
				
				int n = 0;
				
				// 문자열을 char로 나누어 sep 배열에 저장
				for (int i = 1; i <= 4; i++) {
					for (int j = 1; j <= N/4; j++) {
						sep[i-1][j-1] = nums.charAt(n++);
					}
				}
				
				// 차례에 맞게 sep 배열을 all 배열에 복사
				for (int i = 0; i < 4; i++) {
					all[m+i] = sep[i];
				}
				
				m += 4;
				
				// 시계방향으로 numQ 배열을 돌리기 위해 N-1번 poll 하고 offer 하기
				for (int i = 0; i < N-1; i++) {
					numsQ.offer(numsQ.poll());
				}
				
				// 시계방향으로 돌린 numsQ 배열을 nums에 저장하기 위해 nums를 빈 문자열로 초기화
				nums = "";
				
				// nums 문자열에 numQ 배열 복사하기
				for (int i = 0; i < N; i++) {
					nums += numsQ.poll().toString();
				}
				
				// 모두 poll 해서 사라진 numQ 배열에 다시 nums 문자열 복사하기 
				for (int i = 0; i < N; i++) {
					numsQ.offer(nums.charAt(i));
				}
			}
			
			// all 배열에 같은 숫자가 있으면 지우기
			for (int i = 0; i < p; i++) {
				for (int j = 1; i + j < p; j++) {
					// boolean 자료형 same을 true로 두고 하나라도 다르면 false로 바꾸기
					boolean same = true;
					for (int k = 0; k < q; k++) {
						if (all[i][k] != all[i+j][k]) {
							same = false;
							break;
						}
					}
					// same이 true로 남아있으면 같다는 뜻이므로 빈 배열로 만들기
					if (same) {
						all[i] = new char[q];
					}
				}
			}
			
			// char 배열로 만들어진 all을 int로 바꿔 비교하기 위해 int 배열 number 만들기
			int[] number = new int[p];
			
			for (int i = 0; i < p; i++) {
				for (int j = 0; j < q; j++) {
					// char 값이 57보다 작거나 같으면 0~9 이므로 48을 뺀 후 16진법의 자리수에 맞게 곱해서 number에 더하기
					if (all[i][j] <= 57) {
						number[i] += (((int) all[i][j] - 48)*Math.pow(16, q-j-1));
					}
					// char 값이 57보다 크면 A~F 이므로 55를 뺀 후 16진법의 자리수에 맞게 곱해서 number에 더하기
					else {
						number[i] += (((int) all[i][j] - 55)*Math.pow(16, q-j-1));
					}
				}
			}
			
			// 오름차 순으로 배열한 후 테스트 케이스 번호와 p-k번째 숫자 출력
			Arrays.sort(number);
			System.out.println("#" + t + " " + number[p-K]);
		}
	}
}
