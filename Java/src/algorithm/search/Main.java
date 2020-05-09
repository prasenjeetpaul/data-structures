package algorithm.search;

import java.util.Arrays;

public class Main {

	public static void main(String args[]) {
		int arr[] = {3,2,9,0,6,8,1};
		
		SearchAlgorithm searchObj = new LinearSearch();
		System.out.println(Arrays.toString(arr));
		System.out.println("8 found at index: " + searchObj.search(arr, 8));
		
		Arrays.sort(arr);
		
		searchObj = new BinarySearch();
		System.out.println(Arrays.toString(arr));
		System.out.println("2 found at index: " + searchObj.search(arr, 2));
		
	}
}
