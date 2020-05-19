package algorithm.dc;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		int arr[] = {0,0,0,0,1,1,1};
		System.out.println("No. of 1s: " + Solution.getNoOfOne(arr));
		
		
		String arr2[] = {"abcd", "abcd", "abcd", "abcdefg", "abcd"};
		System.out.println(Arrays.toString(arr2));
		System.out.println("Longest comon prefix: " + Solution.longestCommonPrefix(arr2));
		System.out.println("Longest comon prefix: " + Solution.longestCommonPrefix2(arr2));
		
		System.out.println("2^0: " + Solution.power(2, 0));
		System.out.println("2^1: " + Solution.power(2, 1));
		System.out.println("2^2: " + Solution.power(2, 2));
		System.out.println("2^5: " + Solution.power(2, 5));
	}

}
