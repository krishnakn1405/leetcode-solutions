// Valid Parenthesis String

// Given a string s containing only three types of characters: '(', ')' and '*', return true if s is valid.

// The following rules define a valid string:

// Any left parenthesis '(' must have a corresponding right parenthesis ')'.
// Any right parenthesis ')' must have a corresponding left parenthesis '('.
// Left parenthesis '(' must go before the corresponding right parenthesis ')'.
// '*' could be treated as a single right parenthesis ')' or a single left parenthesis '(' or an empty string "".

// Example 1:
// Input: s = "()"
// Output: true

// Example 2:
// Input: s = "(*)"
// Output: true

// Example 3:
// Input: s = "(*))"
// Output: true

class ValidParenthesisString {
    public boolean checkValidString(String s) {
        
        int minOpen = 0; // Minimum possible open parentheses
        int maxOpen = 0; // Maximum possible open parentheses

        for(char c: s.toCharArray()) {
            if(c == '(') {
                // Treat '(' as an open parenthesis
                minOpen++;
                maxOpen++;
            } else if(c == ')') {
                // Treat ')' as a closing parenthesis
                minOpen--;
                maxOpen--;
            } else {
                // '*' can be treated as '(', ')' or ""
                minOpen--; // Treat '*' as ')'
                maxOpen++; // Treat '*' as '()'
            }

            // If at any point, maxOpen becomes negative, it means there are too many ')'
            if(maxOpen < 0) {
                return false;
            }

            // minOpen should never be negative, as we cannot have unmatched ')' without '('
            minOpen = Math.max(minOpen, 0);
        }

        // If minOpen is 0, it means all '(' can be matched with ')'
        return minOpen == 0;
    }

    public static void main(String[] args) {

        ValidParenthesisString obj = new ValidParenthesisString();

        String s = "(*))";

        boolean result = obj.checkValidString(s);

        System.out.println("Input: " + s);
        System.out.println("Output: " + result);
    }
}


