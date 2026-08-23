// Remove Nth Node From End of List

// Given the head of a linked list, remove the nth node from the end of the list and return its head.

// Example 1:
// Input: head = [1,2,3,4,5], n = 2
// Output: [1,2,3,5]

// Example 2:
// Input: head = [1], n = 1
// Output: []

// Example 3:
// Input: head = [1,2], n = 1
// Output: [1]


// ListNode definition
class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

class RemoveNthNodeFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        
        ListNode dummy = new ListNode(1);
        dummy.next = head;

        ListNode front = dummy;
        ListNode back = dummy;

        for(int i=0; i<=n; i++) {
            front = front.next;
        }

        while(front != null) {
            front = front.next;
            back = back.next;
        }

        back.next = back.next.next;

        return dummy.next;
    }

    // Convert array to linked list
    public static ListNode createList(int[] arr) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        for (int value : arr) {
            current.next = new ListNode(value);
            current = current.next;
        }

        return dummy.next;
    }

    // Print linked list as array
    public static void printArray(ListNode head) {
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
        int[] arr = {1, 2, 3, 4, 5};
        int n = 2;

        // Convert array -> linked list
        ListNode head = createList(arr);

        // Remove nth node from end
        RemoveNthNodeFromEndOfList solution =
                new RemoveNthNodeFromEndOfList();

        ListNode result = solution.removeNthFromEnd(head, n);

        // Output as array
        printArray(result);
    }

}
