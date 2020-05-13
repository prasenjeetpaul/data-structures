package ds.tree;

public interface BinaryTree<T> {

	public Node<T> getRoot();
	public void insert(int data);
	public void delete(int data);

}
