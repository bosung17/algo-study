package sinip;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int t = 1; t<= T; t++) {
			
			int N = sc.nextInt();
			int min = sc.nextInt();
			int max = sc.nextInt();
			
			int[] score = new int[N];
			
			for (int i = 0; i < N; i++) {
				score[i] = sc.nextInt();
			}
			
			Arrays.sort(score);

			int maxScore = score[N-1];
			
			int[] student = new int[3];
			
//			int score1 = 0;
//			int score2 = 0;
			int gap = Integer.MAX_VALUE;
			
			for (int sc1 = 0; sc1 <= maxScore; sc1++) {
				for (int sc2 = sc1; sc2 <= maxScore; sc2++) {
					student = new int[3];
					for (int i = 0; i < N; i++) {
						if (score[i] < sc1) {
							student[0]++;
						}
						else if (score[i] < sc2) {
							student[1]++;
						}
						else {
							student[2]++;
						}
					}
					Arrays.sort(student);
//					System.out.println(Arrays.toString(student));
					if (student[0] >= min && student[2] <= max) {
						if (student[2] - student[0] < gap) {
							gap = student[2] - student[0];
//							score1 = sc1;
//							score2 = sc2;
						}
					}
				}
			}
			if (gap == Integer.MAX_VALUE) {
				gap = -1;
			}
			
			System.out.println("#" + t + " " + gap);
		}
	}
}
