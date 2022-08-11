package org.example;

public class LongestPalindromicSubstring {

    public static void main(String[] args) {
        System.out.println(new LongestPalindromicSubstring().longestPalindrome("a"));
    }

    // Solução com
    // Time Complexity - O(N^4),  O(N^2) to generate all substring and O(N) to check it is palindrome or not. and O(n) to substring
    // Space complexity - O(1).

    // Agora, posso testar todas as possibilidades dentro de substrings da parametro word
    public String longestPalindrome(String word) {
        if (word == null || word.isBlank()) {
            return word;
        }
        int length = word.length();

        if (word.length() <= 1) {
            return word;
        }


        String result = "";
        for (int i = 0; i < length - 1; i++) {
            for (int j = i; j <= length; j++) {
                String wordSubstring = word.substring(i, j);
                if (isPalindrome(wordSubstring)
                        && wordSubstring.length() > result.length()) {
                    result = wordSubstring;
                }
            }
        }
        return result;
    }

    // Primeiramente, como sei que uma String é um palindromo?
    // eu posso ir comparando o caractere no começo da string com o do final, e se não for igual, simplesmente retorno false
    // faço isso até o primeiro ser maior ou igual o caractere do final, e sempre vou somarndo um na váriavel que conta
    // o caractere no começo da string, e substraindo do fim
    private boolean isPalindrome(String s) {

        int start = 0;
        int end = s.length() - 1;

        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }

        return true;
    }
}

/*
Longest Palindromic Substring
*
* Given a string s, return the longest palindromic substring in s.



Example 1:

Input: s = "babad"
Output: "bab"
Explanation: "aba" is also a valid answer.
Example 2:

Input: s = "cbbd"
Output: "bb"


Constraints:

1 <= s.length <= 1000
s consist of only digits and English letters.
*
* */

