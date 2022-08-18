package org.example;

public class IntegerToEnglishWords2 {

    public static void main(String[] args) {
        System.out.println(new IntegerToEnglishWords2().numberToWords(123));

    }

    static final String[] TENS = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    static final String[] ONES = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven",
            "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};

    public String numberToWords(int num) {
        if (num == 0)
            return "Zero";

        return helper(num).trim();
    }

    private String helper(int num) {

        if (num >= 1000000000) {
            return (helper(num / 1000000000) + " Billion " + helper(num % 1000000000));
        }
        if (num >= 1000000) {
            return (helper(num / 1000000) + " Million " + helper(num % 1000000));
        }
        if (num >= 1000) {
            return (helper(num / 1000) + " Thousand " + helper(num % 1000));
        }
        if (num >= 100) {
            return (helper(num / 100) + " Hundred " + helper((num % 100))).trim();
        }
        if (num >= 20) {
            return (TENS[num / 10] + " " + helper(num % 10)).trim();
        }
        return ONES[num];
    }
}

/*
Integer to English Words

Convert a non-negative integer num to its English words representation.



Example 1:

Input: num = 123
Output: "One Hundred Twenty Three"
Example 2:

Input: num = 12345
Output: "Twelve Thousand Three Hundred Forty Five"
Example 3:

Input: num = 1234567
Output: "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"


Constraints:

0 <= num <= 231 - 1







*/