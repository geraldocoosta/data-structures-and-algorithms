package org.example;

import java.util.Stack;

public class SumOfSubarrayMinimums {

    public static void main(String[] args) {
        System.out.println(new SumOfSubarrayMinimums().sumSubarrayMins(new int[]{1, 3, 4, 1}));
    }

    public int sumSubarrayMins(int[] nums) {
        // initialize previous less element and next less element of
        // each element in the array

        Stack<int[]> stack = new Stack<>();

        // Dado um array [2, 9, 7, 8, 3, 4, 6, 1]
        // Se eu to o elemento com numero 3, eu tenho que encontrar até quando ele é o menor na direita dele e na esquerda dele

        // O 3 é o minimo na direita até encontrar o 3, então incluindo ele mesmo, ele é minimo por 3 vezes pra direita
        // Pra esquerda, ele será o minimo por 4 vezes
        // Se eu 3*4 = eu sei que ele participa de 12 subarrays sendo o valor minimo

        // Vamos exemplificar mais 2 vezes
        // com o 2, ele é minimo pra direita por 7 vezes
        // ele vai ser o minimo da esquerda 1 apenas, pois só iremos contar ele mesmo
        // logo 7 * 1 = 7

        // Meu real problema aqui é encontrar uma forma linear de achar quantas vezes ele é o menor pra direita e
        // quantas vezes ele vai ser o menor pra esquerda

        // A forma mais fácil, seria com um for de for, pois eu iria percorrer o array e verificar isso

        // Na forma linear, eu crio uma stack


        int[] leftDistance = new int[nums.length];
        int[] rightDistance = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {

            while (!stack.isEmpty() && nums[i] <= stack.peek()[0]) {
                stack.pop();
            }

            // Se minha pilha está vazia, quer dizer que o elemento i é menor pra esquerda uma vez
            if (stack.isEmpty()) {
                leftDistance[i] = i + 1;
            } else {
                // se não, como eu já tirei os numeros maiores que o numero atual, sobrou aqui o proximo menor a esquerda
                // que é menor que o valor atual
                leftDistance[i] = i - stack.peek()[1];
            }
            stack.push(new int[]{nums[i], i});
        }

        stack.clear();

        for (int i = nums.length - 1; i >= 0; i--) {
            // Se a stack não for vazia, e o numero do topo da minha stack for maior que o numero do nums[i]
            // quer dizer que o numero do topo é maior, logo, posso descartalo
            while (!stack.isEmpty() && nums[i] < stack.peek()[0]) {
                stack.pop();
            }

            // Se minha pilha está vazia, quer dizer que o elemento i é menor pra direita uma vez
            if (stack.isEmpty()) {
                rightDistance[i] = nums.length - i;
            } else {
                // se minha pilha não está vazia e o numero do topo da minha stack é menor que o nums[i] atual
                // quer dizer que achamos um indice que contem um numero menor que o atual na minha direita
                rightDistance[i] = stack.peek()[1] - i;
            }

            stack.push(new int[]{nums[i], i});
        }

        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            ans +=  nums[i] * leftDistance[i] * rightDistance[i];
        }
        return ans;
    }
}

/*
*
* Sum of Subarray Minimums
*
* Given an array of integers arr, find the sum of min(b), where b ranges over every (contiguous) subarray of arr. Since the answer may be large, return the answer modulo 109 + 7.



Example 1:

Input: arr = [3,1,2,4]
Output: 17
Explanation:
Subarrays are [3], [1], [2], [4], [3,1], [1,2], [2,4], [3,1,2], [1,2,4], [3,1,2,4].
Minimums are 3, 1, 2, 4, 1, 1, 2, 1, 1, 1.
Sum is 17.
Example 2:

Input: arr = [11,81,94,43,3]
Output: 444


Constraints:

1 <= arr.length <= 3 * 104
1 <= arr[i] <= 3 * 104
* */
