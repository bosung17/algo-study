package 연결_스택_구현;

import java.util.LinkedList;
import java.util.List;

public class LinkedStack {
	
	List<String> list = new LinkedList<>();
	int top = -1;
	
	public boolean isEmpty() {
		return top == -1;
	}
	
	public void push(String num) {
		list.add(++top, num);
	}
	
	public String pop() {
		if (!isEmpty()) {
			return list.get(top--);
		}
		else return null;
	}
	
	public String peek() {
		if (!isEmpty()) {
			return list.get(top);
		}
		else return null;
	}
}
