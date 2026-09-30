// Kth Largest Element in an Array

// Given an integer array nums and an integer k, return the kth largest element in the array.

// Note that it is the kth largest element in the sorted order, not the kth distinct element.

// Can you solve it without sorting?

// Example 1:
// Input: nums = [3,2,1,5,6,4], k = 2
// Output: 5

// Example 2:
// Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
// Output: 4

import java.util.PriorityQueue;

class KthLargestElementInAnArray {
    public int findKthLargest(int[] nums, int k) {
        
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for(int num: nums) {
            minHeap.add(num);
            if(minHeap.size() > k) {
                minHeap.poll(); // Remove the smallest element to maintain the heap size as k
            }
        }

        return minHeap.peek(); // The root of the min-heap is the kth largest element
    }

    public static void main(String[] args) {

        KthLargestElementInAnArray obj = new KthLargestElementInAnArray();

        int[] nums = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        int k = 4;

        int result = obj.findKthLargest(nums, k);

        System.out.println("Input: nums = [3,2,3,1,2,4,5,5,6], k = " + k);
        System.out.println("Output: " + result);
    }
}
