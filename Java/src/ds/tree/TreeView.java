package ds.tree;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

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
	
	public static void printTopView(Node root) {
		if(root == null) return;

		Queue<Node> queue = new LinkedList<Node>();
		Queue<Integer> distanceQueue = new LinkedList<Integer>();
		Map<Integer, Integer> map = new TreeMap<Integer, Integer>();
		
		
		queue.add(root);
		distanceQueue.add(0);
		
		while(!queue.isEmpty()) {
			int distance = distanceQueue.poll();
			Node node = queue.poll();
			
			if(!map.containsKey(distance)) {
				map.put(distance, node.data);
			}
			if(node.left != null) {
				queue.add(node.left);
				distanceQueue.add(distance-1);
			}
			if(node.right != null) {
				queue.add(node.right);
				distanceQueue.add(distance+1);
			}
		}
		
		for(int value: map.values()) {
			System.out.print(value + " ");
		}
		
	}
	
	public static void printBottomView(Node root) {
		if(root == null) return;

		Queue<Node> queue = new LinkedList<Node>();
		Queue<Integer> distanceQueue = new LinkedList<Integer>();
		Map<Integer, Integer> map = new TreeMap<Integer, Integer>();
		
		
		queue.add(root);
		distanceQueue.add(0);
		
		while(!queue.isEmpty()) {
			int distance = distanceQueue.poll();
			Node node = queue.poll();
			
			map.put(distance, node.data);

			if(node.left != null) {
				queue.add(node.left);
				distanceQueue.add(distance-1);
			}
			if(node.right != null) {
				queue.add(node.right);
				distanceQueue.add(distance+1);
			}
		}
		
		for(int value: map.values()) {
			System.out.print(value + " ");
		}
		
	}
}
