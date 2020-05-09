package algorithm.sort;

public class InsertionSort implements SortAlgorithm {
	
	@Override
	public int[] sort(int[] arr) {
		
		for(int i=1; i<arr.length; i++) {
			int value = arr[i]; 
			//Setting the lower boundary
			int j = i-1;
			
			//Changing values of left sub array
			while(j>=0 && arr[j] > value) {
				arr[j] = arr[j+1];
				j--;
			}
			
			//Inserting the actual value
			arr[j+1] = value;
		}
		return arr;
	}
}
