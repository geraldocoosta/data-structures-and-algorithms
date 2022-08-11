package org.example;

public class LongestPalindromicSubstring2 {

    public static void main(String[] args) {
        System.out.println(new LongestPalindromicSubstring2().longestPalindrome("abcacba"));
    }

    public String longestPalindrome(String str) {

        if (str == null || str.length() <= 1)
            return str;

        int length = str.length();

        boolean[][] dp = new boolean[length][length];

        int start = 0;
        int end = 0;

//           A  B  C  A  A
//        A [1, 0, 0, 0, 0]
//        B [0, 1, 0, 0, 0]
//        C [0, 0, 1, 0, 0]
//        A [0, 0, 0, 1, 0]
//        A [0, 0, 0, 1, 1] -- aqui encontramos o palindromo na posição 4 - 3 e a flag é true


//             A  B  C  A  C  B  A
//          A [1, 0, 0, 0, 0, 0, 0]
//          B [0, 1, 0, 0, 0, 0, 0]
//          C [0, 0, 1, 0, 0, 0, 0]
//          A [0, 0, 0, 1, 0, 0, 0]
//          C [0, 0, 1, 0, 1, 0, 0]
//          B [0, 1, 0, 0, 0, 1, 0]
//          A [1, 0, 0, 0, 0, 0, 1] -- aqui nos encontramos os palindromos nas diagonais a superior direita


        for (int i = 0; i < length; i++) {
            for (int j = i; j >= 0; j--) {
                boolean flag = str.charAt(i) == str.charAt(j);
                if (i == j                          // Se i igual a j, quer dizer que estamos analisando o mesmo caractere
                    || (i - j == 1 && flag)         // essa linha verifica se o acontece um palindromo com o caractere anterior
                    || (flag && dp[i - 1][j + 1]))  // Nessa linha, eu verifico na minha tabela, minha posição superior direita, se ela tiver true e a flag true, achamos outro palindromo
                    dp[i][j] = true;

                if (dp[i][j] && i - j > end - start) {
                    end = i;
                    start = j;
                }
            }
        }

        return str.substring(start, end + 1);
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

