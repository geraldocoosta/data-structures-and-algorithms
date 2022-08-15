package org.example;

public class TrappingRainWater {

    //Complexity analysis
    //Time complexity: O(n). Single iteration of O(n).
    //Space complexity: O(1) extra space. Only constant space required for left, right, left_max and right_max.

    public static void main(String[] args) {
        System.out.println(new TrappingRainWater().trap(new int[]{0, 1, 2, 1, 0, 1, 4, 3, 2, 3, 1}));
    }

    private int trap(int[] height) {
        if (height.length == 0) return 0;
        int left = 0;
        int right = height.length - 1;
        int leftMax = 0;
        int rightMax = 0;
        int ans = 0;
        while (left < right) {
            if (height[left] > leftMax) {
                leftMax = height[left];
            }
            if (height[right] > rightMax) {
                rightMax = height[right];
            }
            if (leftMax < rightMax) {
                ans += Math.max(0, leftMax - height[left]);
                left++;
            } else {
                ans += Math.max(0, rightMax - height[right]);
                right--;
            }
        }
        return ans;
    }
}

/*
*
* Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.



Example 1:


Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.
Example 2:

Input: height = [4,2,0,3,2,5]
Output: 9


Constraints:

n == height.length
1 <= n <= 2 * 104
0 <= height[i] <= 105
* */
