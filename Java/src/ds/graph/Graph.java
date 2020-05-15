package ds.graph;

public interface Graph<T> {
	
	public void addEdge(T src, T dest);
	
	public void deleteEdge(T src, T dest);
	
	public void printGraph();
}
