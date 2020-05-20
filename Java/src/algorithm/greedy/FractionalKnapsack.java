package algorithm.greedy;

public class FractionalKnapsack {

	public static void main(String args[]) {
		int weight[] = {2, 3, 5, 7, 1, 4, 1};
		int profit[] = {10, 5, 15, 7, 6, 18, 13};
		
		System.out.println("Max profit for 10: " + findMaxProfit(weight, profit, 10));
	}
	
	private static float findMaxProfit(int weight[], int profit[], int capacity) {
		float maxProfit = 0;
		float profitToWeight[] = new float[profit.length];
		
		for(int i=0; i<profit.length; i++) {
			profitToWeight[i] = profit[i] / weight[i];
		}
		
		while(capacity > 0) {
			int maxIndex = 0;
			float maxValue = Float.MIN_VALUE;
			
			for(int i=0; i<profitToWeight.length; i++) {
				if(profitToWeight[i] > maxValue && weight[i] > 0) {
					maxIndex = i;
					maxValue = profitToWeight[i];
				}
			}
			
			if(capacity >= weight[maxIndex]) {
				capacity = capacity - weight[maxIndex];
				maxProfit = maxProfit + profit[maxIndex];
				weight[maxIndex] = 0;
			} else {
				maxProfit = maxProfit + (profitToWeight[maxIndex]*capacity);
				capacity = 0;
			}
		}
		
		return maxProfit;
	}
}
