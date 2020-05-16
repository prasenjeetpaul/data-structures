package ds.graph;

public class Main {
	
	public static void main(String args[]) {
		AdjacencyMatrix matrix = new AdjacencyMatrix(5);
		matrix.addEdge(0, 1);
		matrix.addEdge(0, 2);
		matrix.addEdge(0, 3);
		matrix.addEdge(1, 2);
		matrix.addEdge(4, 3);
		matrix.addEdge(4, 2);
		matrix.printGraph();
		
		System.out.println("-------------------");
		AdjacencyList list = new AdjacencyList(5);
		list.addEdge(0, 1);
		list.addEdge(0, 2);
		list.addEdge(0, 3);
		list.addEdge(1, 2);
		list.addEdge(4, 3);
		list.addEdge(4, 2);
		list.printGraph();
		
		System.out.println("-------------------");
		list.deleteEdge(1, 2);
		list.printGraph();
		
		System.out.println("-------------------");
		System.out.print("Matrix DFS: ");
		GraphUtil.printDFS(matrix.getGraph(), 0);
	
		System.out.println("-------------------");
		System.out.print("Matrix BFS: ");
		GraphUtil.printBFS(matrix.getGraph(), 0);
		
		System.out.println("-------------------");
		System.out.print("Adjacency List DFS: ");
		GraphUtil.printDFS(list.getMatrix(), 1);
		
		System.out.println("-------------------");
		System.out.print("Adjacency List BFS: ");
		GraphUtil.printBFS(list.getMatrix(), 1);
		
		
		maxNoOfPathsTest();
		
	}
	
	private static void maxNoOfPathsTest() {
		DirectedAdjacencyList directedList = new DirectedAdjacencyList(6);
		directedList.addEdge(0, 3);
		directedList.addEdge(0, 4);
		directedList.addEdge(1, 0);
		directedList.addEdge(1, 2);
		directedList.addEdge(1, 3);
		directedList.addEdge(2, 3);
		directedList.addEdge(3, 5);
		directedList.addEdge(4, 2);
		directedList.addEdge(4, 5);
		directedList.addEdge(5, 3);
		System.out.println("Max no. of paths from 1 to 3: " + Solution.maxNoOfRoutes(directedList.getGraph(), 1, 3));
	}
	

}
