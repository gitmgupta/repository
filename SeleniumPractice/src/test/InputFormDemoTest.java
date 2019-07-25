package test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.InputFormDemo;

public class InputFormDemoTest {

	public InputFormDemoTest() {
		inputForm = new InputFormDemo();
	}

	InputFormDemo inputForm;


	@BeforeMethod
	public void launchBrowser() {
		inputForm.launchBrowser("firefOX");
		inputForm.loadURL();
	}

	@Test(priority = 1)
	public void withValidDetails() {
		inputForm.enterDetailsofContactUs();
		inputForm.clickOnSend();
	}

	@Test(priority = 2)
	public void withBlankFields() {
		inputForm.clickOnSend();
	}

	@AfterMethod
	public void tearDown() {
		inputForm.closeBrowser();
	}
}
