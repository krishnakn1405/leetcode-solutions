// Implement a Min Heap

// Design a Min Heap data structure that supports the following operations:

// insert(int val) — Inserts an integer into the heap.
// removeMin() — Removes and returns the smallest element in the heap.

// A Min Heap is a complete binary tree where the value of each parent node is less than or equal to the values of its children.

// Implement the MinHeap class using an array.

// Example 1

// Input:
// MinHeap minHeap = new MinHeap(10);
// minHeap.insert(5);
// minHeap.insert(3);
// minHeap.insert(17);
// minHeap.insert(10);
// minHeap.insert(84);
// minHeap.insert(19);
// minHeap.insert(6);
// minHeap.insert(22);
// minHeap.insert(9);
// minHeap.removeMin();

// Output: 3

class MinHeap {

    private int[] heap;
    private int size;
    private int capacity;

    public MinHeap(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        heap = new int[capacity];
    }

    // Helper methods
    private int parent(int i) {
        return (i-1) / 2;
    }

    private int leftChild(int i) {
        return 2 * i + 1;
    }

    private int rightChild(int i) {
        return 2 * i + 2;
    }

    private boolean isLeaf(int i) {
        return i>=size /2 && i<size;
    }

    // Insert a new element into the heap
    public void insert(int element) {

        if(size == capacity) {
            throw new IllegalStateException("Heap is full");
        }

        heap[size] = element;
        int current = size;
        size++;

        while(heap[current] < heap[parent(current)]) {
            swap(current, parent(current));
            current = parent(current);
        }
    }

    // Remove and return the minimum element from the heap
    public int removeMin() {

        if(size == 0) {
            throw new IllegalStateException("Heap is empty");
        }

        int min = heap[0];
        heap[0] = heap[--size];
        heapify(0);

        return min;
    }

    // Heapify the heap starting from a given index
    private void heapify(int i) {

        if(isLeaf(i)) return;

        int left = leftChild(i);
        int right = rightChild(i);
        int smallest = i;

        if(left < size && heap[left] < heap[i]) {
            smallest = right;
        }

        if(right < size && heap[right] < heap[smallest]) {
            smallest = right;
        }

        if(smallest != i) {
            swap(i, smallest);
            heapify(smallest);
        }
    }

    // Swap two elements in the heap array
    private void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    // Main method for testing
    public static void main(String[] args) {
        
        MinHeap minHeap = new MinHeap(10);
        minHeap.insert(5);
        minHeap.insert(3);
        minHeap.insert(17);
        minHeap.insert(10);
        minHeap.insert(84);
        minHeap.insert(19);
        minHeap.insert(6);
        minHeap.insert(22);
        minHeap.insert(9);
        
        System.out.println("Min value: " + minHeap.removeMin());
    }
}