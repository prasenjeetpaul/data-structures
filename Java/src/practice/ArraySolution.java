package practice;

import java.util.HashSet;

public class ArraySolution {

	/**
	 * Shifts all the zeros to the end of the string
	 * @param arr	input array
	 * @return		modified output array
	 */
	public static int[] moveZeroToRight(int arr[]) {
		int index = 0;
		for(int i=0; i<arr.length; i++) {
			if(arr[i]!=0) {
				arr[index] = arr[i];
				index++;
			}
		}
		for(int i=index; i<arr.length; i++) {
			arr[i] = 0;
		}
		return arr;
	}
	
	/**
	 * Returns the maximum sum of an continuous subarray
	 * Kadane's Algorithm
	 * @param arr	input array
	 * @return		max sum of an subarray
	 */
	public static int getMaxSum(int arr[])  {
		int sumTillNow = arr[0];
		int maxSum = arr[0];
		for(int i=0; i<arr.length; i++) {
			sumTillNow = Math.max(arr[i], sumTillNow+arr[i]);
			maxSum = Math.max(maxSum, sumTillNow);
		}
		return maxSum;
	}
	
	/**
	 * Returns the count of unique elements of the array
	 * @param arr	input array
	 * @return		unique elements count
	 */
	public static int getCountOfUniqueElement(int arr[]) {
		HashSet<Integer> set = new HashSet<Integer>();
		for(int i=0; i<arr.length; i++) set.add(arr[i]);
		return set.size();
	}
	
	/**
	 * Checks whether any subarray has an sum of zero
	 * @param arr	input array
	 * @return		true if any subarray has zero sum, else false
	 */
	public static boolean hasSubArrayWithZeroSum(int arr[]) {
		int sum = 0;
		HashSet<Integer> set = new HashSet<Integer>();
		for(int i=0; i<arr.length; i++) {
			sum = sum + arr[i];
			if(arr[i] == 0 || sum == 0 || set.contains(sum)) return true;
			set.add(sum);
		}
		
		return false;
	}
	
	/**
	 * Checks weather visit of last element is possible by performing jumps
	 * @param arr	input array
	 * @return		true if visit is possible, else false
	 */
	public static boolean isLastPossible(int arr[]) {
		if(arr.length <= 1) return true;
		int jumpCouter = 0;
		for(int i=0; i<arr.length; i++) {
			if(i==arr.length-1) return true;
			
			int jump = Math.max(jumpCouter, arr[i]);
			if(jump == 0) return false;
			else {
				jumpCouter = jump -1;
			}
		}
		
		return false;
	}
}
