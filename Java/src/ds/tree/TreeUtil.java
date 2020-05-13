package ds.tree;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TreeUtil {

	public static boolean isNodePresent(Node<Integer> root, int data) {
		if(root == null) return false;
		if(root.data == data) return true;
		if(data < root.data ) {
			return isNodePresent(root.left, data);
		} else {
			return isNodePresent(root.right, data);
		}
	}
	
	public static int getMinValue(Node<Integer> root) {
		if(root == null) return -1;
		if(root.left == null) return root.data;
		else return getMinValue(root.left);
	}
	
	
	/**
	 * Creates a tree with Integer data from the below input format: 
	 * (Doesn't allow duplicate nodes in tree)
	 * 4
	 * 10 20 L 10 30 R 20 40 L 20 60 R
	 * @return
	 */
	public static Node<Integer> createTree() {
		Node<Integer> root = null;
		Scanner in = new Scanner(System.in);
		Map<Integer, Node<Integer>> map = new HashMap<Integer, Node<Integer>>();
		int n = in.nextInt();
		
		for(int i=0; i<n; i++) {
			int parent = in.nextInt();
			int child = in.nextInt();
			String pos = in.next();
			
			if(i==0) {
				root = new Node<Integer>(parent);
				map.put(parent, root);
			}
			
			Node<Integer> parentNode = map.get(parent);
			Node<Integer> childNode = new Node<Integer>(child);
			if(pos.equals("L")) parentNode.left = childNode;
			else if(pos.equals("R")) parentNode.right = childNode;
			
			map.put(child, childNode);
			
		}
		in.close();
		return root;
	}
	
	/**
	 * Create a tree with Character data if the inputs are given in complete binary tree order
	 * Allows duplicate nodes
	 * Ex Input:
	 * 4
	 * R A L R D R A A L A R R
	 * @return	Root Node of the created tree
	 */
	@SuppressWarnings("unchecked")
	public static Node<Character> createTreeWithLevelOrderInput() {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();

		Node<Character> arr[] = new Node[(int)Math.pow(2, n+1)-1];
		
		for(int i=0; i<n; i++) {
			char parent = in.next().charAt(0);
			char child = in.next().charAt(0);
			String pos = in.next();
			
			if(i==0) {
				arr[0] = new Node<Character>(parent);
			}
			
			Node<Character> childNode = new Node<Character>(child);
			int parentIndex = (i+1-1)/2;
			arr[i+1] = childNode;
			if(pos.equals("L")) arr[parentIndex].left = childNode;
			else arr[parentIndex].right = childNode;
			
		}
		
		in.close();
		return arr[0];
	}
}
