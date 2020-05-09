package ds.list;

public interface List {
	
	public Node getHead();
	public void insertAtHead(int data);
	public void insertAtTail(int data);
	public Node deleteAtHead();
	public Node deleteAtTail();
	
}
