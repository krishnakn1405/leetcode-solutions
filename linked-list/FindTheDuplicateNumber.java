// Find the Duplicate Number

// Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.

// There is only one repeated number in nums, return this repeated number.

// You must solve the problem without modifying the array nums and using only constant extra space.

// Example 1:
// Input: nums = [1,3,4,2,2]
// Output: 2

// Example 2:
// Input: nums = [3,1,3,4,2]
// Output: 3

// Example 3:
// Input: nums = [3,3,3,3,3]
// Output: 3

import java.util.Arrays;

class FindTheDuplicateNumber {
    public int findDuplicate(int[] nums) {
        
        // Initialize the slow and fast pointers
        int slow = nums[0];
        int fast = nums[nums[0]];

        // Find the intersection point of the two runners
        while(slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }

        // Find the "entrance" to the cycle
        slow = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow;
    }

    public static void main(String[] args) {

        // Input array
        int[] nums = {1, 3, 4, 2, 2};

        // Create object
        FindTheDuplicateNumber obj = new FindTheDuplicateNumber();

        // Find duplicate
        int result = obj.findDuplicate(nums);

        // Output
        System.out.println("Input: " + Arrays.toString(nums));
        System.out.println("Duplicate: " + result);
    }
}
