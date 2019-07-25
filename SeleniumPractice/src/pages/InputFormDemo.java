package pages;

import common.TestDriver;

public class InputFormDemo extends TestDriver {

	TestDriver td;
	String FirstName = "//input[@name='first_name']";
	String LastName = "//input[@name='last_name']";
	String EmailAddress = "//input[@name='email']";
	String Phone = "//input[@name='phone']";
	String Address = "//input[@name='address']";
	String City = "//input[@name='city']";
	String State = "//select[@name='state']";
	String ZipCode = "//input[@name='zip']";
	String Website = "//input[@name='website']";
	String HostingYes = "//input[@value='yes']";
	String ProjectDescription = "//textarea[@name='comment']";
	String Send = "//button[text()='Send ']";
	// =============================

	public InputFormDemo() {
		// TestDriver testdriver = new TestDriver();
		// td.launchBrowser("Chrome");
		// td.driver
		// td = new TestDriver();
	}

	public void loadURL() {

		String URL = "http://www.seleniumeasy.com/test/input-form-demo.html";
		loadURL(URL);
	}

	public void enterDetailsofContactUs() {

		sendKeys(FirstName, "Manishkumar");
		sendKeys(LastName, "Gupta");
		sendKeys(EmailAddress, "manishkumar.gupta@citiustech.com");
		sendKeys(Phone, "9664160519");
		sendKeys(Address, "Bhandup West");
		sendKeys(City, "Mumbai");
		selectValueFromDropdown(State, "Indiana");
		sendKeys(ZipCode, "40007");
		sendKeys(Website, "myseleniumpratice.com");
		click(HostingYes);
		sendKeys(ProjectDescription, "Pratice Selenium");
	}

	public void clickOnSend() {
		click(Send);
	}

}
