// Longest Increasing Subsequence

// Given an integer array nums, return the length of the longest strictly increasing subsequence.

// Example 1:
// Input: nums = [10,9,2,5,3,7,101,18]
// Output: 4
// Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.

// Example 2:
// Input: nums = [0,1,0,3,2,3]
// Output: 4

// Example 3:
// Input: nums = [7,7,7,7,7,7,7]
// Output: 1

import java.util.ArrayList;

class LongestIncreasingSubsequence2 {
    public int lengthOfLIS(int[] nums) {
        
        ArrayList<Integer> sub = new ArrayList<>();
        sub.add(nums[0]);

        for(int i=1; i<nums.length; i++) {
            if(nums[i] > sub.get(sub.size()-1)) {
                sub.add(nums[i]);
            } else {
                int j = binarySearch(sub, nums[i]);
                sub.set(j, nums[i]);
            }
        }

        return sub.size();
    }

    private int binarySearch(ArrayList<Integer> sub, int num) {

        int left = 0;
        int right = sub.size() - 1;

        while(left < right) {
            int mid = (left+right)/2;
            if(sub.get(mid) == num) {
                return mid;
            }
            if(sub.get(mid) < num) {
                left = mid+1;
            } else {
                right=mid;
            }
        }

        return left;
    }

    public static void main(String[] args) {

        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};

        LongestIncreasingSubsequence2 obj = new LongestIncreasingSubsequence2();

        int result = obj.lengthOfLIS(nums);

        System.out.println("Length of LIS: " + result);
    }
}

