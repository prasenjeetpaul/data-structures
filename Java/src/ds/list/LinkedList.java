package ds.list;

public class LinkedList implements List {
	private Node head;

	public LinkedList() {
		this.head = null;
	}
	
	public Node getHead() {
		return this.head;
	}

	public void insertAtHead(int data) {
		Node newNode = new Node(data);
		newNode.next = head;
		head = newNode;
	}

	public void insertAtTail(int data) {
		if(head == null) {
			head = new Node(data);
			return;
		}
		Node curr = head;
		while(curr.next != null) {
			curr = curr.next;
		}
		curr.next = new Node(data);
	}

	public void insertAtIndex(int data, int index) {
		if(index == 1) {
			Node newNode = new Node(data);
			newNode.next = head;
			head = newNode;
			return;
		}
		Node curr = head;
		int i = 1;
		while(curr.next != null) {
			if(++i==index) break;
			curr = curr.next;
		}
		Node newNode = new Node(data);
		Node nextNode = curr.next;
		curr.next = newNode;
		newNode.next = nextNode;	
	}

	public Node deleteAtHead() {
		if(head == null) return null;
		Node first = this.head;
		this.head = first.next;
		return first;
	}

	public Node deleteAtTail() {
		if(head == null) return null;
		else if(head.next == null) {
			Node node = this.head;
			this.head = null;
			return node;
		}
		Node curr = head;
		Node prev = null;
		while(curr.next != null) {
			prev = curr;
			curr = curr.next;
		}
		prev.next = null;
		return curr;
	}
	
}
