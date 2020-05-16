package ds.graph;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DirectedAdjacencyList implements Graph<Integer> {
private List<List<Integer>> list;
	
	public DirectedAdjacencyList(int noOfVertex) {
		this.list = new ArrayList<List<Integer>>(noOfVertex);
		for(int i=0; i<noOfVertex; i++) {
			this.list.add(new ArrayList<Integer>());
		}
	}
	
	public List<List<Integer>> getGraph() {
		return this.list;
	}
	
	@Override
	public void addEdge(Integer src, Integer dest) {
		this.list.get(src).add(dest);
	}
	
	@Override
	public void deleteEdge(Integer src, Integer dest) {
		for(int i=0; i<this.list.get(src).size(); i++) {
			if(this.list.get(src).get(i) == dest) {
				this.list.get(src).remove(i);
				break;
			}
		}
	}
	
	@Override
	public void printGraph() {
		for(int i=0; i<list.size(); i++) {
			System.out.print(i + "\t");
			Iterator<Integer> iterator = this.list.get(i).iterator();
			while(iterator.hasNext()) {
				System.out.print("->" + iterator.next());
			}
			System.out.println();
		}
		
	}
}
