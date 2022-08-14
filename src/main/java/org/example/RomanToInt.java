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
