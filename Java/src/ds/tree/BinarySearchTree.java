package ds.tree;

public class BinarySearchTree implements BinaryTree<Integer> {

	private Node<Integer> root;
	
	public BinarySearchTree() {
		this.root = null;
	}

	@Override
	public Node<Integer> getRoot() {
		return this.root;
	}

	private Node<Integer> insertIntoTree(Node<Integer> root, int data) {
		if(root ==  null) return new Node<Integer>(data);
		if(data < root.data) {
			root.left = insertIntoTree(root.left, data);
		} else {
			root.right = insertIntoTree(root.right, data);
		}
		return root;
	}
	
	@Override
	public void insert(int data) {
		this.root = insertIntoTree(this.root, data);
	}
	
	private Node<Integer> deleteFromTree(Node<Integer> root, int data) {
		if(root == null) return null;
		
		if(data < root.data) {
			root.left = deleteFromTree(root.left, data);
		} else if(data > root.data) {
			root.right = deleteFromTree(root.right, data);
		} else {
			//data == root.data;
			
			if(root.left == null) {
				return root.right;
			} else if(root.right == null) {
				return root.left;
			} else {
				//Both are not null;
				int minValue = TreeUtil.getMinValue(root.right);
				root.data = minValue;
				root.right = deleteFromTree(root.right, minValue);	
			}
		}
		
		return root;
	}
	
	
	@Override
	public void delete(int data) {
		this.root = this.deleteFromTree(this.root, data);
	}
		
	
}
