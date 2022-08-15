package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SuggestedProducts2 {

    public static void main(String[] args) {
        String[] strings = {"geladeira", "gelo", "gerson"};
        System.out.println(new SuggestedProducts2().suggestedProducts(strings, "gerson"));
    }

    List<List<String>> suggestedProducts(String[] products, String searchWord) {

        Trie trie = new Trie();

        List<List<String>> result = new ArrayList<>();

        for (String produto : products) {
            trie.insert(produto);
        }

        StringBuilder substringToSearch = new StringBuilder();

        for (char actualChar : searchWord.toCharArray()) {
            substringToSearch.append(actualChar);
            List<String> resultForThisChards = trie.getWordsStartWith(substringToSearch.toString());
            result.add(resultForThisChards);
        }


        return result;
    }

    static class Trie {

        Node root;
        List<String> results;

        Trie() {
            root = new Node();
        }

        void insert(String s) {
            Node curr = root;
            // para cada caractere da palavra
            char[] stringChars = s.toCharArray();
            for (int i = 0; i < stringChars.length; i++) {
                // vou verificar se já tem settado um objeto Node na posição da letra i
                if (curr.childrenNodes.get(stringChars[i] - 'a') == null) {
                    // Se não tiver, eu crio um objeto node naquela posição, marcando que tem algum caminho valido ali
                    curr.childrenNodes.set(stringChars[i] - 'a', new Node());
                }
                // curr recebe o proximo filho
                curr = curr.childrenNodes.get(stringChars[i] - 'a');
            }
            // ao final do for, percorremos a arvore preenchendo com new Node() os caminhos validos
            // esse curr é o que fica ao final da palavra, então settamos ele como uma palavra
            // EX: word 'aaaa'
            //    0            1
            //   [new Node]...
            //   [new Node]...
            //   [new Node]...
            //   [new Node(is prodct = true)]

            curr.isProduct = true;
        }

        List<String> getWordsStartWith(String forSearch) {
            results = new ArrayList<>();
            Node curr = root;
            // Esse for é pra chegar no nivel do ultimo caractere do string de busca
            for (char c : forSearch.toCharArray()) {
                // Se o nó não estiver settado, não temos resultados
                if (curr.childrenNodes.get(c - 'a') == null) {
                    return results;
                }
                // passa para o próximo nivel
                curr = curr.childrenNodes.get(c - 'a');
            }
            // vou fazer um busca depth first search, que é pra descobrir os nós que o curr é pai
            dfs(curr, forSearch);
            return results;
        }

        private void dfs(Node curr, String forSearch) {
            // se já tenho 3 resultados, retorno
            if (results.size() == 3) {
                return;
            }
            // se o node atual é um produto, eu adiciono ele na minha lista
            if (curr.isProduct) {
                results.add(forSearch);
            }


            for (char c = 'a'; c < 'z'; c++) {
                // Se eu tenho um node valido, eu vou até os filhos dele recursivamente, até encontrar uma palavra
                if (curr.childrenNodes.get(c - 'a') != null) {
                    dfs(curr.childrenNodes.get(c - 'a'), forSearch + c);
                }
            }
        }


        static class Node {
            boolean isProduct = false;
            List<Node> childrenNodes = Arrays.asList(new Node[26]);
        }

    }
}

/*
*  Search Suggestions System
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

