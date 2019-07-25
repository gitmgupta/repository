package pages;

import org.openqa.selenium.WebElement;

import common.TestDriver;

public class DragAndDrop extends TestDriver {
	String listToDarg = "//*[@id='todrag']/span";
	String drag_Zone = "//*[@id='mydropzone']";

	String place = "//html/body/ul/li";

	public void loadURLDragAndDrop() {
		//String URL = "http://www.seleniumeasy.com/test/drag-and-drop-demo.html";
		String URL1 = "https://jqueryui.com/sortable/";
		loadURL(URL1);
	}

	public WebElement elementToBeDrag(String value) {
		return itemToBeDrag(place, value);
	}

	public WebElement dropZone() {
		return webelement(drag_Zone);

	}

}
