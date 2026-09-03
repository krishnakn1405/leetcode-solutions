// Evaluate Reverse Polish Notation

// You are given an array of strings tokens that represents an arithmetic expression in a Reverse Polish Notation.

// Evaluate the expression. Return an integer that represents the value of the expression.

// Note that:
// The valid operators are '+', '-', '*', and '/'.
// Each operand may be an integer or another expression.
// The division between two integers always truncates toward zero.
// There will not be any division by zero.
// The input represents a valid arithmetic expression in a reverse polish notation.
// The answer and all the intermediate calculations can be represented in a 32-bit integer.

// Example 1:
// Input: tokens = ["2","1","+","3","*"]
// Output: 9
// Explanation: ((2 + 1) * 3) = 9

// Example 2:
// Input: tokens = ["4","13","5","/","+"]
// Output: 6
// Explanation: (4 + (13 / 5)) = 6

// Example 3:
// Input: tokens = ["10","6","9","3","+","-11","*","/","*","17","+","5","+"]
// Output: 22
// Explanation: ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
// = ((10 * (6 / (12 * -11))) + 17) + 5
// = ((10 * (6 / -132)) + 17) + 5
// = ((10 * 0) + 17) + 5
// = (0 + 17) + 5
// = 17 + 5
// = 22

import java.util.Stack;

class EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        
        Stack<Integer> stack = new Stack<>();

        for(String token: tokens) {
            if(isOperator(token)) {
                int b = stack.pop(); // Second operand
                int a = stack.pop(); // First operand
                int result = applyOperator(token, a, b);
                stack.push(result);
            } else {
                stack.push(Integer.parseInt(token));
            }
        }

        return stack.pop();
    }

    private boolean isOperator(String token) {
        return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/");
    }

    private int applyOperator(String operator, int a, int b) {
        switch(operator) {
            case "+": return a+b;
            case "-": return a-b;
            case "*": return a*b;
            case "/": return a/b;
            default: throw new IllegalArgumentException("Invalid operator");
        }
    }

    public static void main(String[] args) {

        String[] tokens = {
            "10", "6", "9", "3", "+", "-11", "*", "/",
            "*", "17", "+", "5", "+"
        };

        EvaluateReversePolishNotation obj =
            new EvaluateReversePolishNotation();

        int result = obj.evalRPN(tokens);

        System.out.println("Output: " + result);
    }

}
