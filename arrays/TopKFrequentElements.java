// Top K Frequent Elements

// Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.

// Example 1:
// Input: nums = [1,1,1,2,2,3], k = 2
// Output: [1,2]

// Example 2:
// Input: nums = [1], k = 1
// Output: [1]

// Example 3:
// Input: nums = [1,2,1,2,1,2,3,1,3,2], k = 2
// Output: [1,2]

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

class TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        
        if(k == nums.length) {
            return nums;
        }

        Map<Integer, Integer> count = new HashMap<>();
        for(int n:nums) {
            count.put(n, count.getOrDefault(n,0) + 1);
        }

        Queue<Integer> heap = new PriorityQueue<>(
            (a,b) -> count.get(a) - count.get(b)
        );

        for(int n:count.keySet()) {
            heap.add(n);
            if(heap.size() > k) {
                heap.poll();
            }
        }

        int[] ans = new int[k];
        for(int i=0; i<k; i++) {
            ans[i] = heap.poll();
        }

        return ans;

    }

    public static void main(String[] args) {

        int[] nums = {1, 2, 1, 2, 1, 2, 3, 1, 3, 2};
        int k = 2;

        TopKFrequentElements obj = new TopKFrequentElements();

        int[] result = obj.topKFrequent(nums, k);

        System.out.println("Input Array : " + Arrays.toString(nums));
        System.out.println("k           : " + k);
        System.out.println("Output Array: " + Arrays.toString(result));
    }
}


