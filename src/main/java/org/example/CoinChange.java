package org.example;

public class CoinChange {

    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int amount = 11;
        System.out.println(coinChange(coins, amount));
        System.out.println(coinChange2(coins, amount));
    }

    public static int coinChange(int[] coins, int amount) {
        if (amount < 1) return 0;
        int[] dp = new int[amount + 1];
        int sum = 0;

        while (++sum <= amount) {
            int min = -1;
            for (int coin : coins) {
                if (sum >= coin && dp[sum - coin] != -1) {
                    int temp = dp[sum - coin] + 1;
                    if (min < 0) {
                        min = temp;
                    } else {
                        min = Math.min(temp, min);
                    }
                }
            }
            dp[sum] = min;
        }
        return dp[amount];
    }

    public static int coinChange2(int[] coins, int amount) {
        if (amount < 1) return 0;
        return helper(coins, amount, new int[amount]);
    }

    // rem: remaining coins after the last step;
    // count[rem]: minimum number of coins to sum up to rem
    private static int helper(int[] coins, int remainer, int[] count) {
        if (remainer < 0) { // not valid
            return -1;
        }
        if (remainer == 0) { // completed
            return 0;
        }
        if (count[remainer - 1] != 0) { // already computed, so reuse
            return count[remainer - 1];
        }
        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            int res = helper(coins, remainer - coin, count);
            if (res >= 0 && res < min) {
                min = 1 + res;
            }
        }
        if (min == Integer.MAX_VALUE) {
            count[remainer - 1] = -1;
        } else {
            count[remainer - 1] = min;
        }
        return count[remainer - 1];
    }

}
/*
Coin Change

* You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.

Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.

You may assume that you have an infinite number of each kind of coin.



Example 1:

Input: coins = [1,2,5], amount = 11
Output: 3
Explanation: 11 = 5 + 5 + 1
Example 2:

Input: coins = [2], amount = 3
Output: -1
Example 3:

Input: coins = [1], amount = 0
Output: 0


Constraints:

1 <= coins.length <= 12
1 <= coins[i] <= 231 - 1
0 <= amount <= 104
* */