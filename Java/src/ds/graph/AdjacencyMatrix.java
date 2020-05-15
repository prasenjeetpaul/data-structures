package ds.graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Implementation of Undirected Unweighted Graph using
 * Adjacency Matrix
 */
public class AdjacencyMatrix implements Graph<Integer>{

	private boolean matrix[][];
	
	public AdjacencyMatrix(int noOfvertex) {
		this.matrix = new boolean[noOfvertex][noOfvertex];
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
	
	public void printDFS(int startIndex) {
		boolean[] visited = new boolean[this.matrix.length];
		Stack<Integer> stack = new Stack<Integer>();
		
		stack.push(startIndex);
		visited[startIndex] = true;

		while(!stack.empty()) {
			int curr = stack.pop();
			System.out.print(curr + "-> ");
			for(int i=this.matrix[curr].length-1; i>=0; i--) {
				if(this.matrix[curr][i] && !visited[i]) {
					stack.push(i);
					visited[i] = true;
				}
			}
			
		}
	}
	
	public void printBFS(int startIndex) {
		boolean[] visited = new boolean[this.matrix.length];
		Queue<Integer> queue = new LinkedList<Integer>();
		
		queue.add(startIndex);
		visited[startIndex] = true;

		while(!queue.isEmpty()) {
			int curr = queue.remove();
			System.out.print(curr + "-> ");
			for(int i=0; i<this.matrix[curr].length; i++) {
				if(this.matrix[curr][i] && !visited[i]) {
					queue.add(i);
					visited[i] = true;
				}
			}
			
		}
	}
}
