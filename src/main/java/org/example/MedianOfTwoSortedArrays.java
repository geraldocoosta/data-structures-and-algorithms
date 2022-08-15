package org.example;

public class MedianOfTwoSortedArrays {

    public static void main(String[] args) {
        int[] nums1 = {1, 3};
        int[] nums2 = {2, 4};
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int lengthNums1 = nums1.length;
        int lengthNums2 = nums2.length;
        if (lengthNums1 < lengthNums2) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int left = 0;
        int right = lengthNums2 * 2;

        // Dois pointers

        while (left <= right) {
            int mid2 = (left + right) / 2;                // Try Cut 2
            int mid1 = lengthNums1 + lengthNums2 - mid2;  // Calculate Cut 1 accordingly

            double leftNums1 = (mid1 == 0) ? Integer.MIN_VALUE : nums1[(mid1 - 1) / 2];    // Get leftNums1, rightNums1, leftNums2, rightNums2 respectively
            double leftNums2 = (mid2 == 0) ? Integer.MIN_VALUE : nums2[(mid2 - 1) / 2];
            double rightNums1 = (mid1 == lengthNums1 * 2) ? Integer.MAX_VALUE : nums1[(mid1) / 2];
            double rightNums2 = (mid2 == lengthNums2 * 2) ? Integer.MAX_VALUE : nums2[(mid2) / 2];

            if (leftNums1 > rightNums2) { // A1's lower half is too big; need to move C1 left (C2 right)
                left = mid2 + 1;
            } else if (leftNums2 > rightNums1) { // A2's lower half too big; need to move C2 left.
                right = mid2 - 1;
            } else {   // Otherwise, that's the right cut.
                return (Double.max(leftNums1, leftNums2) + Double.min(rightNums1, rightNums2)) / 2;
            }
        }
        return -1;
    }
}

/*
*Median of Two Sorted Arrays
* Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.

The overall run time complexity should be O(log (m+n)).



Example 1:

Input: nums1 = [1,3], nums2 = [2]
Output: 2.00000
Explanation: merged array = [1,2,3] and median is 2.
Example 2:

Input: nums1 = [1,2], nums2 = [3,4]
Output: 2.50000
Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.


Constraints:

nums1.length == m
nums2.length == n
0 <= m <= 1000
0 <= n <= 1000
1 <= m + n <= 2000
-106 <= nums1[i], nums2[i] <= 106*/