package org.example;

public class AddBinary {

	public static void main(String[] args) {

		System.out.println(addBinary("1111", "11"));
	}

	public static String addBinary(String a, String b) {
		String res = "";
		int i = a.length() - 1;
		int j = b.length() - 1;
		int carry = 0;
		while(i >= 0 || j >= 0){
			int sum = carry;
			if(i >= 0) sum += a.charAt(i--) - '0';
			if(j >= 0) sum += b.charAt(j--) - '0';
			carry = sum > 1 ? 1 : 0;
			res = sum % 2 + res;
		}
		if(carry != 0) {
			res = carry + res;
		}
		return res;
	}
}
