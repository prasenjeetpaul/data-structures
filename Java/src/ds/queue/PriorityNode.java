package ds.queue;

public class PriorityNode {
	public int data;
	public int priority;
	public PriorityNode next;
	public PriorityNode prev;
	
	public PriorityNode(int data) {
		this.data = data;
		this.priority = 0;
		this.next = null;
		this.prev = null;
	}
	
	public PriorityNode(int data, int priority) {
		this.data = data;
		this.priority = priority;
		this.next = null;
		this.prev = null;
	}
}
