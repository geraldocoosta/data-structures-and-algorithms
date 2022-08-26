package org.example;

public class SearchInRotatedSortedArray {

    public static void main(String[] args) {
        System.out.println(new SearchInRotatedSortedArray().search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
    }

    public int search(int[] nums, int target) {
        return binarySearch(nums, 0, nums.length - 1, target);
    }


    private int binarySearch(int[] nums, int left, int right, int target) {

        var mid = (right + left) / 2;

        if (left > right) {
            return -1;
        }

        if (nums[mid] == target) {
            return mid;
        }


        // casos esquisitos
        if (target > nums[mid] && target > nums[right]) {
            return binarySearch(nums, left, mid - 1, target);
        }

        if (target < nums[mid] && target < nums[left]) {
            return binarySearch(nums, mid + 1, right, target);
        }


        // casos normais

        if (target > nums[mid] && target <= nums[right]) {
            return binarySearch(nums, mid + 1, right, target);
        }

        if (target < nums[mid] && target >= nums[left]) {
            return binarySearch(nums, left, mid - 1, target);
        }


        return -1;

    }
}

/*
 Search in Rotated Sorted Array

There is an integer array nums sorted in ascending order (with distinct values).

Prior to being passed to your function, nums is possibly rotated at an unknown pivot index k (1 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].

Given the array nums after the possible rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.

You must write an algorithm with O(log n) runtime complexity.



Example 1:

Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4
Example 2:

Input: nums = [4,5,6,7,0,1,2], target = 3
Output: -1
Example 3:

Input: nums = [1], target = 0
Output: -1


Constraints:

1 <= nums.length <= 5000
-104 <= nums[i] <= 104
All values of nums are unique.
nums is an ascending array that is possibly rotated.
-104 <= target <= 104
*/