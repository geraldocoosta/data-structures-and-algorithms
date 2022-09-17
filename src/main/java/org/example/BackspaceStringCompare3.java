package org.example;

import java.util.LinkedList;

public class BackspaceStringCompare3 {

    public static void main(String[] args) {

        String s = "abb##c";
        String t = "ad#c";
        System.out.println(backspaceCompare(s, t));
    }

    	public static boolean backspaceCompare(String s, String t) {
    		return build(s).equals(build(t));
    	}

    	public static String build(String s) {
    		LinkedList<Character> ans = new LinkedList<>();
    		for (char c: s.toCharArray()) {
    			if (c != '#'){
    				ans.push(c);
                } else if (!ans.isEmpty()) {
    				ans.pop();
                }
    		}

            StringBuilder stringBuilder = new StringBuilder();
            while (!ans.isEmpty()) {
                stringBuilder.append(ans.pop());
            }
            return stringBuilder.toString();
    	}

}
