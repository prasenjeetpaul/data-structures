#include <stdio.h>
#include <stdlib.h>

struct TreeNode {
    int treeData;
    struct TreeNode *left, *right;
};

struct QueueNode {
    struct TreeNode *data;
    struct QueueNode *next;
} *head = NULL;

/**
 * Logic of Queue
 */
struct QueueNode* createQueueNode(struct TreeNode *data) {
        struct QueueNode *newNode = (struct QueueNode*)malloc(sizeof(struct QueueNode));
        newNode->data = data;
        newNode->next = NULL;
        return newNode;
}

void enQueue(struct TreeNode *data) {
    //Insertion at beginning
    if(data==NULL) return;
    struct QueueNode *newNode = createQueueNode(data);
    newNode->next = head;
    head = newNode;
}

struct TreeNode* deQueue() {
    //Deletion at the end
    if(head == NULL) {
        //Nothing to delete
        printf("\nQueue is empty\n");
    } else if (head->next == NULL) {
        //Only one element in queue;
        struct TreeNode *temp = head->data;
        head = NULL;
        return temp;
    } else {
        //More than one element
        struct QueueNode *current = head;
        struct QueueNode *prev = NULL;
        while(current->next != NULL) {
            prev = current;
            current = current->next;
        }
        prev->next = NULL;
        return current->data;
    }
}

struct TreeNode* peek() {
    if(head == NULL) {
        return NULL;
    } else if (head->next == NULL) {
        //Only one element in queue;
        return head->data;
    } else {
        //More than one element
        struct QueueNode *current = head;
        struct QueueNode *prev = NULL;
        while(current->next != NULL) {
            prev = current;
            current = current->next;
        }
        return current->data;
    }
}
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

/**
 * Level Order Traversal 
 */
void levelOrder(struct TreeNode *root) {
    head = NULL;
    enQueue(root);
    while(head != NULL) {
        struct TreeNode *current = deQueue();
        printf("%d ", current->treeData);
        enQueue(current->left);
        enQueue(current->right);
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
	printf("Inorder: \t");
	inorder(root);
	printf("\n");
	printf("Level Order: \t");
	levelOrder(root);
	printf("\n");
	return 0;
}

/*
Expected Output:
---------------
Inorder: 	9 10 15 20 25 30 
Level Order: 	20 10 30 9 15 25 
*/

