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

/**
 * Sum of leaf nodes of a binary tree
 * without using global variable or any pointers
 */
int sumOfLeafNodes(struct Node *root, int sum) {
    if(root == NULL) return 0;
    sum = sumOfLeafNodes(root->left, sum);
    if(root->left == NULL && root->right==NULL) {
        sum = sum+root->data;
    }
    sum += sumOfLeafNodes(root->right, sum);
    return sum;
}

/**
 * Print the sum of leaf nodes of a tree
 */
void printSumOfLeafNodes(struct Node *root) {
    int sum = sumOfLeafNodes(root, 0);
    printf("Sum of leaf nodes: %d", sum);
    
}

/**
 * Returns the sum of the tree provided by root pointer
 */
int sumOfTree(struct Node *root) {
    if(root==NULL) return 0;
    int sum = sumOfTree(root->left) + root->data + sumOfTree(root->right);
    return sum;
}

/**
 * Checks whether a tree is a sum tree or not
 */
int isSumTree(struct Node *root) {
    if(root==NULL) {
        return 1;
    }
    int isLeftSum = isSumTree(root->left);
    int isRightSum = isSumTree(root->right);
     
    int leftSum = sumOfTree(root->left);
    int rightSum = sumOfTree(root->right);
 
    if(isLeftSum && isRightSum) {
        if(root->left == NULL && root->right == NULL) {
            return 1;
        } else if(leftSum+rightSum == root->data) {
            return 1;
        }
    } 
    return 0;
}

int main() {
    struct Node *root = NULL;
    root = createNewNode(22);
    root->left = createNewNode(10);
    root->right = createNewNode(2);
    root->left->left = createNewNode(5);
    root->left->right = createNewNode(5);
    printSumOfLeafNodes(root);
    printf("\n");
    if(isSumTree(root)) {
        printf("Sum tree");
    } else {
        printf("Not Sum tree");
    }
	return 0;
}


/*
Expected Output:
---------------
Sum of leaf nodes: 12
Sum tree
*/
