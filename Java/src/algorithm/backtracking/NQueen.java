package algorithm.backtracking;

public class NQueen {

	public static void main(String args[]) {
		printNQueen(4);
	}
	
	
	public static void printNQueen(int n) {
		int board[][] = new int[n][n];
		placeNQueen(board, 0);
	}
	
	private static void printBoard(int board[][]) {
		for(int i[]: board) {
			for(int j: i) 
				System.out.print(j + " ");
			System.out.println();
		}
		System.out.println();
		System.out.println();
	}
	
	private static void placeNQueen(int board[][], int col) {
		if(col >= board.length) printBoard(board);
		
		
		for(int row=0; row<board.length; row++) {
			if(isSafe(board, row, col)) {
				board[row][col] = 1;
				placeNQueen(board, col+1);
				board[row][col] = 0;
			}
		}
	}
	
	private static boolean isSafe(int board[][], int row, int col) {
		if(row >= board.length || col >= board.length) return false;
		int n = board.length;
		
		//Check top column
		for(int i=0; i<col; i++) 
			if(board[row][i] == 1) return false;
		
		//Upper Left Diagonal
		for(int i=row, j=col; i>=0 && j>=0; i--, j--) 
				if(board[i][j] == 1) return false;
		
		//Lower Left Diagonal
		for(int i=row, j=col; j>=0 && i<n; i++, j--)
			if(board[i][j]==1) return false;
		
		return true;
	}
}
