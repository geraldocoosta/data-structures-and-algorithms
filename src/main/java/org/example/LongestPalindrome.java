package org.example;

public class LongestPalindrome {

	public static void main(String[] args) {

		System.out.println(longestPalindrome("civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth"));
	}

	public static int longestPalindrome(String s) {
		int[] count = new int[128];

		for (var c : s.toCharArray()) {
			count[c]++;
		}

		var maxEven = 0;
		var sumOdd = 0;

		for (var value: count) {
			if (value % 2 == 0) {
				sumOdd += value;
			} else {
				if (value > maxEven) {
					var aux = maxEven;
					maxEven = value;
					sumOdd += aux > 0 ? aux - 1 : 0;
				} else {
					sumOdd += value > 0 ? value - 1 : 0;
				}
			}
		}

		return maxEven + sumOdd;
	}
}
