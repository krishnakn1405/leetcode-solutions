// Jump Game II

// You are given a 0-indexed array of integers nums of length n. You are initially positioned at index 0.

// Each element nums[i] represents the maximum length of a forward jump from index i. In other words, if you are at index i, you can jump to any index (i + j) where:

// 0 <= j <= nums[i] and
// i + j < n
// Return the minimum number of jumps to reach index n - 1. The test cases are generated such that you can reach index n - 1.

// Example 1:
// Input: nums = [2,3,1,1,4]
// Output: 2
// Explanation: The minimum number of jumps to reach the last index is 2. Jump 1 step from index 0 to 1, then 3 steps to the last index.

// Example 2:
// Input: nums = [2,3,0,1,4]
// Output: 2

import java.util.Arrays;

class JumpGame2 {
    public int jump(int[] nums) {
        
        int jump=0, currMax=0, currEnd=0;

        for(int i=0; i<nums.length-1; i++) {
            currMax = Math.max(currMax, i+nums[i]);
            if(i == currEnd) {
                jump++;
                currEnd = currMax;
            }
        }

        return jump;
    }

    public static void main(String[] args) {

        int[] nums = {2, 3, 1, 1, 4};

        JumpGame2 obj = new JumpGame2();

        int result = obj.jump(nums);

        System.out.println("Input: " + Arrays.toString(nums));
        System.out.println("Output: " + result);
    }

}


