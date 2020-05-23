package algorithm.dp;

public class MatrixPath {

	private static int bruteForceCount = 0;
	private static int dpCount = 0;
	
	public static void main(String args[]) {
		int matrix[][] = {
				{1, 2, 3},
				{4, 5, 6},
				{8, 9, 7}
		};
		printTestCase(matrix);
		
		int matrix2[][] = {
				{1, 2, 13, 14, 16},
				{5, 3, 15, 12, 18},
				{6, 4, 17, 11, 20},
				{7, 8, 10, 9, 19},
				{23, 24, 22, 25, 21}
		};
		printTestCase(matrix2);
	}
	
	
	private static void printTestCase(int matrix[][]) {
		long startTime = System.nanoTime();
		System.out.println("Max path length: " + findMaxPath(matrix));
		System.out.println("Time Elapses (Brute Fore): " + (System.nanoTime() - startTime));
		System.out.println("Brute force count: " + bruteForceCount);
		bruteForceCount = 0;
		System.out.println();
		
		startTime = System.nanoTime();
		System.out.println("Max path length: " + findMaxPathDP(matrix));
		System.out.println("Time Elapses (DP): " + (System.nanoTime() - startTime));
		System.out.println("DP count: " + dpCount);
		dpCount = 0;
		System.out.println();
		System.out.println();
		System.out.println("---------------------------");
	}
	
	public static int findMaxPath(int matrix[][]) {
		int ans = Integer.MIN_VALUE;
		for(int i=0; i<matrix.length; i++) {
			for(int j=0; j<matrix.length; j++) {
				ans = Math.max(ans, calculatePath(matrix, i, j));
			}
		}
		return ans;
	}
	
	private static int calculatePath(int matrix[][], int i, int j) {
		if(i < 0 || j<0 || i>=matrix.length || j>= matrix.length) return 0;
		bruteForceCount++;
		int n = matrix.length;
		int top = Integer.MIN_VALUE;
		int right = Integer.MIN_VALUE;
		int bottom = Integer.MIN_VALUE;
		int left = Integer.MIN_VALUE;
		
		//Go Top
		if(i>0 && matrix[i][j] + 1 == matrix[i-1][j])
			top = 1 + calculatePath(matrix, i-1, j);
		
		//Go Right
		if(j<n-1 && matrix[i][j] + 1 == matrix[i][j+1]) 
			right = 1 + calculatePath(matrix, i, j+1);
		
		//Go bottom
		if(i<n-1 && matrix[i][j] + 1 == matrix[i+1][j]) 
			bottom = 1 + calculatePath(matrix, i+1, j);
		
		//Go Left
		if(j>0 && matrix[i][j] + 1 == matrix[i][j-1]) 
			left = 1 + calculatePath(matrix, i, j-1);
		
		return Math.max(top, Math.max(right, Math.max(bottom, Math.max(left, 1))));
	}
	
	public static int findMaxPathDP(int matrix[][]) {
		int ans = Integer.MIN_VALUE;
		int dp[][] = new int[matrix.length][matrix.length];

		for(int i=0; i<dp.length; i++) {
			for(int j=0; j<dp.length; j++) {
				dp[i][j] = -1;
			}
		}

		for(int i=0; i<matrix.length; i++) {
			for(int j=0; j<matrix.length; j++) {
				if(dp[i][j] == -1) calculatePathDP(matrix, dp, i, j);
				ans = Math.max(ans, dp[i][j]);
			}
		}
		return ans;
	}

	private static int calculatePathDP(int matrix[][], int dp[][], int i, int j) {
		if(i < 0 || j<0 || i>=matrix.length || j>= matrix.length) return 0;
		if(dp[i][j] != -1) return dp[i][j];
		dpCount++;
		int n = matrix.length;
		int top = Integer.MIN_VALUE;
		int right = Integer.MIN_VALUE;
		int bottom = Integer.MIN_VALUE;
		int left = Integer.MIN_VALUE;
		
		//Go Top
		if(i>0 && matrix[i][j] + 1 == matrix[i-1][j])
			top =  1 + calculatePathDP(matrix, dp, i-1, j);
		
		//Go Right
		if(j<n-1 && matrix[i][j] + 1 == matrix[i][j+1]) 
			right = 1 + calculatePathDP(matrix, dp, i, j+1);
		
		//Go bottom
		if(i<n-1 && matrix[i][j] + 1 == matrix[i+1][j]) 
			bottom = 1 + calculatePathDP(matrix, dp, i+1, j);
		
		//Go Left
		if(j>0 && matrix[i][j] + 1 == matrix[i][j-1]) 
			left = 1 + calculatePathDP(matrix, dp, i, j-1);
		
		
		dp[i][j] = Math.max(top, Math.max(right, Math.max(bottom, Math.max(left, 1))));
		return dp[i][j];
	}
}
