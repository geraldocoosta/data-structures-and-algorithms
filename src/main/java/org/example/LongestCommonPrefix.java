package org.example;

import java.util.Arrays;
import java.util.LinkedList;

public class LongestCommonPrefix {


    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"", "b"}));
        System.out.println(longestCommonPrefix2(new String[]{"flower", "flow", "flight"}));
    }

    public static String longestCommonPrefix(String[] strs) {

        if (strs == null || strs.length == 0)
            return "";
        if (strs.length == 1)
            return strs[0];
        Trie trie = new Trie();
        for (int i = 0; i < strs.length; i++) {
            trie.insert(strs[i]);
        }
        return trie.searchLongestPrefix();
    }

    public static String longestCommonPrefix2(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        if (strs.length == 1) return strs[0];

        StringBuilder sb = new StringBuilder();
        Arrays.sort(strs);
        char[] first = strs[0].toCharArray();
        char[] last = strs[strs.length - 1].toCharArray();
        for (int i = 0, j = 0; i < first.length && j < last.length; i++, j++) {
            if (first[i] != last[j]) break;
            sb.append(first[i]);
        }
        return sb.toString();
    }

    static class TrieNode {
        private TrieNode[] links = new TrieNode[26];
        private boolean isEnd;

        private int size;

        public void put(char ch, TrieNode node) {
            links[ch - 'a'] = node;
            size++;
        }

        public boolean containsKey(char ch) {
            return links[ch - 'a'] != null;
        }

        public TrieNode get(char ch) {
            return links[ch - 'a'];
        }

        public void setEnd() {
            isEnd = true;
        }


        public int getLinksSize() {
            return size;
        }
    }

    static class Trie {
        private final TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        public void insert(String word) {
            TrieNode node = root;
            for (int i = 0; i < word.length(); i++) {
                char currentChar = word.charAt(i);
                if (!node.containsKey(currentChar)) {
                    node.put(currentChar, new TrieNode());
                }
                node = node.get(currentChar);
            }
            node.setEnd();
        }

        private String searchLongestPrefix() {
            StringBuilder prefix = new StringBuilder();
            LinkedList<TrieNode> queue = new LinkedList<>();

            queue.add(root);

            while (!queue.isEmpty()) {
                TrieNode node = queue.poll();
                if (node.getLinksSize() != 1) {
                    break;
                } else {
                    for (int i = 0; i < node.links.length; i++) {
                        if (node.links[i] != null) {
                            queue.add(node.links[i]);
                            prefix.append((char) (i + 'a'));
                        }
                    }
                }
            }

            return prefix.toString();
        }

    }
}

/*
Longest Common Prefix
Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".



Example 1:

Input: strs = ["flower","flow","flight"]
Output: "fl"
Example 2:

Input: strs = ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.


Constraints:

1 <= strs.length <= 200
0 <= strs[i].length <= 200
strs[i] consists of only lowercase English letters.


*/