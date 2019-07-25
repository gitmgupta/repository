package com.program;

import com.oops.ConstructorTest;

public class logical extends ConstructorTest {
	public logical() {
	}

	public static int reverseANumber(int number) {

		int reminder = 1234 % 10;
		int quotation = 1234 / 10;
		System.out.println("Remider: " + reminder);
		System.out.println("Quotation: " + quotation);

		int reversed = 0;
		while (number != 0) {
			int digit = number % 10;
			reversed = reversed * 10 + digit;
			number = number / 10;
		}

		return reversed;
	}

	public static String Palindrome(int number) {

		int reversed = 0;
		int originalInteger = number;

		while (number != 0) {
			int digit = number % 10;
			reversed = reversed * 10 + digit;
			number = number / 10;
		}

		if (originalInteger == reversed) {
			return "Number is Palindrome";
		} else {
			return "Number is not Palindrome";
		}

	}

	public static void ArmStrongNumber() {

	}

	public static void equal() {
		String S1 = "Manish";
		String S2 = "Manish";
		String S3 = new String("Manish");

		System.out.println(S1.equals(S3));
		System.out.println(S1 == S3);
	}

	public static void NULLPOINTEREXPECTION() {
		String S1 = null;
		System.out.println(S1.length());

	}

	public static void characterCount() {
		String str = "This is a string";
		int count = 0;
		System.out.println(str.length());
		for (int i = 0; i < str.length(); i++) {
			for (int j = i + 1; j < str.length(); i++) {
				if (str.charAt(i) == str.charAt(j)) {
					count++;
				}
			}
			System.out.println(str.charAt(i) + "repated count  it " + count);
		}
	}

	public static void main(String[] args) {
		// System.out.print(fileIO.reverseANumber(123456789));

		// System.out.println(fileIO.Palindrome(1254464));
		characterCount();
	}

}
