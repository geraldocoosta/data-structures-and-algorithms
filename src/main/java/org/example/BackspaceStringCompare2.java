package org.example;

public class BackspaceStringCompare2 {

    public static void main(String[] args) {
        String s = "xywrrmp";
        String t = "xywrrmu#p";
        System.out.println(backspaceCompare(s, t));
    }

    public static boolean backspaceCompare(String s, String t) {
        var lengthS = s.length() - 1;
        var lengthT = t.length() - 1;
        var count = 0;

        while (lengthS >= 0 || lengthT >= 0) {
            while (lengthS >= 0 && (count > 0 || s.charAt(lengthS) == '#')) {
                if (s.charAt(lengthS) == '#') {
                    count++;
                } else {
                    count--;
                }

                lengthS--;
            }

            count = 0;
            while (lengthT >= 0 && (count > 0 || s.charAt(lengthT) == '#')) {
                if (s.charAt(lengthT) == '#') {
                    count++;
                } else {
                    count--;
                }
                lengthT--;
            }

            if (lengthS >= 0 && lengthT >= 0 && s.charAt(lengthT) == s.charAt(lengthS)) {
                lengthT--;
                lengthS--;
            } else {
                break;
            }
        }

        return lengthS == -1 && lengthT == -1;
    }
}
