package org.example;

import java.util.HashMap;

public class LongestRepeatingCharacterReplacement {

    public static void main(String[] args) {
        System.out.println(characterReplacement("AABABBA", 1));
    }

    public static int characterReplacement(String s, int k) {
        // HashMap para guardar caracteres e seus maiores valores validos em uma janela
        var count = new HashMap<Character, Integer>();

        // resposta
        var res = 0;

        // variavel para guardar qtd que a letra que mais aparece na janela
        var mostFreqLetter = 0;

        // pointer do left
        var left = 0;

        // right pointer
        for (var right = 0; right < s.length(); right++) {

            // caractere que o right aponta
            var c = s.charAt(right);

            // vou settar +1 pra ele no hash map
            count.put(c, count.getOrDefault(c, 0) + 1);

            // Verifico qual a quantidade do caractere mais frequente
            mostFreqLetter = Math.max(mostFreqLetter, count.get(c));

            // verifico o total de letras que tenho que mudar ppra ter uma resposta valida
            var letterToChange = (right - left + 1) - mostFreqLetter;

            // se esse valor for maior que o total K
            if ( letterToChange > k ) {
                // diminuo a quantidade que aparece meu caractere da esquerda
                var cLeft = s.charAt(left);
                count.put(cLeft, count.get(cLeft) - 1);

                // ponteiro esquerdo vai pra direita (diminuindo a janela)
                left++;
            }

            // meu resultado é o tamanho da janela valida, que seria right - left + 1
            res = Math.max(res, right - left + 1);
        }

        return res;
    }
}

/*
*
* Longest Repeating Character Replacement
*
* You are given a string s and an integer k. You can choose any character of the string and change it to any other uppercase English character. You can perform this operation at most k times.

Return the length of the longest substring containing the same letter you can get after performing the above operations.



Example 1:

Input: s = "ABAB", k = 2
Output: 4
Explanation: Replace the two 'A's with two 'B's or vice versa.
Example 2:

Input: s = "AABABBA", k = 1
Output: 4
Explanation: Replace the one 'A' in the middle with 'B' and form "AABBBBA".
The substring "BBBB" has the longest repeating letters, which is 4.


Constraints:

1 <= s.length <= 105
s consists of only uppercase English letters.
0 <= k <= s.length
*
*
* */