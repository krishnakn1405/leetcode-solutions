// Sort List

// Given the head of a linked list, return the list after sorting it in ascending order.

// Example 1:
// Input: head = [4,2,1,3]
// Output: [1,2,3,4]

// Example 2:
// Input: head = [-1,5,3,4,0]
// Output: [-1,0,3,4,5]

// Example 3:
// Input: head = []
// Output: []

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

class ListNode {
    int val;
    ListNode next;

    ListNode() {}

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class SortList {
    public ListNode sortList(ListNode head) {
        
        if(head == null || head.next == null) {
            return head;
        }

        // Split the list into two halves
        ListNode mid = getMid(head);
        ListNode left = sortList(head); // sort the first half
        ListNode right = sortList(mid); // sort the second half

        // Merge the sorted halves
        return merge(left, right);
    }

    // Function to find the middle of the list
    private ListNode getMid(ListNode head) {
        ListNode prev = null;
        while(head != null && head.next != null) {
            prev = (prev == null) ? head : prev.next;
            head = head.next.next;
        }
        ListNode mid = prev.next;
        prev.next = null; // Split the list into two halves
        return mid;
    }

    // Function to merge two sorted lists
    private ListNode merge(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        while(list1 != null && list2 != null) {
            if(list1.val < list2.val) {
                tail.next = list1;
                list1 = list1.next;
            } else {
                tail.next = list2;
                list2 = list2.next;
            }
            tail = tail.next;
        }

        // Append the remaining nodes of list1 or list2
        tail.next = (list1 != null) ? list1 : list2;

        return dummy.next;
    }

    // Convert array to linked list
    private static ListNode arrayToList(int[] arr) {

        if(arr.length == 0) {
            return null;
        }

        ListNode head = new ListNode(arr[0]);
        ListNode current = head;

        for(int i = 1; i < arr.length; i++) {
            current.next = new ListNode(arr[i]);
            current = current.next;
        }

        return head;
    }

    // Convert linked list to array
    private static int[] listToArray(ListNode head) {

        List<Integer> result = new ArrayList<>();

        while(head != null) {
            result.add(head.val);
            head = head.next;
        }

        int[] arr = new int[result.size()];

        for(int i = 0; i < result.size(); i++) {
            arr[i] = result.get(i);
        }

        return arr;
    }

    public static void main(String[] args) {

        // Input
        int[] input = {-1, 5, 3, 4, 0};

        // Convert array -> linked list
        ListNode head = arrayToList(input);

        // Sort linked list
        SortList solution = new SortList();
        ListNode sortedHead = solution.sortList(head);

        // Convert linked list -> array
        int[] output = listToArray(sortedHead);

        // Print output
        System.out.println("Input  : " + Arrays.toString(input));
        System.out.println("Output : " + Arrays.toString(output));
    }
}


