package ds.tree;

public class Solution {
	
	public static int bstLCA(Node<Integer> root, int d1, int d2) {
		if(root == null) return -1;
		
		if(d1 < root.data  && d2 < root.data) {
			return bstLCA(root.left, d1, d2);
		}
		
		if(d1 > root.data && d2 > root.data) {
			return bstLCA(root.right, d1, d2);
		}
		
		return root.data;
		
	}
	
	public static int binaryTreeLCA(Node<Integer> root, int d1, int d2) {
		if(root == null) return -1;
		
		if(root.data == d1 || root.data == d2) {
			return root.data;
		}
		
		int leftNode = binaryTreeLCA(root.left, d1, d2);
		int rightNode = binaryTreeLCA(root.right, d1, d2);
		
		if(leftNode != -1 && rightNode != -1) {
			return root.data;
		}
		
		return leftNode != -1 ? leftNode : rightNode;
		
	}

}
