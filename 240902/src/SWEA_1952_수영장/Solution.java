package SWEA_1952_수영장;

import java.util.Scanner;

// 테스트 케이스 46/50 성공 반복문에 어떤 오류가 있을까..?
public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int t = 1; t <= T; t++) {
			
			int D = sc.nextInt();
			int M = sc.nextInt();
			int Q = sc.nextInt();
			int Y = sc.nextInt();
			
			int[] plan = new int[12];
			
			for (int i = 0; i < 12; i++) {
				plan[i] = sc.nextInt() * D;
				if (plan[i] > M) {
					plan[i] = M;
				}
			}
			
			int sum = 0;
			for (int i = 0; i < 12; i++) {
				sum += plan[i];
			}
			
			int min = sum;
			int temp = sum;
			
			for (int i = 0; i < 10; i++) {
				temp = temp - (plan[i] + plan[i+1] + plan[i+2]) + Q;
				if (temp < min) {
					min = temp;
				}
				for(int j = i+3; j < 10; j++) {
					temp = temp - (plan[j] + plan[j+1] + plan[j+2]) + Q;
					if (temp < min) {
						min = temp;
					}
					for (int k = j+3; k < 10; k++) {
						temp = temp - (plan[k] + plan[k+1] + plan[k+2]) + Q;
						if (temp < min) {
							min = temp;
						}
						for (int l = k+3; l < 10; l++) {
							temp = temp - (plan[l] + plan[l+1] + plan[l+2]) + Q;
							if (temp < min) {
								min = temp;
							}
							temp = sum;
						}
						temp = sum;
					}
					temp = sum;
				}
				temp = sum;
			}
			
			if (Y < min) {
				min = Y;
			}
			
			System.out.println("#" + t + " " + min);
		}
	}
}