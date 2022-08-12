package org.example;

import java.util.Deque;
import java.util.LinkedList;

public class SumOfSubarrayRanges2 {

    // Time O(n)
    // Space O(5*n) -> usamos o stack no maximo uma vez por elemento

    Deque<long[]> stack = new LinkedList<>();


    public static void main(String[] args) {
        System.out.println(new SumOfSubarrayRanges2().subArrayRanges(new int[]{3, 1, 2, 4}));
    }

    public long subArrayRanges(int[] nums) {

        //      [3, 1, 2, 4]
        // ll    1  1  2  4
        // lr    3, 1, 1, 1

        //       3  1  2  4

        // gl    1, 2, 1, 1
        // gr    1, 3, 2, 1

        //       1  6  2  1

        //       2 (-5) 0 3
        //       6  -5  0 12 = 13


        long[] lesserLeft = getLesserLeft(nums);
        long[] lesserRight = getLesserRight(nums);
        long[] greaterLeft = getGreaterLeft(nums);
        long[] greaterRight = getGreaterRight(nums);

        long ans = 0;

        for (int i = 0; i < nums.length; i++) {
            var greaterLeftNum = greaterLeft[i] * greaterRight[i];
            var lesserLeftNum = lesserLeft[i] * lesserRight[i];
            ans += (lesserLeftNum - greaterLeftNum) * nums[i];
        }
        return ans;
    }


    private long[] getGreaterRight(int[] nums) {
        stack.clear();
        var values = new long[nums.length];
        for (int i = nums.length - 1; i >= 0; i--) {

            while ( !stack.isEmpty() && stack.peek()[0] > nums[i]) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                values[i] = nums.length - i;
            } else {
                values[i] = stack.peek()[1] - i;
            }

            stack.push(new long[]{nums[i], i});
        }
        return values;
    }

    private long[] getGreaterLeft(int[] nums) {
        stack.clear();
        var values = new long[nums.length];
        for (int i = 0; i < nums.length ; i++) {

            while ( !stack.isEmpty() && stack.peek()[0] >= nums[i]) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                values[i] = i + 1;
            } else {
                values[i] = i - stack.peek()[1] ;
            }

            stack.push(new long[]{nums[i], i});
        }
        return values;
    }

    private long[] getLesserRight(int[] nums) {
        stack.clear();
        var values = new long[nums.length];
        for (int i = nums.length - 1; i >= 0; i--) {

            while ( !stack.isEmpty() && stack.peek()[0] < nums[i]) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                values[i] = nums.length - i;
            } else {
                values[i] = stack.peek()[1] - i;
            }

            stack.push(new long[]{nums[i], i});
        }
        return values;
    }

    private long[] getLesserLeft(int[] nums) {
        stack.clear();
        var values = new long[nums.length];
        for (int i = 0; i < nums.length; i++) {

            while ( !stack.isEmpty() && stack.peek()[0] <= nums[i]) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                values[i] = i + 1;
            } else {
                values[i] = i - stack.peek()[1];
            }

            stack.push(new long[]{nums[i], i});
        }
        return values;
    }
}


// [3]                  3 - 3	= 0
// [3,1]				3 - 1	= 2
// [3,1,2]				3 - 1	= 2
// [3,1,2,4]			4 - 1	= 3
//   [1]				1 - 1	= 0
//   [1,2]				2 - 1	= 1
//   [1,2,4]			4 - 1	= 3
//	   [2]				2 - 2	= 0
//	   [2,4]			4 - 2	= 2
//	     [4]			4 - 4	= 0
/*
*
* Sum of Subarray Ranges
*
*You are given an integer array nums. The range of a subarray of nums is the difference between the largest and smallest element in the subarray.

Return the sum of all subarray ranges of nums.

A subarray is a contiguous non-empty sequence of elements within an array.



Example 1:

Input: nums = [1,2,3]
Output: 4
Explanation: The 6 subarrays of nums are the following:
[1], range = largest - smallest = 1 - 1 = 0
[2], range = 2 - 2 = 0
[3], range = 3 - 3 = 0
[1,2], range = 2 - 1 = 1
[2,3], range = 3 - 2 = 1
[1,2,3], range = 3 - 1 = 2
So the sum of all ranges is 0 + 0 + 0 + 1 + 1 + 2 = 4.
Example 2:

Input: nums = [1,3,3]
Output: 4
Explanation: The 6 subarrays of nums are the following:
[1], range = largest - smallest = 1 - 1 = 0
[3], range = 3 - 3 = 0
[3], range = 3 - 3 = 0
[1,3], range = 3 - 1 = 2
[3,3], range = 3 - 3 = 0
[1,3,3], range = 3 - 1 = 2
So the sum of all ranges is 0 + 0 + 0 + 2 + 0 + 2 = 4.
Example 3:

Input: nums = [4,-2,-3,4,1]
Output: 59
Explanation: The sum of all subarray ranges of nums is 59.
* */