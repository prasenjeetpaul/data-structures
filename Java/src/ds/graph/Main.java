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
		Graph<Integer> list = new AdjacencyList(4);
		list.addEdge(0, 1);
		list.addEdge(0, 2);
		list.addEdge(0, 3);
		list.addEdge(1, 2);
		list.printGraph();
		
		System.out.println("-------------------");
		list.deleteEdge(1, 2);
		list.printGraph();
		
		System.out.println("-------------------");
		list.deleteEdge(0, 1);
		list.printGraph();
	
		System.out.println("-------------------");
		System.out.print("DFS: ");
		matrix.printDFS(0);
		System.out.println();
	
		System.out.println("-------------------");
		System.out.print("BFS: ");
		matrix.printBFS(0);
	
	}

}
