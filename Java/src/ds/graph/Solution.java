package ds.graph;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class Solution {

	private static int maxNoOfRoutesHelper(List<List<Integer>> list, int src, int dest, int count, String path) {
		if(src == dest) {
			count++;
			System.out.println(path);
		} else {
			Iterator<Integer> iterator = list.get(src).iterator();
			while(iterator.hasNext()) {
				int next = iterator.next();
				count = maxNoOfRoutesHelper(list, next, dest, count, path + next + " -> ");
			}
		}
		return count;
	}
	
	public static int maxNoOfRoutes(List<List<Integer>> list, int src, int dest) {
		return maxNoOfRoutesHelper(list, src, dest, 0, src + " -> ");
	}
	
	public static void printConnectedComponent(boolean graph[][]) {
		boolean visisted[] = new boolean[graph.length];
		
		for(int i=0; i<graph.length; i++) {
			if(!visisted[i]) printDFS(graph, visisted, i);
		}
		
	}
	
	
	private static void printDFS(boolean matrix[][], boolean[] visited, int startIndex) {
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
}
