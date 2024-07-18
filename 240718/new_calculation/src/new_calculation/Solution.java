package new_calculation;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		
		int[][] arr = new int[300][300];					// p와 q가 10000일 때 합까지 포함되려면 300*300은 되어야 함
		
		for (int i=1; i<300; i++)
			for (int j=1; j<300; j++) {						// i와 j가 0부터이면 x축, y축에 예상되지 않은 수가 들어가서 1부터 구함
				arr[i][j] = (i*i+2*i*j+j*j-i-(3*j)+2)/2;	// x, y 좌표가 주어졌을 때 할당된 수 arr[x][y] 구하기
			}
		
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();								// 테스트 케이스 수 T 입력 받기
		
		int[] K = new int[t];								// 각 케이스 마다 주어진 p, q의 x, y 좌표를 저장하기 위해
		int[] Px = new int[t];								// for문 밖에서 배열 만들어놓기
		int[] Py = new int[t];
		int[] Qx = new int[t];
		int[] Qy = new int[t];
		
		for (int k=0; k<t; k++) {
			int px = 0;
			int py = 0;
			int a = sc.nextInt();							// p 입력 받기
			for (int i=1; i<300; i++)
				for (int j=1; j<300; j++) {
					if (arr[i][j] == a) {					// 입력 받은 값이 위치하는 좌표의 x, y 값 저장
						px=i;
						py=j;
					}
				}
			
			int qx = 0;
			int qy = 0;
			int b = sc.nextInt();							// q 입력 받기
			for (int i=1; i<300; i++)
				for (int j=1; j<300; j++) {
					if (arr[i][j] == b) {					// 입력 받은 값이 위치하는 좌표의 x, y 값 저장
						qx=i;
						qy=j;
					}
				}
			K[k] = k;										// for 문 안에서 테스트 케이스 번호,
			Px[k] = px;										// 주어진 정수에 대한 x, y 좌표 저장
			Py[k] = py;
			Qx[k] = qx;
			Qy[k] = qy;
		}
		
		for (int i=0; i<t;i++)
			System.out.println("#"+(K[i]+1)+" "+arr[Px[i]+Qx[i]][Py[i]+Qy[i]]);
		
	}
}