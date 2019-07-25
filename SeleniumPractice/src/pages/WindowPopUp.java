package pages;

import java.util.Set;

import common.TestDriver;

public class WindowPopUp extends TestDriver {

	String twitter_loaction = "//a[text()='  Follow On Twitter ']";

	public void loadURLWindowPopUp() {
		String URL = "http://www.seleniumeasy.com/test/window-popup-modal-demo.html";
		loadURL(URL);
	}

	public void clickOnTwitter() {
		click(twitter_loaction);
	}

	public Set<String> getAllWindowID() {
		Set<String> windowIDs = getWindowsID();
		for (String windowId : windowIDs) {
			System.out.println("Windows ID are : " + windowId);
		}
		return windowIDs;
	}

	public String getTitleBySwitchWindow(String id) {
		switchWindow(id);
		return getWindowTitle();

	}
}
