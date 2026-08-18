// Middle of the Linked List

// Given the head of a singly linked list, return the middle node of the linked list.

// If there are two middle nodes, return the second middle node.

// Example 1:
// Input: head = [1,2,3,4,5]
// Output: [3,4,5]
// Explanation: The middle node of the list is node 3.

// Example 2:
// Input: head = [1,2,3,4,5,6]
// Output: [4,5,6]
// Explanation: Since the list has two middle nodes with values 3 and 4, we return the second one.

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}

class MiddleOfTheLinkedList {
    public ListNode middleNode(ListNode head) {
        
        ListNode slow = head, fast = head;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    // Convert array to linked list
    public static ListNode createLinkedList(int[] arr) {

        if (arr.length == 0) {
            return null;
        }

        ListNode head = new ListNode(arr[0]);
        ListNode current = head;

        for (int i = 1; i < arr.length; i++) {
            current.next = new ListNode(arr[i]);
            current = current.next;
        }

        return head;
    }

    // Convert linked list to array format
    public static void printLinkedList(ListNode head) {

        System.out.print("[");

        while (head != null) {
            System.out.print(head.val);

            if (head.next != null) {
                System.out.print(",");
            }

            head = head.next;
        }

        System.out.println("]");
    }

    public static void main(String[] args) {

        // Input
        int[] arr = {1, 2, 3, 4, 5, 6};

        // Convert array -> linked list
        ListNode head = createLinkedList(arr);

        // Find middle
        MiddleOfTheLinkedList obj = new MiddleOfTheLinkedList();
        ListNode middle = obj.middleNode(head);

        // Output
        System.out.print("Output: ");
        printLinkedList(middle);
    }
}


