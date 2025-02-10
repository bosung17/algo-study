package BOJ_5639_이진_검색_트리;

import java.util.Scanner;

public class Main {
	static class Node {
		int num;

		Node left, right;

		Node(int num) {
			this.num = num;
		}

		void insert(int num) {
			if (num < this.num) {
				if (left == null) {
					left = new Node(num);
				} 
				else {
					left.insert(num);
				}
			} 
			else {
				if (right == null) {
					right = new Node(num);
				} 
				else {
					right.insert(num);
				}
			}
		}
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt(); // STS에서 입력받기 위해 일단 넣음

		Node root = new Node(sc.nextInt());
		for (int i = 0; i < N - 1; i++) {
			root.insert(sc.nextInt());
		}
		preOrder(root);
	}

	static void preOrder(Node node) {
		if (node == null) {
			return;		
		}
		preOrder(node.left);
		preOrder(node.right);
		System.out.println(node.num);
	}
}
