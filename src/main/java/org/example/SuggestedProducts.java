package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SuggestedProducts {


    public static void main(String[] args) {
        String[] strings = {"geladeira", "gelo", "gerson"};
        System.out.println(new SuggestedProducts().suggestedProducts(strings, "gerson"));
    }


    // Tendo uma lista de sugestões e uma palavra para pesquisa, o que queremos?
    // a cada caractere digitado trado uma lista no máximo 3 palavras de forma lexicografica (basicamente, ordem alfabetica)
    // Poderia fazer bruteforce, for um for pra cada caractere, ordenando o array de produtos primeiro
    // a cada caractere do searchWord, eu vou rodar um for pra buscar as palavras que conteem aqueles caracteres


    // result = [["geladeira", "gelo", "gerson"], ["geladeira", "gelo", "gerson"], [gerson], [gerson], [gerson], [gerson] ]

    // complexidade de tempo O(n² + tamanhoPalavra)
    // Complexidade espacial O(1)

    List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> result = new ArrayList<>();
        Arrays.sort(products);

        StringBuilder buscaAtual = new StringBuilder();

        for (char c : searchWord.toCharArray()) {
            buscaAtual.append(c);
            List<String> resultados = new ArrayList<>();
            for (String produto : products) {
                if (resultados.size() == 3) {
                    break;
                }

                if (produto.length() >= buscaAtual.toString().length() &&
                        buscaAtual.toString().equals(produto.substring(0, buscaAtual.length()))) {
                    resultados.add(produto);
                }
            }
            result.add(resultados);
        }


        return result;
    }
}

/*
*
* Search Suggestions System
*
* You are given an array of strings products and a string searchWord.

Design a system that suggests at most three product names from products after each character of searchWord is typed. Suggested products should have common prefix with searchWord. If there are more than three products with a common prefix return the three lexicographically minimums products.

Return a list of lists of the suggested products after each character of searchWord is typed.



Example 1:

Input: products = ["mobile","mouse","moneypot","monitor","mousepad"], searchWord = "mouse"
Output: [
["mobile","moneypot","monitor"],
["mobile","moneypot","monitor"],
["mouse","mousepad"],
["mouse","mousepad"],
["mouse","mousepad"]
]
Explanation: products sorted lexicographically = ["mobile","moneypot","monitor","mouse","mousepad"]
After typing m and mo all products match and we show user ["mobile","moneypot","monitor"]
After typing mou, mous and mouse the system suggests ["mouse","mousepad"]
Example 2:

Input: products = ["havana"], searchWord = "havana"
Output: [["havana"],["havana"],["havana"],["havana"],["havana"],["havana"]]
Example 3:

Input: products = ["bags","baggage","banner","box","cloths"], searchWord = "bags"
Output: [["baggage","bags","banner"],["baggage","bags","banner"],["baggage","bags"],["bags"]]


Constraints:

1 <= products.length <= 1000
1 <= products[i].length <= 3000
1 <= sum(products[i].length) <= 2 * 104
All the strings of products are unique.
products[i] consists of lowercase English letters.
1 <= searchWord.length <= 1000
searchWord consists of lowercase English letters.
* */