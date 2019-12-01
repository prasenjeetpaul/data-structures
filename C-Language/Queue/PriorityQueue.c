//Priority Queues with LinkedList

#include <stdio.h>
#include <stdlib.h>

struct QueueNode {
    int data;
    int priority; //Higher the value, higher the priority
    struct QueueNode *next;
} *head = NULL;


struct QueueNode* createQueueNode(int data, int priority) {
    struct QueueNode *newNode = (struct QueueNode*)malloc(sizeof(struct QueueNode));
    newNode->data = data;
    newNode->priority = priority;
    newNode->next = NULL;
    return newNode;
}

void enQueue(int data, int priority) {
    //Insertion at beginning
    struct QueueNode *newNode = createQueueNode(data, priority);
    
    if(head == NULL) {
        //Queue is empty
        head = newNode;
    } else if(head->next == NULL) {
        //Queue contains only one element
        if(newNode->priority <= head->priority) {
            newNode->next = head;
            head = newNode;
        } else {
            head->next = newNode;
        }
    } else {
        //More than one element
        struct QueueNode *current = head;
        struct QueueNode *prev = NULL;
        while(current != NULL && current->priority < newNode->priority) {
            prev = current;
            current = current->next;
        }
        if(prev == NULL) {
            newNode->next = head;
            head = newNode;
        } else {
            prev->next = newNode;
            newNode->next =current;
        }
        
    }
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
    printf("Priority Queue with LinkedList\n");
	enQueue(10,1);
	enQueue(20,1);
	enQueue(25,1);
	display(); 
	enQueue(5, 10);
	display(); 
	enQueue(36, 5);
	display(); 
	enQueue(37, 5);
	display(); 
	deQueue();
	display();
	peek();
	
	return 0;
}


/*
Expected Output:
---------------
Priority Queue with LinkedList
Entry -> 25 -> 20 -> 10 -> Exit
Entry -> 25 -> 20 -> 10 -> 5 -> Exit
Entry -> 25 -> 20 -> 10 -> 36 -> 5 -> Exit
Entry -> 25 -> 20 -> 10 -> 37 -> 36 -> 5 -> Exit
Entry -> 25 -> 20 -> 10 -> 37 -> 36 -> Exit
Peek: 36
*/

