package ds.graph;

import java.util.Iterator;
import java.util.List;

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
}
