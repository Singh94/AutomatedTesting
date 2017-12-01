package QAConsulting.DemoQA.ToolTip;

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

import QAConsulting.DemoQA.Draggable.DraggablePage;
import junit.framework.*;

public class ToolTip {

	String url = "http://demoqa.com/tooltip/";
	
	private WebDriver driver;
	private ToolTipPage page;
	
	
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
	public void slider() {
		
		driver.navigate().to(url);
		page = PageFactory.initElements(driver, ToolTipPage.class);
		Actions builder = new Actions(driver);
		
		//Default Functionality
		builder.moveToElement(page.yourAgeToolTipLoc()).perform();
		
		
		
		
		driver.navigate().refresh();
		//Custom Animation
		page.customAnimationDemoClick();
		
		builder.moveToElement(page.openEventToolTip()).perform();
		
		
		
	}


	@After
	public void tearDown() {
		driver.quit();
	}

}

