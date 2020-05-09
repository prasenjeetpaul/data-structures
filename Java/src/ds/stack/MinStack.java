package ds.stack;

import java.util.LinkedList;

/**
 * A wrapper implementation around a normal stack where getting the
 * minimum element of the stack at any given time takes constant time (O(1))
 */
public class MinStack {
	private LinkedList<Integer> minStack;
	private LinkedList<Integer> list;
	
	public MinStack() {
		this.minStack = new LinkedList<Integer>();
		this.list = new LinkedList<Integer>();
	}
	
	public void push(int data) {
		if(minStack.isEmpty()) {
			this.minStack.push(data);
		} else if(data < this.minStack.peek()){
			this.minStack.push(data);
		}
		list.push(data);
	}
	
	public int pop() {
		if(this.minStack.peek() <= this.top()) {
			this.minStack.pop();
		}
		return list.pop();
	}
	
	public int top() {
		return list.peek();
	}
	
	public int size() {
		return this.list.size();
	}
	
	public int getMin() {
		return this.minStack.peek();
	}
}
