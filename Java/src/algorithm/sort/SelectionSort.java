package algorithm.sort;

public class SelectionSort implements SortAlgorithm {
	
	@Override
	public int[] sort(int[] arr) {
		for(int i=0; i<arr.length-1; i++) {
			int minIndex = i;
			
			for(int j=i+1; j<arr.length; j++) {
				if(arr[j] < arr[minIndex]) {
					minIndex = j;
				}
			}
			
			if(minIndex != i) {
				int temp = arr[minIndex];
				arr[minIndex] = arr[i];
				arr[i] = temp;				
			}
		}
		return arr;
	}
}
