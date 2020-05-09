package ds.list;

public class ListProgramming {

	/**
	 * Adds one to the number represented as a list
	 * Example: 1->2->3 + 1 = 1->2->4
	 * @param head 	head pointer of the list
	 * @return		updated head pointer
	 */
	public Node addOne(Node head) {
		int finalRem = addOneLogic(head);
		if(finalRem!=0) {
			Node node= new Node(finalRem);
			node.next = head;
			return node;
		}
		return head;
	}
	
	public int addOneLogic(Node head) {
		if(head==null) {
			return 1;
		}
		//You do things before going into recursion
		int rem = addOneLogic(head.next);
		//You do things after coming back from recursion
		int sum = head.data + rem;
		head.data = sum%10;
		return sum/10;
	}
	
	/**
	 * Function to perform n clockwise rotation over a list 
	 * @param head	head pointer of the single linked list
	 * @param n		no. of rotations to be performed
	 * @return		updated head of the list after rotations
	 */
	public Node rotateList(Node head, int n) {
		if(head == null) {
			return null;
		}
		
		int i = 0;
		Node prevHead = null;
		Node newHead = null;
		Node curr = head;
		Node prev = null;
		
		while(curr!=null) {
			i++;
			if(i == n) prevHead = curr;
			if(i == n+1) newHead = curr;
			prev = curr;
			curr = curr.next;
		}
		
		if(n>=i) {
			return head;
		} else {
			prev.next = head;
			head = newHead;
			prevHead.next = null;
			return head;
		}
	}
	

	/**
	 * Sorts the linked list using merge sort approach
	 * @param head	head pointer of the linked list
	 * @return		update head pointer after sorting
	 */
	public Node sort(Node head) {
		if(head == null || head.next == null) return head;
		
		Node middle = getMiddle(head);
		Node middleNext = middle.next;
		
		middle.next = null;
		
		Node leftList = sort(head);
		Node rightList = sort(middleNext);
		
		return mergeSortedList(leftList, rightList);
	}
	
	public Node getMiddle(Node head) {
		if(head == null) return head;
		
		Node slow = head;
		Node fast = head;
		
		while(fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		
		return slow;
	}
	
	public Node mergeSortedList(Node head1, Node head2) {
		if(head1 == null) return head2;
		if(head2 == null) return head1;
		
		if(head1.data <= head2.data) {
			head1.next = mergeSortedList(head1.next, head2);
			return head1;
		} else {
			head2.next = mergeSortedList(head1, head2.next);
			return head2;
		}
	}
	

}
