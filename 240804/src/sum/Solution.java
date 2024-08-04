package sum;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int[] maxarr = new int[10];
		
		for (int i=0; i<10; i++) {
			
			int t = sc.nextInt();
			
			int[][] arr = new int[100][100];
			
			for (int r=0; r<100; r++) {
				for (int c=0; c<100; c++) {
					arr[r][c] = sc.nextInt();
				}
			}
			
			int max = 0;
			int maybemax = 0;
			
			for (int r=0; r<100; r++) {
				max += arr[r][r];
			}
			
			for (int r=0; r<100; r++) {
				maybemax += arr[r][99-r];
			}
			
			if (maybemax > max) {
				max = maybemax;
			}
			
			for (int r=0; r<100; r++) {
				maybemax = 0;
				for (int c=0; c<100; c++) {
					maybemax += arr[r][c];
				}
				if (maybemax > max) {
					max = maybemax;
				}
			}
			
			for (int r=0; r<100; r++) {
				maybemax = 0;
				for (int c=0; c<100; c++) {
					maybemax += arr[c][r];
				}
				if (maybemax > max) {
					max = maybemax;
				}
			}
			maxarr[i] = max;
		}
		
		for (int i=0; i<10; i++) {
			System.out.println("#" + (i+1) + " " + maxarr[i]);
		}
	}
}
