package org.example;

public class MaximumLengthOfSubarrayWithPositiveProduct {

    public static void main(String[] args) {
        System.out.println(new MaximumLengthOfSubarrayWithPositiveProduct().getMaxLen(new int[]{1, -2, -3, 4}));
    }

    // Time O(n)
    // Space O(1)

    public int getMaxLen(int[] nums) {
        // sum is used to count the number of negative numbers from zeroPosition to current index
        int firstNegative = -1;
        int zeroPosition = -1;
        int cntNegative = 0;
        int max = 0;


        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                cntNegative++;
                // we only need to know index of first negative number
                if (firstNegative == -1) {
                    firstNegative = i;
                }
            }
            // if current number is 0, we can't use any element from index 0 to i anymore, so update zeroPosition,
            // and reset sum and firstNegative. If it is a game, we should refresh the game when we meet 0.
            if (nums[i] == 0) {
                cntNegative = 0;
                firstNegative = -1;
                zeroPosition = i;
            } else {
                // consider index of zero
                if (cntNegative % 2 == 0) {
                    max = Math.max(i - zeroPosition, max);
                } else { // consider index of first negative number
                    max = Math.max(i - firstNegative, max);
                }
            }
        }
        return max;
    }
}

/*
Maximum Length of Subarray With Positive Product

Given an array of integers nums, find the maximum length of a subarray where the product of all its elements is positive.

A subarray of an array is a consecutive sequence of zero or more values taken out of that array.

Return the maximum length of a subarray with positive product.



Example 1:

Input: nums = [1,-2,-3,4]
Output: 4
Explanation: The array nums already has a positive product of 24.
Example 2:

Input: nums = [0,1,-2,-3,-4]
Output: 3
Explanation: The longest subarray with positive product is [1,-2,-3] which has a product of 6.
Notice that we cannot include 0 in the subarray since that'll make the product 0 which is not positive.
Example 3:

Input: nums = [-1,-2,-3,0,1]
Output: 2
Explanation: The longest subarray with positive product is [-1,-2] or [-2,-3].


Constraints:

1 <= nums.length <= 105
-109 <= nums[i] <= 109
 */