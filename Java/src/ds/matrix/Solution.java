package ds.matrix;

public class Solution {

	public static void printMatrix(int matrix[][]) {
		for(int i[]: matrix) {
			for(int j: i) {
				System.out.printf("%-4d ", j);
			}
			System.out.println();
		}
	}
	

	public static int noOfIsland(int matrix[][]) {
		int count = 0;
		for(int i=0; i<matrix.length; i++) {
			for(int j=0; j<matrix.length; j++) {
				if(matrix[i][j] == 1) {
					count++;
					destroyIsland(matrix, i, j);
				}
			}
		}
		return count;
	}
	
	private static void destroyIsland(int matrix[][], int i, int j) {
		if(i<0 || j<0 || i>=matrix.length || j>=matrix.length || matrix[i][j] == 0) return;
		matrix[i][j] = 0;
		destroyIsland(matrix, i-1, j);
		destroyIsland(matrix, i, j+1);
		destroyIsland(matrix, i+1, j);
		destroyIsland(matrix, i, j-1);
		
		destroyIsland(matrix, i-1, j-1);
		destroyIsland(matrix, i-1, j+1);
		destroyIsland(matrix, i+1, j+1);
		destroyIsland(matrix, i+1, j-1);
	}

	public static void printSpiral(int n) {
		int matrix[][] = new int[n][n];
		printSpiral(matrix, 0, 0, 0);
		printMatrix(matrix);
	}
	
	private static void printSpiral(int matrix[][], int i, int j, int count) {
		if(i<0 || j<0 || i>=matrix.length || j>=matrix.length || matrix[i][j] != 0) return;
		matrix[i][j] = ++count;
		if(i == 0 || matrix[i-1][j] != 0) printSpiral(matrix, i, j+1, count);
		printSpiral(matrix, i+1, j, count);
		printSpiral(matrix, i, j-1, count);
		printSpiral(matrix, i-1, j, count);
	}
	
}
