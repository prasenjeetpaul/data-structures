package ds.tree;

import java.util.LinkedList;
import java.util.Queue;

public class TreeView {
	public static void printLeftView(Node root) {
		if(root == null) return;
		
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);
		
		while(!queue.isEmpty()) {
			int size = queue.size();
			int i = 0;
			
			while(i < size) {
				i++;
				Node node = queue.poll();
				if(i==1) System.out.print(node.data + " ");
				if(node.left != null) queue.add(node.left);
				if(node.right != null) queue.add(node.right);
			}
			
		}
	}
	
	public static void printRightView(Node root) {
		if(root == null) return;
		
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);
		
		while(!queue.isEmpty()) {
			int size = queue.size();
			int i = 0;
			
			while(i < size) {
				i++;
				Node node = queue.poll();
				if(i==1) System.out.print(node.data + " ");
				if(node.right != null) queue.add(node.right);
				if(node.left != null) queue.add(node.left);
			}
			
		}
	}
}
