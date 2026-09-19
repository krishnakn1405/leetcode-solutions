// Implement Queue using Stacks

// Implement a first in first out (FIFO) queue using only two stacks. The implemented queue should support all the functions of a normal queue (push, peek, pop, and empty).

// Implement the MyQueue class:

// void push(int x) Pushes element x to the back of the queue.
// int pop() Removes the element from the front of the queue and returns it.
// int peek() Returns the element at the front of the queue.
// boolean empty() Returns true if the queue is empty, false otherwise.

// Notes: You must use only standard operations of a stack, which means only push to top, peek/pop from top, size, and is empty operations are valid. Depending on your language, the stack may not be supported natively. You may simulate a stack using a list or deque (double-ended queue) as long as you use only a stack's standard operations.
 
// Example 1:

// Input
// ["MyQueue", "push", "push", "peek", "pop", "empty"]
// [[], [1], [2], [], [], []]
// Output
// [null, null, null, 1, 1, false]

// Explanation
// MyQueue myQueue = new MyQueue();
// myQueue.push(1); // queue is: [1]
// myQueue.push(2); // queue is: [1, 2] (leftmost is front of the queue)
// myQueue.peek(); // return 1
// myQueue.pop(); // return 1, queue is [2]
// myQueue.empty(); // return false

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.ArrayList;
import java.util.List;

class ImplementQueueUsingStacks {

    private Deque<Integer> inStack;
    private Deque<Integer> outStack;

    public ImplementQueueUsingStacks() {
        inStack = new ArrayDeque<>();
        outStack = new ArrayDeque<>();
    }
    
    // Enqueue (O(1))
    public void push(int x) {
        inStack.push(x);
    }
    
    // Dequeue (Amortized O(1))
    public int pop() {
        moveIfNeeded();
        return outStack.pop();
    }
    
    // Peek front (Amortized O(1))
    public int peek() {
        moveIfNeeded();
        return outStack.peek();
    }
    
    // Check empty
    public boolean empty() {
        return inStack.isEmpty() && outStack.isEmpty();
    }

    // Helper: Move elements only when outStack is empty
    private void moveIfNeeded() {
        if(outStack.isEmpty()) {
            while(!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
        }
    }


    public static void main(String[] args) {

        // Input
        String[] operations = {
            "MyQueue",
            "push",
            "push",
            "peek",
            "pop",
            "empty"
        };

        int[][] values = {
            {},
            {1},
            {2},
            {},
            {},
            {}
        };

        List<Object> output = new ArrayList<>();

        ImplementQueueUsingStacks queue = null;

        for (int i = 0; i < operations.length; i++) {

            switch (operations[i]) {

                case "MyQueue":
                    queue = new ImplementQueueUsingStacks();
                    output.add(null);
                    break;

                case "push":
                    queue.push(values[i][0]);
                    output.add(null);
                    break;

                case "peek":
                    output.add(queue.peek());
                    break;

                case "pop":
                    output.add(queue.pop());
                    break;

                case "empty":
                    output.add(queue.empty());
                    break;
            }
        }

        // Output
        System.out.println(output);
    }
}

