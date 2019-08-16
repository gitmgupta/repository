package com.program;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;

public class HighestOccurCharInString {

	static TreeMap<Character, Integer> hashmap;

	public static void check1(String word) {
		char[] c = word.toCharArray();
		int count;

		for (int i = 0; i < word.length(); i++) {

		}
	}

	public static void check(String word) {
		char[] ch = word.toCharArray();
		hashmap = new TreeMap<Character, Integer>();

		for (char c : ch) {
			if (hashmap.containsKey(c)) {
				hashmap.put(c, hashmap.get(c) + 1);
			} else {
				hashmap.put(c, 1);
			}
		}
		System.out.println(hashmap);
		

	}

	public static void main(String[] args) {
		check("aaaaaaaaaaaabbbbbbbbbcddd");
	}

}
