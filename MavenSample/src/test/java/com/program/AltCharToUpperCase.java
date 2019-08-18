package com.program;

import java.util.Scanner;

public class AltCharToUpperCase {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the value: ");
		String value = scan.next();
		String word = "";
		for (int i = 0; i < value.length(); i++) {
			char ch = value.charAt(i);
			if (i % 2 == 0) {
				ch = Character.toUpperCase(ch);
				word = word + ch;
			}
			System.out.println(word);
		}
	}
}
