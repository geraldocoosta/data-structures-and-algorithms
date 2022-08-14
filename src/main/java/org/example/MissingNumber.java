package org.example;

import java.util.HashSet;
import java.util.Set;

public class MissingNumber {

    public static void main(String[] args) {
        System.out.println(missingNumber(new int[]{1, 2, 3, 4, 5}));
        System.out.println(missingNumber2(new int[]{1, 2, 3, 4, 5}));
    }


    public static int missingNumber(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }

        int expectedNumCount = nums.length + 1;
        for (int number = 0; number < expectedNumCount; number++) {
            if (!numSet.contains(number)) {
                return number;
            }
        }
        return -1;
    }

    public static int missingNumber2(int[] nums) {
        // 1 + 2 + ... + n = n*(n + 1) / 2
        int expectedSum = nums.length * (nums.length + 1) / 2;
        int actualSum = 0;
        for (int num : nums) {
            actualSum += num;
        }
        return expectedSum - actualSum;
    }
}
