package com.program;

import java.util.LinkedHashSet;
import java.util.Set;

public class DeleteDuplicateCharaters {

	public static void removeDulplicateCharaters(String word) {
		Set<Character> set = new LinkedHashSet<Character>();
		for (int i = 0; i < word.length(); i++) {
			set.add(word.charAt(i));
		}

		StringBuffer sb = new StringBuffer();
		for(char c: set) {
			sb.append(c);
		}
		System.out.println(sb.toString());
	}

	public static void main(String[] args) {
		removeDulplicateCharaters("communicate");
	}

}
