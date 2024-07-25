package error_correction;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[][] arr = new int[N][N];			// 행렬의 크기 N 입력

		for (int i=0; i<N; i++)
			for (int j=0; j<N; j++) {
				arr[i][j] = sc.nextInt();		// 행렬에 값 입력
			}
		
		boolean parity = true;					// for문 들어가기 전 parity를 true로 설정
		
		for (int i=0; i<N; i++) {
			int sum = 0;
			for (int j=0; j<N; j++) {
				sum += arr[i][j];
			}
			if (sum%2!=0) {						// 각 행의 합을 구해서 2로 나눴을 때 나머지가 0이 아니면
				parity = false;					// (=패리티 성질을 가지지 않으면) parity를 false로 설정
			}
		}
		
		for (int i=0; i<N; i++) {
			int sum = 0;
			for (int j=0; j<N; j++) {
				sum += arr[j][i];
			}
			if (sum%2!=0) {						// 각 열의 합을 구해서 2로 나눴을 때 나머지가 0이 아니면
				parity = false;					// (=패리티 성질을 가지지 않으면) parity를 false로 설정
			}
		}
		
		if (parity==true) {
			System.out.println("OK");			// parity가 true이면 OK 출력
		}										
		else {
			boolean corrupt = true;				// for문 들어가기 전 corrupt를 true로 설정
			for (int i=0; i<N; i++)
				for (int j=0; j<N; j++) {
					if (arr[i][j]==0) {			// 하나의 비트를 바꿔 패리티 성질을 가지는지 찾기 위해
						arr[i][j]++;			// 값이 0이면 1로,
					}
					else {
						arr[i][j]--;			// 값이 1이면 0으로 바꿈
					}
					
					boolean parityChanged = true; // 하나의 비트를 바꾼 후 parityChanged를 true로 설정
					
					for (int k=0; k<N; k++) {
						int sum = 0;
						for (int l=0; l<N; l++) {
							sum += arr[k][l];
						}
						if (sum%2!=0) {
							parityChanged = false; // 각 행의 합이 2로 나눠지지 않으면 parityChanged = false
						}
					}
					
					for (int k=0; k<N; k++) {
						int sum = 0;
						for (int l=0; l<N; l++) {
							sum += arr[l][k];
						}
						if (sum%2!=0) {
							parityChanged = false; // 각 열의 합이 2로 나눠지지 않으면 parityChanged = false
						}
					}
					
					if (parityChanged==true) {
						System.out.println("Change bit ("+(i+1)+","+(j+1)+")");
						corrupt = false;		// 하나의 비트를 바꿨을 때 패리티 성질을 가지면 위치 출력 후 corrupt = false
					}
					
					if (arr[i][j]==0) {			// 다음 열이나 다음 행으로 넘어가기 전 바꿨던 값을 다시 바꿈
						arr[i][j]++;			// 0이면 1로,
					}
					else {
						arr[i][j]--;			// 1이면 0으로
					}
				}
			if (corrupt==true) {				// 하나의 비트를 바꿔도 패리티 성질을 가지지 않으면 corrupt = true
				System.out.println("Corrupt");	// Corrupt 출력
			}
			
		}
		
	}
}
