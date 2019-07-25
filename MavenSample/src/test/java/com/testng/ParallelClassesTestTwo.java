package com.testng;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ParallelClassesTestTwo {
	public WebDriver driver;

	@BeforeClass
	public void beforeClass() {
		long id = Thread.currentThread().getId();
		System.out.println("ParallelClassesTestTwo Before test-class. Thread id is: " + id);
		System.setProperty("webdriver.gecko.driver",
				"C:\\Users\\Manishkumarg\\eclipse-workspace\\MavenSample\\Excuteable\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("https://www.google.com/");
	}

	@Test
	public void testMethodOne() {
		long id = Thread.currentThread().getId();
		System.out.println("ParallelClassesTestTwo Sample test-method One. Thread id is: " + id);
	}

	@Test
	public void testMethodTwo() {
		long id = Thread.currentThread().getId();
		System.out.println("ParallelClassesTestTwo Sample test-method Two. Thread id is: " + id);
		driver.findElement(By.cssSelector("input[class^='gLFyf gsfi']")).sendKeys("selenium parallel execution");
		driver.findElement(By.cssSelector("input[class^='gLFyf gsfi']")).sendKeys(Keys.ENTER);
	}

	@AfterClass
	public void afterClass() {
		long id = Thread.currentThread().getId();
		System.out.println("ParallelClassesTestTwo After test-class. Thread id is: " + id);
		driver.quit();
	}
}
