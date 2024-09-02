package SWEA_1952_수영장;

import java.util.Arrays;
import java.util.Scanner;

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
			
			
			
		}
	}
}