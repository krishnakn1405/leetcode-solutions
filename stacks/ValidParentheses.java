// Valid Parentheses

// Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

// An input string is valid if:

// Open brackets must be closed by the same type of brackets.
// Open brackets must be closed in the correct order.
// Every close bracket has a corresponding open bracket of the same type.

// Example 1:
// Input: s = "()"
// Output: true

// Example 2:
// Input: s = "()[]{}"
// Output: true

// Example 3:
// Input: s = "(]"
// Output: false

// Example 4:
// Input: s = "([])"
// Output: true

// Example 5:
// Input: s = "([)]"
// Output: false

import java.util.Stack;
import java.util.HashMap;

class ValidParentheses {
    public boolean isValid(String s) {
        
        HashMap<Character, Character> mappedBrackets = new HashMap<>();

        mappedBrackets.put(')','(');
        mappedBrackets.put('}','{');
        mappedBrackets.put(']','[');

        Stack<Character> stack = new Stack<>();

        for(int i=0; i<s.length(); i++) {
            
            char c = s.charAt(i);

            if(!mappedBrackets.containsKey(c)) {
                stack.push(c);
            } else {
                if(stack.empty()) {
                    return false;
                }
                char topElement = stack.pop();
                if(topElement != mappedBrackets.get(c)) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {

        String s = "()[]{}";

        ValidParentheses obj = new ValidParentheses();

        boolean result = obj.isValid(s);

        System.out.println("Input: s = \"" + s + "\"");
        System.out.println("Output: " + result);
    }
}
