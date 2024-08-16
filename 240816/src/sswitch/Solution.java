package sswitch;

import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int[] sw = new int[N+1];
		
		for (int i = 1; i <= N; i++) {
			sw[i] = sc.nextInt();
		}
		
		int stuNum = sc.nextInt();
		
		for (int i = 0; i < stuNum; i++) {
			
			int gen = sc.nextInt();
			int num = sc.nextInt();
			
			if (gen == 1) {
				for (int j = num; j < N; j += num) {
					if (sw[j] == 0) {
						sw[j]++;
					}
					else {
						sw[j]--;
					}
				}
			}
			else {
				int D = 0;
				for (int d = 1; d < N; d++) {
					if (num+d <= N && num-d >=1) {
						if (sw[num+d] == sw[num-d]) {
							D = d;
						}
						else {
							break;
						}
					}
				}
				for (int j = num - D; j <= num + D; j++) {
					if (sw[j] == 0) {
						sw[j]++;
					}
					else {
						sw[j]--;
					}
				}
			}
		}
		for (int i = 1; i <= N; i++) {
			System.out.print(sw[i] + " ");
		}
	}
}
