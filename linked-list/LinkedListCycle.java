// Linked List Cycle

// Given head, the head of a linked list, determine if the linked list has a cycle in it.

// There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected to. Note that pos is not passed as a parameter.

// Return true if there is a cycle in the linked list. Otherwise, return false.

// Example 1:
// Input: head = [3,2,0,-4], pos = 1
// Output: true
// Explanation: There is a cycle in the linked list, where the tail connects to the 1st node (0-indexed).

// Example 2:
// Input: head = [1,2], pos = 0
// Output: true
// Explanation: There is a cycle in the linked list, where the tail connects to the 0th node.

// Example 3:
// Input: head = [1], pos = -1
// Output: false
// Explanation: There is no cycle in the linked list.

public class LinkedListCycle {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    public boolean hasCycle(ListNode head) {
        
        if(head == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head.next;

        while(slow != null || fast != null) {

            if(fast == null || fast.next == null) {
                return false;
            }

            if(fast == slow) {
                return true;
            }

            slow = slow.next;
            fast = fast.next.next;
        }

        return false;
    }


    // Create linked list from array and connect last node to position 'pos'
    public static ListNode createList(int[] arr, int pos) {

        if (arr.length == 0) {
            return null;
        }

        ListNode head = new ListNode(arr[0]);
        ListNode current = head;

        ListNode cycleNode = null;

        // pos = 0 means cycle starts at head
        if (pos == 0) {
            cycleNode = head;
        }

        for (int i = 1; i < arr.length; i++) {
            current.next = new ListNode(arr[i]);
            current = current.next;

            if (i == pos) {
                cycleNode = current;
            }
        }

        // Connect last node to cycle position
        if (pos >= 0) {
            current.next = cycleNode;
        }

        return head;
    }

    public static void main(String[] args) {

        // Input: head = [3,2,0,-4], pos = 1
        int[] arr = {3, 2, 0, -4};
        int pos = 1;

        ListNode head = createList(arr, pos);

        LinkedListCycle solution = new LinkedListCycle();

        boolean result = solution.hasCycle(head);

        System.out.println("Input: head = [3,2,0,-4], pos = 1");
        System.out.println("Output: " + result);
    }

}

