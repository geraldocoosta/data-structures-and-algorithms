package org.example;

public class CountBinarySubstrings {


    public static void main(String[] args) {
        System.out.println(new CountBinarySubstrings().countBinarySubstrings("00110110"));
    }


    //            "00110110"
    // result 0     0002334 -> 5
    // prev   0     0222112
    // cur    1     2121121


    // Basicamente, percorremos a String a procura de caracteres iguais ou diferentes
    // criamos 2 variaveis pra guardar os valores dos subgrupos iguais de caracteres
    // uma para o grupo que já passamos, e outro pro grupo atual
    // verificamos o total de substring com Math.min(current, previus) pois
    // nessa substring '01', onde temos 1 zero (previus) e 1 um (actual), temos um total de uma substring valida
    // nessa outra substring '0011', temos o total de 2 zeros (previus) e 2 uns (actual), temos o total de 2 substrings
    // validas nas condições desse algoritmo
    // 01 e 0011

    // Complexidade Spacial, 1, pois não criamos array auxiliar, apenas váriaveis auxiliares
    // Complexidade Temporal, N, onde N é o tamanho da String, pois vamos percorrer todos os elementos da string

    // Perguntas que poderiamos fazer
    // Só irei receber 0 e 1? Tenho que verificar se a String só tem 0s e 1s
    //

    public int countBinarySubstrings(String s) {

        int currentCounter = 1;
        int previusCounter = 0;
        int result = 0;

        for (int i = 1; i< s.length(); i++) {
            char actualChar = s.charAt(i);
            char prevChar = s.charAt(i - 1);
            if (actualChar == prevChar) {
                currentCounter++;
            } else {
                result += Math.min(currentCounter, previusCounter);
                previusCounter = currentCounter;
                currentCounter = 1;
            }
        }

        result += Math.min(currentCounter, previusCounter);

        return result;
    }
}


/*
*
* Count Binary Substrings
*
* Given a binary string s, return the number of non-empty substrings that have the same number of 0's and 1's,
* and all the 0's and all the 1's in these substrings are grouped consecutively.

Substrings that occur multiple times are counted the number of times they occur.



Example 1:

Input: s = "00110011"
Output: 6
Explanation: There are 6 substrings that have equal number of consecutive 1's and 0's: "0011", "01", "1100", "10", "0011", and "01".
Notice that some of these substrings repeat and are counted the number of times they occur.
Also, "00110011" is not a valid substring because all the 0's (and 1's) are not grouped together.
Example 2:

Input: s = "10101"
Output: 4
Explanation: There are 4 substrings: "10", "01", "10", "01" that have equal number of consecutive 1's and 0's.


Constraints:

1 <= s.length <= 105
s[i] is either '0' or '1'.
* */