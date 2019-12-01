//Queues with LinkedList

#include <stdio.h>
#include <stdlib.h>

struct QueueNode {
    int data;
    struct QueueNode *next;
} *head = NULL;


struct QueueNode* createQueueNode(int data) {
        struct QueueNode *newNode = (struct QueueNode*)malloc(sizeof(struct QueueNode));
        newNode->data = data;
        newNode->next = NULL;
        return newNode;
}

void enQueue(int data) {
    //Insertion at beginning
    struct QueueNode *newNode = createQueueNode(data);
    newNode->next = head;
    head = newNode;
}

void deQueue() {
    //Deletion at the end
    if(head == NULL) {
        //Nothing to delete
        printf("Queue is empty\n");
    } else if (head->next == NULL) {
        //Only one element in queue;
        free(head);
        head = NULL;
    } else {
        //More than one element
        struct QueueNode *current = head;
        struct QueueNode *prev = NULL;
        while(current->next != NULL) {
            prev = current;
            current = current->next;
        }
        prev->next = NULL;
        free(current);
    }
}


void peek() {
    if(head == NULL) {
        //Nothing to delete
        printf("Queue is empty\n");
    } else if (head->next == NULL) {
        //Only one element in queue;
        printf("Peek: %d\n", head->data);
    } else {
        //More than one element
        struct QueueNode *current = head;
        struct QueueNode *prev = NULL;
        while(current->next != NULL) {
            prev = current;
            current = current->next;
        }
        printf("Peek: %d\n", current->data);
    }
}

void display() {
    struct QueueNode *current = head;
    if(current == NULL) {
        printf("Queue is empty\n");
    } else {
        printf("Entry -> ");
        while(current!=NULL) {
            printf("%d -> ", current->data);
            current = current->next;
        }
        printf("Exit\n");
    }
}


int main() {
    printf("Queue with LinkedList\n");
	enQueue(10);
	enQueue(20);
	display(); // 20 -> 10
	enQueue(25);
	display(); // 25 -> 20 -> 10
	deQueue();
	display(); // 25 -> 20
	peek(); //20
	deQueue();
	deQueue();
	display(); //Empty
	deQueue(); //Queue empty
    enQueue(20);
	display(); // 20
	return 0;
}



/*
Expected Output:
---------------
Queue with LinkedList
Entry -> 20 -> 10 -> Exit
Entry -> 25 -> 20 -> 10 -> Exit
Entry -> 25 -> 20 -> Exit
Peek: 20
Queue is empty
Queue is empty
Entry -> 20 -> Exit
*/

