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
