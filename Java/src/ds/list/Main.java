package ds.list;


public class Main {

	public static void main(String args[]) {
		LinkedList list = new LinkedList();
		
		list.insertAtHead(10);
		ListUitl.printList(list.getHead());
		list.deleteAtTail();
		ListUitl.printList(list.getHead());
		list.insertAtTail(20);
		list.insertAtHead(10);
		ListUitl.printList(list.getHead());
		list.insertAtHead(30);
		list.insertAtHead(40);
		list.insertAtHead(50);
		ListUitl.printList(list.getHead());
		list.deleteAtHead();
		list.insertAtIndex(100, 1);
		list.insertAtIndex(200, 3);
		list.insertAtIndex(300, 10);
		ListUitl.printList(list.getHead());
		
	}
}
