package test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.BootstrapDatePickers;

public class BootstrapDatePickerTest {

	public BootstrapDatePickerTest() {
		bootstrapDatePickers = new BootstrapDatePickers();
	}

	BootstrapDatePickers bootstrapDatePickers;

	@BeforeMethod
	public void init() {
		bootstrapDatePickers.launchBrowser("Chrome");
		bootstrapDatePickers.loadDatePickerURL();
	}

	@Test(alwaysRun=true)
	public void selectDate() throws InterruptedException {
		System.out.println("Test Date");
		bootstrapDatePickers.selectTodaysDate();
		bootstrapDatePickers.selectDatesFromDatePicker("4", "January", "1986");
	}
	
	@AfterMethod
	public void closeBrowser() {
		bootstrapDatePickers.closeBrowser();
	}
}
