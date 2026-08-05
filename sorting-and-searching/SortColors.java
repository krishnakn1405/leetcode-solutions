// Sort Colors

// Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.

// We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.

// You must solve this problem without using the library's sort function.

// Example 1:
// Input: nums = [2,0,2,1,1,0]
// Output: [0,0,1,1,2,2]

// Example 2:
// Input: nums = [2,0,1]
// Output: [0,1,2]

import java.util.Arrays;

class SortColors {
    public void sortColors(int[] nums) {
        
        int low = 0, high = nums.length-1, current = 0;

        while(current <= high) {
            if(nums[current] == 0) {
                // If the current element is 0 (red), swap it with the element at `low` and move both `current` and `low` one step forward
                swap(nums, current, low);
                low++;
                current++;
            } else if(nums[current] == 2) {
                // If the current is 2 (blue), swap it with the element at `high` and move `high` one step backward
                // Note: We don't move `current` forward in this case because the swapped element from `high` could be 0, and we need to process it in the next iteration
                swap(nums, current, high);
                high--;
            } else {
                // If the current element is 1 (white), just move `current` one step forward
                current++;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        SortColors sc = new SortColors();

        int[] nums = {2, 0, 2, 1, 1, 0};

        System.out.println("Input:  " + Arrays.toString(nums));

        sc.sortColors(nums);

        System.out.println("Output: " + Arrays.toString(nums));
    }
}


