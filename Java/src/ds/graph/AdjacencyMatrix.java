package ds.graph;

/**
 * Implementation of Undirected Unweighted Graph using
 * Adjacency Matrix
 */
public class AdjacencyMatrix implements Graph<Integer>{

	private boolean matrix[][];
	
	public AdjacencyMatrix(int noOfvertex) {
		this.matrix = new boolean[noOfvertex][noOfvertex];
	}
	
	public boolean[][] getGraph() {
		return this.matrix;
	}
	
	@Override
	public void addEdge(Integer src, Integer dest) {
		this.matrix[src][dest] = true;
		this.matrix[dest][src] = true;
	}
	
	@Override
	public void deleteEdge(Integer src, Integer dest) {
		this.matrix[src][dest] = false;
		this.matrix[dest][src] = false;
	}
	
	@Override
	public void printGraph() {
		System.out.print("\t");
		for(int i=0; i<this.matrix.length; i++) {
			System.out.print(i + "\t");
		}
		System.out.println();
		for(int i=0; i<this.matrix.length; i++) {
			System.out.print(i + "\t");
			for(int j=0; j<this.matrix.length; j++) {
				System.out.print((this.matrix[i][j] ? 1 : 0) + "\t");
			}
			System.out.println();
		}
	}

}
