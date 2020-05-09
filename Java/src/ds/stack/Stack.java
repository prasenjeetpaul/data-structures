package ds.stack;

import ds.list.LinkedList;
import ds.list.List;
import ds.list.Node;

public class Stack {

	private List stack;
	
	public Stack() {
		this.stack = new LinkedList();
	}
	
	public void push(int data) {
		this.stack.insertAtHead(data);
	}
	
	public Node pop() {
		return this.stack.deleteAtHead();
	}
	
	public Node peek() {
		return this.stack.getHead();
	}
}
