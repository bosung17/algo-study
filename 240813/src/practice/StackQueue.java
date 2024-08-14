package practice;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class StackQueue {

	public static void main(String[] args) {
		
		Stack<Integer> s = new Stack<>();
		
		Queue<Integer> q = new LinkedList<>();
		
		q.offer(1);
		q.offer(2);
		q.offer(3);
		
		System.out.println(q.poll());
		System.out.println(q.poll());
		System.out.println(q.poll());
		
	}
}
