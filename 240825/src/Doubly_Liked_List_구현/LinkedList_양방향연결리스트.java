package Doubly_Liked_List_구현;

class Node{
	String data;
	Node prev;
	Node next;
}

class DoublyLinkedList{
	Node head;
	Node tail;
	int size;
	
	public DoublyLinkedList(){
		head = new Node();
		tail = new Node();
		head.next = tail;
		tail.prev = head;
	}
	
	// 삽입
	void addData(int i, String data) {
		// 0 : 제일 앞에 삽입
		// size : 제일 뒤에 삽입
		if (i < 0 || i > size) {
			System.out.println("삽입할 수 없는 범위입니다.");
			return;
		}
		size++;
		
		// 삽입 위치 앞의 노드를 찾는다.
		Node curr = head;
		
		for (int k = 0; k < i; k++) {
			curr = curr.next;
		}
		
		// 새 노드 만들어주기
		Node newNode = new Node();
		newNode.data = data;
		
		// 새 노드 연결해주기
		newNode.next = curr.next;
		newNode.prev = curr;
		
		// 기존 노드 연결 재구성
		curr.next.prev = newNode;
		curr.next = newNode;
	}
	
	// 삭제
	void removeData(int i) {
		// 0 : 제일 앞의 데이터 삭제
		// size - 1 : 제일 뒤의 데이터 삭제
		
		if (i < 0 || i >= size) {
			System.out.println("삭제할 수 없는 범위입니다.");
			return;
		}
		
		size--;
		
		// 삭제할 위치를 찾기 (next 붙는 이유는 rmNode를 삭제할 위치로 보내야 하는데 next가 안 붙었을 땐 앞의 위치까지만 보내져서)
		Node rmNode = head.next;
		
		for (int k = 0; k < i; k++) {
			rmNode = rmNode.next;
		}
		
		rmNode.prev.next = rmNode.next;
		rmNode.next.prev = rmNode.prev;
	}
	
	void printReverse() {
		Node curr = tail.prev;
		String str = "";
		while(curr != head) {
			str = " <- " + curr.data + str;
			curr = curr.prev;
		}
		System.out.println(str);
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



public class LinkedList_양방향연결리스트 {

	public static void main(String[] args) {
		DoublyLinkedList list = new DoublyLinkedList();
		
		list.addData(0, "보성");
		list.addData(0, "흥행몬");
		list.addData(0, "현수");
		list.addData(0, "고밍");
		list.addData(0, "Heylee");
		
		list.printReverse();
		list.printAll();
		
		list.removeData(0);
		list.printAll();
		System.out.println(list.size);
	}
}
