package pages;

import java.util.ArrayList;

import java.util.Collections;

import java.util.List;

import common.TestDriver;

/**
 * @author ManishkumarG
 *
 */
public class TableSorting extends TestDriver {

	String coloumn_name = "//*[@id='example']/thead/tr/th[1]";
	String coloumn_position = "//*[@id='example']/thead/tr/th[2]";
	String coloumn_office = "//*[@id='example']/thead/tr/th[3]";
	String coloumn_age = "//*[@id='example']/thead/tr/th[4]";
	String coloumn_startdate = "//*[@id='example']/thead/tr/th[5]";
	String coloumn_salary = "//*[@id='example']/thead/tr/th[6]";

	String nextButton = "//a[@id='example_next']";
	String paginationInfo = "//*[@id='example_info']";
	String commonTablePath = "//table[@id='example']/tbody/tr[";
	String tagname;

	public void loadURLTableSorting() {
		String URL = "http://www.seleniumeasy.com/test/table-sort-search-demo.html";
		loadURL(URL);
	}

	public void clickOnColoumnName() {
		click(coloumn_name);
	}

	public void clickOnColumnPosition() {
		click(coloumn_position);
	}

	public void clickOnColumnAge() {
		click(coloumn_age);
	}

	public void clickOnColumnOffice() {
		click(coloumn_office);
	}

	public void clickOnColumnStartdate() {
		click(coloumn_startdate);
	}

	public void clickOnColumnSalary() {
		click(coloumn_salary);
	}

	/**
	 * @param coloumnName
	 * @return : Returning the tagname of the table's column
	 */
	public String getColoumnID(String coloumnName) {
		switch (coloumnName.toUpperCase()) {
		case "NAME":
			return tagname = "]/td[1]";
		case "POSITION":
			return tagname = "]/td[2]";
		case "OFFICE":
			return tagname = "]/td[3]";
		case "AGE":
			return tagname = "]/td[4]";
		case "STARTDATE":
			return tagname = "]/td[5]";
		case "SALARY":
			return tagname = "]/td[6]";
		default:
			System.out.println("No such column found");
		}
		return "NO SUCH COLUMN PRESENT";

	}

	/**
	 * @param coloumnName
	 * @return 
	 *  1. Getting the columnName and returning the tagname of the table's column
	 *  2. Getting the columnDate and storing in List by method getColoumnData();
	 *  3. Sorting in ascending order by using collections class
	 *  4. Returning sorting value as Expected result
	 */
	public List<String> expectedSortedList(String coloumnName) {

		tagname = getColoumnID(coloumnName);
		List<String> expectedSortedList = new ArrayList<String>();
		expectedSortedList = getColoumnData(commonTablePath, tagname, nextButton, paginationInfo);
		Collections.sort(expectedSortedList);
		System.out.println("Expected sorted result " + expectedSortedList);
		return expectedSortedList;
	}

	/**
	 * @param coloumnName
	 * @return 
	 * 1. Getting the columnName and returning the tagname of the table's column.
	 * 2. Getting the columnDate and storing in List by method getColoumnData();
	 * 3. Returning sorting value as actual result
	 */
	public List<String> actualSortedList(String coloumnName) {
		tagname = getColoumnID(coloumnName);
		List<String> actualSortedList = new ArrayList<String>();
		actualSortedList = getColoumnData(commonTablePath, tagname, nextButton, paginationInfo);
		System.out.println("Actual sorted result " + actualSortedList);
		return actualSortedList;

	}

}
