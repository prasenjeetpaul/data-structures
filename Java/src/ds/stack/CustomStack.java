package ds.stack;

import java.util.Stack;

public class CustomStack {
	private Stack<Integer> stack;
    
    public CustomStack() {
        this.stack = new Stack<Integer>();
    }
    
    public void push(int data) {
        this.stack.push(data);
    }
    
    public int pop() {
        return this.stack.pop();
    }
    
    public boolean empty() {
        return this.stack.empty();
    }
}
