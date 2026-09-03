// Minimum Remove to Make Valid Parentheses

// Given a string s of '(' , ')' and lowercase English characters.

// Your task is to remove the minimum number of parentheses ( '(' or ')', in any positions ) so that the resulting parentheses string is valid and return any valid string.

// Formally, a parentheses string is valid if and only if:

// It is the empty string, contains only lowercase characters, or
// It can be written as AB (A concatenated with B), where A and B are valid strings, or
// It can be written as (A), where A is a valid string.

// Example 1:
// Input: s = "lee(t(c)o)de)"
// Output: "lee(t(c)o)de"
// Explanation: "lee(t(co)de)" , "lee(t(c)ode)" would also be accepted.

// Example 2:
// Input: s = "a)b(c)d"
// Output: "ab(c)d"

// Example 3:
// Input: s = "))(("
// Output: ""
// Explanation: An empty string is also valid.

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

class MinimumRemoveToMakeValidParentheses {
    public String minRemoveToMakeValid(String s) {
        
        Set<Integer> removeIndices = new HashSet<>();
        Stack<Integer> stack = new Stack<>();

        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if(c == '(') {
                stack.push(i);
            } else if (c == ')') {
                if(stack.isEmpty()) {
                    removeIndices.add(i);
                } else {
                    stack.pop();
                }
            }
        }

        // Add remaining unmatched opening parenthesis indices to the set
        while(!stack.isEmpty()) {
            removeIndices.add(stack.pop());
        }

        // Build the result string
        StringBuilder result = new StringBuilder();
        for(int i=0; i<s.length(); i++) {
            if(!removeIndices.contains(i)) {
                result.append(s.charAt(i));
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {

        // Input
        String s = "lee(t(c)o)de)";

        // Create object
        MinimumRemoveToMakeValidParentheses obj =
                new MinimumRemoveToMakeValidParentheses();

        // Call method
        String result = obj.minRemoveToMakeValid(s);

        // Output
        System.out.println("Input: " + s);
        System.out.println("Output: " + result);
    }

}
