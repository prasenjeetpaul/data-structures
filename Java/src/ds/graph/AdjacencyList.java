package ds.graph;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AdjacencyList implements Graph<Integer> {

	private List<List<Integer>> list;
	
	public AdjacencyList(int noOfVertex) {
		this.list = new ArrayList<List<Integer>>(noOfVertex);
		for(int i=0; i<noOfVertex; i++) {
			this.list.add(new ArrayList<Integer>());
		}
	}
	
	@Override
	public void addEdge(Integer src, Integer dest) {
		this.list.get(src).add(dest);
		this.list.get(dest).add(src);
	}
	
	@Override
	public void deleteEdge(Integer src, Integer dest) {
		for(int i=0; i<this.list.get(src).size(); i++) {
			if(this.list.get(src).get(i) == dest) {
				this.list.get(src).remove(i);
				break;
			}
		}
		for(int i=0; i<this.list.get(dest).size(); i++) {
			if(this.list.get(dest).get(i) == src) {
				this.list.get(dest).remove(i);
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
