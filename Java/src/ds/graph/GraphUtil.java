package ds.graph;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class GraphUtil {

	public static void printDFS(boolean matrix[][], int startIndex) {
		boolean[] visited = new boolean[matrix.length];
		Stack<Integer> stack = new Stack<Integer>();
		
		stack.push(startIndex);
		visited[startIndex] = true;

		while(!stack.empty()) {
			int curr = stack.pop();
			System.out.print(curr + "-> ");
			for(int i=matrix[curr].length-1; i>=0; i--) {
				if(matrix[curr][i] && !visited[i]) {
					stack.push(i);
					visited[i] = true;
				}
			}	
		}
		System.out.println();
	}
	
	public static void printDFS(List<List<Integer>> list, int startIndex) {
		boolean visited[] = new boolean[list.size()];
		Stack<Integer> stack = new Stack<>();
		
		stack.push(startIndex);
		visited[startIndex] = true;
		
		while(!stack.isEmpty()) {
			int curr = stack.pop();
			System.out.print(curr + " -> ");
			
			for(int i=0; i<list.get(curr).size(); i++) {
				int vertex = list.get(curr).get(i);
				if(!visited[vertex]) {
					stack.push(vertex);
					visited[vertex] = true;					
				}
			}
		}
		System.out.println();
	}
	
	public static void printBFS(boolean matrix[][], int startIndex) {
		boolean[] visited = new boolean[matrix.length];
		Queue<Integer> queue = new LinkedList<Integer>();
		
		queue.add(startIndex);
		visited[startIndex] = true;

		while(!queue.isEmpty()) {
			int curr = queue.remove();
			System.out.print(curr + "-> ");
			for(int i=0; i<matrix[curr].length; i++) {
				if(matrix[curr][i] && !visited[i]) {
					queue.add(i);
					visited[i] = true;
				}
			}
			
		}
		System.out.println();
	}
	
	public static void printBFS(List<List<Integer>> list, int startIndex) {
		boolean visited[] = new boolean[list.size()];
		Queue<Integer> queue = new LinkedList<>();
		
		queue.add(startIndex);
		visited[startIndex] = true;
		
		while(!queue.isEmpty()) {
			int curr = queue.remove();
			System.out.print(curr + " -> ");
			
			Iterator<Integer> iterator = list.get(curr).listIterator();
			while(iterator.hasNext()) {
				int vertex = iterator.next();
				if(!visited[vertex]) {
					queue.add(vertex);
					visited[vertex] = true;					
				}
			}
		}
		System.out.println();
	}
}
