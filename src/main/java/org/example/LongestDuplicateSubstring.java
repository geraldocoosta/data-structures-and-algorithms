package org.example;

public class LongestDuplicateSubstring {


    public static void main(String[] args) {
        System.out.println(longestDupSubstring("banana"));
    }

    private static String lcp(String s, String t) {
        int minLength = Math.min(s.length(), t.length());
        for (int i = 0; i < minLength; i++) {
            if (s.charAt(i) != t.charAt(i)) {
                return s.substring(0, i);
            }
        }
        return s.substring(0, minLength);
    }

    public static String longestDupSubstring(String string) {
        int length = string.length();
        String lrs = "";
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                String x = lcp(string.substring(i, length), string.substring(j, length));
                if (x.length() > lrs.length()) lrs = x;
            }
        }
        return lrs;
    }
}

/*

Given a string s, consider all duplicated substrings: (contiguous) substrings of s that occur 2 or more times. The occurrences may overlap.

Return any duplicated substring that has the longest possible length. If s does not have a duplicated substring, the answer is "".



Example 1:

Input: s = "banana"
Output: "ana"
Example 2:

Input: s = "abcd"
Output: ""


Constraints:

2 <= s.length <= 3 * 104
s consists of lowercase English letters.



*/