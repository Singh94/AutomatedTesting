package QAConsulting.DemoQA.Draggable;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import junit.framework.*;

public class Draggable {

	String url = "http://demoqa.com/draggable/";
	
	private WebDriver driver;
	private DraggablePage page;
	int currentLocation;
	int expectedLocation;
	
	
	@Before
	public void setUp() {
		driver = new ChromeDriver();
		JavascriptExecutor js;
		if (driver instanceof JavascriptExecutor) {
		    js = (JavascriptExecutor)driver;
		} else {
		    throw new IllegalStateException("This driver does not support JavaScript!");
		}
	}
	
	@Test
	public void draggable() {
		
		driver.navigate().to(url);
		page = PageFactory.initElements(driver, DraggablePage.class);
		Actions builder = new Actions(driver);
		
		// Default Functionality
		page.clickDefaultFunc();
		
		int a = page.getDefaultFuncLoc();
	    builder.clickAndHold(page.draggableBox()).moveByOffset(150,0).release().perform();

		currentLocation = page.getDefaultFuncLoc();
		expectedLocation =  a + 150;
		assertEquals(expectedLocation, currentLocation);
		
				
		
		
		driver.navigate().refresh();
		//Constraint Movement - Vertical
		page.clickConstraintMovement();
		
		int b = page.getVerticalDragLoc();	
		builder.clickAndHold(page.verticalDrag()).moveByOffset(0, 158).release().perform();
		
		currentLocation = page.getVerticalDragLoc();
		expectedLocation = b + 158;
		assertEquals(expectedLocation, currentLocation);
		
		
		
		//Constraint Movement - Horizontal
		int c = page.getHorizontalDragLoc();
		
		builder.clickAndHold(page.horizontalDrag()).moveByOffset(158, 0).release().perform();
		
		currentLocation = page.getHorizontalDragLoc();
		expectedLocation = c + 158;
		assertEquals(expectedLocation, currentLocation);
		
		
		
		//Constraint Movement - Within Box
		int d = page.getContainedBoxLoc();
		
		builder.clickAndHold(page.containedBox()).moveByOffset(503, 0).release().perform();
		
		currentLocation = page.getContainedBoxLoc();
		expectedLocation = d + 503;
		assertEquals(expectedLocation, currentLocation);
		
		
		
		//Constraint Movement - Within Parent
		int e = page.getWithinParentLoc();
		
		builder.clickAndHold(page.withinParent()).moveByOffset(0, 64).release().perform();
		
		currentLocation = page.getWithinParentLoc();
		expectedLocation = (e - 64) - 1;
		assertEquals(expectedLocation, currentLocation);
		
		
		
		
		driver.navigate().refresh();
		//Cursor Style - Centre
		page.clickCursorStyle();
		
		int xPos = page.getCursorCentreLoc().getX();
		int yPos = page.getCursorCentreLoc().getY();
		
		Point f = page.getCursorCentreLoc();
		
		builder.clickAndHold(page.cursorCentre()).moveByOffset(150, 150).release().release().perform();
		
		
		
		
		
	}


	@After
	public void tearDown() {
		driver.quit();
	}

}

