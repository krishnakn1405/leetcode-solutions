// Add Two Numbers

// You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.

// You may assume the two numbers do not contain any leading zero, except the number 0 itself.

// Example 1:
// Input: l1 = [2,4,3], l2 = [5,6,4]
// Output: [7,0,8]
// Explanation: 342 + 465 = 807.

// Example 2:
// Input: l1 = [0], l2 = [0]
// Output: [0]

// Example 3:
// Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
// Output: [8,9,9,9,0,0,0,1]

class AddTwoNumbers {

    // Definition of ListNode
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        ListNode dummy = new ListNode(0);
        ListNode ans = dummy;
        int carry = 0;

        while(l1 != null || l2 != null || carry != 0) {

            int x = (l1 != null) ? l1.val : 0;
            int y = (l2 != null) ? l2.val : 0;
            int sum = carry + x + y;

            carry = sum/10;

            ans.next = new ListNode(sum%10);
            ans = ans.next;

            if(l1 != null) {
                l1 = l1.next;
            }

            if(l2 != null) {
                l2 = l2.next;
            }
        }

        return dummy.next;

    }

    // Convert array to linked list
    public static ListNode createList(int[] arr) {

        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        for (int num : arr) {
            current.next = new ListNode(num);
            current = current.next;
        }

        return dummy.next;
    }

    // Print linked list in array format
    public static void printList(ListNode head) {

        System.out.print("[");

        while (head != null) {
            System.out.print(head.val);

            if (head.next != null) {
                System.out.print(", ");
            }

            head = head.next;
        }

        System.out.println("]");
    }

    public static void main(String[] args) {

        // Input
        int[] arr1 = {9, 9, 9, 9, 9, 9, 9};
        int[] arr2 = {9, 9, 9, 9};

        // Convert arrays to linked lists
        ListNode l1 = createList(arr1);
        ListNode l2 = createList(arr2);

        // Add the numbers
        AddTwoNumbers solution = new AddTwoNumbers();
        ListNode result = solution.addTwoNumbers(l1, l2);

        // Output
        System.out.print("Output: ");
        printList(result);
    }

}
