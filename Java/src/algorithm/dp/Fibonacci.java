package algorithm.dp;

public class Fibonacci {

	public static void main(String args[]) {
		printTestCase(30);
		System.out.println("------------");
		printTestCase(40);
	}
	
	private static void printTestCase(int n) {
		long startTime = System.nanoTime();
		System.out.println("Fibonnaci without dp: " + fibonacci(n));
		System.out.println("Time Elapsed: " + (System.nanoTime() - startTime));
		System.out.println();
		
		startTime = System.nanoTime();
		System.out.println("Fibonnaci with DP(Top Down): " + fibonacciWithDP(n));
		System.out.println("Time Elapsed: " + (System.nanoTime() - startTime));
		System.out.println();
		
		startTime = System.nanoTime();
		System.out.println("Fibonnaci with DP(Bottom Up): " + fibonacciWithDPBottomUP(n));
		System.out.println("Time Elapsed: " + (System.nanoTime() - startTime));
		System.out.println();
	}
	
	public static long fibonacci(int n) {
		if(n < 2) return n;
		return fibonacci(n-1) + fibonacci(n-2);
	}
	
	public static long fibonacciWithDP(int n) {
		if(n < 2) return n;
		long dp[] = new long[n+1];
		dp[0] = 0;
		dp[1] = 1;
		return fibonacciWithDP(n, dp);
	}
	
	private static long fibonacciWithDP(int n, long dp[]) {
		if(n == 0) return 0;
		if(dp[n] != 0) return dp[n];
		else dp[n] = fibonacciWithDP(n-1, dp) + fibonacciWithDP(n-2, dp);
		return dp[n];
	}
	
	private static long fibonacciWithDPBottomUP(int n) {
		long dp[] = new long[n+1];
		dp[0] = 0;
		dp[1] = 1;
		
		for(int i=2; i<=n; i++) {
			dp[i] = dp[i-1] + dp[i-2];
		}
		
		return dp[n];
	}
}
