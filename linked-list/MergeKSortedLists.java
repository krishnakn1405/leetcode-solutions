// Merge k Sorted Lists

// You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.

// Merge all the linked-lists into one sorted linked-list and return it.

// Example 1:
// Input: lists = [[1,4,5],[1,3,4],[2,6]]
// Output: [1,1,2,3,4,4,5,6]
// Explanation: The linked-lists are:
// [
//  1->4->5,
//  1->3->4,
//  2->6
// ]
// merging them into one sorted linked list:
// 1->1->2->3->4->4->5->6

// Example 2:
// Input: lists = []
// Output: []

// Example 3:
// Input: lists = [[]]
// Output: []

import java.util.PriorityQueue;

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}

class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(ListNode list: lists) {
            while(list != null) {
                minHeap.add(list.val);
                list = list.next;
            }
        }

        ListNode dummy = new ListNode(1);
        ListNode merge = dummy;

        while(!minHeap.isEmpty()) {
            merge.next = new ListNode(minHeap.remove());
            merge = merge.next;
        }

        return dummy.next;
    }

    // Convert int[] to linked list
    static ListNode createList(int[] arr) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        for (int value : arr) {
            current.next = new ListNode(value);
            current = current.next;
        }

        return dummy.next;
    }

    // Print linked list in array format
    static void printArray(ListNode head) {

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

        // Input:
        // lists = [[1,4,5],[1,3,4],[2,6]]
        int[][] input = {
            {1, 4, 5},
            {1, 3, 4},
            {2, 6}
        };

        // Convert int[][] → ListNode[]
        ListNode[] lists = new ListNode[input.length];

        for (int i = 0; i < input.length; i++) {
            lists[i] = createList(input[i]);
        }

        // Merge
        MergeKSortedLists solution = new MergeKSortedLists();
        ListNode result = solution.mergeKLists(lists);

        // Output
        System.out.print("Output: ");
        printArray(result);
    }
}
