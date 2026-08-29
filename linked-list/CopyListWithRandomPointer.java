// Copy List with Random Pointer

// A linked list of length n is given such that each node contains an additional random pointer, which could point to any node in the list, or null.

// Construct a deep copy of the list. The deep copy should consist of exactly n brand new nodes, where each new node has its value set to the value of its corresponding original node. Both the next and random pointer of the new nodes should point to new nodes in the copied list such that the pointers in the original list and copied list represent the same list state. None of the pointers in the new list should point to nodes in the original list.

// For example, if there are two nodes X and Y in the original list, where X.random --> Y, then for the corresponding two nodes x and y in the copied list, x.random --> y.

// Return the head of the copied linked list.

// The linked list is represented in the input/output as a list of n nodes. Each node is represented as a pair of [val, random_index] where:

// val: an integer representing Node.val
// random_index: the index of the node (range from 0 to n-1) that the random pointer points to, or null if it does not point to any node.
// Your code will only be given the head of the original linked list.

// Example 1:
// Input: head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
// Output: [[7,null],[13,0],[11,4],[10,2],[1,0]]

// Example 2:
// Input: head = [[1,1],[2,1]]
// Output: [[1,1],[2,1]]

// Example 3:
// Input: head = [[3,null],[3,0],[3,null]]
// Output: [[3,null],[3,0],[3,null]]

import java.util.HashMap;

class Node {
    int val;
    Node next;
    Node random;

    Node(int val, Node next, Node random) {
        this.val = val;
        this.next = next;
        this.random = random;
    }
}

class CopyListWithRandomPointer {
    
    HashMap<Node, Node> visitedNode = new HashMap<Node, Node>();
    
    public Node copyRandomList(Node head) {

        if(head == null) {
            return null;
        }

        if(this.visitedNode.containsKey(head)) {
            return this.visitedNode.get(head);
        }

        Node node = new Node(head.val, null, null);

        this.visitedNode.put(head, node);
        node.next = copyRandomList(head.next);
        node.random = copyRandomList(head.random);

        return node;
    
    }

    // Create linked list from 2D array
    static Node createList(int[][] input) {

        if (input.length == 0) {
            return null;
        }

        // Create all nodes
        Node[] nodes = new Node[input.length];

        for (int i = 0; i < input.length; i++) {
            nodes[i] = new Node(input[i][0], null, null);
        }

        // Set next pointers
        for (int i = 0; i < input.length - 1; i++) {
            nodes[i].next = nodes[i + 1];
        }

        // Set random pointers
        for (int i = 0; i < input.length; i++) {

            int randomIndex = input[i][1];

            if (randomIndex != -1) {
                nodes[i].random = nodes[randomIndex];
            }
        }

        return nodes[0];
    }


    // Print linked list in required array format
    static void printList(Node head) {

        System.out.print("[");

        Node current = head;

        // First print values and random indices
        while (current != null) {

            System.out.print("[" + current.val + ",");

            if (current.random == null) {
                System.out.print("null");
            } else {
                System.out.print(getIndex(head, current.random));
            }

            System.out.print("]");

            if (current.next != null) {
                System.out.print(",");
            }

            current = current.next;
        }

        System.out.println("]");
    }

    // Find index of a node
    static int getIndex(Node head, Node target) {

        int index = 0;
        Node current = head;

        while (current != null) {

            if (current == target) {
                return index;
            }

            current = current.next;
            index++;
        }

        return -1;
    }

    public static void main(String[] args) {

        // Input
        // -1 represents null
        int[][] input = {
            {7, -1},
            {13, 0},
            {11, 4},
            {10, 2},
            {1, 0}
        };

        // Convert array -> linked list
        Node head = createList(input);

        // Copy list
        CopyListWithRandomPointer obj = new CopyListWithRandomPointer();
        Node result = obj.copyRandomList(head);

        // Output
        System.out.print("Input: ");
        printList(head);

        System.out.print("Output: ");
        printList(result);
    }
}
