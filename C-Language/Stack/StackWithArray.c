//Stacks with Array

#include <stdio.h>
#include <stdlib.h>

int *stack;
int maxSize;
int top;

void initStack(int size) {
    stack = (int *)malloc(sizeof(int) * size);
    maxSize = size;
    top = -1;
}

int isStackFull() {
    return top >= maxSize-1 ;
}

int isStackEmpty() {
    return top < 0;    
}

void push(int data) {
    if(isStackFull()) {
        printf("Stack Overflow\n");
    } else {
        stack[++top] = data;
    }
}

void pop() {
    if(isStackEmpty()) {
        printf("Stack Underflow\n");
    } else {
        top--;
    }
}


int peek() {
    if(isStackEmpty()) {
        printf("Stack is empty\n");
        return -1;
    } else {
        printf("Top Value: %d\n", stack[top]);
        return stack[top];
    }
}

void display() {
    if(isStackEmpty()) {
        printf("Stack is empty\n");
    } else {
        int i;
        for(i=0; i<=top; i++) {
            printf("%d -> ", stack[i]);
        }
        printf("\n");
    }
}

int main() {
    printf("Stack with Arrays\n");
	initStack(2);
	push(10);
	push(20);
	display();
	push(30);
	display();
	peek();
	pop();  
	peek();
	display();
	pop(); 
	peek();
	pop();
	display();
	return 0;
}


/*
Expected Output:
---------------
Stack with Arrays
10 -> 20 -> 
Stack Overflow
10 -> 20 -> 
Top Value: 20
Top Value: 10
10 -> 
Stack is empty
Stack Underflow
Stack is empty
*/

