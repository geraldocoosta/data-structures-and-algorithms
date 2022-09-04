package org.example;

import java.util.HashMap;

public class SingleNumber {

    public static void main(String[] args) {
        System.out.println(singleNumber(new int[]{2, 2, 1}));
        System.out.println(singleNumber1(new int[]{2, 2, 1}));
    }

    // O(n)
    // O(n)
    public static int singleNumber(int[] nums) {

        var countNums = new HashMap<Integer, Integer>();

        for (var num : nums) {
            countNums.put(num, countNums.getOrDefault(num, 0) + 1);
        }

        for (var keyValue : countNums.entrySet()) {
            if (keyValue.getValue() == 1) {
                return keyValue.getKey();
            }
        }

        return -1;
    }

    // O(n)
    // O(1)

    public static int singleNumber1(int[] nums) {

        var result = 0;


        for (var num : nums) {
            result = num ^ result;
        }

        return result;
    }
}

/*Single Number
*
* Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.

You must implement a solution with a linear runtime complexity and use only constant extra space.



Example 1:

Input: nums = [2,2,1]
Output: 1
Example 2:

Input: nums = [4,1,2,1,2]
Output: 4
Example 3:

Input: nums = [1]
Output: 1


Constraints:

1 <= nums.length <= 3 * 104
-3 * 104 <= nums[i] <= 3 * 104
Each element in the array appears twice except for one element which appears only once.
*
* */