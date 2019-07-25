package com.testng;

import org.testng.annotations.*;

import org.testng.annotations.Test;

public class DataProviderClass {

	@DataProvider(name = "data-provider")
	public static Object[][] dataProviderMethods() {
		return new Object[][] { { "data one" }, { "data two" } };
	}

	@Test(dataProvider = "data-provider")
	public void dataProviderMethod(String data) {
		System.out.println("Data provider example in same class: " + data);
	}
}
