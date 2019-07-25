package test;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.TableSearchFilter;

public class TableSearchFilterTest {

	public TableSearchFilterTest() {
		tableSearchFilter = new TableSearchFilter();
	}

	TableSearchFilter tableSearchFilter;
	String value = "ko";

	@BeforeMethod
	public void launchBrowser() {
		tableSearchFilter.launchBrowser("chrome");
		tableSearchFilter.loadURLTableSearchFilter();
	}

	@Test(priority = 1)
	public void withValidDetails() {
		int expected_result = tableSearchFilter.filterColumn("FirstName", value);
		System.out.println(expected_result);
		tableSearchFilter.clickOnFilterButton();
		tableSearchFilter.sendFilterFirstName(value);
		int actual_result = tableSearchFilter.actualFilterResult();
		assertEquals(actual_result, expected_result);
	}

	@AfterMethod
	public void tearDown() {
		tableSearchFilter.closeBrowser();
	}

}
