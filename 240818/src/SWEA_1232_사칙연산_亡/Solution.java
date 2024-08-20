package SWEA_1232_사칙연산_亡;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		for (int t = 1; t <= 1; t++) {
			
			int N = sc.nextInt();
			
			String[] tree = new String[N+1];
			
			for (int i = 1; i <= N; i++) {
				
				sc.nextInt();
				
				String input = sc.nextLine();
				
				if (input.charAt(1) >= '0') {
					tree[i] = "";
					for (int j = 1; j < input.length(); j++) {
						tree[i] += input.charAt(j);
					}
				}
				else {
					tree[i] = "";
					tree[i] += input.charAt(1);
				}
			}
			
			System.out.println(Arrays.toString(tree));
		}
	}
	
//	static double cal(String[] arr, int num) {
//		
//		if (num*2 < arr.length && num*2+1 < arr.length) {
//			if (arr[num*2].charAt(0) >= '0' && arr[num*2+1].charAt(0) >= '0') {
//				double a = Double.parseDouble(arr[num*2]);
//				double b = Double.parseDouble(arr[num*2+1]);
//				if (arr[num].equals("+")) {
//					return a + b;
//				}
//				else if (arr[num].equals("-")) {
//					return a - b;
//				}
//				else if (arr[num].equals("*")) {
//					return a * b;
//				}
//				else if (arr[num].equals("/")) {
//					return a / b;
//				}
//				else return Double.parseDouble(arr[num]);
//			}
//		}
//	}
}
