package QAConsulting.DemoQA.Slider;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SliderPage {

	@FindBy(xpath = "//*[@id=\"slider-range-max\"]/span")
	private WebElement sliderBox;
	
	@FindBy(xpath = "//*[@id=\"amount1\"]")
	private WebElement numberOfBedrooms;
	
	
	public int getSliderLocation() {
		return sliderBox.getLocation().getX();
	}
	
	public WebElement slider() {
		return sliderBox;
	}
	
	public String getNumberOfBedrooms() {
		return numberOfBedrooms.getAttribute("value");
	}
	
	
}

