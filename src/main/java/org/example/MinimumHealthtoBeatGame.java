package org.example;

public class MinimumHealthtoBeatGame {
    public static void main(String[] args) {
        int[] health = {2,7,4,3};
        int armot = 4;
        System.out.println(minimumHealth(health, armot));
    }

    public static long minimumHealth(int[] damage, int armor) {
        int max = 0;
        long health = 1; // Since we need to be grater than 0 to beat the game at all times

        for (int i = 0; i < damage.length; i++) {
            // 1. Add all the damages to the result.
            health += damage[i];
            // 2. Find the maximum number out of damage array.
            max = Math.max(max, damage[i]);
        }

        // 3. To optimally use the armor, we need to use it against the that level that inflicts the most damage.
        health -= Math.min(max, armor);
        return health;
    }
}


/*
Minimum Health to Beat Game

* You are playing a game that has n levels numbered from 0 to n - 1. You are given a 0-indexed integer array damage where damage[i] is the amount of health you will lose to complete the ith level.

You are also given an integer armor. You may use your armor ability at most once during the game on any level which will protect you from at most armor damage.

You must complete the levels in order and your health must be greater than 0 at all times to beat the game.

Return the minimum health you need to start with to beat the game.



Example 1:

Input: damage = [2,7,4,3], armor = 4
Output: 13
Explanation: One optimal way to beat the game starting at 13 health is:
On round 1, take 2 damage. You have 13 - 2 = 11 health.
On round 2, take 7 damage. You have 11 - 7 = 4 health.
On round 3, use your armor to protect you from 4 damage. You have 4 - 0 = 4 health.
On round 4, take 3 damage. You have 4 - 3 = 1 health.
Note that 13 is the minimum health you need to start with to beat the game.
Example 2:

Input: damage = [2,5,3,4], armor = 7
Output: 10
Explanation: One optimal way to beat the game starting at 10 health is:
On round 1, take 2 damage. You have 10 - 2 = 8 health.
On round 2, use your armor to protect you from 5 damage. You have 8 - 0 = 8 health.
On round 3, take 3 damage. You have 8 - 3 = 5 health.
On round 4, take 4 damage. You have 5 - 4 = 1 health.
Note that 10 is the minimum health you need to start with to beat the game.
Example 3:

Input: damage = [3,3,3], armor = 0
Output: 10
Explanation: One optimal way to beat the game starting at 10 health is:
On round 1, take 3 damage. You have 10 - 3 = 7 health.
On round 2, take 3 damage. You have 7 - 3 = 4 health.
On round 3, take 3 damage. You have 4 - 3 = 1 health.
Note that you did not use your armor ability.
* */