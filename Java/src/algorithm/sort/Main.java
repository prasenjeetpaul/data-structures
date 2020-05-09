package algorithm.sort;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		int arr[] = {5, 2, 1, 8, 9, 3};
		
		SortAlgorithm sortObj = new BubbleSort();
		System.out.println(Arrays.toString(sortObj.sort(arr)));
		
		sortObj = new SelectionSort();
		System.out.println(Arrays.toString(sortObj.sort(arr)));
		
		sortObj = new InsertionSort();
		System.out.println(Arrays.toString(sortObj.sort(arr)));
		
		sortObj = new MergeSort();
		System.out.println(Arrays.toString(sortObj.sort(arr)));
		
		sortObj = new QuickSort();
		System.out.println(Arrays.toString(sortObj.sort(arr)));
		
		//Java Inbuilt Sorting
		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));
	}

}
