package ds.tree;

import java.util.Scanner;

public class Main {

	public static void main(String args[]) {
//		BinarySearchTree tree = new BinarySearchTree();
//		
//		tree.insert(30);
//		tree.insert(20);
//		tree.insert(25);
//		tree.insert(10);
//		tree.insert(50);
//		tree.insert(45);
//		tree.insert(60);
//		tree.insert(15);
//		tree.insert(70);
//		tree.insert(80);
//		
//		TreeTraversal.inOrder(tree.getRoot());
//		System.out.println();
//
//		tree.delete(30);
//		TreeTraversal.inOrder(tree.getRoot());
//		System.out.println();
//
//		System.out.println("Found 20: " + TreeUtil.isNodePresent(tree.getRoot(), 20));
//		System.out.println("Found 100: " + TreeUtil.isNodePresent(tree.getRoot(), 100));
//		
//		TreeTraversal.levelOrder(tree.getRoot());
//		System.out.println();
//		TreeView.printLeftView(tree.getRoot());
//		System.out.println();
//		TreeView.printRightView(tree.getRoot());
//		
//		System.out.println();
//		System.out.println("Top View: ");
//		TreeView.printTopView(tree.getRoot());
//		
//		System.out.println();
//		System.out.println("Bottom View: ");
//		TreeView.printBottomView(tree.getRoot());
//		
//		
//		BinaryTree bst = new BinarySearchTree();
//		bst.insert(30);
//		bst.insert(20);
//		bst.insert(10);
//		bst.insert(15);
//		bst.insert(40);
//		bst.insert(35);
//		bst.insert(50);
//		bst.insert(60);
//		bst.insert(55);
//		
//		System.out.println(Solution.bstLCA(bst.getRoot(), 40, 55));
//		
//		MinHeap minHeap = new MinHeap();
//		int arr[] = {12, 4, 5, 1, 7, 18};
//		for(int i=0; i<arr.length; i++) {
//			minHeap.insert(arr[i]);
//			minHeap.print();
//		}
//
//		System.out.println("Deleting 5: " + minHeap.delete(5));
//		minHeap.print();
//
//		System.out.println("Min element: " + minHeap.deleteMin());
//		minHeap.print();
//		
		
		//Generating tree from console input
//		TreeTraversal.levelOrder(TreeUtil.createTree());
//		TreeTraversal.levelOrder(TreeUtil.createTreeWithLevelOrderInput());
		
		
		TrieSolution sol = new TrieSolution();
		Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String arr[] = new String[n];
        for(int i=0; i<n; i++) {
            arr[i] = in.next();
        }
        System.out.println("========");
        System.out.println("Longest Word: " + sol.longestWord(arr)); 
        
        in.close();
	}
}
