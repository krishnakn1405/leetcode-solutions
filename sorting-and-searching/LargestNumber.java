// Largest Number

// Given a list of non-negative integers nums, arrange them such that they form the largest number and return it.

// Since the result may be very large, so you need to return a string instead of an integer.

// Example 1:
// Input: nums = [10,2]
// Output: "210"

// Example 2:
// Input: nums = [3,30,34,5,9]
// Output: "9534330"

import java.util.Arrays;
import java.util.Comparator;

class LargestNumber {
    public String largestNumber(int[] nums) {
        
        // Convert int array to String array, so we can sort later
        String[] asStrs = new String[nums.length];
        for(int i=0; i<nums.length; i++) {
            asStrs[i] = String.valueOf(nums[i]);
        }

        // Sort strings according to custom comparator
        Arrays.sort(asStrs, new Comparator<String>() {
            public int compare(String a, String b) {
                String order1 = a+b;
                String order2 = b+a;
                return order2.compareTo(order1);
            }
        });

        // If, after being sorted, the largest number is `0`
        if(asStrs[0].equals("0")) {
            return "0";
        }

        // Build largest number from sorted array
        StringBuilder largestNumberStr = new StringBuilder();
        for(String numAsStr: asStrs) {
            largestNumberStr.append(numAsStr);
        }

        return largestNumberStr.toString();

    }

    public static void main(String[] args) {

        int[] nums = {3, 30, 34, 5, 9};

        LargestNumber obj = new LargestNumber();

        String result = obj.largestNumber(nums);

        System.out.println("Input: [3, 30, 34, 5, 9]");
        System.out.println("Output: " + result);
    }
}

