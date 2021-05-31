package algorithm.dp;

import java.text.DecimalFormat;
import java.util.Arrays;

public class Knapsack {

	public static void main(String args[]) {
		int profit[] = {20, 25, 5, 10, 40 ,15};
		int weight[] = {1, 4, 2, 3, 8, 7};
		
		printTestCase(weight, profit, 10);
		
		int profit1[] = {20, 1, 18, 2, 25, 4, 15, 10, 8, 9, 11, 17, 21, 19};
		int weight1[] = {5, 3, 2, 1, 4, 2, 2, 8, 5, 5, 3, 7, 9, 5};
		
		printTestCase(weight1, profit1, 25);
	}
	
	private static void printTestCase(int weight[], int profit[], int capacity) {
		System.out.println("----------------------------");
		System.out.println("----------------------------");
		System.out.println("Weight: " + Arrays.toString(weight));
		System.out.println("Profit: " + Arrays.toString(profit));
		System.out.println();

		long startTime = System.nanoTime();
		System.out.println("Max Profit of " + capacity + ": " + maxProfitBruteForce(weight, profit, capacity));
		System.out.println("Time elapsed Brute Force: " + getFormattedNumber(System.nanoTime() - startTime));
		System.out.println();
		
		startTime = System.nanoTime();
		System.out.println("Max Profit of " + capacity + ": " + maxProfitDPTopDown(weight, profit, capacity));
		System.out.println("Time elapsed DP Top Down: " + getFormattedNumber(System.nanoTime() - startTime));
		System.out.println();
		
		startTime = System.nanoTime();
		System.out.println("Max Profit of " + capacity + ": " + maxProfitDPBottomUP(weight, profit, capacity));
		System.out.println("Time elapsed DP Bottom Up: " + getFormattedNumber(System.nanoTime() - startTime));
		System.out.println();
		System.out.println("----------------------------");
		System.out.println("----------------------------");
	}
	
	private static String getFormattedNumber(long number) {
		String pattern = "###,###.###";
		DecimalFormat decimalFormat = new DecimalFormat(pattern);

		return decimalFormat.format(number);
	}
	
	public static int maxProfitBruteForce(int weight[], int profit[], int capacity) {
		return maxProfitBruteForce(weight, profit, capacity, 0);
	}
	
	public static int maxProfitBruteForce(int weight[], int profit[], int capacity, int index) {
		if(capacity == 0 || index >= weight.length) return 0;
		
		int include = Integer.MIN_VALUE;
		if(weight[index] <= capacity) 
			include = profit[index] + maxProfitBruteForce(weight, profit, capacity - weight[index], index + 1);
		int exclude = maxProfitBruteForce(weight, profit, capacity, index + 1);
		
		return Math.max(include, exclude);
	}
	
	public static int maxProfitDPTopDown(int weight[], int profit[], int capacity) {
		int dp[][] = new int[weight.length][capacity+1];
		for(int i=0; i<dp.length; i++) {
			for(int j=0; j<dp[i].length; j++) {
				dp[i][j] = Integer.MIN_VALUE;
			}
		}
		return maxProfitDPTopDown(weight, profit, capacity, 0, dp);
	}
	
	public static int maxProfitDPTopDown(int weight[], int profit[], int capacity, int index, int dp[][]) {
		if(capacity == 0 || index >= weight.length) return 0;
		if(dp[index][capacity] != Integer.MIN_VALUE) return dp[index][capacity];
		
		int include = Integer.MIN_VALUE;
		if(weight[index] <= capacity) 
			include = profit[index] + maxProfitDPTopDown(weight, profit, capacity - weight[index], index + 1, dp);
		int exclude = maxProfitDPTopDown(weight, profit, capacity, index + 1, dp);
		
		dp[index][capacity] = Math.max(include, exclude);
		return dp[index][capacity];
	}
	
	private static int maxProfitDPBottomUP(int weight[], int profit[], int capacity) {
		int dp[][] = new int[weight.length+1][capacity+1];
		
		for(int i=0; i<dp.length; i++) {
			for(int j=0; j<dp[i].length; j++) {
				if(i==0 || j==0) dp[i][j] = 0;
				else if(weight[i-1] > j) dp[i][j] = dp[i-1][j];
				else dp[i][j] = Math.max(dp[i-1][j], profit[i-1] + dp[i-1][j - weight[i-1]]);
			}
		}
		
		return dp[weight.length][capacity];
	}
	
	
}
