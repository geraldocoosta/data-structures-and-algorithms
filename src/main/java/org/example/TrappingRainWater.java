package org.example;

public class TrappingRainWater {

    public static void main(String[] args) {
        System.out.println(trap(new int[]{0, 1, 2, 1, 0, 1, 4, 3, 2, 3, 1}));
    }

    //Complexity analysis
    //Time complexity: O(n). Single iteration of O(n).
    //Space complexity: O(1) extra space. Only constant space required for left, right, left_max and right_max.


    private static int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }

        int left = 0;
        int right = height.length - 1;
        int leftMax = 0;
        int rightMax = 0;
        int ans = 0;

        while (left < right) {
            leftMax = Math.max(height[left], leftMax);
            rightMax = Math.max(height[right], rightMax);


            // Basicamente, se o max left for menor que o max right, tenho que mover o max left
            // Essa logica serve para mover o ponteiro que tem o menor maximo
            // dessa forma, quando um encontrar a altura maxima, ele não vai ser mover além disso
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
