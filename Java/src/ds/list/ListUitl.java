package ds.list;

public class ListUitl {

	/**
	 * Utility function to print the given linked list
	 * @param head	head pointer of the linked list
	 */
	public static void printList(Node head) {
		Node curr = head;
		while(curr != null) {
    		System.out.print(curr.data + " -> ");
    		curr = curr.next;
		} 
		System.out.print("X\n");
	}

	public static void printUsingRecursion(Node head) {
		if(head == null) {
			System.out.print(" X\n");
		} else {
			System.out.print(head.data + " -> ");
			printUsingRecursion(head.next);			
		}
	}

	/**
	 * Utility method to reverse the given linked list
	 * @param head 	head pointer of the list
	 * @return		updated head pointer
	 */
	public static Node reverse(Node head) {
		//Iterative Method
		Node curr = head;
		Node prev = null;
		Node next = null;
		
		while(curr!=null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		
		return prev;
	}
	
	public static Node reverseWithRecursion(Node head) {
		if(head==null || head.next == null) {
			return head;
		}
		
		Node last = reverseWithRecursion(head.next);
		
		head.next.next = head;
		head.next = null;
		
		return last;
	}
	
	/**
	 * Utility method to print the list in reverse order
	 * @param head	head pointer of the linked list
	 */
	public static void printReverse(Node head) {
		if(head == null) return;
		printReverse(head.next);
		System.out.print(head.data + " ");
	}
	
	/**
	 * Returns the middle element of the list
	 * @param head	head pointer of the list
	 * @return		middle element
	 */
	public static int findMiddle(Node head) {
		if(head == null) return -1;
		
		Node slow = head;
		Node fast = head;
		
		while(fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		
		return slow.data;
	}
	
	/**
	 * Delete the middle element from the list
	 * @param head	head pointer of the list
	 * @return		updated head after deletion
	 */
	public static Node deleteMiddle(Node head) {
		if(head == null || head.next == null) return null;
		Node prev = null;
		Node slow = head;
		Node fast = head;
		
		while(fast != null && fast.next != null) {
			fast = fast.next.next;
			prev = slow;
			slow = slow.next;
		}
		prev.next = slow.next;
		return head;
	}
}
