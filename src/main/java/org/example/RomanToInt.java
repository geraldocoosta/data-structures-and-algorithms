package org.example;

import java.util.HashMap;

public class RomanToInt {

    public static void main(String[] args) {
        System.out.println(romanToInt("MMCMXCIV"));
    }

    // Time complexity : O(1).
    // As there is a finite set of roman numerals, the maximum number possible number can be 3999,
    // which in roman numerals is MMMCMXCIX. As such the time complexity is O(1).
    //
    // If roman numerals had an arbitrary number of symbols,
    // then the time complexity would be proportional to the length of the input, i.e. O(n).
    // This is assuming that looking up the value of each symbol is O(1).
    //
    //Space complexity : O(1).
    // Because only a constant number of single-value variables are used, the space complexity is O(1)O(1).
    public static int romanToInt(String s) {
        HashMap<String, Integer> romanToIntDict = getRomanToIntDict();

        int sum = 0;
        int i = 0;
        while (i < s.length()) {
            String currentSymbol = s.substring(i, i + 1);
            int currentValue = romanToIntDict.get(currentSymbol);
            int nextValue = 0;

            if (i + 1 < s.length()) {
                String nextSymbol = s.substring(i + 1, i + 2);
                nextValue = romanToIntDict.get(nextSymbol);
            }

            // Se o simbolo da minha direita de I for maior que o simbolo da I
            // quer dizer que é um simbolo duplo, e que o tenho que diminuir o valor de I do da direita de I
            if (currentValue < nextValue) {
                sum += (nextValue - currentValue);
                i += 2;
            } else {
                // Se não, é só somar
                sum += currentValue;
                i += 1;
            }

        }
        return sum;
    }

    private static HashMap<String, Integer> getRomanToIntDict() {
        HashMap<String, Integer> romanToIntDict = new HashMap<>();
        romanToIntDict.put("M", 1000);
        romanToIntDict.put("D", 500);
        romanToIntDict.put("C", 100);
        romanToIntDict.put("L", 50);
        romanToIntDict.put("X", 10);
        romanToIntDict.put("V", 5);
        romanToIntDict.put("I", 1);
        return romanToIntDict;
    }
}

/*
Roman to Integer

Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.

Symbol       Value
I             1
V             5
X             10
L             50
C             100
D             500
M             1000
For example, 2 is written as II in Roman numeral, just two ones added together. 12 is written as XII, which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.

Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:

I can be placed before V (5) and X (10) to make 4 and 9.
X can be placed before L (50) and C (100) to make 40 and 90.
C can be placed before D (500) and M (1000) to make 400 and 900.
Given a roman numeral, convert it to an integer.



Example 1:

Input: s = "III"
Output: 3
Explanation: III = 3.
Example 2:

Input: s = "LVIII"
Output: 58
Explanation: L = 50, V= 5, III = 3.
Example 3:

Input: s = "MCMXCIV"
Output: 1994
Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.


Constraints:

1 <= s.length <= 15
s contains only the characters ('I', 'V', 'X', 'L', 'C', 'D', 'M').
It is guaranteed that s is a valid roman numeral in the range [1, 3999].






*/