package test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.DownloadProgress;

public class DownloadProgressTest {
	public DownloadProgressTest() {
		downloadProgress = new DownloadProgress();
	}

	DownloadProgress downloadProgress;

	@BeforeTest
	public void launchBrowser() {
		downloadProgress.launchBrowser("Chrome");
		downloadProgress.loadURLDownloadProgress();
	}

	@Test(alwaysRun=true)
	public void switchToWindowAndGetTitle() {
		System.out.println("Test in download progress");
		downloadProgress.clickOnDownload();
		System.out.println(downloadProgress.downloadCheck());
		Assert.assertEquals(downloadProgress.downloadCheck(), true);
	}

	@AfterMethod
	public void close() {
		downloadProgress.closeBrowser();
	}

}
