#include <stdio.h>
#include <stdlib.h>

struct Node {
    int data;
    struct Node *left, *right;
    int height;
};

struct Node* createNewNode(int data) {
    struct Node* newNode = (struct Node*)malloc(sizeof(struct Node));
    newNode->data = data;
    newNode->left = NULL;
    newNode->right = NULL;
    newNode->height = 1;
    return newNode;
}

int getHeight(struct Node *root) {
    if(root==NULL) return 0;
    else return root->height;
}

int getMax(int a, int b) {
    return a>b ? a : b;
}

void preOrder(struct Node *root) {
    if(root!=NULL) {
        printf("%d ", root->data);
        preOrder(root->left);
        preOrder(root->right);
    };
}

struct Node* rightRotate(struct Node *root) {
    if(root == NULL) return root; 
    
    //Storing pointers
    struct Node *leftChild = root->left;
    struct Node *rightChildOfLeft = leftChild->right;
    
    //Do the rotation/pointer changes
    leftChild->right = root;
    root->left = rightChildOfLeft;
    
    //Update the height
    root->height = getMax(getHeight(root->left), getHeight(root->right)) + 1;
    leftChild->height = getMax(getHeight(leftChild->left), getHeight(leftChild->right)) + 1;
    
    //return root
    return leftChild;
}


struct Node* leftRotate(struct Node *root) {
    if(root == NULL) return root;
    
    //Storing pointers
    struct Node *rightChild = root->right;
    struct Node *leftChildOfRight = rightChild->left;
    
    //Do the rotation/pointer changes
    rightChild->left = root;
    root->right = leftChildOfRight;
    
    //Update the height
    root->height = getMax(getHeight(root->left), getHeight(root->right)) + 1;
    rightChild->height = getMax(getHeight(rightChild->left), getHeight(rightChild->right)) + 1;
    
    //return root
    return rightChild;
}

struct Node *leftRightRotate(struct Node *root) {
    if(root == NULL) return root;

    root->left = leftRotate(root->left);
    return rightRotate(root);
}


struct Node *rightLeftRotate(struct Node *root) {
    if(root == NULL) return root;

    root->right = rightRotate(root->right);
    return leftRotate(root);
}

struct Node* insert(struct Node *root, int data) {
    if(root==NULL) {
        return createNewNode(data);
    } 
    
    if(data < root->data) {
        root->left = insert(root->left, data);
    } else if(data > root->data) {
        root->right = insert(root->right, data);
    } else {
        printf("Duplicate insertion not allowed\n");
    }
    
    //Updating height & Balance Factor;
    root->height = getMax(getHeight(root->left), getHeight(root->right)) + 1;
    int balanceFactor = getHeight(root->left) - getHeight(root->right);
    
    //Check the insertion condition
    if(balanceFactor > 1 && data < root->left->data) {
        //Left Left insertion
        //Right rotation
        return rightRotate(root);
    } else if(balanceFactor < -1 && data > root->right->data) {
        //Right Right insertion
        //Left rotation
        return leftRotate(root);
    } else if(balanceFactor > 1 && data > root->left->data) {
        //Left Right insertion
        //Left Right rotation
        return leftRightRotate(root);
    } else if(balanceFactor < -1 && data < root->right->data) {
        //Right Left insertion
        //Right Left rotation
        return rightLeftRotate(root);
    }
    
    return root;
}

int main() {
    printf("Implementation of AVL Tree\n");
	struct Node *root = NULL;
	root = insert(root, 10);
	root = insert(root, 20);
	printf("Preorder: ");
	preOrder(root);
	printf("\n");
	
	root = insert(root, 30);
	printf("Preorder: ");
	preOrder(root);
	printf("\n");
	
	root = insert(root, 25);
	root = insert(root, 12);
	root = insert(root, 11);
	printf("Preorder: ");
	preOrder(root);
	printf("\n");
	
	return 0;
}

/*
Expected Output:
---------------
Implementation of AVL Tree
Preorder: 10 20 
Preorder: 20 10 30 
Preorder: 20 11 10 12 30 25 
*/

