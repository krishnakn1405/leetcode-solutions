// Counting Bits

// Given an integer n, return an array ans of length n + 1 such that for each i (0 <= i <= n), ans[i] is the number of 1's in the binary representation of i.

// Example 1:
// Input: n = 2
// Output: [0,1,1]
// Explanation:
// 0 --> 0
// 1 --> 1
// 2 --> 10

// Example 2:
// Input: n = 5
// Output: [0,1,1,2,1,2]
// Explanation:
// 0 --> 0
// 1 --> 1
// 2 --> 10
// 3 --> 11
// 4 --> 100
// 5 --> 101

import java.util.Arrays;

class CountingBits {
    public int[] countBits(int n) {
        
        int[] ans = new int[n+1];
        ans[0] = 0;

        for(int i=1; i<=n; i++) {
            ans[i] = ans[i & (i-1)] + 1;
        }

        return ans;
    }

    public static void main(String[] args) {

        int n = 5;

        CountingBits obj = new CountingBits();
        int[] result = obj.countBits(n);

        System.out.println("Input: n = " + n);
        System.out.println("Output: " + Arrays.toString(result));
    }

}



