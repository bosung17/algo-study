package BOJ_1476_날짜_계산;

import java.util.Scanner;

public class Main {
	static int[] jYear = new int[3];
	static int year = 0;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		for (int i = 0; i < 3; i++) {
			jYear[i] = sc.nextInt();
		}
		
		cal();
		System.out.println(year);
	}
	static void cal() {
		if (jYear[0] == jYear[1] && jYear[1] == jYear[2]) {
			year = jYear[0];
			return;
		}
		
		int E = 15;
		int S = 28;
		int M = 19;
		
		if (Math.min(jYear[0], Math.min(jYear[1], jYear[2])) == jYear[0]) {
			jYear[0] += E;
		}
		else if (Math.min(jYear[0], Math.min(jYear[1], jYear[2])) == jYear[1]) {
			jYear[1] += S;
		}
		else if (Math.min(jYear[0], Math.min(jYear[1], jYear[2])) == jYear[2]) {
			jYear[2] += M;
		}
		
		cal();
	}
}
