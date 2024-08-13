package 연결_스택_구현;

public class LinkedStackTest {

	public static void main(String[] args) {
		
		LinkedStack ls = new LinkedStack();
		
		ls.push("a");
		ls.push("b");
		ls.push("c");
		ls.push("d");
		
		System.out.println(ls.pop());
		System.out.println(ls.pop());
		System.out.println(ls.pop());
		System.out.println(ls.pop());
		System.out.println(ls.pop());
	}
}
