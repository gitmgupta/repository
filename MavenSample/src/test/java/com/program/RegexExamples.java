package com.program;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class RegexExamples {
	public void regexSample() {
		String str = "dgfgfga";
		String patternMatcher = "a+";
		int count = 0;
		Pattern pattern = Pattern.compile(patternMatcher);
		Matcher matcher = pattern.matcher(str);
		while (matcher.find()) {
			count++;
			System.out.print(matcher.start());
			System.out.print(" " + matcher.group());

			System.out.println();

		}
		System.out.println("Number of occurence: " + count);
	}

	public static void patternSplitMethod() {
		String str = "My Name is Manish";
		Pattern pattern = Pattern.compile("a");
		String[] args = pattern.split(str);
		for (String s : args) {
			System.out.println(s);
		}

	}

	public static void patternSplitMethod2() {
		String str = "www.mywebsite.com";
		Pattern pattern = Pattern.compile("[.]");
		String[] args = pattern.split(str);
		for (String s : args) {
			System.out.println(s);
		}

	}

	public static void validPhoneNumber(String phoneNumber) {
		Pattern pattern = Pattern.compile("(0|91)?[7-9][0-9]{9}");
		Matcher matcher = pattern.matcher(phoneNumber);
		if (matcher.find()) {
			System.out.println("true");
		} else {
			System.out.println("false");
		}
	}

	public static boolean validEmailAddress(String emailAddress) {
		// manish@gmail.com
		Pattern pattern = Pattern.compile("[\\w][\\w]*@[\\w]+([.][a-zA-Z]+)+");
		Matcher matcher = pattern.matcher(emailAddress);
		if (matcher.find()) {
			return true;
		} else {
			return false;
		}
	}

	public static void onlyVowels() {
		Pattern pattern = Pattern.compile("\\g[aeiou]");
		Matcher matcher = pattern.matcher("dsfaba ksdvbaav eioukjsd askn");
		if (matcher.find()) {
			System.out.println(matcher.start());
			System.out.println(matcher.group());
		}
	}

	public static int countVowelsRegex() {
		int count = 0;
		String str = " Counts the number of vowels in a given string using a Regular Expression pattern matching scheme.";
		if (str.length() > 0) {
			// Create a pattern that detects vowels.
			Pattern vowelPattern = Pattern.compile("(//gmi)[aeiou]");
			Matcher vowelMatcher = vowelPattern.matcher(str);
			System.out.println("Total string lenght: " + str.length());
			// Look for the next match and if found, add to count and repeat.
			while (vowelMatcher.find())
				vowelMatcher.start();
			count++;
			System.out.println("Total Vowel  Count: " + count);
		}

		return count;
	}

	public static void findTestUsingRegex() {
		String str = "Hello test chalo test tata test why test when test";
		String findStr = "test";
		int innerCount = 0;
		Pattern pattern = Pattern.compile(findStr);
		Matcher matcher = pattern.matcher(str);
		while (matcher.find()) {
			innerCount++;
		}
		System.out.println(innerCount);
	}

	public static void main(String[] args) {
		// System.out.println(validEmailAddress("durga_acjp.123@gmail.com"));
//		System.out.println(countVowelsRegex());
//		System.out.println();
//		String str = " Counts the number of vowels in a given string using a Regular Expression pattern matching scheme.";
//		String s = str.replaceAll("[^aeiouAEIOU]", "").replaceAll("\\s", "");
//		System.out.println(s);
//		System.out.println(s.length());.
		findTestUsingRegex();

	}
}
