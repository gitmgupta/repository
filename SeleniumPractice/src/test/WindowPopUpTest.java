package test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.WindowPopUp;

public class WindowPopUpTest {

	public WindowPopUpTest() {
		windowPopUp = new WindowPopUp();
	}

	WindowPopUp windowPopUp;

	@BeforeTest
	public void launchBrowser() {
		windowPopUp.launchBrowser("Chrome");
		windowPopUp.loadURLWindowPopUp();
	}

	@Test
	public void switchToWindowAndGetTitle() {
		windowPopUp.clickOnTwitter();
		windowPopUp.getAllWindowID();
		Set<String> set = windowPopUp.getAllWindowID();
		for (String b : set) {
			Map<String, String> map = new HashMap<String, String>();
			map.put(b, windowPopUp.getTitleBySwitchWindow(b));
			System.out.println(map);
		}

	}

	@AfterMethod
	public void close() {
		windowPopUp.closeBrowser();
	}

}
