package org.example;

public class FirstUniqChar {


    public static void main(String[] args) {
        System.out.println(new FirstUniqChar().firstUniqChar("ihaaaai"));
    }

    public int firstUniqChar(String s) {
        int[] count = new int[26];
        int n = s.length();
        for (int i = 0; i < n; i++) {
            int c = s.charAt(i) - 'a';
            count[c]++;
        }

        // find the index
        for (int i = 0; i < s.length(); i++) {
            if (count[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }
}
