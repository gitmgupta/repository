package com.program;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.activation.MailcapCommandMap;

public class FindDuplicateCharacters {

	public static void printDuplicateCharacters(String word) {
		char[] ch = word.toCharArray();

		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for (Character c : ch) {
			if (map.containsKey(c)) {
				map.put(c, map.get(c) + 1);
			} else {
				map.put(c, 1);
			}
		}

		Set set = map.entrySet();
		Iterator itr = set.iterator();
		System.out.printf("List of duplicate characters in String '%s' %n", word);
		while (itr.hasNext()) {
			Map.Entry<Character, Integer> entry = (Map.Entry) itr.next();
			if (entry.getValue() > 1) {
				System.out.println(entry.getKey() + " : " + entry.getValue());
			}
		}
	}

	public static void main(String[] args) {
		printDuplicateCharacters("successes");
	}

}
