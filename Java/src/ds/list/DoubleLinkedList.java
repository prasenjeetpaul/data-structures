package ds.list;

public class DoubleLinkedList implements List {

	private int size;
	private Node head;
	private Node tail;

	public DoubleLinkedList() {
		this.head = null;
		this.tail = null;
		this.size = 0;
	}

	public Node getHead() {
		return this.head;
	}

	public Node getTail() {
		return this.tail;
	}
	
	public void insertAtHead(int data) {
		if(this.head == null) {
			//No element
			Node newNode = new Node(data);
			this.head = newNode;
			this.tail = newNode;
		} else {
			//One or more element
			Node newNode= new Node(data);
			this.head.prev = newNode;
			newNode.next = this.head;
			this.head = newNode;	
		}
		this.size++;
	}

	public void insertAtTail(int data) {
		if(this.tail == null) {
			Node newNode = new Node(data);
			this.head = newNode;
			this.tail = newNode;
		} else {
			Node newNode= new Node(data);
			this.tail.next = newNode;
			newNode.prev = this.tail;
			this.tail = newNode;
		}
		this.size++;
	}
	
	public Node deleteAtHead() {
		if(this.head == null) {
			return null;
		} else if(this.head.next == null) {
			Node node = this.head;
			this.head = null;
			this.tail = null;
			this.size--;
			return node;
		}	else {
			Node firstNode = this.head;
			Node nextNode = this.head.next;
			firstNode.next = null;
			nextNode.prev = null;
			this.head = nextNode;
			this.size--;
			return firstNode;
		}
	}

	public Node deleteAtTail() {
		if(this.tail== null) {
			return null;
		} else if(this.tail.prev == null) {
			//Only one node in list
			Node node = this.tail;
			this.head = null;
			this.tail = null;
			this.size--;
			return node;
		} else {
			Node lastNode = this.tail;
			Node prevNode = this.tail.prev;
			prevNode.next = null;
			lastNode.prev = null;
			this.tail = prevNode;
			this.size--;
			return lastNode;
		}
	}
	
	public int size() {
		return this.size;
	}
	
	public boolean empty() {
		return this.size == 0;
	}

}
