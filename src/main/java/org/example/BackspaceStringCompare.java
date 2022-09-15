package org.example;

public class BackspaceStringCompare {

	public static void main(String[] args) {
		String s = "#ab#c";
		String t = "ad#c";
		System.out.println(backspaceCompare(s, t));
	}

	public static boolean backspaceCompare(String s, String t) {
		return makeString(s).equals(makeString(t));
	}

	public static String makeString(String s) {
		var stringA = "";
		for (var c : s.toCharArray()) {
			if (c == '#' && stringA.length() > 0) {
				var teste = stringA.length() - 1;
				stringA = stringA.substring(0, teste);
				continue;
			}

			if (c == '#') {
				continue;
			}
			stringA = stringA + c;
		}
		return stringA;
	}
}
