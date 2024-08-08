package SWEA_1222_계산기1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int[] ans = new int[10];
		
		for (int i = 0; i < 10; i++) {
			
			int N = sc.nextInt();
			
			String input = sc.next();
			
			char[] infix = new char[N];
			
			for (int j = 0; j < N; j++) {
				infix[j] = input.charAt(j);
			}
			
			char[] postfix = new char[N];
			int top = -1;
			
			for (int j = 0; j < N; j++) {
				if (infix[j] == '+') {
					push(infix[j]);
				}
				else {
					postfix[++top] = infix[j];
					if (!isEmpty()) {
						postfix[++top] = popChar();
					}
				}
			}
			reset();
			
			int sum = 0;
			
			for (int j = 0; j < N; j++) {
				if (postfix[j] == '+') {
					sum = popInt() + popInt();
					push(sum);
				}
				else {
					push((int) (postfix[j] - '0'));
				}
			}
			reset();
			
			ans[i] = sum;
		}
		for (int i = 0; i < 10; i++) {
			System.out.println("#" + (i+1) + " " + ans[i]);
		}
	}
	
	static List<Character> stackChar = new ArrayList<>();
	static List<Integer> stackInt = new ArrayList<>();
	
	static int top = -1;
	
	static boolean isEmpty() {
		return top == -1;
	}
	
	static void push(char a) {
		stackChar.add(++top, a);
	}
	static void push(int a) {
		stackInt.add(++top, a);
	}
	
	static char popChar() {
		return stackChar.get(top--);
	}
	static int popInt() {
		return stackInt.get(top--);
	}
	
	static void reset() {
		top = -1;
	}
}