package com.testng;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

public class Class02 {

	@Test(groups = { "functest" })
	public void testMethod1() {
		System.out.println("Class02 - Test Anotation 01");
	}

	@Test
	public void testMethod2() {
		System.out.println("Class02 - Test Anotation 02");
	}

	@AfterClass
	public void afterClass() {
		System.out.println("Class02 - After Class");
	}

	@BeforeClass
	public void beforeClass() {
		System.out.println("Class02 - before Class");
	}

	@BeforeGroups("functest")
	public void beforeGroup() {
		System.out.println("Class02 - Before Group");
	}

	@AfterGroups("functest")
	public void afterGroup() {
		System.out.println("Class02 - After Groups");
	}
}
