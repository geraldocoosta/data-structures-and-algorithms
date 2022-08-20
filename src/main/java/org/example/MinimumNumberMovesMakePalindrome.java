package org.example;

public class MinimumNumberMovesMakePalindrome {

    public static void main(String[] args) {
        System.out.println(minMovesToMakePalindrome("aabaa"));
    }

    public static int minMovesToMakePalindrome(String s) {
        int res = 0;
        while (s.length() > 0) {
            int i = s.indexOf(s.charAt(s.length() - 1));
            if (i == s.length() - 1) res += i / 2;
            else {
                res += i;
                s = s.substring(0, i) + s.substring(i + 1);
            }
            s = s.substring(0, s.length() - 1);
        }
        return res;
    }
}
