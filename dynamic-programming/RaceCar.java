// Race Car

// Your car starts at position 0 and speed +1 on an infinite number line. Your car can go into negative positions. Your car drives automatically according to a sequence of instructions 'A' (accelerate) and 'R' (reverse):

// When you get an instruction 'A', your car does the following:
// position += speed
// speed *= 2
// When you get an instruction 'R', your car does the following:
// If your speed is positive then speed = -1
// otherwise speed = 1
// Your position stays the same.
// For example, after commands "AAR", your car goes to positions 0 --> 1 --> 3 --> 3, and your speed goes to 1 --> 2 --> 4 --> -1.

// Given a target position target, return the length of the shortest sequence of instructions to get there.

// Example 1:
// Input: target = 3
// Output: 2
// Explanation: 
// The shortest instruction sequence is "AA".
// Your position goes from 0 --> 1 --> 3.

// Example 2:
// Input: target = 6
// Output: 5
// Explanation: 
// The shortest instruction sequence is "AAARA".
// Your position goes from 0 --> 1 --> 3 --> 7 --> 7 --> 6.

import java.util.Arrays;

class RaceCar {
    public int racecar(int target) {
        
        int[] dp = new int[target+1];
        Arrays.fill(dp,1,dp.length, -1);

        return raceCar(target, dp);
    }

    public int raceCar(int target, int[] dp) {

        if(dp[target] >= 0) {
            return dp[target];
        }

        dp[target] = Integer.MAX_VALUE;

        int x = 1, j = 1;

        for(; j<target; j=(1 << ++x)-1) {
            for(int q=0, p=0; p<j; p=(1 << ++q) - 1) {
                dp[target] = Math.min(dp[target], x+1+1+q+raceCar(target-(j-p), dp));
            }
        }

        dp[target] = Math.min(dp[target], x+(target==j ? 0 : 1 + raceCar(j-target, dp)));

        return dp[target];
    }


    public static void main(String[] args) {

        int target = 6;

        RaceCar obj = new RaceCar();

        int result = obj.racecar(target);

        System.out.println("Input: target = " + target);
        System.out.println("Output: " + result);
    }

}


