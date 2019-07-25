package com.program;

public class RegexWithString {
	public static void main(String args[]) {
		String str = "P@ssw0rd!001";
		String specialCharater = str.replaceAll("[\\w]", "");
		System.out.println(specialCharater);
		String charachers = str.replaceAll("[^a-zA-z]", "");
		System.out.println(charachers);
		String digits = str.replaceAll("\\D", "");
		System.out.println(digits);
	}
}
