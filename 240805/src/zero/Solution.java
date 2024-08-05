package zero;

import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		
		int[] maxarr = new int[t];
		
		for (int i=0; i<t; i++) {
			
			int K = sc.nextInt();
			
			for (int j=0; j<K; j++) {
				int num = sc.nextInt();
				if (num != 0) {
					push(num);
				}
				else pop();
			}
			maxarr[i] = sum();
			reset();
		}
		
		for (int i=0; i<t; i++) {
			System.out.println("#" + (i+1) + " " + maxarr[i]);
		}
	}
	
	static int[] stack = new int[100000];
	
	static int top = -1;
	
	static void push(int num) {
		stack[++top] = num;
	}
	
	static int pop() {
		return stack[top--];
	}
	
	static int sum() {
		int sum = 0;
		for (int i=0; i<=top; i++) {
			sum += stack[i];
		}
		return sum;
	}
	static void reset() {
		for (int i=0; i<stack.length; i++) {
			stack[i] = 0;
		}
	}
}
