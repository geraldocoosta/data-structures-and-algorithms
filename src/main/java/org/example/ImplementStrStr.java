package org.example;

public class ImplementStrStr {

    public static void main(String[] args) {
        System.out.println(strStr("hello", "lo"));
    }

    //Time Complexity O(n * m) where n is length of haystack and m is length of needle
    //Space complexity O(1)
    public static int strStr(String haystack, String needle) {
        // empty needle appears everywhere, first appears at 0 index
        if (needle.length() == 0) {
            return 0;
        }
        if (haystack.length() == 0) {
            return -1;
        }


        for (int i = 0; i < haystack.length(); i++) {
            // no enough places for needle after i
            if (i + needle.length() > haystack.length()) {
                break;
            }

            // for em needle
            for (int j = 0; j < needle.length(); j++) {
                // compara char na posição i+j com o char na posição j do needle
                // i mais j é a posição do char que deve ser igual, porém no haystack
                if (haystack.charAt(i+j) != needle.charAt(j))
                    break;
                // se o j for igual ao tamanho do needle, então o needle foi encontrado dentro de haystack
                if (j == needle.length()-1)
                    return i;
            }
        }

        return -1;
    }
}


/*

 Implement strStr()

Implement strStr().

Given two strings needle and haystack, return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

Clarification:

What should we return when needle is an empty string? This is a great question to ask during an interview.

For the purpose of this problem, we will return 0 when needle is an empty string. This is consistent to C's strstr() and Java's indexOf().



Example 1:

Input: haystack = "hello", needle = "ll"
Output: 2
Example 2:

Input: haystack = "aaaaa", needle = "bba"
Output: -1


Constraints:

1 <= haystack.length, needle.length <= 104
haystack and needle consist of only lowercase English characters.


*/