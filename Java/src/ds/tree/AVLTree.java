package ds.tree;

public class AVLTree {

	private AVLNode root;

	public AVLNode getRoot() {
		return this.root;
	}
	
	private int getHeight(AVLNode node) {
		if(node == null) return 0;
		else return node.height;
	}
	
	private AVLNode rightRotate(AVLNode root) {
	    if(root == null) return root; 
	    
	    //Storing pointers
	    AVLNode leftChild = root.left;
	    AVLNode rightChildOfLeft = leftChild.right;
	    
	    //Do the rotation/pointer changes
	    leftChild.right = root;
	    root.left = rightChildOfLeft;
	    
	    //Update the height
	    root.height = Math.max(getHeight(root.left), getHeight(root.right)) + 1;
	    leftChild.height = Math.max(getHeight(leftChild.left), getHeight(leftChild.right)) + 1;
	    
	    //return root
	    return leftChild;
	}


	private AVLNode leftRotate(AVLNode root) {
	    if(root == null) return root;
	    
	    //Storing pointers
	    AVLNode rightChild = root.right;
	    AVLNode leftChildOfRight = rightChild.left;
	    
	    //Do the rotation/pointer changes
	    rightChild.left = root;
	    root.right = leftChildOfRight;
	    
	    //Update the height
	    root.height = Math.max(getHeight(root.left), getHeight(root.right)) + 1;
	    rightChild.height = Math.max(getHeight(rightChild.left), getHeight(rightChild.right)) + 1;
	    
	    //return root
	    return rightChild;
	}

	private AVLNode leftRightRotate(AVLNode root) {
	    if(root == null) return root;

	    root.left = leftRotate(root.left);
	    return rightRotate(root);
	}


	private AVLNode rightLeftRotate(AVLNode root) {
	    if(root == null) return root;

	    root.right = rightRotate(root.right);
	    return leftRotate(root);
	}
	
	private AVLNode insertIntoTree(AVLNode root, int data) {
		if(root ==  null) return new AVLNode(data);
		if(data < root.data) {
			root.left = insertIntoTree(root.left, data);
		} else {
			root.right = insertIntoTree(root.right, data);
		}
		
		//Insertion done, traversing up
		root.height = Math.max(getHeight(root.left), getHeight(root.right)) + 1;
		
		//Checking balance factor
		int balanceFactor = getHeight(root.left) - getHeight(root.right);
		
		//Checking whether my bf is correct or not
		
		 //Check the insertion condition
	    if(balanceFactor > 1 && data < root.left.data) {
	        //Left Left insertion
	        //Right rotation
	        return rightRotate(root);
	    } else if(balanceFactor < -1 && data > root.right.data) {
	        //Right Right insertion
	        //Left rotation
	        return leftRotate(root);
	    } else if(balanceFactor > 1 && data > root.left.data) {
	        //Left Right insertion
	        //Left Right rotation
	        return leftRightRotate(root);
	    } else if(balanceFactor < -1 && data < root.right.data) {
	        //Right Left insertion
	        //Right Left rotation
	        return rightLeftRotate(root);
	    }
		
		
		return root;
	}
	
	public void insert(int data) {
		this.root = insertIntoTree(this.root, data);
	}
	
	public void delete(int data) {
		// TODO Auto-generated method stub
		
	}
	
}
