#include <stdio.h>
#include <stdlib.h>

struct Node {
    int data;
    struct Node *left, *right;
};

struct Node* createNewNode(int data) {
    struct Node *newNode = (struct Node*)malloc(sizeof(struct Node));
    newNode->data = data;
    newNode->left = NULL;
    newNode->right = NULL;
    return newNode;
}

struct Node* insert(struct Node* root, int data) {
    if(root == NULL) {
        root = createNewNode(data);   
    } else {
        if(data > root->data) {
            root->right = insert(root->right, data);
        } else if(data < root->data) {
            root->left = insert(root->left, data);
        } else {
            //Duplicate
            printf("Duplicate Insertion Not allowed");
        }
    }
    return root;
}


struct Node* deleteNode(struct Node* root, int data) {
    if(root == NULL) {
        return root;
    } else if(data > root->data) {
        root->right = deleteNode(root->right, data);
    } else if(data < root->data) {
        root->left = deleteNode(root->left, data);
    } else {
        //Value Found
        
        if(root->left == NULL && root->right == NULL) {
            //Leaf Node
            free(root);
            return NULL;
        } else if(root->left == NULL) {
            //Only right node available
            struct Node* temp = root->right;
            free(root);
            return temp;
        } else if(root->right == NULL) {
            //Only left node available
            struct Node* temp = root->left;
            free(root);
            return temp;
        } else {
            //both left & right node available
            
            struct Node *leastNode = root->right;
            while(leastNode != NULL && leastNode->left != NULL) {
                leastNode = leastNode->left;
            }
            //Copying the data;
            root->data = leastNode->data;
            
            //deleting the lestnode
            root->right = deleteNode(root->right, leastNode->data);
            return root;
        }
    }
    
}

void inOrder(struct Node* root) {
    if(root == NULL){
      return;  
    } else {
        inOrder(root->left);
        printf("%d ", root->data);
        inOrder(root->right);
    }
}

void postOrder(struct Node* root) {
    if(root == NULL){
      return;  
    } else {
        postOrder(root->left);
        postOrder(root->right);
        printf("%d ", root->data);
    }
}

void preOrder(struct Node* root) {
    if(root == NULL){
      return;  
    } else {
        printf("%d ", root->data);
        preOrder(root->left);
        preOrder(root->right);
    }
}

int main() {
    struct Node *root = NULL;
    root = insert(root, 20);
    root = insert(root, 30);
    root = insert(root, 10);
    root = insert(root, 15);
    root = insert(root, 9);
    root = insert(root, 40);
    
    printf("InOrder: ");
    inOrder(root);
    printf("\n\nAfter Deleting 10:\n");
    root = deleteNode(root, 10);
    printf("InOrder: ");
    inOrder(root);
    printf("\n");
    printf("\nAfter Deleting 9:\n");
    root = deleteNode(root, 9);
    printf("InOrder: ");
    inOrder(root);
    printf("\n");
    printf("\nAfter Deleting 30:\n");
    root = deleteNode(root, 30);
    printf("InOrder: ");
    inOrder(root);
    printf("\n");
	return 0;
}