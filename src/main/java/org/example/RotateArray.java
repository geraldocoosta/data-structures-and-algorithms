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
            var destiny = (i+k) % nums.length;
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
            nums[right] =  nums[left];
            nums[left] = aux;
            left++;
            right--;
        }

        // inverto o array do elemento 0 até o k elemento
        left = 0;
        right = k - 1;

        while (left < right) {
            var aux = nums[right];
            nums[right] =  nums[left];
            nums[left] = aux;
            left++;
            right--;
        }

        // inverto o array do elemento k até o final
        left = k;
        right = nums.length - 1;
        while (left < right) {
            var aux = nums[right];
            nums[right] =  nums[left];
            nums[left] = aux;
            left++;
            right--;
        }
    }


}
