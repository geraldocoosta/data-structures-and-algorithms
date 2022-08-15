package org.example;

public class KthLargestElementInAnArray {

    public static void main(String[] args) {
        int[] nums = {3,2,1,5,6,4};
        System.out.println(findKthLargest(nums, 2));
    }

    public static int findKthLargest(int[] nums, int k) {
        int start = 0;
        int end = nums.length - 1;
        int index = nums.length - k;

        while (start < end) {
            // retorna index do pivot
            int pivot = partition(nums, start, end);

            // se o index do pivot for menor que o index da k largest, então o pivot está na direita
            if (pivot < index) {
                start = pivot + 1;
            } else if (pivot > index) { // se o pivot for maior que o index, o pivot está na direita
                end = pivot - 1;
            } else {
                return nums[pivot];
            }
        }
        return nums[start];
    }

    private static int partition(int[] nums, int start, int end) {
        int pivot = start;
        int temp;
        while (start <= end) {
            while (start <= end && nums[start] <= nums[pivot]) {
                start++;
            }
            while (start <= end && nums[end] > nums[pivot]) {
                end--;
            }
            if (start > end) {
                break;
            }
            temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
        }
        temp = nums[end];
        nums[end] = nums[pivot];
        nums[pivot] = temp;
        return end;
    }
}

/*
*
* Kth Largest Element in an Array
*
*Given an integer array nums and an integer k, return the kth largest element in the array.

Note that it is the kth largest element in the sorted order, not the kth distinct element.

You must solve it in O(n) time complexity.



Example 1:

Input: nums = [3,2,1,5,6,4], k = 2
Output: 5
Example 2:

Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
Output: 4


Constraints:

1 <= k <= nums.length <= 105
-104 <= nums[i] <= 104
*
*
* */