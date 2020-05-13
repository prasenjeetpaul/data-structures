package ds.tree;

public class MinHeap {

	private int heap[];
	private int size;
	private int capacity;

	public MinHeap() {
		this.initHeap(20);
	}
	
	public MinHeap(int size) {
		this.initHeap(size);
	}
	
	private void initHeap(int size) {
		this.heap = new int[size];
		this.capacity = size;
		this.size = 0;
	}
	
	private int getParentIndex(int index) {
		if(index == 0) return 0;
		return (index-1)/2;
	}
	
	private int getLeftChild(int index) {
		return (index*2) + 1;
	}
	
	private int getRightChild(int index) {
		return (index*2) + 2;
	}
	
	private void swap(int i, int j) {
		int temp = this.heap[i];
		this.heap[i] = this.heap[j];
		this.heap[j] = temp;
	}
	
	public void insert(int data) {
		if(this.size+1 == this.capacity) {
			System.out.println("Heap is full");
			return;
		};
		this.heap[this.size++] = data;
		this.heapifyUp(this.size-1);
	}
	
	public int deleteMin() {
		if(this.size == 0) {
			System.out.println("Heap is empty");
			return -1;
		}
		
		int data = this.heap[0];
		this.heap[0] = this.heap[--this.size];
		this.heapifyDown(0);
		
		return data;
	}
	
	public int delete(int data) {
		if(this.size == 0) {
			System.out.println("Heap is empty");
			return -1;
		}
		
		int index = -1;
		for(int i=0; i<this.size; i++) {
			if(this.heap[i] == data) {
				index = i;
				break;
			}
		}
		
		if(index == -1) {
			System.out.println("Element not found");
			return -1;
		}
		
		int val = this.heap[index];
		this.heap[index] = this.heap[--this.size];
		
		if(index == 0 || this.heap[getParentIndex(index)] < this.heap[index]) heapifyDown(index);
		else heapifyUp(index);
		
		return val;
	}
	
	private void heapifyUp(int index) {
		if(this.heap[getParentIndex(index)] > this.heap[index]) {
			swap(getParentIndex(index), index);
			heapifyUp(getParentIndex(index));
		}
	}
	
	private void heapifyDown(int index) {
		int leftChild = this.getLeftChild(index);
		int rightChild = this.getRightChild(index);
		
		int minIndex = index;
		
		if(leftChild < size && this.heap[leftChild] < this.heap[index]) {
			minIndex = leftChild;
		}
		
		if(rightChild < size && this.heap[rightChild] < this.heap[minIndex]) {
			minIndex = rightChild;
		}
		
		if(minIndex != index) {
			swap(minIndex, index);
			heapifyDown(minIndex);
		}
		
	}
	
	public void print() {
		for(int i=0; i<this.size; i++) {
			System.out.print(this.heap[i] + " ");
		}
		System.out.println();
	}
}
