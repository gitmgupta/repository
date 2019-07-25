package com.testng;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
//--
import org.testng.annotations.Test;

public class Class01 {

	// private WebDriver driver;

	@BeforeClass
	public void beforeClass() {
		System.out.println("Class01 - Before Class");
//		System.setProperty("webdriver.gecko.driver",
//				"C:\\Users\\Manishkumarg\\eclipse-workspace\\MavenSample\\Excuteable\\geckodriver.exe");
//		driver = new FirefoxDriver();
//		driver.manage().window().maximize();
	}

	@BeforeMethod
	public void beforeMethod() {
		System.out.println("Class01 - Before Method");
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("Class01 - After Method");
	}

	@BeforeTest
	public void beforeTest() {
		System.out.println("Class01 - Before Test");
	}

	@AfterTest
	public void afterTest() {
		System.out.println("Class01 - After Test");
	}

	@BeforeGroups("functest")
	public void beforeGroup() {
		System.out.println("Class01 - Before Group");
	}

	@AfterGroups("functest")
	public void afterGroup() {
		System.out.println("Class01 - After Groups");
	}

	@BeforeSuite
	public void beforeSuite() {
		System.out.println("Class01 - Before Suite");
	}

	@AfterSuite
	public void afterSuite() {
		System.out.println("Class01 - After Suite");
	}

	@AfterClass
	public void afterClass() {
		System.out.println("Class01 - After Class");
		// driver.quit();
	}

	@Test(enabled = true)
	@Parameters({ "username", "password" })
	public void paramertersExample(@Optional("manishkumarg") String username,@Optional("Test")String password) {
		System.out.println("Username is : " + username);
		System.out.println("Password is : " + password);
	}

	@Test(groups = { "functest" }, enabled = true)
	public void checktheTestAnotation() {
		System.out.println("Class01 - Test Anotation 01");
	}

	@Test(groups = { "functest" }, enabled = true)
	public void verifySearchButton() throws InterruptedException {
		System.out.println("Class01 - Test Anotation 02");
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//
//		driver.get("http://www.google.com");
//
//		String search_text = "Google Search";
//		WebElement search_button = driver.findElement(By.name("btnK"));
//
//		String text = search_button.getAttribute("value");
//		Thread.sleep(10000);
//		Assert.assertEquals(text, search_text, "Text not found!");
	}

	@Test(dataProvider = "data-provider", dataProviderClass = DataProviderClass.class, timeOut = 200)
	public void dataProviderMethod(String data) {
		System.out.println("Data provider example in different class : " + data);
		Assert.assertEquals("Test", "Test");
	}
}