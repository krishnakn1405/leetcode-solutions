// Coin Change

// You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.

// Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.

// You may assume that you have an infinite number of each kind of coin.

// Example 1:
// Input: coins = [1,2,5], amount = 11
// Output: 3
// Explanation: 11 = 5 + 5 + 1

// Example 2:
// Input: coins = [2], amount = 3
// Output: -1

// Example 3:
// Input: coins = [1], amount = 0
// Output: 0

import java.util.Arrays;

class CoinChange {
    public int coinChange(int[] coins, int amount) {
        
        int[] amt = new int[amount+1];

        Arrays.fill(amt, amount+1);
        amt[0] = 0;

        for(int i=1;i<=amount;i++) {
            for(int j=0; j<coins.length; j++) {
                if(i>= coins[j]) {
                    amt[i] = Math.min(amt[i], 1+amt[i-coins[j]]);
                }
            }
        }

        if(amt[amount] < amount+1) {
            return amt[amount];
        }

        return -1;
    }


    public static void main(String[] args) {
        CoinChange solution = new CoinChange();

        int[] coins = {1, 2, 5};
        int amount = 11;

        int result = solution.coinChange(coins, amount);

        System.out.println("Coins: " + Arrays.toString(coins));
        System.out.println("Amount: " + amount);
        System.out.println("Minimum coins needed: " + result);
    }
}




