package ds.queue;

import ds.list.DoubleLinkedList;
import ds.list.Node;

public class Deque {

	private DoubleLinkedList queue;
	
	public Deque() {
		this.queue = new DoubleLinkedList();
	}
	
	public void insertAtRear(int data) {
		this.queue.insertAtHead(data);
	}
	
	public void insertAtFront (int data) {
		this.queue.insertAtTail(data);
	}

	public Node deleteFromRear() {
		return this.queue.deleteAtHead();
	}

	public Node deleteFromFront() {
		return this.queue.deleteAtTail();
	}
	
	public int peekRear() {
		if(this.queue.getHead() != null) return this.queue.getHead().data;
		else return -1;
	}
	
	public int peekFront() {
		if(this.queue.getTail() != null) return this.queue.getTail().data;
		else return -1;
	}
	
	public int getSize( ) {
		return this.queue.size();
	}
	
	public boolean isEmpty() {
		return this.queue.empty();
	}

}
