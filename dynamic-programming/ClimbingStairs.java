// Climbing Stairs

// You are climbing a staircase. It takes n steps to reach the top.

// Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

// Example 1:
// Input: n = 2
// Output: 2
// Explanation: There are two ways to climb to the top.
// 1. 1 step + 1 step
// 2. 2 steps

// Example 2:
// Input: n = 3
// Output: 3
// Explanation: There are three ways to climb to the top.
// 1. 1 step + 1 step + 1 step
// 2. 1 step + 2 steps
// 3. 2 steps + 1 step


class ClimbingStairs {
    public int climbStairs(int n) {
        
        // Base cases
        if(n == 0) return 1;
        if(n == 1) return 1;

        // Initialize the two variables to represent the number of ways to reach step 0 and step 1
        int prev2 = 1;
        int prev1 = 1;

        // Iterate from step 2 to n
        for(int i=2; i<=n; i++) {
            int current = prev1 + prev2; // Number of ways to reach current step
            prev2 = prev1; // Update prev2 to the previous step
            prev1 = current; // Update prev1 to the current step
        }

        // The answer is the number of ways to reach the n-th step
        return prev1;
    }

    public static void main(String[] args) {
        ClimbingStairs cs = new ClimbingStairs();

        int n = 3; // given input
        int result = cs.climbStairs(n);

        System.out.println("Input: n = " + n);
        System.out.println("Output: " + result);
    }
}


