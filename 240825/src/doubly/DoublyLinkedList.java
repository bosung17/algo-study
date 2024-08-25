package doubly;

class Node {
	String data;
	Node prev;
	Node next;
}

class DLL {
	Node head;
	Node tail;
	int size;
	
	DLL(){
		head = new Node();
		tail = new Node();
		head.next = tail;
		tail.prev = head;
	}
	
	void addData(int i, String data) {
		if (i < 0 || i > size) {
			System.out.println("삽입x");
			return;
		}
		
		size++;
		
		Node newNode = new Node();
		newNode.data = data;
		
		Node curr = head;
		for (int k = 0; k < i; k++) {
			curr = curr.next;
		}
		
		newNode.next = curr.next;
		newNode.prev = curr;
		curr.next.prev = newNode;
		curr.next = newNode;
	}
	
	void removeData(int i) {
		if (i < 0 || i >= size) {
			System.out.println("삭제x");
			return;
		}
		
		size--;
		
		Node curr = head.next;
		for (int k = 0; k < i; k++) {
			curr = curr.next;
		}
		
		curr.next.prev = curr.prev;
		curr.prev.next = curr.next;
	}
	
	void printAll() {
		Node curr = head.next;
		while(curr != tail) {
			System.out.print(curr.data + " -> ");
			curr = curr.next;
		}
		System.out.println();
	}
}


public class DoublyLinkedList {
	public static void main(String[] args) {
		DLL list = new DLL();
		
		list.addData(0, "1");
		list.addData(0, "2");
		list.addData(0, "3");
		
		list.printAll();
		
		list.removeData(1);
		list.printAll();
	}
}
