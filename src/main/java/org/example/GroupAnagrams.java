package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {

    public static void main(String[] args) {
        String[] strs = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> result = groupAnagrams(strs);
        for (List<String> list : result) {
            System.out.println(list);
        }
    }

    //Time Complexity: O(N * K log K), where N is the length of strs, and K is the maximum length of a string in strs.
    // The outer loop has complexity O(N) as we iterate through each string. Then, we sort each string in O(KlogK) time.

    //Space Complexity: O(N * K), the total information content stored in ans.

    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        if (strs.length == 0) {
            return result;
        }
        Map<String, List<String>> ans = new HashMap<>();
        for (String s : strs) {
            char[] ca = s.toCharArray();

            // Ordeno os caracteres
            Arrays.sort(ca);



            // Crio uma key contendo os caracteres
            String key = String.valueOf(ca);

            // Se a key não existir no meu hash map, eu crio a key com uma lista
            if (!ans.containsKey(key)) {
                ans.put(key, new ArrayList<>());
            }
            // adiciono a palavra na minha lista para a chave criada
            ans.get(key).add(s);

        }

        for (List<String> list : ans.values()) {
            result.add(list);
        }
        return result;
    }


}


/*

49. Group Anagrams

Given an array of strings strs, group the anagrams together. You can return the answer in any order.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.



Example 1:

Input: strs = ["eat","tea","tan","ate","nat","bat"]
Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
Example 2:

Input: strs = [""]
Output: [[""]]
Example 3:

Input: strs = ["a"]
Output: [["a"]]


Constraints:

1 <= strs.length <= 104
0 <= strs[i].length <= 100
strs[i] consists of lowercase English letters.




*/
