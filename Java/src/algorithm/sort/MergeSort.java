package algorithm.sort;

public class MergeSort implements SortAlgorithm {
	
	private void merge(int arr[], int start, int mid, int end) {
		
		int leftSize = mid - start + 1;
		int rightSize = end - mid;
		
		int leftArray[] = new int[leftSize];
		int rightArray[] = new int[rightSize];
		
		//Copying elements
		for(int i=0; i<leftSize; i++) {
			leftArray[i] = arr[start + i];
		}
		for(int i=0; i<rightSize; i++) {
			rightArray[i] = arr[mid + 1 + i];
		}
		
		//Merge Starts
		int i=0, j=0;
		int index = start;
		
		while(i < leftSize && j < rightSize) {
			if(leftArray[i] <= rightArray[j]) {
				arr[index++] = leftArray[i++];
			} else {
				arr[index++] = rightArray[j++];
			}
		}
		
		//Merge Remaining
		while(i < leftSize) arr[index++] = leftArray[i++];
		while(j < rightSize) arr[index++] = rightArray[j++];		
	}
	
	private void sort(int arr[], int start, int end) {
		if(start >= end) return;
		
		int mid = (start+end)/2;
		sort(arr, start, mid);
		sort(arr, mid+1, end);
		
		merge(arr, start, mid, end);
	}
	
	
	@Override
	public int[] sort(int[] arr) {
		sort(arr, 0, arr.length-1);
		return arr;
	}
	
}
