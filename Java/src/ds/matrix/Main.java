package ds.matrix;

public class Main {

	public static void main(String args[]) {
		int matrix[][] = {
				{0, 1, 1, 1, 0, 1, 0},
				{0, 1, 1, 1, 1, 1, 0},
				{0, 1, 0, 0, 0, 0, 0},
				{0, 0, 0, 1, 1, 0, 1},
				{1, 1, 1, 0, 0, 1, 1},
				{1, 1, 0, 0, 0, 0, 1},
				{0, 1, 1, 0, 1, 0, 1}
		};
		Solution.printMatrix(matrix);
		System.out.println("No. of Islands: " + Solution.noOfIsland(matrix));
		System.out.println();
		System.out.println("Spiral Traversal of 4");
		Solution.printSpiral(4);
		
		System.out.println();
		System.out.println("Spiral Traversal of 5");
		Solution.printSpiral(5);
	}
	
	
	
}
