package org.example;

public class BackspaceStringCompare2 {

    public static void main(String[] args) {
        String s = "ab#c";
        String t = "ad#c";
        System.out.println(backspaceCompare(s, t));
    }

    public static boolean backspaceCompare(String s, String t) {
        var sLength = s.length() - 1;
        var tLength = t.length() - 1;
        var countS = 0;
        var countT = 0;

        while (sLength >= 0 || tLength >= 0) {
            while (sLength >= 0 && (s.charAt(sLength) == '#' || countS > 0)) {
                if (s.charAt(sLength) == '#') {
                    countS++;
                } else {
                    countS--;
                }
                sLength--;
            }

            while (tLength >= 0 && (t.charAt(tLength) == '#' || countT > 0)) {
                if (t.charAt(tLength) == '#') {
                    countT++;
                } else {
                    countT--;
                }
                tLength--;
            }

            if (sLength >= 0 && tLength < 0 || sLength < 0 && tLength >= 0) {
                return false;
            }

            if (s.charAt(sLength) != t.charAt(tLength)) {
                return false;
            }

            sLength--;
            tLength--;

        }

        return true;
    }
}
