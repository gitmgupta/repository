package test;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pages.AlertBox;

@Listeners(listenersPackage.ListenersTest.class)

public class AlertBoxTest {
	static Logger logger = Logger.getLogger(AlertBoxTest.class);

	// Logger log = Logger.getLogger("devpinoyLogger");
	public AlertBoxTest() {
		alertBox = new AlertBox();
	}

	AlertBox alertBox;

	@BeforeClass
	public void launchBrowser() {
		alertBox.launchBrowser("Chrome");
		alertBox.loadURLAlertBox();
	}

	@Test(enabled = true)

	public void testPositionData() throws InterruptedException {
	//	PropertyConfigurator.configure("log4j.properties");
		logger.debug("Log4j appender configuration is successful !!");
		logger.warn("Test Warn");
		logger.error("Test Error");
		logger.fatal("Test fatal");
		logger.info("Test info");
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

	@Test
	public void testexample() {
		System.out.println("Second test method fail");
		Assert.assertEquals("Manish", "Manish");
	}

	@Test(dependsOnMethods = { "testexample" }, enabled = false)
	public void testExample2() {
		System.out.println("Second test method skipped");
	}

	@Test(retryAnalyzer = listenersPackage.RetryAnalyzer.class)
	public void TestExample3() {
		Assert.assertEquals(false, true);
	}

	@AfterClass
	public void close() {
		alertBox.closeBrowser();
	}

}
