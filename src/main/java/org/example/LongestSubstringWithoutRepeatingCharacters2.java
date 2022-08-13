package org.example;

import java.util.HashMap;

public class LongestSubstringWithoutRepeatingCharacters2 {

    public static void main(String[] args) {
        int lengthOfLongestSubstring = new LongestSubstringWithoutRepeatingCharacters2().lengthOfLongestSubstring("abcabcbb");
        System.out.println(lengthOfLongestSubstring);
    }

    // Temporal O(N)
    // Space O(M) -> Onde M é o tamanho do alfabeto

    //int[26] for Letters 'a' - 'z' or 'A' - 'Z'
    //int[128] for ASCII
    //int[256] for Extended ASCII
    public int lengthOfLongestSubstring(String s) {
        Integer[] chars = new Integer[128];

        int left = 0;
        int right = 0;

        int res = 0;
        while (right < s.length()) {
            char r = s.charAt(right);

            Integer index = chars[r];
            if (index != null && index >= left && index < right) {
                left = index + 1;
            }

            res = Math.max(res, right - left + 1);

            chars[r] = right;
            right++;
        }

        return res;
    }
}
