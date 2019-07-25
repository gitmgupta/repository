package test;

import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.DragAndDrop;

public class DragAndDropTest {
	public DragAndDropTest() {
		dragAndDrop = new DragAndDrop();
	}

	DragAndDrop dragAndDrop;

	@BeforeTest
	public void launchBrowser() {
		dragAndDrop.launchBrowser("Chrome");
		dragAndDrop.loadURLDragAndDrop();
	}

	@Test(enabled = false)
	public void test() {
		dragAndDrop.elementToBeDrag("Draggable 2");
		dragAndDrop.dropZone();
		dragAndDrop.dragAndDrop();
	}

	@Test
	public void test2() {
		dragAndDrop.switchToiFrame();
		WebElement source = dragAndDrop.elementToBeDrag("Item 1");
		WebElement target = dragAndDrop.elementToBeDrag("Item 2");
		System.out.println("Source: " + source);
		System.out.println("Traget: " + target);
		dragAndDrop.dragAndDrop();
	}

	@AfterMethod
	public void close() {
		dragAndDrop.closeBrowser();
	}

}
