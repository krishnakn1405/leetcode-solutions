// Sliding Window Maximum

// You are given an array of integers nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position.

// Return the max sliding window.

// Example 1:
// Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
// Output: [3,3,5,5,6,7]
// Explanation: 
// Window position                Max
// ---------------               -----
// [1  3  -1] -3  5  3  6  7       3
//  1 [3  -1  -3] 5  3  6  7       3
//  1  3 [-1  -3  5] 3  6  7       5
//  1  3  -1 [-3  5  3] 6  7       5
//  1  3  -1  -3 [5  3  6] 7       6
//  1  3  -1  -3  5 [3  6  7]      7

// Example 2:
// Input: nums = [1], k = 1
// Output: [1]

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        
        if(nums == null || nums.length == 0 || k <= 0) {
            return new int[0];
        }

        int n = nums.length;
        int[] result = new int[n-k+1];
        Deque<Integer> deque = new LinkedList<>();

        for(int i=0; i<n; i++) {

            // Remove indices that are out of the current window
            while(!deque.isEmpty() && deque.peek() < i-k+1) {
                deque.poll();
            }

            // Remove indices whose corresponding values are less than nums[i]
            while(!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }

            // Add the current index to the deque
            deque.offer(i);

            // Add the maximum element of the current window to the result
            if(i >= k-1) {
                result[i-k+1] = nums[deque.peek()];
            }
        }

        return result;
    }

    public static void main(String[] args) {

        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;

        SlidingWindowMaximum obj = new SlidingWindowMaximum();

        int[] result = obj.maxSlidingWindow(nums, k);

        System.out.println("Input:");
        System.out.println("nums = " + Arrays.toString(nums));
        System.out.println("k = " + k);

        System.out.println("\nOutput:");
        System.out.println(Arrays.toString(result));
    }
}



