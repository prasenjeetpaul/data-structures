package algorithm.search;

public class BinarySearch implements SearchAlgorithm {
	
	/**
	 * Time Complexity	: O(log n)
	 * Space Complexity	: O(1)
	 */
	@Override
	public int search(int[] arr, int k) {
		int low = 0;
		int high = arr.length;
		int mid = -1;
		while(low <= high) {
			mid = (low+high)/2;
			if(arr[mid] == k) return mid;
			if(arr[mid] > k) {
				high = mid-1;
			} else if(arr[mid] < k) {
				low = mid+1;
			}
		}
		return mid;
	}
}
