#include <stdio.h>
#include <stdlib.h>
#include <limits.h>

struct TreeNode {
    int treeData;
    struct TreeNode *left, *right;
};

/**
 * Logic of BST
 */
struct TreeNode* createTreeNode(int data) {
    struct TreeNode *newNode = (struct TreeNode*)malloc(sizeof(struct TreeNode));
    newNode->treeData= data;
    newNode->left = NULL;
    newNode->right = NULL;
}

struct TreeNode* insert(struct TreeNode *root, int data) {
    if(root == NULL) {
        return createTreeNode(data);
    } else {
        if(data < root->treeData) {
            root->left = insert(root->left, data);
        } else if(data > root->treeData) {
            root->right = insert(root->right, data);
        } else {
            printf("\nDuplication not allowed !!\n");
        }
    }
}

void inorder(struct TreeNode* root) {
    if(root != NULL) {
        inorder(root->left);
        printf("%d ", root->treeData);
        inorder(root->right);
    }
}

void minValue(struct TreeNode* root) {
    struct TreeNode *current = root;
    if(current == NULL) {
        printf("\n Empty tree");
    } else {
        while(current && current->left != NULL) {
            current = current->left;
        }
        printf("Min Value: %d\n", current->treeData);
    }
}


void maxValue(struct TreeNode* root) {
    struct TreeNode *current = root;
    if(current == NULL) {
        printf("\n Empty tree");
    } else {
        while(current && current->right != NULL) {
            current = current->right;
        }
        printf("Max Value: %d\n", current->treeData);
    }
}


void nMinHelper(struct TreeNode* root, int *index, int n)
{
	if (root == NULL) return;
    nMinHelper(root->left, index, n);
	// if current element is k'th smallest, return its value
	(*index)++;
	if (*index == n) {
	    printf("%d Smallest: %d\n", n, root->treeData);
	    return;
	}
    nMinHelper(root->right, index, n);
}


// Function to find n'th smallest element in BST
void nMin(struct TreeNode* root, int n)
{
	int index = 0;
	nMinHelper(root, &index, n);
}


void nMaxHelper(struct TreeNode* root, int *index, int n)
{
	if (root == NULL) return;
    nMaxHelper(root->right, index, n);
	// if current element is k'th smallest, return its value
	(*index)++;
	if (*index == n) {
	    printf("%d Max: %d\n", n, root->treeData);
	    return;
	}
    nMaxHelper(root->left, index, n);
}


// Function to find n'th smallest element in BST
void nMax(struct TreeNode* root, int n)
{
	int index = 0;
	nMaxHelper(root, &index, n);
}


int treeHeight(struct TreeNode *root) {
    if(root==NULL) {
        return 0;
    } else {
        int leftHeight = treeHeight(root->left);
        int rightHeight = treeHeight(root->right);
        return leftHeight > rightHeight ? leftHeight+1 : rightHeight+1;
    }
}

int main() {
	struct TreeNode *root = NULL;
	root = insert(root, 20);
	root = insert(root, 10);
	root = insert(root, 9);
	root = insert(root, 15);
	root = insert(root, 30);
	root = insert(root, 25);
	root = insert(root, 22);
	printf("Inorder: ");
	inorder(root);
	printf("\n");
	minValue(root);
	maxValue(root);
	nMin(root, 2);
	nMin(root, 1);
	nMax(root, 2);
	nMax(root, 1);
	
	printf("Height of tree: %d", treeHeight(root));
	return 0;
}

/*
Expected Output:
---------------
Inorder: 9 10 15 20 22 25 30 
Min Value: 9
Max Value: 30
2 Smallest: 10
1 Smallest: 9
2 Max: 25
1 Max: 30
Height of tree: 4
*/


