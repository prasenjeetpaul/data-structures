package algorithm.dp;

import java.util.Arrays;

public class CoinChange {

	public static void main(String[] args) {
		int coins[] = {9, 5, 6, 1};
		printTestCase(coins, 11);
		
		int coins2[] = {2, 9, 6, 5, 1};
		printTestCase(coins2, 11);
		
		int coins3[] = {2, 10, 5, 1};
		printTestCase(coins3, 37);
	}
	
	private static void  printTestCase(int coins[], int sum) {
		System.out.println("----------------");
		long startTime = System.nanoTime();
		
		System.out.println(Arrays.toString(coins));
		System.out.println("Min Coins for " + sum + ": " + findMinCoins(coins, sum));
		System.out.println("Time Elapsed (Brute Force): " + (System.nanoTime() - startTime));
		System.out.println();
		
		startTime = System.nanoTime();
		System.out.println(Arrays.toString(coins));
		System.out.println("Min Coins for " + sum + ": " + findMinCoinsDPTopDown(coins, sum));
		System.out.println("Time Elapsed (DP Top Down): " + (System.nanoTime() - startTime));
		System.out.println();
		
		startTime = System.nanoTime();
		System.out.println(Arrays.toString(coins));
		System.out.println("Min Coins for " + sum + ": " + findMinCoinsDPBottomUp(coins, sum));
		System.out.println("Time Elapsed (DP Bottom Up): " + (System.nanoTime() - startTime));
		
		
		System.out.println("----------------");
	}

	public static int findMinCoins(int coins[], int sum) {
		if(sum == 0) return 0;
		int ans = Integer.MAX_VALUE;
		
		for(int i=0; i<coins.length; i++) {
			if(coins[i] <= sum) {
				int subRes = findMinCoins(coins, sum - coins[i]) + 1;
				ans = Math.min(ans, subRes);
			}
		}
		return ans;
	}
	
	public static int findMinCoinsDPTopDown(int coins[], int sum) {
		int dp[] = new int[sum+1];
		dp[0] = 0;
		for(int i=0; i<dp.length; i++) dp[i] =Integer.MAX_VALUE;
		return findMinCoinsDPTopDown(coins, sum, dp);
	}
	
	public static int findMinCoinsDPTopDown(int coins[], int sum, int dp[]) {
		if(sum == 0) return 0;
		if(dp[sum] != Integer.MAX_VALUE) return dp[sum];
		for(int i=0; i<coins.length; i++) {
			if(coins[i] <= sum) {
				dp[sum] = Math.min(dp[sum], findMinCoinsDPTopDown(coins, sum-coins[i], dp) + 1); 
			}
		}
		return dp[sum];
	}
	
	
	public static int findMinCoinsDPBottomUp(int coins[], int sum) {
		int dp[] = new int[sum+1];
		for(int i=0; i<dp.length; i++) dp[i] =Integer.MAX_VALUE;
		dp[0] = 0;
		
		for(int amount = 1; amount <= sum; amount++) {
			for(int i=0; i<coins.length; i++) {
				if(coins[i] <= amount) {
					dp[amount] = Math.min(dp[amount], 1 + dp[amount - coins[i]]);
				}
			}
		}
		
		return dp[sum];
	}

}
