package pages;

import common.TestDriver;

public class TableSearchFilter extends TestDriver {
	String FilterButton = "//html/body/div[2]/div/div[2]/div[2]/div/div/div/button";
	String ListedUserTable = "//html/body/div[2]/div/div[2]/div[2]/div/table/tbody";
	String usernameSearchField = "//html/body/div[2]/div/div[2]/div[2]/div/table/thead/tr/th[2]/input";
	String FirstNameSearchField = "//html/body/div[2]/div/div[2]/div[2]/div/table/thead/tr/th[3]/input";
	String LastNameSearchField = "//html/body/div[2]/div/div[2]/div[2]/div/table/thead/tr/th[4]/input";

	String commonTablepath = "//html/body/div[2]/div/div[2]/div[2]/div/table/tbody/tr";
	String tagname;

	public void loadURLTableSearchFilter() {
		String URL = "http://www.seleniumeasy.com/test/table-search-filter-demo.html";
		loadURL(URL);
	}

	public String getColoumnID(String coloumnName) {
		switch (coloumnName.toUpperCase()) {
		case "NUMBER":
			return tagname = "]/td[1]";
		case "USERNAME":
			return tagname = "]/td[2]";
		case "FIRSTNAME":
			return tagname = "]/td[3]";
		case "LASTNAME":
			return tagname = "]/td[4]";
		default:
			System.out.println("No such column found");
		}
		return "NO SUCH COLUMN PRESENT";

	}

	public void clickOnFilterButton() {
		click(FilterButton);
	}

	public void sendFilterUserName(String value) {
		sendKeys(usernameSearchField, value);
	}

	public void sendFilterFirstName(String value) {
		sendKeys(FirstNameSearchField, value);
	}

	public void sendFilterLastName(String value) {
		sendKeys(LastNameSearchField, value);
	}

	public int filterColumn(String columnName, String value) {
		tagname = getColoumnID(columnName);
		return getFilterdResult(commonTablepath, tagname, value);
	}
	
	public int actualFilterResult() {
		return rowIsDisplayed(commonTablepath);
	}

}
