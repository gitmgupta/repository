package pages;

import java.util.List;

import common.TestDriver;

public class DualListBox extends TestDriver {

	String avaiableListBox = "//html/body/div[2]/div/div[2]/div/div[1]/div/ul/li";
	String selectedListBox = "//html/body/div[2]/div/div[2]/div/div[3]/div/ul/li";

	String move_right = "//html/body/div[2]/div/div[2]/div/div[2]/button[2]";
	String move_left = "//html/body/div[2]/div/div[2]/div/div[2]/button[1]";

	public void loadURLDualListBox() {
		String URL = "http://www.seleniumeasy.com/test/bootstrap-dual-list-box-demo.html";
		loadURL(URL);
	}

	public List<String> getAvaiableList() {
		List<String> avaiablelist = getlistValue(avaiableListBox);
		return avaiablelist;
	}

	public List<String> getSelectedList() {
		List<String> selectedList = getlistValue(selectedListBox);
		return selectedList;
	}

	public void moveToSelectedList() {
		click(move_right);
	}

	public void moveToAvaiableList() {
		click(move_left);
	}

	public void movingAvailableListGroupItem(String value) {
		movinglistGroupItem(value, avaiableListBox);
	}

	public void movingSelectedListGroupItem(String value) {
		movinglistGroupItem(value, selectedListBox);
	}
	
	public void verifyList() {
		
		
	}

}
