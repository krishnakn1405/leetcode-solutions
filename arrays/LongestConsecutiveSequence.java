// Longest Consecutive Sequence

// Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.

// You must write an algorithm that runs in O(n) time.

// Example 1:
// Input: nums = [100,4,200,1,3,2]
// Output: 4
// Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.

// Example 2:
// Input: nums = [0,3,7,2,5,8,4,6,0,1]
// Output: 9

// Example 3:
// Input: nums = [1,0,1,2]
// Output: 3

import java.util.HashSet;

class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        
        if(nums.length == 0) {
            return 0;
        }

        HashSet<Integer> numSet = new HashSet<>();
        for(int i=0; i<nums.length; i++) {
            numSet.add(nums[i]);
        }

        int longestSub = 1;

        for(int num:numSet) {

            if(numSet.contains(num-1)) {
                continue;
            } else {
                int currentNum = num;
                int currentSub = 1;
                while(numSet.contains(currentNum+1)) {
                    currentNum++;
                    currentSub++;
                }

                longestSub = Math.max(longestSub, currentSub);
            }
        }

        return longestSub;

    }

    public static void main(String[] args) {
        LongestConsecutiveSequence obj = new LongestConsecutiveSequence();

        int[] nums = {0, 3, 7, 2, 5, 8, 4, 6, 0, 1};

        int result = obj.longestConsecutive(nums);

        System.out.println("Input: nums = [0,3,7,2,5,8,4,6,0,1]");
        System.out.println("Output: " + result);
    }

}
