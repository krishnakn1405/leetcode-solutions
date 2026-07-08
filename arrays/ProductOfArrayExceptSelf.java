// Product of Array Except Self

// Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].

// The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

// You must write an algorithm that runs in O(n) time and without using the division operation.

// Example 1:
// Input: nums = [1,2,3,4]
// Output: [24,12,8,6]

// Example 2:
// Input: nums = [-1,1,0,-3,3]
// Output: [0,0,9,0,0]

import java.util.Arrays;

class ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        
        int[] result = new int[nums.length];

        Arrays.fill(result, 1);

        int pre = 1, post = 1;

        for(int i=0; i<nums.length; i++) {
            result[i] = pre;
            pre = nums[i] * pre;
        }

        for(int i=nums.length-1; i>=0; i--) {
            result[i] = result[i] * post;
            post = post*nums[i];
        }

        return result;
    }


    public static void main(String[] args) {

        ProductOfArrayExceptSelf obj = new ProductOfArrayExceptSelf();

        int[] nums = {1, 2, 3, 4};

        System.out.println("Input: " + Arrays.toString(nums));

        int[] result = obj.productExceptSelf(nums);

        System.out.println("Output: " + Arrays.toString(result));
    }

}


