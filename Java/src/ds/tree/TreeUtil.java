package ds.tree;

public class TreeUtil {

	public static boolean isNodePresent(Node root, int data) {
		if(root == null) return false;
		if(root.data == data) return true;
		if(data < root.data ) {
			return isNodePresent(root.left, data);
		} else {
			return isNodePresent(root.right, data);
		}
	}
	
	public static int getMinValue(Node root) {
		if(root == null) return -1;
		if(root.left == null) return root.data;
		else return getMinValue(root.left);
	}
	
}
