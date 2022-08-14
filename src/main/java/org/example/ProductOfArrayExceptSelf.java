package org.example;

import java.util.Arrays;

public class ProductOfArrayExceptSelf {

    public static void main(String[] args) {
        int[] ints = new ProductOfArrayExceptSelf().productExceptSelf(new int[]{1, 2, 3, 4});
        System.out.println(Arrays.toString(ints));
        ints = new ProductOfArrayExceptSelf().productExceptSelf2(new int[]{1, 2, 3, 4});
        System.out.println(Arrays.toString(ints));
    }

    // O(n)
    // O(n)
    public int[] productExceptSelf(int[] nums) {

        int length = nums.length;

        int[] left = new int[length];
        int[] right = new int[length];

        int[] answer = new int[length];

        left[0] = 1;
        for (int i = 1; i < length; i++) {
            left[i] = nums[i - 1] * left[i - 1];
        }

        right[length - 1] = 1;
        for (int i = length - 2; i >= 0; i--) {
            right[i] = nums[i + 1] * right[i + 1];
        }

        for (int i = 0; i < length; i++) {
            answer[i] = left[i] * right[i];
        }

        return answer;
    }

    // O(n)
    // O(1)
    public int[] productExceptSelf2(int[] nums) {

        int length = nums.length;
        int[] answer = new int[length];

        answer[0] = 1;
        for (int i = 1; i < length; i++) {
            answer[i] = nums[i - 1] * answer[i - 1];
        }

        int right = 1;
        for (int i = length - 1; i >= 0; i--) {
            answer[i] = answer[i] * right;
            right = right * nums[i];
        }

        return answer;
    }
}


/*
Product of Array Except Self

 Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].

The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

You must write an algorithm that runs in O(n) time and without using the division operation.



Example 1:

Input: nums = [1,2,3,4]
Output: [24,12,8,6]
Example 2:

Input: nums = [-1,1,0,-3,3]
Output: [0,0,9,0,0]


Constraints:

2 <= nums.length <= 105
-30 <= nums[i] <= 30
The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.


Follow up: Can you solve the problem in O(1) extra space complexity? (The output array does not count as extra space for space complexity analysis.)



 */