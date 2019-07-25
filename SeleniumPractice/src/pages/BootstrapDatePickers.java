package pages;

import common.TestDriver;

public class BootstrapDatePickers extends TestDriver {

	String textFieldFfDatePicker = "//input[@class='form-control' and @placeholder='dd/mm/yyyy']";
	String today = "//html/body/div[3]/div[1]/table/tfoot/tr[1]/th";

	public void loadDatePickerURL() {
		String URL = "http://www.seleniumeasy.com/test/bootstrap-date-picker-demo.html";
		loadURL(URL);
	}

	public void selectTodaysDate() {
		click(textFieldFfDatePicker);
		click(today);

	}

	public void selectCustomizeDate(String date, String month, String year) {
		selectDatesFromDatePicker(date, month, year);

	}

}
