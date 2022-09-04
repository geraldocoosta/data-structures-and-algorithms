package org.example;

public class RotateArray {

    public static void main(String[] args) {
        var nums = new int[]{1, 2, 3, 4, 5, 6, 7};
        rotate(nums, 3);
        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();
        nums = new int[]{1, 2, 3, 4, 5, 6, 7};
        rotate1(nums, 3);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }

    // O(n)
    // O(n)
    public static void rotate(int[] nums, int k) {
        if (k < 1) {
            return;
        }

        var result = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            var destiny = (i + k) % nums.length;
            result[destiny] = nums[i];
        }


        for (int i = 0; i < nums.length; i++) {
            nums[i] = result[i];
        }
    }

    // O(n)
    // O(1)
    public static void rotate1(int[] nums, int k) {

        k = k % nums.length;

        var left = 0;
        var right = nums.length - 1;

        // inverto o array completamente
        while (left < right) {
            var aux = nums[right];
            nums[right] = nums[left];
            nums[left] = aux;
            left++;
            right--;
        }

        // inverto o array do elemento 0 até o k elemento
        left = 0;
        right = k - 1;

        while (left < right) {
            var aux = nums[right];
            nums[right] = nums[left];
            nums[left] = aux;
            left++;
            right--;
        }

        // inverto o array do elemento k até o final
        left = k;
        right = nums.length - 1;
        while (left < right) {
            var aux = nums[right];
            nums[right] = nums[left];
            nums[left] = aux;
            left++;
            right--;
        }
    }


}

/* Rotate Array
*
* Given an array, rotate the array to the right by k steps, where k is non-negative.



Example 1:

Input: nums = [1,2,3,4,5,6,7], k = 3
Output: [5,6,7,1,2,3,4]
Explanation:
rotate 1 steps to the right: [7,1,2,3,4,5,6]
rotate 2 steps to the right: [6,7,1,2,3,4,5]
rotate 3 steps to the right: [5,6,7,1,2,3,4]
Example 2:

Input: nums = [-1,-100,3,99], k = 2
Output: [3,99,-1,-100]
Explanation:
rotate 1 steps to the right: [99,-1,-100,3]
rotate 2 steps to the right: [3,99,-1,-100]


Constraints:

1 <= nums.length <= 105
-231 <= nums[i] <= 231 - 1
0 <= k <= 105


Follow up:

Try to come up with as many solutions as you can. There are at least three different ways to solve this problem.
Could you do it in-place with O(1) extra space?
*
*
* */