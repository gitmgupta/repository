package test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.AlertBox;

public class AlertBoxTest {

	public AlertBoxTest() {
		alertBox = new AlertBox();
	}

	AlertBox alertBox;

	@BeforeMethod
	public void launchBrowser() {
		alertBox.launchBrowser("Chrome");
		alertBox.loadURLAlertBox();
	}

	@Test(alwaysRun=true)
	public void testPositionData() throws InterruptedException {
		System.out.println("Test in Alert Box");
		alertBox.click_Alert_Box();
		System.out.println(alertBox.getAlertInAction("GetText", ""));
		alertBox.getAlertInAction("Accept", "");
		alertBox.click_Confirm_Box();
		System.out.println(alertBox.getAlertInAction("GetText", ""));
		alertBox.getAlertInAction("Dismiss", "");
		alertBox.click_Prompt_Box();
		// Working for firefox but not for chrome.
		alertBox.getAlertInAction("SendKeys", "Manish");
		alertBox.getAlertInAction("Accept", "");

	}

	@AfterMethod
	public void close() {
		alertBox.closeBrowser();
	}

}
