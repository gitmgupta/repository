package com.program;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

public class StopAtOccurenceExists {

	public static void stopOccurence(String word) {
		char[] ch = word.toCharArray();
		for (int i = 0; i < word.length(); i++) {
			if (word.indexOf(ch[i]) == word.lastIndexOf(i)) {
				// return ch[i];
			}
		}
	}
	
	public static char getFirstNonRepeatedChar(String str) {
        Map<Character,Integer> counts = new LinkedHashMap<>(str.length());
        
        for (char c : str.toCharArray()) {
            counts.put(c, counts.containsKey(c) ? counts.get(c) + 1 : 1);
        }
        
        for (Entry<Character,Integer> entry : counts.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        throw new RuntimeException("didn't find any non repeated Character");
    }


	public static void stopOccurenceHM(String word) {
		Map<Character, Integer> hashmap = new LinkedHashMap<>();
		char[] ch = word.toCharArray();

		for (Character c : ch) {
			if (hashmap.containsKey(c)) {
				hashmap.put(c, hashmap.get(c) + 1);
			} else {
				hashmap.put(c, 1);
			}
		}

		for (Map.Entry<Character, Integer> entry : hashmap.entrySet()) {

			if (entry.getValue() == 1) {
				System.out.println(entry.getKey());
				break;
			}
		}

	}

	public static void StringConcept() {
		System.out.println("========== String  result ===========");

		String s = "Manish";
		String s1 = s;
		String s2 = new String("Manish");
		String s4 = new String("Manish");
		String s3 = s2;
		System.out.println(s == s1);
		System.out.println(s == s2);
		System.out.println(s1 == s2);
		System.out.println(s3 == s2);
		System.out.println(s2 == s4);
	}

	public static void StringBufferConcept() {

		System.out.println("========== String Buffer result ===========");
		StringBuffer sb1 = new StringBuffer("Manish");
		StringBuffer sb2 = new StringBuffer("Manish");
		StringBuffer sb3 = new StringBuffer("Suraj");
		StringBuffer sb4 = sb3;

		System.out.println(sb1 == sb2);
		System.out.println(sb1 == sb3);
		System.out.println(sb4 == sb3);

	}

	public static void main(String[] args) {
		String str = "honest";
		//stopOccurence(str);
		stopOccurenceHM(str);
		//getFirstNonRepeatedChar(str);

	}
}
