package org.example;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {

    public static void main(String[] args) {
        System.out.println(minWindow("ADOBECODEBANC", "ABC"));
    }


    public static String minWindow(String s, String t) {

        if (s.length() == 0 || t.length() == 0) {
            return "";
        }

        // popular o hash map T
        Map<Character, Integer> hashMapT = new HashMap<Character, Integer>();
        for (int i = 0; i < t.length(); i++) {
            hashMapT.put(t.charAt(i), hashMapT.getOrDefault(t.charAt(i), 0) + 1);
        }

        // valor total que precisamos
        int required = hashMapT.size();

        // variavel para guardar quantos caracteres necessário capturamos até agora
        int formed = 0;

        // HashMap para guardar caracteres da janela
        Map<Character, Integer> windowCounts = new HashMap<Character, Integer>();

        // resposta
        int len = -1;
        int start = 0;
        int end = 0;

        // ponteiros left e right
        int left = 0;
        for (int right = 0; right < s.length(); right++ ) {
            char c = s.charAt(right);
            // vou ir colocando qualquer caractere no hash map da janela
            windowCounts.put(c, windowCounts.getOrDefault(c, 0) + 1);

            // se o caractere que eu coloquei no hash map da janela existe no hashT
            // e a quantidade de vezes que achei ele for igual da quantidade de vezes que ele tá no hashT
            // eu incremento o formed, mais ou menos dizendo que encontrei um caractere valido
            if (hashMapT.containsKey(c) && windowCounts.get(c).intValue() == hashMapT.get(c).intValue()) {
                formed++;
            }

            // se fomed == required, eu tenho uma janela valida
            while (left <= right && formed == required) {
                c = s.charAt(left);
                // aqui eu verifico se a janela atual é menor que a janela já salva
                if (len == -1 || right - left + 1 < len) {
                    len = right - left + 1;
                    start = left;
                    end = right;
                }

                // tiro o caractere da esquerda da janela
                windowCounts.put(c, windowCounts.get(c) - 1);

                // se esse caractere for um que faz a janela estar valida, tenho que decrementar o formed
                if (hashMapT.containsKey(c) && windowCounts.get(c) < hashMapT.get(c)) {
                    formed--;
                }

                // ando com o ponteiro do left, diminuindo a janela
                left++;
            }
        }

        return len == -1 ? "" : s.substring(start, end + 1);
    }
}

/*

Minimum Window Substring

Given two strings s and t of lengths m and n respectively, return the minimum window substring of s such that every character in t (including duplicates) is included in the window. If there is no such substring, return the empty string "".

The testcases will be generated such that the answer is unique.

A substring is a contiguous sequence of characters within the string.



Example 1:

Input: s = "ADOBECODEBANC", t = "ABC"
Output: "BANC"
Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.
Example 2:

Input: s = "a", t = "a"
Output: "a"
Explanation: The entire string s is the minimum window.
Example 3:

Input: s = "a", t = "aa"
Output: ""
Explanation: Both 'a's from t must be included in the window.
Since the largest window of s only has one 'a', return empty string.


Constraints:

m == s.length
n == t.length
1 <= m, n <= 105
s and t consist of uppercase and lowercase English letters.


Follow up: Could you find an algorithm that runs in O(m + n) time?






*/