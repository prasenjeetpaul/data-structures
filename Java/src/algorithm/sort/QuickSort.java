package algorithm.sort;

public class QuickSort implements SortAlgorithm {

	public int partition(int arr[], int start, int end) {
		int pivot = arr[end];
		int i = start-1;
		
		//Start loop to get the min Index
		for(int j=start; j<end; j++) {
			if(arr[j] < pivot) {
				i++;
				
				int temp = arr[i];
				arr[j] = arr[i];
				arr[i] = temp;
			}
		}
		
		//swap the pivot
		int temp = arr[i+1];
		arr[i+1] = arr[end];
		arr[end] = temp;

 		return i+1;
	}

	public void sort(int arr[], int start, int end) {
		if(start >= end) return;
		
		int pivotIndex = partition(arr, start, end);
		sort(arr, start, pivotIndex - 1);
		sort(arr, pivotIndex+1, end);
	}
	
	
	@Override
	public int[] sort(int[] arr) {
		sort(arr, 0, arr.length-1);
		return arr;
	}
}
