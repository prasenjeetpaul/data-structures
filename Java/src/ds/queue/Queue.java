package ds.queue;

import ds.list.DoubleLinkedList;
import ds.list.Node;

public class Queue {
	private DoubleLinkedList queue;

	public Queue() {
		this.queue = new DoubleLinkedList();
	}
	
	public void enQueue(int data) {
		this.queue.insertAtHead(data);
	}
	
	public Node deQueue() {
		return this.queue.deleteAtTail();
	}
	
	public void printQueue() {
		Node curr = this.queue.getHead();
		while(curr!=null) {
			System.out.print(curr.data +  " ");
			curr = curr.next;
		}
		System.out.println();
	}
}
