package org.example;

import java.util.Arrays;

public class ThreeSumClosest {

    public static void main(String[] args) {

        System.out.println(new ThreeSumClosest().threeSumClosest(new int[]{-1,2,1,-4}, 1));
        System.out.println(new ThreeSumClosest().threeSumClosest2(new int[]{-1,2,1,-4}, 1));
    }

    public int threeSumClosest(int[] nums, int target) {
        int diff = Integer.MAX_VALUE;
        int numsLength = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < numsLength && diff != 0; ++i) {
            int lowest = i + 1;
            int highest = numsLength - 1;
            while (lowest < highest) {
                int sum = nums[i] + nums[lowest] + nums[highest];
                if (Math.abs(target - sum) < Math.abs(diff)) {
                    diff = target - sum;
                }
                if (sum < target) {
                    ++lowest;
                } else {
                    --highest;
                }
            }
        }
        return target - diff;
    }

    // O (n²)
    // O (1)
    public int threeSumClosest2(int[] nums, int target) {
        Arrays.sort(nums);
        int ans = nums[0] + nums[1] + nums[2]; // arbitrary ans

        for (int i = 0; i < nums.length; i++) {
            int lowest = i + 1;
            int highest = nums.length - 1;
            while (lowest < highest) {
                int sum = nums[i] + nums[lowest] + nums[highest];
                // if |sum - target| < |ans - target|, update ans
                if (Math.abs(sum - target) < Math.abs(ans - target)) {
                    ans = sum;
                }

                if (sum > target) {
                    highest--; // if sum > target, try smaller sum to approach target
                } else if (sum < target) {
                    lowest++; // if sum < target, try bigger sum to approach target
                } else {
                    return target; // if sum == target, return target
                }
            }
        }
        return ans;
    }
}


/*

 3Sum Closest

Given an integer array nums of length n and an integer target, find three integers in nums such that the sum is closest to target.

Return the sum of the three integers.

You may assume that each input would have exactly one solution.



Example 1:

Input: nums = [-1,2,1,-4], target = 1
Output: 2
Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
Example 2:

Input: nums = [0,0,0], target = 1
Output: 0



*/