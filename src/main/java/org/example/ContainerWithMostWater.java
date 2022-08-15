package org.example;

public class ContainerWithMostWater {


    public static void main(String[] args) {
        System.out.println(new ContainerWithMostWater().maxArea(new int[]{1,8,2,6,5}));
    }

    // Nesse algoritmos, nós iremos fazer iterações pra cada subarray
    // pra cada subarray, eu vou calcular a distancia do indice left até o indece right
    // essa distancia vai ser calculada utilizando a conta right - left
    // pra calcular o maximo de agua que podemos, pegaremos o elementos que right e left estão apontando,
    // e veremos qual o menor deles
    // Depois de achar o menor, nós multiplicamos pela distancia, e verificamos se o resultado disso é maior que meu
    // maior valor atual

    // time O(n²)
    // space O(1)

    public int maxArea(int[] height) {
        int result = 0;
        for (int left = 0; left < height.length; left++) {
            for (int right = left + 1; right < height.length; right++) {
                int distance = right - left;
                result = Math.max(result, Math.min(height[left], height[right]) * distance);
            }
        }
        return result;
    }


}

/*

Container With Most Water

You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).

Find two lines that together with the x-axis form a container, such that the container contains the most water.

Return the maximum amount of water a container can store.

Notice that you may not slant the container.



Example 1:


Input: height = [1,8,6,2,5,4,8,3,7]
Output: 49
Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.
Example 2:

Input: height = [1,1]
Output: 1


Constraints:

n == height.length
2 <= n <= 105
0 <= height[i] <= 104
*
*
* */