package singly;

class Node {
	String data;
	Node link;
}

class SinglyLinkedList1 {
	Node head;
	int size;
	
	SinglyLinkedList1() {
		head = new Node();
	}
	
	void addData(int i, String data) {
		if (i < 0 || i > size) {
			System.out.println("삽입이 가능한 범위가 아닙니다.");
			return;
		}
		
		size++;
		
		Node newNode = new Node();
		newNode.data = data;
		
		Node curr = head;
		for (int k = 0; k < i; k++) {
			curr = curr.link;
		}
		
		newNode.link = curr.link;
		curr.link = newNode;
	}
	
	void removeData(int i) {
		if (i < 0 || i >= size) {
			System.out.println("삭제가 가능한 범위가 아닙니다.");
			return;
		}
		size--;
		
		Node curr = head;
		for (int k = 0; k < i; k++) {
			curr = curr.link;
		}
		
		curr.link = curr.link.link;
	}
	
	void printAll() {
		Node curr = head.link;
		
		while (curr != null) {
			System.out.print(curr.data + " -> ");
			curr = curr.link;
		}
		System.out.println();
	}
}



public class SinglyLinkedList {
	public static void main(String[] args) {
		SinglyLinkedList1 list = new SinglyLinkedList1();
		
		list.addData(0, "hi");
		list.addData(0, "hello");
		list.addData(0, "안녕");
		
		list.printAll();
		
		list.removeData(0);
		list.printAll();
	}
}
