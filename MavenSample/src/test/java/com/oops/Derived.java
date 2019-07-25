package com.oops;

class Derived extends Base {

	// This method hides display() in Base
	public static void display() {
		System.out.println("Static or class method from Derived");
	}

	// This method overrides print() in Base
	public void print() {
		System.out.println("Non-static or Instance method from Derived");
	}

	public void DerviedMethod() {
		System.out.println("Dervied methods");
	}

	public void test(double str) {
		Derived dri = new Derived();
		System.out.println("This is derived class final method " + Base.speedlimit );
	}
}
