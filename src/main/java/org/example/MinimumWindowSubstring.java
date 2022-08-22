package org.example;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {

    public static void main(String[] args) {
        System.out.println(minWindow("ADOBECODEBANC", "ABC"));
    }


    public static String minWindow(String s, String t) {
        // corner case
        if (s == null || t == null || s.length() == 0 || t.length() == 0 || s.length() < t.length()) return "";

        // construct model
        int minLeft = 0;
        int minRight = 0;
        int min = s.length();
        boolean flag = false;

        Map<Character, Integer> map = new HashMap<>();
        int count = t.length(); // the number of characters that I need to match
        for (char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        // unfixed sliding window, 2 pointers
        int i = 0;
        int j = 0;
        while (j < s.length()) {
            char c = s.charAt(j);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) - 1);
                if (map.get(c) >= 0) count--; // if still unmatched characters, then count--
            }

            // if found a susbtring
            while (count == 0 && i <= j) {
                // update global min
                flag = true;
                int curLen = j + 1 - i;
                if (curLen <= min) {
                    minLeft = i;
                    minRight = j;
                    min = curLen;
                }

                // shrink left pointer
                char leftC = s.charAt(i);
                if (map.containsKey(leftC)) {
                    map.put(leftC, map.get(leftC) + 1);
                    if (map.get(leftC) >= 1) count++;
                }
                i++;
            }
            j++;
        }

        return flag == true ? s.substring(minLeft, minRight + 1) : "";
    }
}

/*

Minimum Window Substring

Given two strings s and t of lengths m and n respectively, return the minimum window substring of s such that every character in t (including duplicates) is included in the window. If there is no such substring, return the empty string "".

The testcases will be generated such that the answer is unique.

A substring is a contiguous sequence of characters within the string.



Example 1:

Input: s = "ADOBECODEBANC", t = "ABC"
Output: "BANC"
Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.
Example 2:

Input: s = "a", t = "a"
Output: "a"
Explanation: The entire string s is the minimum window.
Example 3:

Input: s = "a", t = "aa"
Output: ""
Explanation: Both 'a's from t must be included in the window.
Since the largest window of s only has one 'a', return empty string.


Constraints:

m == s.length
n == t.length
1 <= m, n <= 105
s and t consist of uppercase and lowercase English letters.


Follow up: Could you find an algorithm that runs in O(m + n) time?






*/