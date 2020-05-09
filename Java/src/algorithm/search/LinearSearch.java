package algorithm.search;

public class LinearSearch implements SearchAlgorithm {

	/**
	 * Time Complexity	: O(n)
	 * Space Complexity	: O(1)
	 */
	@Override
	public int search(int[] arr, int k) {
		int index = -1;
		for(int i=0; i<arr.length; i++) {
			if(arr[i] == k) {
				index = i;
				break;
			}
		}
		return index;
	}
}
