package com.program;

import java.util.Arrays;

public class Angram {
	static boolean status = true;

	public static boolean isAnagram(String s1, String s2) {

		if (s1.length() != s2.length()) {
			return false;
		} else {
			s1.trim();
			char[] ch1 = s1.toLowerCase().trim().toCharArray();
			char[] ch2 = s2.toLowerCase().trim().toCharArray();

			Arrays.sort(ch1);
			Arrays.sort(ch2);

			return status = Arrays.equals(ch1, ch2);
		}

	}

	public static void main(String[] args) {

		if (isAnagram("Nitin", "Nitin")) {
			System.out.println("Anagram");

		} else {
			System.out.println("Not Anagram");
		}
	}
}
