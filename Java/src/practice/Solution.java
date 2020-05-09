package practice;

import java.util.LinkedList;
import java.util.PriorityQueue;

public class Solution {
	
	/**
	 * Returns nth odd number made up of all odd digits
	 * Example: 1 3 5 7 9 11 13 15 19 21...
	 * @param n	number to get from sequence
	 * @return	nth odd number
	 */
	public static int getNthOdd(int n) {
		LinkedList<Integer> queue = new LinkedList<Integer>();
		int count = 0;
		queue.addFirst(0);
		while (count < n) {
			queue.addFirst(queue.peekLast() * 10 + 1);
			if (++count == n)
				break;
			queue.addFirst(queue.peekLast() * 10 + 3);
			if (++count == n)
				break;
			queue.addFirst(queue.peekLast() * 10 + 5);
			if (++count == n)
				break;
			queue.addFirst(queue.peekLast() * 10 + 7);
			if (++count == n)
				break;
			queue.addFirst(queue.peekLast() * 10 + 9);
			if (++count == n)
				break;

			queue.removeLast();
		}
		return queue.getFirst();
	}
	
	/**
	 * Prints a sequence of pure numbers which are made up of '4' and '5' digits
	 * @param n	limit of the sequence
	 */
	public static void printPureNumber(int n) {
		LinkedList<String> queue = new LinkedList<String>();
		PriorityQueue<Integer> ans = new PriorityQueue<Integer>();
		queue.addLast("44");
		queue.addLast("55");
		
		while(ans.size() < n) {
			String str = queue.removeFirst();
			ans.add(Integer.parseInt(str));
			queue.addLast("4"+str+"4");
			queue.addLast("5"+str+"5");
		}
		
		for(int i=0; i<n; i++) {
			System.out.print(ans.remove()+" ");
		}
	}
	
	/**
	 * Prints a sequence of pure numbers which are made up of '4' and '5' digits
	 * @param n	limit of the sequence
	 */
	public static String getPureNumberFor(int n) {
		String ans = "";
		
		while(n>0) {
			n--;
			if(n%2 == 0) {
				ans = '4'+ans;
			} else{
				ans = '5'+ans;
			}
			n = n/2;
		}
		
		char arr[] = ans.toCharArray();
		for(int i=ans.length()-1; i>=0; i--) {
			ans += arr[i];
		}
		return ans;
	}
	
}
