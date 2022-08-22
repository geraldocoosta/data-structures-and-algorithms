package org.example;

import java.util.Arrays;

public class LongestConsecutiveSequence {


    public static void main(String[] args) {
        System.out.println(longestConsecutive(new int[]{1, 4, 2, 3, 5, 7, 8, 5, 1}));
    }

    public static int longestConsecutive(int[] nums) {

        if (nums == null || nums.length == 0) {
            return 0;
        }


        Arrays.sort(nums);


        int result = 0;
        int consective = 1;

        for (int i = 1; i < nums.length; i++) {

            if (nums[i] == nums[i - 1]) {
                continue;
            }
            if (nums[i] == nums[i - 1] + 1) {
                consective++;
            } else {
                result = Math.max(result, consective);
                consective = 1;
            }
        }

        return Math.max(result, consective);
    }
}
