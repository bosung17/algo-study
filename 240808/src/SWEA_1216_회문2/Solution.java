package SWEA_1216_회문2;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int[] ans = new int[10];
		
		for (int i = 0; i < 10; i++) {
			
			int t = sc.nextInt();
			
			char[][] arr = new char[100][100];
			
			for (int r = 0; r < 100; r++) {
				String str = sc.next();
				for (int c = 0; c < 100; c++) {
					arr[r][c] = str.charAt(c);
				}
			}
			
			int count = 0;
			int max = 0;
			
			for (int r = 0; r < 100; r++) {
				for (int c = 0; c < 100; c++) {
					count = 1;
					for (int j = 1; j < 50; j++) {
						if (c-j >= 0 && c+j <100) {
							if (arr[r][c-j] == arr[r][c+j]) {
								count += 2;
							}
							else break;
						}
					}
					if (count > max) {
						max = count;
					}
				}
			}
			
			for (int r = 0; r < 100; r++) {
				for (int c = 0; c < 100; c++) {
					count = 1;
					for (int j = 1; j < 50; j++) {
						if (c-j >= 0 && c+j <100) {
							if (arr[c-j][r] == arr[c+j][r]) {
								count += 2;
							}
							else break;
						}
					}
					if (count > max) {
						max = count;
					}
				}
			}
			
			for (int r = 0; r < 100; r++) {
				for (int c = 0; c < 100; c++) {
					count = 0;
					for (int j = 1; j < 50; j++) {
						if (c-j >= 0 && c+j+1 <100) {
							if (arr[r][c] == arr[r][c+1]) {
								if (arr[r][c-j] == arr[r][c+j+1]) {
									count += 2;
								}
								else {
									count += 2;
									break;
								}
							}
						}
					}
					if (count > max) {
						max = count;
					}
				}
			}
			
			for (int r = 0; r < 100; r++) {
				for (int c = 0; c < 100; c++) {
					count = 0;
					for (int j = 1; j < 50; j++) {
						if (c-j >= 0 && c+j+1 <100) {
							if (arr[c][r] == arr[c+1][r]) {
								if (arr[c-j][r] == arr[c+j+1][r]) {
									count += 2;
								}
								else {
									count += 2;
									break;
								}
							}
						}
					}
					if (count > max) {
						max = count;
					}
				}
			}
			
			ans[i] = max;
			
//			System.out.println(max);
			
//			System.out.println(Arrays.deepToString(arr));
		}
		
		for (int i = 0; i < 10; i++) {
			System.out.println("#" + (i+1) + " " + ans[i]);
		}
	}
}