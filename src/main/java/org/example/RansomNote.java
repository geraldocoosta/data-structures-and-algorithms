package org.example;

import java.util.HashMap;

public class RansomNote {

	public static void main(String[] args) {

		System.out.println(canConstruct("a", "ba"));

	}

	public static boolean canConstruct(String ransomNote, String magazine) {
		if (ransomNote.length() > magazine.length() ) {
			return false;
		}

		var characterQtd = new HashMap<Character, Integer>();
		for (var c : magazine.toCharArray()) {
			characterQtd.put(c, characterQtd.getOrDefault(c, 0) + 1);
		}

		for (var c : ransomNote.toCharArray()) {
			Integer qtd = characterQtd.get(c);

			if (qtd == null || qtd - 1 < 0) {
				return false;
			} else {
				characterQtd.put(c, qtd - 1);
			}
		}
		return true;
	}

	public static boolean contains(String ransomNote, String magazine) {
		if (ransomNote.length() > magazine.length()) {
			return false;
		}

		for (int i = 0; i < magazine.length(); i++) {
			for (int j = 0; j < ransomNote.length(); j++) {
				if (ransomNote.charAt(i) != magazine.charAt(j)) {
					break;
				} else if (j + 1 == ransomNote.length()) {
					return true;
				}

			}
		}



		return false;
	}
}
