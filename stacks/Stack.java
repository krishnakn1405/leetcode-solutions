// Stack implementation

import java.util.ArrayList;

public class Stack {

    private ArrayList<Integer> items;

    public Stack() {
        items = new ArrayList<>();
    }

    public void push(int item) {
        items.add(item);
    }

    public Integer pop() {
        if(!isEmpty()) {
            return items.remove(items.size() - 1);
        }
        return null;
    }

    public Integer peek() {
        if(!isEmpty()) {
            return items.get(items.size() - 1);
        }
        return null;
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

    public static void main(String[] args) {

        Stack stack = new Stack();

        // Pushing elements onto the stack
        stack.push(10);
        stack.push(20);
        stack.push(30);

        // Peeking at the top element
        System.out.println("Top element: " + stack.peek());

        // Popping elements from the stack
        System.out.println("Popped element: " + stack.pop());
        System.out.println("Popped element: " + stack.pop());

        // Checking the top element after popping
        System.out.println("Top element after popping: " + stack.peek());
    }
}