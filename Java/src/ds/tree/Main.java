package ds.tree;

public class Main {

	public static void main(String args[]) {
		BinarySearchTree tree = new BinarySearchTree();
		
		tree.insert(30);
		tree.insert(20);
		tree.insert(25);
		tree.insert(10);
		tree.insert(50);
		tree.insert(45);
		tree.insert(60);
		tree.insert(15);
		tree.insert(70);
		tree.insert(80);
		
		TreeTraversal.inOrder(tree.getRoot());
		System.out.println();

		tree.delete(30);
		TreeTraversal.inOrder(tree.getRoot());
		System.out.println();

		System.out.println("Found 20: " + TreeUtil.isNodePresent(tree.getRoot(), 20));
		System.out.println("Found 100: " + TreeUtil.isNodePresent(tree.getRoot(), 100));
		
		TreeTraversal.levelOrder(tree.getRoot());
		System.out.println();
		TreeView.printLeftView(tree.getRoot());
		System.out.println();
		TreeView.printRightView(tree.getRoot());
	}
}
