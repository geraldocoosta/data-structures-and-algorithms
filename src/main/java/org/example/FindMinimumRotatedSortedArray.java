package org.example;

public class FindMinimumRotatedSortedArray {

    public static void main(String[] args) {
        System.out.println(findMin(new int[]{7,8,1,2,3,4,5,6}));
    }

    public static int findMin(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        int left = 0;
        int right = nums.length - 1;

        if (nums[right] > nums[0]) {
            return nums[0];
        }

        return binarySearch(nums, left, right);
    }


    public static int binarySearch(int[] nums, int left, int right) {
        var mid = (left + right) / 2;

        if (nums[mid] > nums[mid + 1]) {
            return nums[mid + 1];
        }

        if (nums[mid - 1] > nums[mid]) {
            return nums[mid];
        }


        if (nums[mid] > nums[left]) {
            return binarySearch(nums, mid + 1, right);
        } else {
            return binarySearch(nums, left, mid - 1);
        }

    }
}
