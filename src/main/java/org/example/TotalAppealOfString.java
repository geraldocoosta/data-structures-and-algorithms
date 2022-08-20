package org.example;

public class TotalAppealOfString {

    public static void main(String[] args) {
        System.out.println(appealSum("teste"));
    }

    public static long appealSum(String s) {
        // array que vai ter a posição que cada caractere apareceu
        int[] last = new int[26];
        // resposta
        long res = 0;
        // total de aparição de uma letra em uma substring
        long total = 0;
        for (int i = 0; i < s.length(); ++i) {
            // pegamos o valor que o char vai estar dentro do array
            int charValue = s.charAt(i) - 'a';

            // para calcular o total, é somado total + indice + 1 - a ultima aparição de um caractere
            total += i + 1 - last[charValue];

            // na resposta é somado o total + resposta
            res += total;

            // atualiza o valor da ultima ocorrencia de um char
            last[charValue] = i + 1;
        }
        return res;
    }
}
