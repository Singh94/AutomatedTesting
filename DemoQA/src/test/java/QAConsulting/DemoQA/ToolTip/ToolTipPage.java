package QAConsulting.DemoQA.ToolTip;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ToolTipPage {

	@FindBy(xpath = "//*[@id=\"age\"]")
	WebElement yourAgeToolTip;
	
	@FindBy(xpath = "//*[@id=\"ui-id-2\"]")
	WebElement customAnimationDemo;
	
	@FindBy(xpath = "//*[@id=\"open-event\"]")
	WebElement openEvent;

	public WebElement yourAgeToolTipLoc() {
		return yourAgeToolTip;
	}
	
	public WebElement openEventToolTip() {
		return openEvent;
	}
	
	public void customAnimationDemoClick() {
		customAnimationDemo.click();
	}
	
}

