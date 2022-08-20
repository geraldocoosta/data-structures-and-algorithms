package org.example;

public class CountUniqueCharactersAllSubstringsGivenString {

    public static void main(String[] args) {
        System.out.println(uniqueLetterString("ABC"));
    }

    // Não entendi mas funciona
    public static int uniqueLetterString(String string) {
        int sum = 0;
        int curr = 0;
        int n = string.length();

        int[] last = new int[26];
        int[] prev = new int[26];

        for (int i = 0; i < last.length; i++) {
            last[i] = -1;
            prev[i] = -1;
        }

        char[] chars = string.toCharArray();
        for (int i = 0; i < n; i++) {
            char c = chars[i];
            int indexChar = c - 'A';

            curr += (i - last[indexChar] - 1) - (last[indexChar] - prev[indexChar]) + 1;
            prev[indexChar] = last[indexChar];
            last[indexChar] = i;
            sum += curr;
        }

        return sum;
    }

}


/*

Let's define a function countUniqueChars(s) that returns the number of unique characters on s.

For example, calling countUniqueChars(s) if s = "LEETCODE" then "L", "T", "C", "O", "D" are the unique characters since they appear only once in s, therefore countUniqueChars(s) = 5.
Given a string s, return the sum of countUniqueChars(t) where t is a substring of s. The test cases are generated such that the answer fits in a 32-bit integer.

Notice that some substrings can be repeated so in this case you have to count the repeated ones too.



Example 1:

Input: s = "ABC"
Output: 10
Explanation: All possible substrings are: "A","B","C","AB","BC" and "ABC".
Every substring is composed with only unique letters.
Sum of lengths of all substring is 1 + 1 + 1 + 2 + 2 + 3 = 10
Example 2:

Input: s = "ABA"
Output: 8
Explanation: The same as example 1, except countUniqueChars("ABA") = 1.
Example 3:

Input: s = "LEETCODE"
Output: 92


Constraints:

1 <= s.length <= 105
s consists of uppercase English letters only.



*/