package error_correction;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[][] arr = new int[N][N];

		for (int i=0; i<N; i++)
			for (int j=0; j<N; j++) {
				arr[i][j] = sc.nextInt();
			}
		
		boolean parity = true;
		
		for (int i=0; i<N; i++) {
			int sum = 0;
			for (int j=0; j<N; j++) {
				sum += arr[i][j];
			}
			if (sum%2!=0) {
				parity = false;
			}
		}
		
		for (int i=0; i<N; i++) {
			int sum = 0;
			for (int j=0; j<N; j++) {
				sum += arr[j][i];
			}
			if (sum%2!=0) {
				parity = false;
			}
		}
		
		if (parity==true) {
			System.out.println("OK");
		}
		else {
			boolean corrupt = true;
			for (int i=0; i<N; i++)
				for (int j=0; j<N; j++) {
					if (arr[i][j]==0) {
						arr[i][j]++;
					}
					else {
						arr[i][j]--;
					}
					
					boolean parityChanged = true;
					
					for (int k=0; k<N; k++) {
						int sum = 0;
						for (int l=0; l<N; l++) {
							sum += arr[k][l];
						}
						if (sum%2!=0) {
							parityChanged = false;
						}
					}
					
					for (int k=0; k<N; k++) {
						int sum = 0;
						for (int l=0; l<N; l++) {
							sum += arr[l][k];
						}
						if (sum%2!=0) {
							parityChanged = false;
						}
					}
					
					if (parityChanged==true) {
						System.out.println("Change bit ("+(i+1)+","+(j+1)+")");
						corrupt = false;
					}
					
					if (arr[i][j]==0) {
						arr[i][j]++;
					}
					else {
						arr[i][j]--;
					}
				}
			if (corrupt==true) {
				System.out.println("Corrupt");
			}
			
		}
		
	}
}
