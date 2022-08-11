package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UniqueLetterString {
    public static void main(String[] args) {
        System.out.println(new Solution().uniqueLetterString("PAPA"));
    }

    static class Solution {
        public int uniqueLetterString(String s) {
            Map<Character, ArrayList<Integer>> indexMap = new HashMap<>();

            // aqui eu faço um for colocando no Map todas as ocorrencias de um caractere
            // vamo imagenar que coloquei a string PAPA
            // P -> 0, 2
            // A -> 1, 3
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                ArrayList<Integer> integers = indexMap.get(c);
                if (integers == null) {
                    integers = new ArrayList<>();
                }
                integers.add(i);
                indexMap.put(c, integers);
            }
            int res = 0;

            //        P A P A
            // left   1 2 2 2
            // right  2 2 2 1
            // total  2+4+4+2 -> 12

            for (Map.Entry<Character, ArrayList<Integer>> kv : indexMap.entrySet()) {
                List<Integer> allOccurrences = kv.getValue();
                for (int i = 0; i < allOccurrences.size(); i++) {
                    int left;
                    int right;

                    if (i == 0) {
                        // Se indice for 0, quer dizer que foi a primeira vez que esse caractere apareceu na esquerda
                        // Logo, a quantidade total de possibilidade é index do caractere mais um
                        // Vamos supor que é o primeiro A da string PAPA
                        // O total de possibilidade pra esquerda é 1+1, pois ele pode ser tanto "PA" quanto "A"
                        left = allOccurrences.get(i) + 1;
                    } else {
                        // Só vamos entrar aqui caso o caractere apareça mais de uma vez, ou seja, temos que verificar
                        // O total de possibilidades para esquerda
                        // Vamo imaginar o caso do Segundo A da palavra PAPA
                        // Ela tem a possibilidade de se A ou PA indo para esquerda
                        // logo, se subtrair os indices, podemos no resultado esperado
                        // 3 - 1 = 2
                        left = allOccurrences.get(i) - allOccurrences.get(i - 1);
                    }

                    if (i == allOccurrences.size() - 1) {
                        // Caso seja a ultima vez que ocorra esse caractere na String, vamos verificar quantas possibilidades
                        // temos pra direita, calculando quantos caracteres sobraram na direita
                        right = s.length() - allOccurrences.get(i);
                    } else {
                        // Caso não seja a ultima ocorrencia, temos que verificar quantas possibilidade temos, pegando
                        // o index da proxima ocorrencia e subtraindo com a ocorrencia atual
                        // e.g. PAPA, Vamos checar o primeiro P, ele tem index 0, se eu pegar o proximo que, que tem
                        // indice 2 - 0, ficarei com uma 2, AP e P
                        right = allOccurrences.get(i + 1) - allOccurrences.get(i);
                    }

                    // Multiplicando os resultados da direita e da esquerda, chegamos ao resultado desejado
                    res += left * right;
                }
            }

            return res;
        }
    }
}

/*
Count Unique Characters of All Substrings of a Given String

* Let's define a function countUniqueChars(s) that returns the number of unique characters on s.

For example, calling countUniqueChars(s) if s = "LEETCODE" then "L", "T", "C", "O", "D" are the unique characters since they appear only once in s, therefore countUniqueChars(s) = 5.
Given a string s, return the sum of countUniqueChars(t) where t is a substring of s. The test cases are generated such that the answer fits in a 32-bit integer.

Notice that some substrings can be repeated so in this case you have to count the repeated ones too.



Example 1:

Input: s = "ABC"
Output: 10
Explanation: All possible substrings are: "A","B","C","AB","BC" and "ABC".
Every substring is composed with only unique letters.
Sum of lengths of all substring is 1 + 1 + 1 + 2 + 2 + 3 = 10
Example 2:

Input: s = "ABA"
Output: 8
Explanation: The same as example 1, except countUniqueChars("ABA") = 1.
Example 3:

Input: s = "LEETCODE"
Output: 92


Constraints:

1 <= s.length <= 105
s consists of uppercase English letters only.
* */