package QAConsulting.DemoQA.Draggable;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DraggablePage {

	@FindBy(css = "#ui-id-1")
	private WebElement defaultFunctionality;
	
	@FindBy(css = "#ui-id-2")
	private WebElement constraintMovement;
	
	@FindBy(css = "#ui-id-3")
	private WebElement cursorStyle;
	
	@FindBy(css = "#tabs > ul > li:nth-child(4)")
	private WebElement events;
	
	@FindBy(css = "#ui-id-5")
	private WebElement draggableSortable;
	
	
	
	
	
	
	
	
	@FindBy(css = "#draggable")
	private WebElement draggableBox;
	
	@FindBy(xpath = "//*[@id=\"draggabl\"]/p")
	private WebElement verticalDrag;
	
	@FindBy(xpath = "//*[@id=\"draggabl2\"]/p")
	private WebElement horizontalDrag;

	@FindBy(xpath = "//*[@id=\"draggabl3\"]/p")
	private WebElement containedBox;
	
	@FindBy(xpath = "//*[@id=\"draggabl5\"]")
	private WebElement withinParent;
	
	@FindBy(xpath = "//*[@id=\"drag\"]/p")
	private WebElement cursorCentre;
	
	
	
	
	
	
	
	
	public int getDefaultFuncLoc() {
		return draggableBox.getLocation().getX();
	}
	
	public int getVerticalDragLoc() {
		return verticalDrag.getLocation().getY();
	}
	
	public int getHorizontalDragLoc() {
		return horizontalDrag.getLocation().getX();
	}
	
	public int getContainedBoxLoc() {
		return containedBox.getLocation().getX();
	}
	
	public int getWithinParentLoc() {
		return withinParent.getLocation().getY();
	}
	
	public Point getCursorCentreLoc() {
		return cursorCentre.getLocation();
	}
	
	
	
	
	
	
	public WebElement draggableBox() {
		return draggableBox;
	}
	
	public WebElement verticalDrag() {
		return verticalDrag;
	}
	
	public WebElement horizontalDrag() {
		return horizontalDrag;
	}
	
	public WebElement containedBox() {
		return containedBox;
	}
	
	public WebElement withinParent() {
		return withinParent;
	}
	
	public WebElement cursorCentre() {
		return cursorCentre;
	}
	
	
	
	
	
	
	
	
	
	
	public void clickDefaultFunc() {
		defaultFunctionality.click();
	}
	
	public void clickConstraintMovement() {
		constraintMovement.click();
	}
	
	public void clickCursorStyle() {
		cursorStyle.click();
	}
	
	public void clickEvents() {
		events.click();
	}
	
	public void clickdraggableSortable() {
		draggableSortable.click();
	}

	
}
