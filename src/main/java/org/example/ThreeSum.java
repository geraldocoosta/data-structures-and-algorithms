package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    public static void main(String[] args) {
        System.out.println(new ThreeSum().threeSum(new int[]{-1,0,1,2,-1,-4}));
    }

    // Time O(n²)
    // Space O(logN) ou O(N) - por causa do sort
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        // Se num[i] for maior que zero, todas as respostas serão maior que 0
        for (int i = 0; i < nums.length && nums[i] <= 0; ++i) {
            // Meu primeiro item do array sempre vai passar por aqui
            // ou se meu valor atual for diferente do valor anterior

            // Se o meu nums[i] atual tem que ser diferente do anterior
            if (i == 0 || nums[i - 1] != nums[i]) {
                twoSum(nums, i, res);
            }
        }
        return res;
    }

    // time O(n)
    void twoSum(int[] nums, int i, List<List<Integer>> res) {
        // left é meu ponteiro da esquerda, que recebe a posição do for fora desse método mais um, ou seja
        // o proximo item do meu array que não é I
        int left = i + 1;
        int right = nums.length - 1;

        // Enquanto os ponteiros não se encontrarem
        while (left < right) {

            // faço a soma dos meus elementos
            int sum = nums[i] + nums[left] + nums[right];

            // Se sum for menor que zero, eu movo o ponteiro da esquerda uma casa pra direita
            if (sum < 0) {
                ++left;
            } else if (sum > 0) {
                // Se sum for maior que zero, eu movo o ponteiro da direita uma casa pra esquerda
                --right;
            } else {
                // Caso seja zero, encontrei um resultado
                res.add(Arrays.asList(nums[i], nums[left], nums[right]));

                // Após encontrar um resultado, povo o ponteiro da esquerda para a direita
                left++;
                // Movo o ponteiro da direita para a esquerda
                right--;

                // Enquanto meu ponteiro da esquerda for menor que o da direita E tiver um sequencia de numeros iguais
                // na esquerda, eu movo o ponteiro da esquerda pra direita
                while (left < right && nums[left] == nums[left - 1]) {
                    ++left;
                }
            }
        }
    }
}

/*
3Sum

Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.

Notice that the solution set must not contain duplicate triplets.



Example 1:

Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]
Explanation:
nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
The distinct triplets are [-1,0,1] and [-1,-1,2].
Notice that the order of the output and the order of the triplets does not matter.
Example 2:

Input: nums = [0,1,1]
Output: []
Explanation: The only possible triplet does not sum up to 0.
Example 3:

Input: nums = [0,0,0]
Output: [[0,0,0]]
Explanation: The only possible triplet sums up to 0.



*/