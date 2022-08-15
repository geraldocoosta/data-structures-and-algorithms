package org.example;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class WordSearchII {

    char[][] board = null;
    ArrayList<String> result = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println(new WordSearchII()
                .findWords(new char[][]{{'o', 'a', 'a', 'n'}, {'e', 't', 'a', 'e'}, {'i', 'h', 'k', 'r'}, {'i', 'f', 'l', 'v'}}
                , new String[]{"oath", "pea", "eat", "rain"}));
    }

    public List<String> findWords(char[][] board, String[] words) {

        // Step 1). Construct the Trie
        TrieNode root = new TrieNode();
        for (String word : words) {
            TrieNode node = root;

            for (Character letter : word.toCharArray()) {
                if (node.children.containsKey(letter)) {
                    node = node.children.get(letter);
                } else {
                    TrieNode newNode = new TrieNode();
                    node.children.put(letter, newNode);
                    node = newNode;
                }
            }
            node.word = word;  // store words in Trie
        }

        this.board = board;
        // Step 2). Backtracking starting for each cell in the board
        for (int row = 0; row < board.length; ++row) {
            for (int col = 0; col < board[row].length; ++col) {
                if (root.children.containsKey(board[row][col])) {
                    backtracking(row, col, root);
                }
            }
        }

        return this.result;
    }

    private void backtracking(int row, int col, TrieNode parent) {
        Character letter = this.board[row][col];
        TrieNode currNode = parent.children.get(letter);

        // check if there is any match
        if (currNode.word != null) {
            this.result.add(currNode.word);
            currNode.word = null;
        }

        // mark the current letter before the EXPLORATION
        this.board[row][col] = '#';

        // explore neighbor cells in around-clock directions: up, right, down, left
        int[] rowOffset = {-1, 0, 1, 0};
        int[] colOffset = {0, 1, 0, -1};
        for (int i = 0; i < 4; ++i) {
            int newRow = row + rowOffset[i];
            int newCol = col + colOffset[i];
            if (newRow < 0 || newRow >= this.board.length || newCol < 0
                    || newCol >= this.board[0].length) {
                continue;
            }
            if (currNode.children.containsKey(this.board[newRow][newCol])) {
                backtracking(newRow, newCol, currNode);
            }
        }

        // End of EXPLORATION, restore the original letter in the board.
        this.board[row][col] = letter;

        // Optimization: incrementally remove the leaf nodes
        if (currNode.children.isEmpty()) {
            parent.children.remove(letter);
        }
    }

    static class TrieNode {
        HashMap<Character, TrieNode> children = new HashMap<>();
        String word = null;

        public TrieNode() {
        }
    }
}

/*

212. Word Search II


Given an m x n board of characters and a list of strings words, return all words on the board.

Each word must be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.



Example 1:


Input: board = [["o","a","a","n"],["e","t","a","e"],["i","h","k","r"],["i","f","l","v"]], words = ["oath","pea","eat","rain"]
Output: ["eat","oath"]
Example 2:


Input: board = [["a","b"],["c","d"]], words = ["abcb"]
Output: []


Constraints:

m == board.length
n == board[i].length
1 <= m, n <= 12
board[i][j] is a lowercase English letter.
1 <= words.length <= 3 * 104
1 <= words[i].length <= 10
words[i] consists of lowercase English letters.
All the strings of words are unique.



*/
