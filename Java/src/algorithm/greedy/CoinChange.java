package algorithm.greedy;

public class CoinChange {

	public static void main(String[] args) {
		int coins[] = {10, 5, 2, 1};
		System.out.println("Min coins for sum of 12: " + minCoins(coins, 12));
		System.out.println("Min coins for sum of 12: " + minCoinsIterative(coins, 12));
		
		int coins2[] = {20, 10, 5, 2, 1};
		System.out.println("Min coins for sum of 225: " + minCoins(coins2, 225));
		System.out.println("Min coins for sum of 225: " + minCoinsIterative(coins2, 225));
	}
	
	private static int minCoins(int coins[], int sum) {
		return minCoins(coins, sum, 0);
	}
	
	private static int minCoins(int coins[], int sum, int count) {
		if(sum <= 0) return count;
		for(int  i=0; i <coins.length; i++)
			if(coins[i] <= sum) return minCoins(coins, sum-coins[i], count+1);
		return count;
	}

	
	private static int minCoinsIterative(int coins[], int sum) {
		int count = 0;
		while(sum > 0) {
			for(int  i=0; i <coins.length; i++) {
				if(coins[i] <= sum) {
					count++;
					sum = sum - coins[i]; //Can be further optimized
					break;
				}				
			}
		}
		return count;
	}
}
