package org.example;

public class MinFlipsMonoIncr {

    public static void main(String[] args) {
        System.out.println(minFlipsMonoIncr("001010011"));
    }


    //1. Passe os 0 até encontrar o primeiro 1.
    //2. Pra cada caractere 1 que encontrar, vamos incrementar a variável ones.
    //3. Qualquer 0 que vir depois de encontrar um 1 é um candidato a flipar, então a gente cria uma variável pra acompanhar esse numero .
    //4. Se a váriavel de flip for maior que a váriavel de ones, então:
    //    a. Nós estamos tentando inverter mais 0s do que 1s.
    //    b. É melhor flipar o 1

    //           "001010011"
    //      ones  001122234
    //      flip  000112322
    //      flip    0112222

    // Space complexity N
    // Time complexity N
    public static int minFlipsMonoIncr(String str) {
        if (str == null || str.isBlank())
            return 0;

        char[] sChars = str.toCharArray();
        int flip = 0;
        int ones = 0;

        for (int i = 0; i < sChars.length; i++) {
            if (sChars[i] == '0') {
                if (ones == 0) {
                    continue;
                } else {
                    flip++;
                }
            } else {
                ones++;
            }

            if (flip > ones) {
                flip = ones;
            }
        }
        return flip;
    }


    // Como melhor (otimizar o algoritmo)
    // Space complexity 1
    // Time complexity N

    public static int minFlipsMonoIncr2(String str) {
        if (str == null || str.isBlank())
            return 0;

        int flip = 0;
        int ones = 0;

        int strLength = str.length();

        for (int i = 0; i < strLength; i++) {
            if (str.charAt(i) == '0') {
                if (ones == 0) {
                    continue;
                } else {
                    flip++;
                }
            } else {
                ones++;
            }

            if (flip > ones) {
                flip = ones;
            }
        }
        return flip;
    }

}

/*
* Flip String to Monotone Increasing
*
* A binary string is monotone increasing if it consists of some number of 0's (possibly none), followed by some number of 1's (also possibly none).

You are given a binary string s. You can flip s[i] changing it from 0 to 1 or from 1 to 0.

Return the minimum number of flips to make s monotone increasing.



Example 1:

Input: s = "00110"
Output: 1
Explanation: We flip the last digit to get 00111.
Example 2:

Input: s = "010110"
Output: 2
Explanation: We flip to get 011111, or alternatively 000111.
Example 3:

Input: s = "00011000"
Output: 2
Explanation: We flip to get 00000000.


Constraints:

1 <= s.length <= 105
s[i] is either '0' or '1'.
*
* */