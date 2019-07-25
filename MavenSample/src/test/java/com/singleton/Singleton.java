package com.singleton;

public class Singleton {
	private static Singleton single_instance = null;
	public String s;	
	public int count;

	private Singleton() {
		count++;
		s = "This is private Singleton construction";
	}

	public static Singleton getInstance() {
		if (single_instance == null) {
			single_instance = new Singleton();
		}
		return single_instance;
	}
}
