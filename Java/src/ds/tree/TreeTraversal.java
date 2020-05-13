package ds.tree;

import java.util.LinkedList;
import java.util.Queue;

public class TreeTraversal {

	public static void inOrder(Node<?> root) {
		if(root == null) return;
		inOrder(root.left);
		System.out.print(root.data + " ");
		inOrder(root.right);
	}
	
	public static void preOrder(Node<?> root) {
		if(root == null) return;
		System.out.print(root.data + " ");
		preOrder(root.left);
		preOrder(root.right);
	}
	
	public static void postOrder(Node<?> root) {
		if(root == null) return;
		postOrder(root.left);
		postOrder(root.right);
		System.out.print(root.data + " ");
	}
	

	public static void levelOrder(Node<?> root) {
		if(root == null) return;
		
		Queue<Node<?>> queue = new LinkedList<Node<?>>();
		queue.add(root);
		
		while(!queue.isEmpty()) {
			Node<?> node = queue.poll();
			System.out.print(node.data + " ");
			if(node.left != null) queue.add(node.left);
			if(node.right != null) queue.add(node.right);
		}
	}

}
