//Stacks with LinkedList

#include <stdio.h>
#include <stdlib.h>

struct StackNode {
    int data;
    struct StackNode *next;
} *head;

int maxSize;
int currentSize;

void initStack(int size) {
    maxSize = size;
    currentSize = 0;
    head = NULL;
}

struct StackNode* createStackNode(int data) {
        struct StackNode *newNode = (struct StackNode*)malloc(sizeof(struct StackNode));
        newNode->data = data;
        newNode->next = NULL;
        return newNode;
}

int isStackFull() {
    return currentSize >= maxSize;
}

int isStackEmpty() {
    return currentSize <= 0;    
}

void push(int data) {
    if(isStackFull()) {
        printf("Stack Overflow\n");
    } else {
        struct StackNode *newNode = createStackNode(data);
        newNode->next = head;
        head = newNode;
        currentSize++;
    }
}

void pop() {
    if(isStackEmpty()) {
        printf("Stack Underflow\n");
    } else {
        struct StackNode *tempNode = head;
        head = head->next;
        free(tempNode);
        currentSize--;
    }
}


int peek() {
    if(isStackEmpty()) {
        printf("Stack is empty\n");
        return -1;
    } else {
        printf("Top Value: %d\n", head->data);
        return head->data;
    }
}

void display() {
    struct StackNode *current = head;
    if(current == NULL) {
        printf("Stack is empty\n");
    } else {
        while(current!=NULL) {
            printf("%d -> ", current->data);
            current = current->next;
        }
        printf("\n");
    }
}

int main() {
    printf("Stack with LinkedList\n");
	initStack(2);
	push(10);
	push(20);
	display(); // 20 -> 10
	push(30); // Overflow
	display(); // 20 -> 10
	peek();
	pop(); 
	peek();
	display(); // 10
	pop(); 
	peek(); //Empty
	pop(); //Underflow
	display(); // Empty
	return 0;
}


/*
Expected Output:
---------------
Stack with LinkedList
20 -> 10 -> 
Stack Overflow
20 -> 10 -> 
Top Value: 20
Top Value: 10
10 -> 
Stack is empty
Stack Underflow
Stack is empty
*/

