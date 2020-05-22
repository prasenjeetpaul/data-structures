package algorithm.dp;

public class MatrixPath {

	public static void main(String args[]) {
		int matrix[][] = {
				{1, 2, 3},
				{4, 5, 6},
				{8, 9, 7}
		};
		System.out.println(findMaxPath(matrix));
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
}
