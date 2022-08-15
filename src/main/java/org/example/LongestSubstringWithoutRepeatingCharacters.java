package org.example;

import java.util.HashMap;

public class LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {
        int lengthOfLongestSubstring = new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring("abcabcbb");
        System.out.println(lengthOfLongestSubstring);
    }

    // Temporal O(N)
    // Space O(N) -> sendo N o tamanho da string, pois cada caractere vai para o mapa
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        int max = 0;
        int rightPointer = 0;
        int leftPointer = 0;

        // Temos um ponteiro que vai continuamente pra direita em cada iteração
        // Enquanto temos outro ponteiro que vai para frente apenas quando encontrar um caractere que já foi usado

        // Quando encontramos um caractere que já foi usado, atualizamos o ponteiro da esquerda
        // O ponteiro da esquerda vai receber o valor maximo entre ou o ponteiro da esquerda ou o valor do ultimo caractere + 1

        // Tendo os dois ponteiros atualizados, o valor maximo da substring será rightpointer menos leftpointer + 1
        // Lembrando que, como os ponteiros informam o indice, temos que somar um pra saber a posição do caractere

        // A cada iteração, adicionamos ou atualizamos o mapa com a posição do caractere que está sendo apontado pelo
        // ponteiro da direita

        // O valor da váriavel max recebe ou max ou o valor da substring atual
        while (rightPointer < s.length()) {
            char charAtIndex = s.charAt(rightPointer);
            if (map.containsKey(charAtIndex)) {
                leftPointer = Math.max(leftPointer, map.get(charAtIndex) + 1);
            }
            map.put(charAtIndex, rightPointer);
            max = Math.max(max, rightPointer - leftPointer + 1);
            rightPointer++;
        }
        return max;
    }
}

/*

Longest Substring Without Repeating Characters

 Given a string s, find the length of the longest substring without repeating characters.



Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
Example 2:

Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.


Constraints:

0 <= s.length <= 5 * 104
s consists of English letters, digits, symbols and spaces.



 */