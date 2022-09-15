package org.example;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class BackspaceStringCompare3 {

	public static void main(String[] args) {
		String s = "ab#c";
		String t = "ad#c";
		System.out.println(backspaceCompare(s, t));
	}

	public static boolean backspaceCompare(String S, String T) {
		return build(S).equals(build(T));
	}

	public static String build(String S) {
		LinkedList<Character> ans = new LinkedList<>();
		for (char c: S.toCharArray()) {
			if (c != '#')
				ans.push(c);
			else if (!ans.isEmpty())
				ans.pop();
		}
		return String.valueOf(ans);
	}
}
