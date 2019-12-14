#include <stdio.h>
#include <stdlib.h>

struct Node {
    int data;
    struct Node *left, *right;
};


struct Node* createNewNode(int data) {
    struct Node* newNode = (struct Node*)malloc(sizeof(struct Node));
    newNode->data = data;
    newNode->left = NULL;
    newNode->right = NULL;
    return newNode;
}


struct Node* insert(struct Node *root, int data) {
    if(root == NULL) {
        return createNewNode(data);
    }
    if(data < root->data) {
        root->left = insert(root->left, data);
    } else if(data > root->data) {
        root->right = insert(root->right, data);
    } else {
        printf("Duplicate insertion not allowed\n");
    }
    return root;
}

void inOrder(struct Node *root) {
    if(root != NULL) {
        inOrder(root->left);
        printf("%d ", root->data);
        inOrder(root->right);
    }
}

int isLeafNode(struct Node *root) {
    if(root == NULL) return 0;
    else return (root->left == NULL && root->right == NULL);
}

void printLeaf(struct Node *root) {
    if(root != NULL) {
        printLeaf(root->left);
        if(isLeafNode(root)) {
            printf("%d ", root->data);
        }
        printLeaf(root->right);
    }
}

void printLeftNodes(struct Node *root) {
    if(root != NULL) {
        printLeftNodes(root->left);
        printf("%d ", root->data);
    }
}

void printRightNodes(struct Node *root) {
    if(root != NULL) {
        printf("%d ", root->data);
        printRightNodes(root->right);
    } 
}

void printEdges(struct Node *root) {
    if(root!=NULL) {
        printLeftNodes(root);
        printRightNodes(root->right);
    }
}

int main() {
	struct Node *root = NULL;
	root = insert(root, 20);
	root = insert(root, 10);
	root = insert(root, 15);
	root = insert(root, 24);
	root = insert(root, 30);
	root = insert(root, 25);
	root = insert(root, 5);
	root = insert(root, 26);
	printf("Inorder: ");
	inOrder(root);
	printf("\n");
	printf("Leaf Nodes: ");
	printLeaf(root);
	printf("\n");
	printf("Edge Nodes: ");
	printEdges(root);
	printf("\n");
	return 0;
}


/*
Expected Output:
---------------
Inorder: 5 10 15 20 24 25 26 30 
Leaf Nodes: 5 15 26 
Edge Nodes: 5 10 20 24 30 
*/
