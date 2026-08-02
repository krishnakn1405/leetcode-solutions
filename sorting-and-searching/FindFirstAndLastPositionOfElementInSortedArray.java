// Find First and Last Position of Element in Sorted Array

// Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.

// If target is not found in the array, return [-1, -1].

// You must write an algorithm with O(log n) runtime complexity.

// Example 1:
// Input: nums = [5,7,7,8,8,10], target = 8
// Output: [3,4]

// Example 2:
// Input: nums = [5,7,7,8,8,10], target = 6
// Output: [-1,-1]

// Example 3:
// Input: nums = [], target = 0
// Output: [-1,-1]

import java.util.Arrays;

class FindFirstAndLastPositionOfElementInSortedArray {

    public int[] searchRange(int[] nums, int target) {
        
        int first = this.findBound(nums, target, true);

        if(first == -1) {
            return new int[]{-1,-1};
        }

        int last = this.findBound(nums, target, false);

        return new int[]{first, last};
        
    }

    public int findBound(int[] nums, int target, boolean isFirst) {

        int start = 0;
        int end = nums.length - 1;

        while(start <= end) {
            
            int mid = (start+end)/2;

            if(nums[mid] == target) {

                if(isFirst) {
                    if(mid == start || nums[mid-1] != target) {
                        return mid;
                    }
                    end = mid-1;
                } else {

                    if(mid == end || nums[mid+1] != target) {
                        return mid;
                    }
                    start = mid+1;
                }

            } else if(nums[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {

        int[] nums = {5, 7, 7, 8, 8, 10};
        int target = 8;

        FindFirstAndLastPositionOfElementInSortedArray obj =
                new FindFirstAndLastPositionOfElementInSortedArray();

        int[] result = obj.searchRange(nums, target);

        System.out.println(Arrays.toString(result));
    }
}
