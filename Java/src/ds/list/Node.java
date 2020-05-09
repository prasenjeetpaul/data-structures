package ds.list;

public class Node {
	public int data;
	public Node next;
	public Node prev;

	//default constructor
	public Node() {}

	//Parameterized Constructor
	public Node(int data) {
		this.data = data;
		this.next = null;
		this.prev = null;
	}
}
