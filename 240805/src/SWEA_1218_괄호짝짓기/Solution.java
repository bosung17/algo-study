package SWEA_1218_괄호짝짓기;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int[] valid = new int[10];
		
		for (int i=0; i<10; i++) {
			valid[i] = 1;
		}
		
		for (int i=0; i<10; i++) {
			
			int N = sc.nextInt();
			
			String brackets = sc.next();
			
			char[] split = new char[N];

			for (int j=0; j<N; j++) {
				split[j] = brackets.charAt(j);
			}
			
			for (int j=0; j<N; j++) {
				if (split[j] == '(' || split[j] == '[' || split[j] == '{' || split[j] == '<') {
					push(split[j]);
				}
				else if (split[j] == ')') {
					if (j-1<0) {
						valid[i] = 0;
						break;
					}
					else if (split[j-1] != '(') {
						valid[i] = 0;
						break;
					}
					else pop();
				}
				else if (split[j] == ']') {
					if (j-1<0) {
						valid[i] = 0;
						break;
					}
					else if (split[j-1] != '[') {
						valid[i] = 0;
						break;
					}
					else pop();
				}
				else if (split[j] == '}') {
					if (j-1<0) {
						valid[i] = 0;
						break;
					}
					else if (split[j-1] != '{') {
						valid[i] = 0;
						break;
					}
					else pop();
				}
				else if (split[j] == '>') {
					if (j-1<0) {
						valid[i] = 0;
						break;
					}
					else if (split[j-1] != '<') {
						valid[i] = 0;
						break;
					}
					else pop();
				}
			}
		}
		for (int i=0; i<10; i++) {
			System.out.println("#" + (i+1) + " " + valid[i]);
		}
	}
	
	static char[] stack = new char[1000];
	
	static int top = -1;
	
	static boolean isEmpty() {
		return top == -1;
	}
	
	static void push(char bracket) {
		stack[++top] = bracket;
	}
	
	static char pop() {
		if (!isEmpty()) {
			return stack[top--];
		}
		else return '0'; // 이거 지금 의미 없음
	}
}
