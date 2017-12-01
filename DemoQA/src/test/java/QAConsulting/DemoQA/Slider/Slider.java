package QAConsulting.DemoQA.Slider;

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

public class Slider {

	String url = "http://demoqa.com/slider/";
	
	private WebDriver driver;
	private SliderPage page;
	
	
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
		page = PageFactory.initElements(driver, SliderPage.class);
		Actions builder = new Actions(driver);
		
		
		//Slider Functionality	
		builder.clickAndHold(page.slider()).moveByOffset(250,0).release().perform();
		 
		String currentLocation = page.getNumberOfBedrooms();
		String expectedLocation = "5";
		assertEquals(expectedLocation, currentLocation);
	}


	@After
	public void tearDown() {
		driver.quit();
	}

}

