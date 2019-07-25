package test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.TableSorting;

public class TableSortingTest {

	public TableSortingTest() {
		tableSorting = new TableSorting();
	}

	TableSorting tableSorting;

	@BeforeMethod
	public void launchBrowser() {
		tableSorting.launchBrowser("Chrome");
		tableSorting.loadURLTableSorting();
	}

	@Test
	public void testSortingForPosition() throws InterruptedException {
		tableSorting.expectedSortedList("Office");
		tableSorting.refresh();
		tableSorting.clickOnColumnOffice();
		tableSorting.actualSortedList("Office");
	}

	@AfterMethod
	public void close() {
		tableSorting.closeBrowser();
	}
}
