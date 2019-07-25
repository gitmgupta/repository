package com.oops;

public class ConstructorTest {
	protected ConstructorTest() {
		System.out.println("private Constructor");
	}
	

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
