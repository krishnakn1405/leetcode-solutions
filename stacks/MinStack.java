// Min Stack

// Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

// Implement the MinStack class:

// MinStack() initializes the stack object.
// void push(int value) pushes the element value onto the stack.
// void pop() removes the element on the top of the stack.
// int top() gets the top element of the stack.
// int getMin() retrieves the minimum element in the stack.
// You must implement a solution with O(1) time complexity for each function.

// Example 1:

// Input
// ["MinStack","push","push","push","getMin","pop","top","getMin"]
// [[],[-2],[0],[-3],[],[],[],[]]

// Output
// [null,null,null,null,-3,null,0,-2]

// Explanation
// MinStack minStack = new MinStack();
// minStack.push(-2);
// minStack.push(0);
// minStack.push(-3);
// minStack.getMin(); // return -3
// minStack.pop();
// minStack.top();    // return 0
// minStack.getMin(); // return -2

import java.util.List;
import java.util.ArrayList;

class MinStack {

    private Node head;

    public MinStack() {
        
    }
    
    public void push(int val) {
        
        if(head == null) {
            head = new Node(val, val, null);
        } else {
            head = new Node(val, Math.min(val, head.min), head);
        }
    }
    
    public void pop() {
        head = head.next;
    }
    
    public int top() {
        return head.val;
    }
    
    public int getMin() {
        return head.min;
    }

    private class Node {
        int val;
        int min;
        Node next;

        Node(int val, int min, Node next) {
            this.val = val;
            this.min = min;
            this.next = next;
        }
    }

    public static void main(String[] args) {

        String[] operations = {
            "MinStack", "push", "push", "push",
            "getMin", "pop", "top", "getMin"
        };

        int[][] input = {
            {}, {-2}, {0}, {-3},
            {}, {}, {}, {}
        };

        MinStack stack = null;

        // Store output as String because output contains both
        // null and integer values.
        List<String> output = new ArrayList<>();

        for (int i = 0; i < operations.length; i++) {

            switch (operations[i]) {

                case "MinStack":
                    stack = new MinStack();
                    output.add("null");
                    break;

                case "push":
                    stack.push(input[i][0]);
                    output.add("null");
                    break;

                case "pop":
                    stack.pop();
                    output.add("null");
                    break;

                case "top":
                    output.add(String.valueOf(stack.top()));
                    break;

                case "getMin":
                    output.add(String.valueOf(stack.getMin()));
                    break;
            }
        }

        System.out.println(output);
    }

}
