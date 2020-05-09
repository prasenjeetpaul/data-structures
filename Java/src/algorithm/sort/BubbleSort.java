package algorithm.sort;

public class BubbleSort implements SortAlgorithm {
	
	@Override
	public int[] sort(int[] arr) {
		for(int i=0; i<arr.length - 1; i++) {
			boolean isSwapped = false;
			for(int j=0; j<arr.length - 1 -i; j++) {
				if(arr[j] > arr[j+1]) {
					isSwapped = true;
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
			if(!isSwapped) return arr;
		}
		return arr;
	}
}
