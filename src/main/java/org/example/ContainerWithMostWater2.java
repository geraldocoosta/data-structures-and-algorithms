package org.example;

public class ContainerWithMostWater2 {


    public static void main(String[] args) {
        System.out.println(new ContainerWithMostWater2().maxArea(new int[]{1,8,2,6,5}));
    }



    // time O(n)
    // space O(1)


    // Solução com ponteiro duplo
    // Um ponteiro vai apontar pro primeiro valor - chamado left
    // Outro ponteiro vai apontar pro ultimo valor do array - chamado right

    // Enquanto o da esquerda for menor que o da direita, executamos o seguinte

    // pegamos a distancia, que é right - left
    // pegamos a menor altura entre os valores que right e left estão apontando

    // calculamos a quantidade maxima de agua, utilizando a menor altura e multiplicando pela distancia

    // depois verificamos qual é maior entre o resultado já armazenado e o maximo de agua atual

    // Se meu ponteiro da esquerda está apontando pra um numero menor ou igual o meu numero que está sendo apontado
    // pelo meu ponteiro da direita, eu incremento meu ponteiro da esquerda
    // caso contrario, eu decremento meu ponteiro da direita

    public int maxArea(int[] height) {
        int result = 0;
        int left = 0;
        int right = height.length - 1;
        while (left < right) {

            int distance = right - left;
            int shorterHeight = Math.min(height[left], height[right]) ;
            int maxWater = shorterHeight * distance;
            result = Math.max(result, maxWater);

            if (height[left] <= height[right]) {
                left++;
            } else {
                right--;
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