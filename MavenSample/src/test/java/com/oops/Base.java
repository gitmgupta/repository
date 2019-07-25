package com.oops;

import java.io.IOException;

class Base {
	
	String name;
	final static  int  speedlimit = 100;
	


	// Static method in base class which will be hidden in subclass
	public static void display() {
		System.out.println("Static or class method from Base");
	}

	public void BaseMethod() {
		System.out.println("base methods");
	}
	
	// Non-static method which will be overridden in derived class
	public void print() throws IOException  {
		System.out.println("Non-static or Instance method from Base");
	}
	
	public final void test(int str) {
		System.out.println("This is base class final method ");
	}
	
	
	public void test(float flo,String str1, int in) {
		System.out.println("Test" + flo + " " + str1 + " "+ in );
	}
}
