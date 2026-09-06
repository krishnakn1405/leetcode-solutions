// Largest Rectangle in Histogram

// Given an array of integers heights representing the histogram's bar height where the width of each bar is 1, return the area of the largest rectangle in the histogram.

// Example 1:
// Input: heights = [2,1,5,6,2,3]
// Output: 10
// Explanation: The above is a histogram where width of each bar is 1. The largest rectangle is shown in the red area, which has an area = 10 units.

// Example 2:
// Input: heights = [2,4]
// Output: 4

import java.util.Stack;

class LargestRectangleInHistogram {
    public int largestRectangleArea(int[] heights) {
        
        int maxArea = 0;
        Stack<Integer> stack = new Stack<>();
        int n = heights.length;

        for(int i=0; i<=n; i++) {
            int currentHeight = (i == n) ? 0 : heights[i];
            while(!stack.isEmpty() && currentHeight < heights[stack.peek()]) {
                int height = heights[stack.pop()];
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                maxArea = Math.max(maxArea, height * width);
            }
            stack.push(i);
        }

        return maxArea;
    }

    public static void main(String[] args) {

        // Input array
        int[] heights = {2, 1, 5, 6, 2, 3};

        // Create object
        LargestRectangleInHistogram obj =
                new LargestRectangleInHistogram();

        // Call method
        int result = obj.largestRectangleArea(heights);

        // Output
        System.out.println("Largest Rectangle Area: " + result);
    }
}
