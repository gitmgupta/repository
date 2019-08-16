package com.collection;

import java.util.*;

import org.seleniumhq.jetty9.http.PathMap.MappedEntry;

public class SetTest {

	// hash set doesn't support replace
	public static void HashSetTest() {
		HashSet<String> hashset = new HashSet<String>();
		hashset.add("Manish");
		hashset.add("28");
		hashset.add(null);
		hashset.add("Manish");
		// hashset.add(0, "Replace");

		Iterator iterator = hashset.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		System.out.println(hashset.size());
	}
	
	public static void TreeSetTest() {
		TreeSet<String> treeSet = new TreeSet<String>();
		treeSet.add("Manish");
		treeSet.add("Suchi");
		treeSet.add("Bharat");
		treeSet.add("Mandar");
		treeSet.add("Ritesh");
		
		Iterator iterator = treeSet.iterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}
	

	public static void main(String[] args) {
		HashSetTest();
		TreeSetTest();
	}
}
