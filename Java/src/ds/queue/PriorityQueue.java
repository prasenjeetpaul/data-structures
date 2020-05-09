package ds.queue;

public class PriorityQueue {
	private PriorityNode rear;
	private PriorityNode front;
	private int size = 0;
	
	public void enQueue(int data, int priority) {
		PriorityNode newNode = new PriorityNode(data, priority);
		this.size++;
		if(this.rear == null && this.front == null) {
			this.rear = newNode;
			this.front = newNode;
		} else {
			if(newNode.priority <= this.rear.priority) {
				//Insertion at rear
				newNode.next = this.rear;
				this.rear.prev = newNode;
				this.rear = newNode;
			} else if(newNode.priority > this.front.priority) {
				//Insertion at front
				newNode.prev = this.front;
				this.front.next = newNode;
				this.front = newNode;
			} else {
				//Insertion at middle
				PriorityNode curr = rear;
				while(curr.next != null && newNode.priority > curr.priority) {
					curr = curr.next;
				}
				PriorityNode prevNode = curr.prev;
				prevNode.next = newNode;
				newNode.prev = prevNode;
				newNode.next = curr;
				curr.prev = newNode;
				
			}
		}
	}
	
	public int deQueue() {
		if(this.front == null) {
			return -1;
		} else {
			PriorityNode firstNode = this.front;
			PriorityNode prevNode = this.front.prev;
			prevNode.next = null;
			firstNode.prev = null;
			this.front = prevNode;
			return firstNode.data;
		}
	}
	
	
	public int getSize() {
		return this.size;
	}
	
	public boolean isEmpty() {
		return this.size == 0;
	}
	
	public void printQueue() {
		PriorityNode curr = this.rear;
		while(curr!=null) {
			System.out.print(curr.data +  " ");
			curr = curr.next;
		}
		System.out.println();
	}
	
}
