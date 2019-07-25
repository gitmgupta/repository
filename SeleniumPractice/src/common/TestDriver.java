package common;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestDriver {

	WebDriver driver;
	public int current_year = currentYear();

	/**
	 * @param browser,
	 *            Launch browser based on parameter
	 */
	public void launchBrowser(String browser) {
		try {
			switch (browser.toUpperCase()) {
			case "FIREFOX":
				System.out.println("Launching firefox browser");
				String firefoxDriver = "ExecutableFile/geckodriver.exe";
				System.setProperty("webdriver.gecko.driver", firefoxDriver);
				driver = new FirefoxDriver();
				break;
			case "CHROME":
				System.out.println("launching chrome browser");
				String chromeDriver = "ExecutableFile/chromedriver.exe";
				System.setProperty("webdriver.chrome.driver", chromeDriver);
				driver = new ChromeDriver();
				break;
			default:
				System.out.println("Not such browser found");
				break;
			}
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

	public void closeBrowser() {
		driver.close();
	}

	// *************************** Input Form Demo *******************************
	public void loadURL(String URL) {
		driver.get(URL);
	}

	public void sendKeys(String loaction, String value) {
		driver.findElement(By.xpath(loaction)).sendKeys(value);
	}

	public void selectValueFromDropdown(String loaction, String visibleText) {
		Select select = new Select(driver.findElement(By.xpath(loaction)));
		select.selectByVisibleText(visibleText);
	}

	public void click(String loaction) {
		driver.findElement(By.xpath(loaction)).click();
	}

	public String getText(String loaction) {
		return driver.findElement(By.xpath(loaction)).getText();
	}

	public WebElement webelement(String loaction) {
		return driver.findElement(By.xpath(loaction));
	}

	// *************************** DATE PICKER *******************************
	// Getting Current Date
	public int currentYear() {
		Calendar now = Calendar.getInstance();
		return now.get(Calendar.YEAR);
	}

	// Number of count to be clicked on previous button for years
	public int countToClickOnPerviousLinkForYear(String expected_year) {
		return (current_year - Integer.parseInt(expected_year)) / 10;

	}

	/**
	 * @param date:
	 *            Selecting date for the date picker
	 */
	public void selectDateFromdatePicker(String date) {
		WebElement datepicker_dates_loactions = driver.findElement(By.xpath("//html/body/div[3]/div[1]/table/tbody"));
		List<WebElement> datesLoactions = datepicker_dates_loactions.findElements(By.tagName("td"));
		for (WebElement dateLoaction : datesLoactions) {
			if (dateLoaction.getText().contains(date)) {
				dateLoaction.click();
				break;
			}
		}
	}

	// How to check the link is clickable or not?
	// Dyanmic xpath with css?

	/**
	 * @param month:
	 *            Selecting month for the date picker
	 */
	public void selectMonthFromDatePicker(String month) {
		WebElement datepicker_month_loactions = driver
				.findElement(By.xpath("//html/body/div[3]/div[2]/table/tbody/tr/td"));
		List<WebElement> monthsLoactions = datepicker_month_loactions.findElements(By.tagName("span"));
		for (WebElement monthLoaction : monthsLoactions) {
			if (monthLoaction.getText().contains(month.substring(0, 3))) {
				monthLoaction.click();
				break;
			}
		}
	}

	//
	/**
	 * @param year:
	 *            Selecting year for the date picker
	 */

	public void selectYearFromDatePicker(String year) {
		WebElement datepicker_year_loactions = driver
				.findElement(By.xpath("//html/body/div[3]/div[3]/table/tbody/tr/td"));
		List<WebElement> yearsLoactions = datepicker_year_loactions.findElements(By.tagName("span"));
		for (WebElement yearLoaction : yearsLoactions) {
			if (yearLoaction.getText().contains(year)) {
				yearLoaction.click();
				break;
			}

		}
	}

	public void selectDatesFromDatePicker(String date, String month, String year) {
		String actual_month_year = month.trim() + " " + year;

		// Loaction
		String textFieldofDatePicker = "//input[@class='form-control' and @placeholder='dd/mm/yyyy']";
		String datePickerLocationMonthYear = "//html/body/div[3]/div[1]/table/thead/tr[2]/th[2]";

		driver.findElement(By.xpath(textFieldofDatePicker)).click();
		String expected_month_year = driver.findElement(By.xpath(datePickerLocationMonthYear)).getText();

		// Comparing the month and year - If true, then click on date
		if (actual_month_year.equalsIgnoreCase(expected_month_year)) {
			selectDateFromdatePicker(date);
		} else {
			// Click on Month Year link
			driver.findElement(By.xpath(datePickerLocationMonthYear)).click();
			// Store the year
			String datePickerLoactionYear = "//html/body/div[3]/div[2]/table/thead/tr[2]/th[2]";
			String expected_year = driver.findElement(By.xpath(datePickerLoactionYear)).getText();

			// Comparing the year -if true, then click on month
			if (expected_year.equalsIgnoreCase(year)) {
				selectMonthFromDatePicker(month);
				selectDateFromdatePicker(date);
			} else {
				// Click on year link in date picker
				driver.findElement(By.xpath(datePickerLoactionYear)).click();
				// looping how much time to click on pervious button
				for (int i = 1; i <= countToClickOnPerviousLinkForYear(year); i++) {
					driver.findElement(By.xpath("//html/body/div[3]/div[3]/table/thead/tr[2]/th[1]")).click();
				}
				selectYearFromDatePicker(year);
				selectMonthFromDatePicker(month);
				selectDateFromdatePicker(date);
			}
		}

	}

	// **************************** Filter **************************************

	public int rowFilterCount(String tablepathtillTR) {
		int rowCount = driver.findElements(By.xpath(tablepathtillTR)).size();
		return rowCount;
	}

	public int rowIsDisplayed(String tablepathtillTR) {
		int count = 0;
		List<WebElement> elements = driver.findElements(By.xpath(tablepathtillTR));
		for (WebElement ele : elements) {
			if (ele.isDisplayed()) {
				count++;
			}
		}
		return count;
	}

	/**
	 * @param table
	 *            : Common path
	 * @param tagname
	 *            : Respective tag from which the value(getText()) is required
	 * @param value
	 *            : That need to be filter
	 * @return 1. Getting all the path(WebElement) and storing in List<WebElement>
	 *         2. Getting all the text of the WebElements 3. With the method
	 *         .contains search in the list whether the value is present or not 4.
	 *         if value is present then increase the counter until the looping of
	 *         list ends 5. return the total count
	 */
	public int getFilterdResult(String table, String tagname, String value) {
		int count = 0;
		for (int i = 1; i <= rowFilterCount(table); i++) {
			List<WebElement> username_data = driver.findElements(By.xpath(table + "[" + i + tagname));
			for (WebElement element : username_data) {
				if (element.getText().contains(value.toLowerCase())) {
					System.out.println(element.getText());
					count++;
				}
			}
		}
		return count;
	}

	// ********************************Sorting***************************************

	public int rowSortCount() {
		int rowCount = driver.findElements(By.xpath("//table[@id='example']/tbody/tr")).size();
		return rowCount;
	}

	public void isClickable(String loaction) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(loaction)));

	}

	/**
	 * @param table
	 * @param tagname
	 * @param nextButton
	 * @param paginationInfo
	 * @return 1. Getting all the path(web element) for particular column in a
	 *         List<WebElement> 2. Getting all the text of the web element and
	 *         sorting in List<String> 3. Condition : Check when to stop the while
	 *         loop - getting the pagination_info - Spiling the text and comparing
	 *         the condition - if, it is equal then stop the loop
	 */
	public List<String> getColoumnData(String table, String tagname, String nextButton, String paginationInfo) {
		boolean flag = true;

		List<WebElement> position_locations = null;
		List<String> position_data = new ArrayList<String>();
		while (flag == true) {
			for (int i = 1; i <= rowSortCount(); i++) {
				position_locations = driver.findElements(By.xpath(table + i + tagname));

				for (WebElement position : position_locations) {
					position_data.add(position.getText());
				}
			}

			WebElement next = driver.findElement(By.xpath(nextButton));
			WebElement pagination_info = driver.findElement(By.xpath(paginationInfo));
			String[] info = pagination_info.getText().split(" ");
			if (info[3].equals(info[5])) {
				flag = false;
			} else {
				next.click();
			}
		}
		refresh();
		return position_data;
	}

	public void refresh() {
		driver.navigate().refresh();
	}

	// **************************** dual-list-box **********************************

	public List<String> getlistValue(String loaction) {

		List<String> listValue = new ArrayList<String>();

		List<WebElement> listValuePath = driver.findElements(By.xpath(loaction));
		for (WebElement listValues : listValuePath) {
			listValue.add(listValues.getText());
		}
		return listValue;
	}

	public List<WebElement> getlistLoaction(String loaction) {
		List<WebElement> listValuePath = driver.findElements(By.xpath(loaction));
		return listValuePath;
	}

	public void movinglistGroupItem(String loaction, String value) {

		List<WebElement> elements = getlistLoaction(loaction);
		for (WebElement element : elements) {
			if (element.getText().equals(value)) {
				element.click();
				break;
			} else {
				System.out.println("Value not found in List group" + value);
			}
		}
	}

	// **************************** dual-list-box **********************************

	public Set<String> getWindowsID() {
		driver.getWindowHandle();
		Set<String> windowIDs = driver.getWindowHandles();
		return windowIDs;
	}

	public void switchWindow(String windowID) {
		driver.switchTo().window(windowID);
	}

	public void switchToParentWindow() {
		driver.switchTo().defaultContent();
	}

	public String getWindowTitle() {
		return driver.getTitle();
	}

	// **************************** Alert - box **********************************

	public String getAlertInAction(String action, String value) {
		Alert alert = driver.switchTo().alert();
		switch (action.toUpperCase()) {
		case "GETTEXT":
			return alert.getText();
		case "ACCEPT":
			alert.accept();
			break;
		case "DISMISS":
			alert.dismiss();
			break;
		case "SENDKEYS":
			alert.sendKeys(value);
			break;
		default:
			System.out.println("Please provide proper action for alert");
		}
		return action;
	}

	// ****************** Download progress *********************************

	public boolean waitForTextToPresent(String loaction, String value) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		return wait.until(ExpectedConditions.textToBePresentInElement(driver.findElement(By.xpath(loaction)), value));

	}
	// ****************** Drag and Drop *********************************

	public List<String> getItemToDrag() {
		return getlistValue("");
	}

	public void dragAndDrop() {
		WebElement source = driver.findElement(By.xpath("//html/body/ul/li[1]"));
		WebElement target = driver.findElement(By.xpath("//html/body/ul/li[2]"));
		Actions actions = new Actions(driver);
		actions.dragAndDrop(source, target).build().perform();

	}

	/**
	 * @param loaction
	 * @param value
	 * @return But passing visibility text, it will return the path of that element
	 */
	public WebElement itemToBeDrag(String loaction, String value) {

		List<WebElement> elements = getlistLoaction(loaction);
		System.out.println(elements.size());
		for (WebElement element : elements) {
			if (element.getText().equals(value)) {
				System.out.println(element);
				return element;
			} else {
				System.out.println("Value not found in List group : " + value);
			}
		}
		return null;
	}

	public void switchToiFrame() {
		WebElement iframe = driver.findElement(By.tagName("iframe"));
		System.out.println(driver.switchTo().frame(iframe));

	}
}
