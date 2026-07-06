// Two Sum

// Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

// You may assume that each input would have exactly one solution, and you may not use the same element twice.

// You can return the answer in any order.

// Example 1:
// Input: nums = [2,7,11,15], target = 9
// Output: [0,1]
// Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].

// Example 2:
// Input: nums = [3,2,4], target = 6
// Output: [1,2]

// Example 3:
// Input: nums = [3,3], target = 6
// Output: [0,1]

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        
        // Create a HashMap to store numbers and their indices
        Map<Integer, Integer> map = new HashMap<>();

        // Iterate through the array
        for(int i=0; i<nums.length; i++) {

            // Calculate the complement of the current number
            int complement = target - nums[i];
        
            // Check if the complement is already in the map
            if(map.containsKey(complement)) {
                // If found, return the indices of the complement and the current number
                return new int[] { map.get(complement), i };
            }

            // Otherwise, add the current number and its index to the map
            map.put(nums[i], i);
        }

        // Return an empty array if no solution is found(this case won't occur as per problem constraints)
        return new int[] {};
    }

    public static void main(String[] args) {

        TwoSum solution = new TwoSum();

        int[] nums = {3, 3};
        int target = 6;

        int[] result = solution.twoSum(nums, target);

        System.out.println(Arrays.toString(result));
    }
}



