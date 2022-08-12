package org.example;

import java.util.HashMap;

public class SubstringWithLargestVariance {

    public static void main(String[] args) {
        System.out.println(new SubstringWithLargestVariance().largestVariance("abbb"));
    }


    // BASICAMENTE meu algoritmo vai verificar pegar dois caracteres, e verificar a possibilidade maxima de
    // frequencia dele, baseada em um requesito
    //  1. vai verificar a possibilidade maxima sempre entre dois caracteres
    //  2. A variança vai ser a quantidade de vezes que ele apareceu menos a menor quantidade de vezes
    //     que o segundo caractere apareceu
    //  3. Porém, se meu caractere secundario aparecer mais que meu primario e ainda tem caracteres secundarios na string
    //     o contador é resetado
    //  4. É preciso de pelo menos uma ocorrencia do caractere secundario
    //  We solve it independently for each combination of 2 characters. We use variables a and b below, and their values could be any character. We go left-to-right, and:
    //
    //  For a, we increase our variance (+1).
    //  For b - decrease ( -1).
    //  When the variance goes negative, we restart.
    //  This is Kadane algoritm




    // Time N(n³)
    // Space O(N) onde N é o tamanho da string, pois vamos criar um hash map pra cada caractere
    // No pior caso, vai ser 1 espaço ocupado por cada caractere da String

    public int largestVariance(String s) {
        HashMap<Character, Integer> charCount = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            charCount.merge(s.charAt(i), 1, Integer::sum);
        }
        int variance = 0;

        // Passando sobre cada um dos caracteres
        for (Character primaryChar: charCount.keySet()) {
            for (Character secondaryChar: charCount.keySet()) {

                // Algoritmo não funciona se os dois caracteres analizados forem os mesmo
                if (primaryChar.equals(secondaryChar)) { continue; }

                // pegando o valor de aparições do meu secondary Char
                int secondaryCharCount = charCount.get(secondaryChar);

                // Frequencia do primeiro caractere
                int primaryFreq = 0;

                // Frequencia do segundo caractere
                int secondaryFreq = 0;


                // Para cada letra da minha String
                for (int i = 0; i < s.length(); i++) {
                    // Pego o caractere
                    Character currChar = s.charAt(i);

                    // Se esse caractere for igual o meu primeiro caractere, a frenquencia do primeiro aumenta
                    if (currChar.equals(primaryChar)) {
                        primaryFreq++;
                    }

                    // Se o caractere que peguei ali em cima for igual ao segundo caractere que estou analisando
                    // Aumento a frequencia do meu segundo caractere e diminuo o total dele
                    if (currChar.equals(secondaryChar)) {
                        secondaryFreq++;
                        secondaryCharCount--;
                    }

                    // Variança só vai ser computada caso se tenha frequencia para os dois caracteres analisados
                    if (secondaryFreq > 0 && primaryFreq > secondaryFreq) {
                        // Variança vai ser ou a variança, ou a variança do primeiro menos a do segundo caractere
                        // Analisado
                        variance  = Math.max(variance, (primaryFreq - secondaryFreq));
                    }

                    // Nós redefinimos nosso índice, então estamos ignorando a substring que irá
                    // impactar negativamente nossa variação
                    if (primaryFreq < secondaryFreq && secondaryCharCount > 0) {
                        primaryFreq = 0;
                        secondaryFreq = 0;
                    }
                }

            }
        }
        return variance;
    }

}

/*
*
*  Substring With Largest Variance
*
* The variance of a string is defined as the largest difference between the number of occurrences of any 2 characters present in the string. Note the two characters may or may not be the same.

Given a string s consisting of lowercase English letters only, return the largest variance possible among all substrings of s.

A substring is a contiguous sequence of characters within a string.



Example 1:

Input: s = "aababbb"
Output: 3
Explanation:
All possible variances along with their respective substrings are listed below:
- Variance 0 for substrings "a", "aa", "ab", "abab", "aababb", "ba", "b", "bb", and "bbb".
- Variance 1 for substrings "aab", "aba", "abb", "aabab", "ababb", "aababbb", and "bab".
- Variance 2 for substrings "aaba", "ababbb", "abbb", and "babb".
- Variance 3 for substring "babbb".
Since the largest possible variance is 3, we return it.
Example 2:

Input: s = "abcde"
Output: 0
Explanation:
No letter occurs more than once in s, so the variance of every substring is 0.


Constraints:

1 <= s.length <= 104
s consists of lowercase English letters.
*
* */