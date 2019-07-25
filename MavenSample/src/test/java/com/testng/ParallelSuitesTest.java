package com.testng;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Keyboard;
import org.testng.annotations.AfterClass;

import org.testng.annotations.BeforeClass;

import org.testng.annotations.Parameters;

import org.testng.annotations.Test;

public class ParallelSuitesTest {

	public WebDriver driver;

	@Parameters("browser")
	@BeforeClass
	// Passing Browser parameter from TestNG xml
	public void beforeTest(String browser) {

		// If the browser is Chrome, then do this

		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\Manishkumarg\\eclipse-workspace\\MavenSample\\Excuteable\\chromedriver.exe");
			driver = new ChromeDriver();
			// If browser is Firefox, then do this
		} else if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver",
					"C:\\Users\\Manishkumarg\\eclipse-workspace\\MavenSample\\Excuteable\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		// Doesn't the browser type, lauch the Website
		driver.get("https://www.google.com/");
	}

	// Once Before method is completed, Test method will start

	@Test
	public void login() throws InterruptedException {
		driver.findElement(By.cssSelector("input[class^='gLFyf gsfi']")).sendKeys("selenium parallel execution");
		driver.findElement(By.cssSelector("input[class^='gLFyf gsfi']")).sendKeys(Keys.ENTER);
	
	}
}