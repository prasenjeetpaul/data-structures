package ds.queue;

public class Main {

	public static void main(String args[]) {
		
		PriorityQueue queue = new PriorityQueue();
		queue.enQueue(10, 0);
		queue.printQueue();
		queue.enQueue(20, 0);
		queue.printQueue();
		queue.enQueue(16, 1);
		queue.printQueue();
		queue.enQueue(61, 5);
		queue.printQueue();
		queue.enQueue(70, 0);
		queue.printQueue();
		queue.enQueue(72, 3);
		queue.printQueue();
		queue.enQueue(12, 1);
		queue.printQueue();
		queue.deQueue();
		queue.printQueue();

	}
	
	
	public static void maximumSlidingWindow(int arr[], int n, int k) {
		Deque queue = new Deque();
		//Setting first queue
		for(int i=0; i<k; i++) {
			//Delete all the values less than curr value
			while(!queue.isEmpty() && arr[i] >= arr[queue.peekRear()]) {
				queue.deleteFromRear();
			}
			queue.insertAtRear(i);
		}
		
		//Rest of the array
		for(int i=k; i<n; i++) {
			System.out.print(arr[queue.peekFront()] + " ");
			
			//Remeove elements that are not part of the window
			while(!queue.isEmpty() && queue.peekFront() <= i-k) {
				queue.deleteFromFront();
			}
			
			//Insert the current value into queue
			while(!queue.isEmpty() && arr[i] >= arr[queue.peekRear()]) {
				queue.deleteFromRear();
			}
			queue.insertAtRear(i);
		}
		
		System.out.println(arr[queue.peekFront()]);
		
	}
	
	
	
	
}
