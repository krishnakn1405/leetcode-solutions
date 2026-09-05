// Longest Valid Parentheses

// Given a string containing just the characters '(' and ')', return the length of the longest valid (well-formed) parentheses substring.

// Example 1:
// Input: s = "(()"
// Output: 2
// Explanation: The longest valid parentheses substring is "()".

// Example 2:
// Input: s = ")()())"
// Output: 4
// Explanation: The longest valid parentheses substring is "()()".

// Example 3:
// Input: s = ""
// Output: 0

import java.util.Stack;

class LongestValidParentheses {
    public int longestValidParentheses(String s) {
        
        int maxLength = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1); // Base for the next valid substring

        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i) == '(') {
                // Push the index of '(' onto the stack
                stack.push(i);
            } else {
                // Pop the top of the stack
                stack.pop();

                if(stack.isEmpty()) {
                    // If stack is empty, push the current index as the base for the next valid substring
                    stack.push(i);
                } else {
                    // Calculate the length of the current valid substring
                    maxLength = Math.max(maxLength, i - stack.peek());
                }
            }
        }

        return maxLength;

    }

    public static void main(String[] args) {

        // Input
        String s = ")()())";

        // Create object
        LongestValidParentheses obj = new LongestValidParentheses();

        // Call method
        int result = obj.longestValidParentheses(s);

        // Output
        System.out.println("Input: s = \"" + s + "\"");
        System.out.println("Output: " + result);
    }
}
