// Implement Stack using Queues

// Implement a last-in-first-out (LIFO) stack using only two queues. The implemented stack should support all the functions of a normal stack (push, top, pop, and empty).

// Implement the MyStack class:
// void push(int x) Pushes element x to the top of the stack.
// int pop() Removes the element on the top of the stack and returns it.
// int top() Returns the element on the top of the stack.
// boolean empty() Returns true if the stack is empty, false otherwise.

// Notes: You must use only standard operations of a queue, which means that only push to back, peek/pop from front, size and is empty operations are valid. Depending on your language, the queue may not be supported natively. You may simulate a queue using a list or deque (double-ended queue) as long as you use only a queue's standard operations.
 
// Example 1:

// Input
// ["MyStack", "push", "push", "top", "pop", "empty"]
// [[], [1], [2], [], [], []]
// Output
// [null, null, null, 2, 2, false]

// Explanation
// MyStack myStack = new MyStack();
// myStack.push(1);
// myStack.push(2);
// myStack.top(); // return 2
// myStack.pop(); // return 2
// myStack.empty(); // return False

import java.util.Queue; 
import java.util.LinkedList; 
import java.util.ArrayList; 
import java.util.List;

class ImplementStackUsingQueues {

    private Queue<Integer> q1;
    private Queue<Integer> q2;

    public ImplementStackUsingQueues() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }
    
    // Push element x onto stack
    public void push(int x) {
        
        // Step 1: Add to q2
        q2.offer(x);

        // Step 2: Move everything from q1 to q2
        while(!q1.isEmpty()) {
            q2.offer(q1.poll());
        }

        // Step 3: Swap q1 and q2
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
    }
    
    // Removes the element on top of the stack and returns it
    public int pop() {
        return q1.poll();
    }
    
    // Get the top element
    public int top() {
        return q1.peek();
    }
    
    public boolean empty() {
        return q1.isEmpty();
    }

public static void main(String[] args) {

    // Input
    String[] operations = {
        "MyStack",
        "push",
        "push",
        "top",
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

    ImplementStackUsingQueues stack = null;

    for (int i = 0; i < operations.length; i++) {

        switch (operations[i]) {

            case "MyStack":
                stack = new ImplementStackUsingQueues();
                output.add(null);
                break;

            case "push":
                stack.push(values[i][0]);
                output.add(null);
                break;

            case "top":
                output.add(stack.top());
                break;

            case "pop":
                output.add(stack.pop());
                break;

            case "empty":
                output.add(stack.empty());
                break;
        }
    }

    // Output
    System.out.println(output);
}
}

