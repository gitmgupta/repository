package test;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.DualListBox;

public class DualListBoxTest {

	public DualListBoxTest() {
		dualListBox = new DualListBox();
	}

	DualListBox dualListBox;
	String value = "bootstrap-duallist";

	@BeforeMethod
	public void launchBrowser() {
		dualListBox.launchBrowser("Chrome");
		dualListBox.loadURLDualListBox();
	}

	@Test
	public void testPositionData() throws InterruptedException {
		dualListBox.movingAvailableListGroupItem(value);
		dualListBox.moveToSelectedList();
		List<String> selectedList = dualListBox.getSelectedList();
		List<String> avaiableList = dualListBox.getAvaiableList();
		Assert.assertEquals(selectedList.contains(value), true);
		Assert.assertEquals(avaiableList.contains(value), false);
	}

	@AfterMethod
	public void close() {
		dualListBox.closeBrowser();
	}
}
