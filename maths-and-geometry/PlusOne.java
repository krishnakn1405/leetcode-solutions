// Plus One

// You are given a large integer represented as an integer array digits, where each digits[i] is the ith digit of the integer. The digits are ordered from most significant to least significant in left-to-right order. The large integer does not contain any leading 0's.

// Increment the large integer by one and return the resulting array of digits.

// Example 1:
// Input: digits = [1,2,3]
// Output: [1,2,4]
// Explanation: The array represents the integer 123.
// Incrementing by one gives 123 + 1 = 124.
// Thus, the result should be [1,2,4].

// Example 2:
// Input: digits = [4,3,2,1]
// Output: [4,3,2,2]
// Explanation: The array represents the integer 4321.
// Incrementing by one gives 4321 + 1 = 4322.
// Thus, the result should be [4,3,2,2].

// Example 3:
// Input: digits = [9]
// Output: [1,0]
// Explanation: The array represents the integer 9.
// Incrementing by one gives 9 + 1 = 10.
// Thus, the result should be [1,0].

import java.util.Scanner;
import java.util.Arrays;

class PlusOne {
    public int[] plusOne(int[] digits) {
        
        // Start from the last digit and move leftward
        for(int i=digits.length-1; i>=0; i--) {
            if(digits[i] < 9) {
                digits[i]++; // No carry needed, just increment and return
                return digits;
            }
            // If the digit is 9, set it to 0 and continue to the next digit
            digits[i] = 0;
        }

        // If all digits were 9, we need a new array with an extra digit
        int[] newDigits = new int[digits.length + 1];
        newDigits[0] = 1; // The most significant digit is 1, rest are 0 by default
        return newDigits;
    }


    public static void main(String[] args) {

        int[] digits = {9};

        PlusOne obj = new PlusOne();
        int[] result = obj.plusOne(digits);

        System.out.println("Input:  " + Arrays.toString(new int[]{9}));
        System.out.println("Output: " + Arrays.toString(result));
    }
}



