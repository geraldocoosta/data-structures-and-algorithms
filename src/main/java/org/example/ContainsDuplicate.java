package org.example;

import java.util.Arrays;
import java.util.HashMap;

public class ContainsDuplicate {

    public static void main(String[] args) {
        System.out.println(containsDuplicate(new int[]{1, 2, 3, 1}));
        System.out.println(containsDuplicate2(new int[]{1, 2, 3, 1}));
        System.out.println(containsDuplicate3(new int[]{1, 2, 3, 1}));
    }

    // Ruim pelo tempo de execução quadratico
    // O(n²)
    // O(1)
    public static boolean containsDuplicate(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    return true;
                }
            }
        }
        return false;
    }

    // Se puder ordenar
    // O(n log n)
    // O(1)
    public static boolean containsDuplicate2(int[] nums) {

        Arrays.sort(nums);

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                return true;
            }
        }

        return false;
    }

    // Se memoria não for um problema
    // O(n)
    // O(n)
    public static boolean containsDuplicate3(int[] nums) {
        var hm = new HashMap<Integer, Integer>();

        for (int num : nums) {
            hm.put(num, hm.getOrDefault(num, 0) + 1);
            if (hm.get(num) > 1) {
                return true;
            }
        }

        return false;
    }
}

/*
* Contains Duplicate
* Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.



Example 1:

Input: nums = [1,2,3,1]
Output: true
Example 2:

Input: nums = [1,2,3,4]
Output: false
Example 3:

Input: nums = [1,1,1,3,3,4,3,2,4,2]
Output: true


Constraints:

1 <= nums.length <= 105
-109 <= nums[i] <= 109
*
*
* */