// Reverse Nodes in k-Group

// Given the head of a linked list, reverse the nodes of the list k at a time, and return the modified list.

// k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes, in the end, should remain as it is.

// You may not alter the values in the list's nodes, only nodes themselves may be changed.

// Example 1:
// Input: head = [1,2,3,4,5], k = 2
// Output: [2,1,4,3,5]

// Example 2:
// Input: head = [1,2,3,4,5], k = 3
// Output: [3,2,1,4,5]

import java.util.Arrays;
import java.util.ArrayList;

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}

class ReverseNodesInKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        
        ListNode ptr = head;
        ListNode ktail = null;
        ListNode newHead = null;

        while(ptr != null) {
            int count = 0;
            ptr = head;

            while(count<k && ptr!=null) {
                ptr=ptr.next;
                count++;
            }

            if(count == k) {
                ListNode revHead = reverseLinkedList(head,k);

                if(newHead == null) {
                    newHead = revHead;
                }

                if(ktail != null) {
                    ktail.next = revHead;
                }

                ktail = head;
                head = ptr;
            }
        }
        
        if(ktail != null) {
            ktail.next = head;
        }

        return newHead == null ? head : newHead;
    }

    public ListNode reverseLinkedList(ListNode head, int k) {

        ListNode newHead = null;
        ListNode ptr = head;

        while(k>0) {

            ListNode nextNode = ptr.next;
            ptr.next = newHead;
            newHead = ptr;
            ptr = nextNode;

            k--;
        }

        return newHead;
    }

    // Convert array -> linked list
    public static ListNode arrayToList(int[] arr) {
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

    // Convert linked list -> array
    public static int[] listToArray(ListNode head) {
        ArrayList<Integer> result = new ArrayList<>();

        ListNode current = head;

        while (current != null) {
            result.add(current.val);
            current = current.next;
        }

        int[] arr = new int[result.size()];

        for (int i = 0; i < result.size(); i++) {
            arr[i] = result.get(i);
        }

        return arr;
    }


    public static void main(String[] args) {

        // Input
        int[] input = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;

        // Array -> Linked List
        ListNode head = arrayToList(input);

        // Reverse nodes in K groups
        ReverseNodesInKGroup obj = new ReverseNodesInKGroup();
        ListNode result = obj.reverseKGroup(head, k);

        // Linked List -> Array
        int[] output = listToArray(result);

        // Print output
        System.out.println("Input:  " + Arrays.toString(input));
        System.out.println("K:      " + k);
        System.out.println("Output: " + Arrays.toString(output));
    }
}
