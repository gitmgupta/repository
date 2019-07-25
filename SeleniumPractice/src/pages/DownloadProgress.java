package pages;

import common.TestDriver;

public class DownloadProgress extends TestDriver {

	String download = "//*[@id='cricle-btn']";
	String loaction = "//*[@id='circle']/div/div[1]";
	String value = "100%";

	public void loadURLDownloadProgress() {
		String URL = "http://www.seleniumeasy.com/test/bootstrap-download-progress-demo.html";
		loadURL(URL);
	}

	public void clickOnDownload() {
		click(download);
	}

	public boolean downloadCheck() {
		return waitForTextToPresent(loaction, value);
	}

}
