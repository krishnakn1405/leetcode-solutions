
// Trapping Rain Water

// Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.

// Example 1:
// Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
// Output: 6
// Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.

// Example 2:
// Input: height = [4,2,0,3,2,5]
// Output: 9

import java.util.Arrays;

class TrappingRainWater {
    public int trap(int[] height) {
        
        int left = 0;
        int right = height.length - 1;

        int total = 0;
        int leftMax = height[0];
        int rightMax = height[right];

        while(left<right) {
            if(height[left] < height[right]) {
                leftMax = Math.max(leftMax, height[left]);
                if(leftMax - height[left] > 0) {
                    total = total + leftMax - height[left];
                }
                left++;
            } else {
                rightMax = Math.max(rightMax, height[right]);
                if(rightMax - height[right] > 0) {
                    total = total + rightMax - height[right];
                }
                right--;
            }
        }
        
        return total;
    }

    public static void main(String[] args) {

        int[] height = {4, 2, 0, 3, 2, 5};

        TrappingRainWater obj = new TrappingRainWater();

        System.out.println("Input: height = " + Arrays.toString(height));

        int result = obj.trap(height);

        System.out.println("Output: " + result);
    }
}



