// Kth Largest Element in a Stream

// You are part of a university admissions office and need to keep track of the kth highest test score from applicants in real-time. This helps to determine cut-off marks for interviews and admissions dynamically as new applicants submit their scores.

// You are tasked to implement a class which, for a given integer k, maintains a stream of test scores and continuously returns the kth highest test score after a new score has been submitted. More specifically, we are looking for the kth highest score in the sorted list of all scores.

// Implement the KthLargest class:

// KthLargest(int k, int[] nums) Initializes the object with the integer k and the stream of test scores nums.
// int add(int val) Adds a new test score val to the stream and returns the element representing the kth largest element in the pool of test scores so far.

// Example 1:
// Input:
// ["KthLargest", "add", "add", "add", "add", "add"]
// [[3, [4, 5, 8, 2]], [3], [5], [10], [9], [4]]
// Output: [null, 4, 5, 5, 8, 8]
// Explanation:
// KthLargest kthLargest = new KthLargest(3, [4, 5, 8, 2]);
// kthLargest.add(3); // return 4
// kthLargest.add(5); // return 5
// kthLargest.add(10); // return 5
// kthLargest.add(9); // return 8
// kthLargest.add(4); // return 8

// Example 2:
// Input:
// ["KthLargest", "add", "add", "add", "add"]
// [[4, [7, 7, 7, 7, 8, 3]], [2], [10], [9], [9]]
// Output: [null, 7, 7, 7, 8]
// Explanation:
// KthLargest kthLargest = new KthLargest(4, [7, 7, 7, 7, 8, 3]);
// kthLargest.add(2); // return 7
// kthLargest.add(10); // return 7
// kthLargest.add(9); // return 7
// kthLargest.add(9); // return 8

import java.util.PriorityQueue;
import java.util.Arrays;

class KthLargestElementInAStream {

    private PriorityQueue<Integer> minHeap;
    private int k;

    public KthLargestElementInAStream(int k, int[] nums) {
        this.k = k;
        this.minHeap = new PriorityQueue<>(k); // Min-heap with capacity of k

        for(int num: nums) {
            add(num);
        }
    }
    
    public int add(int val) {
        if(minHeap.size() < k) {
            minHeap.offer(val);
        } else if (val > minHeap.peek()) {
            minHeap.poll(); // Remove the smallest element
            minHeap.offer(val); // Add the new value
        }

        return minHeap.peek(); // Return the kth largest element
    }

    public static void main(String[] args) {

        // Input:
        // ["KthLargest", "add", "add", "add", "add", "add"]
        // [[3, [4, 5, 8, 2]], [3], [5], [10], [9], [4]]

        int k = 3;

        int[] nums = {4, 5, 8, 2};

        int[] valuesToAdd = {3, 5, 10, 9, 4};

        KthLargestElementInAStream obj =
                new KthLargestElementInAStream(k, nums);

        int[] output = new int[valuesToAdd.length];

        for (int i = 0; i < valuesToAdd.length; i++) {
            output[i] = obj.add(valuesToAdd[i]);
        }

        System.out.println(Arrays.toString(output));
    }
}
