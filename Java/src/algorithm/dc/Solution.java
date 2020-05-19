package algorithm.dc;

public class Solution {
	
	/**
	 * Given an sorted binary array, find the no. of ones
	 * @param arr	sorted binary array
	 * @return		no. of 1s in the array
	 */
	public static int getNoOfOne(int arr[]) {
		return getNoOfOne(arr, 0, arr.length -1);
	}
	
	private static int getNoOfOne(int arr[], int start, int end) {
		if(arr[end] == 0) return 0;
		if(arr[start] == 1) return end-start+1;
		int mid = (start + end)/2;
		return getNoOfOne(arr, start, mid) + getNoOfOne(arr, mid+1, end);
	}
	
	/**
	 * Returns the longest substring from given list of strings
	 * @param arr	input list of strings
	 * @return		longest common prefix
	 */
	public static String longestCommonPrefix(String arr[]) {
		if(arr.length == 0) return "";
		return longestCommonPrefix(arr, 0, arr.length-1);
	}
	
	private static String longestCommonPrefix(String arr[], int start, int end) {
		if(start == end) return arr[start];
		if(start < end) {
			int mid = (start + end)/2;
			
			String leftCommoPrefix = longestCommonPrefix(arr, start, mid);
			String rightCommoPrefix = longestCommonPrefix(arr, mid+1, end);

			return findPrefix(leftCommoPrefix, rightCommoPrefix);
		}
		
		return "";		
	}
	
	private static String findPrefix(String s1, String s2) {
		if(s1 == null) return s2;
		if(s2 == null) return s1;
		String ans = "";
		for(int i=0; i<s1.length() && i<s2.length(); i++) {
			if(s1.charAt(i) == s2.charAt(i)) ans+= s1.charAt(i);
			else break;
		}
		return ans;
	}
	
	
	public static String longestCommonPrefix2(String arr[]) {
		if(arr == null || arr.length == 0) return "";
		if(arr.length == 1) return arr[0];
		
		String ans= arr[0];
		int end = ans.length();
		
		for(int i=1; i<arr.length; i++) {
			if(end > arr[i].length()) end = arr[i].length();
			for(int j=0; j<end; j++) {
				if(ans.charAt(j) != arr[i].charAt(j)) end = j;
			}
		}
		
		return ans.substring(0, end);
	}
	
	
	/**
	 * Multiplies the base, power times and returns the result
	 * @param base	base value
	 * @param power	exponent value
	 * @return		answer
	 */
	public static int power(int base, int power) {
		if(power == 0) return 1;
		if(power == 1) return base;
		int mul = power(base, power/2);
		if(power % 2 == 0) return mul *  mul;
		else return base * mul * mul;
	}
}
