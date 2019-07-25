package pages;

import common.TestDriver;

public class AlertBox extends TestDriver {

	String click_Alert_Box = "//*[@id='easycont']/div/div[2]/div[1]/div[2]/button";
	String click_Confirm_Box = "//*[@id='easycont']/div/div[2]/div[2]/div[2]/button";
	String click_Prompt_Box = "//*[@id='easycont']/div/div[2]/div[3]/div[2]/button";

	public void loadURLAlertBox() {
		String URL = "http://www.seleniumeasy.com/test/javascript-alert-box-demo.html";
		loadURL(URL);
	}

	public void click_Alert_Box() {
		click(click_Alert_Box);
	}

	public void click_Confirm_Box() {
		click(click_Confirm_Box);
	}

	public void click_Prompt_Box() {
		click(click_Prompt_Box);
	}

}
