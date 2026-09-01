// Max Stack

// Design a max stack data structure that supports the stack operations and supports finding the stack's maximum element.

// Implement the MaxStack class:

// MaxStack() Initializes the stack object.
// void push(int x) Pushes element x onto the stack.
// int pop() Removes the element on top of the stack and returns it.
// int top() Gets the element on the top of the stack without removing it.
// int peekMax() Retrieves the maximum element in the stack without removing it.
// int popMax() Retrieves the maximum element in the stack and removes it. If there is more than one maximum element, only remove the top-most one.

// Example 1
// Input
// ["MaxStack", "push", "push", "push", "top", "popMax", "top", "peekMax", "pop", "top"]
// [[], [5], [1], [5], [], [], [], [], [], []]

// Output
// [null, null, null, null, 5, 5, 1, 5, 1, 5]

import java.util.Stack;
import java.util.ArrayList;
import java.util.List;

class MaxStack {

    private Stack<Integer> stack;
    private Stack<Integer> maxStack;

    public MaxStack() {
        stack = new Stack<>();
        maxStack = new Stack<>();
    }

    public void push(int x) {
        int max = maxStack.isEmpty() ? x : Math.max(maxStack.peek(), x);
        stack.push(x);
        maxStack.push(max);
    }

    public int pop() {
        maxStack.pop();
        return stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int peekMax() {
        return maxStack.peek();
    }

    public int popMax() {
        int max = peekMax();
        Stack<Integer> buffer = new Stack<>();
        while(top() != max) {
            buffer.push(pop());
        }
        pop(); // Remove the max element
        while(!buffer.isEmpty()) {
            push(buffer.pop());
        }

        return max;
    }


    public static void main(String[] args) {

        // Input
        String[] operations = {
            "MaxStack", "push", "push", "push",
            "top", "popMax", "top", "peekMax", "pop", "top"
        };

        int[][] input = {
            {}, {5}, {1}, {5},
            {}, {}, {}, {}, {}, {}
        };

        MaxStack maxStack = null;

        // Output
        List<String> output = new ArrayList<>();

        for (int i = 0; i < operations.length; i++) {

            switch (operations[i]) {

                case "MaxStack":
                    maxStack = new MaxStack();
                    output.add("null");
                    break;

                case "push":
                    maxStack.push(input[i][0]);
                    output.add("null");
                    break;

                case "pop":
                    output.add(String.valueOf(maxStack.pop()));
                    break;

                case "top":
                    output.add(String.valueOf(maxStack.top()));
                    break;

                case "peekMax":
                    output.add(String.valueOf(maxStack.peekMax()));
                    break;

                case "popMax":
                    output.add(String.valueOf(maxStack.popMax()));
                    break;
            }
        }

        System.out.println(output);
    }
}
