package algorithm.greedy;


public class Prims {

	public static void main(String args[]) {
		int matrix[][] = {
				{0,2,0,6,0},
				{2,0,3,8,5},
				{0,3,0,0,7},
				{6,8,0,0,9},
				{0,5,7,9,0}
		};
		printMatrix(matrix);
		System.out.println("------------------------");
		printMatrix(getMinSpanning(matrix));
	}
	
	private static void printMatrix(int graph[][]) {
		for(int i[]: graph) {
			for(int j: i) {
				System.out.print(j + " ");
			}
			System.out.println();
		}
	}
	
	private static int getMinEdgeVertex(int edgeWeight[], boolean visited[]) {
		int minIndex = 0;
		int minValue = Integer.MAX_VALUE;
		
		for(int i=0; i<edgeWeight.length; i++) {
			if(!visited[i] && edgeWeight[i] < minValue) {
				minIndex = i;
				minValue = edgeWeight[i];
			}
		}
		
		return minIndex;
	}
	
	private static int[][] getMinSpanning(int graph[][]) {
		int minSpanning[][] = new int[graph.length][graph.length];
		
		int edgeWeight[] = new int[graph.length];
		int parent[] = new int[graph.length];
		boolean visited[] = new boolean[graph.length];
		
		for(int i=0; i<edgeWeight.length; i++) edgeWeight[i] = Integer.MAX_VALUE;
		
		parent[0] = -1;
		edgeWeight[0] = 0;
		
		for(int c=0; c<graph.length-1; c++) {
			
			int curr = getMinEdgeVertex(edgeWeight, visited);
			visited[curr] = true;
			
			
			for(int i=0; i<edgeWeight.length; i++) {
				if(graph[curr][i] != 0 && !visited[i] && graph[curr][i] < edgeWeight[i]) {
					parent[i] = curr;
					edgeWeight[i] = graph[curr][i];
				}
			}
		}
		
		
		for(int i=1; i<parent.length; i++) {
			minSpanning[parent[i]][i] = graph[i][parent[i]];
			minSpanning[i][parent[i]] = graph[i][parent[i]];
		}
		
		
		return minSpanning;
	}
}
