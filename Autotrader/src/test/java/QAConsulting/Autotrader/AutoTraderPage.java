package QAConsulting.Autotrader;

import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class AutoTraderPage {

	@FindBy(xpath = "//*[@id=\"js-header-nav\"]/ul/li[5]/div/a")
	private WebElement signInButton;
	
	@FindBy(xpath = "//*[@id=\"js-social__signup-tab\"]/span")
	private WebElement signUpButton;
	
	@FindBy(css = "#email")
	private WebElement newSignUpEmail;
	
	@FindBy(css = "#password")
	private WebElement newSignUpPassw;
	
	@FindBy(css = "social--signup--submit")
	private WebElement signUpNowButton;
	
	
	public void clickSignInButton() {
		signInButton.click();
	}
	
	public void clickSignUpButton() {
		signUpButton.click();
	}
	
	public void sendKeysNewSignUpEmail(String emailKeys) {
		newSignUpEmail.sendKeys(emailKeys);
	}
	
	public void sendKeysNewSignUpPassw(String passwKeys) {
		newSignUpPassw.sendKeys(passwKeys);
	}
	
	public void clickSignUpNowButton() {
		signUpNowButton.click();
	}
	
	// <!----------------------------------------------------------------------------!> \\
	
	@FindBy(css = "#postcode")
	private WebElement enterPostcode;
	
	@FindBy(css = "#searchVehiclesCount")
	private WebElement searchCarsButton;
	
	@FindBy(css = "#radius")
	private WebElement distance;
	
	
	
	@FindBy(xpath = "/html/body/main/section[1]/div[1]/form/div/div/h1")
	private WebElement carsFound;
	
	public void clickEnterPostcode() {
		enterPostcode.click();
	}
	
	public void selectDistance() {
		Select distanceSelect = new Select(distance);
		distanceSelect.selectByIndex(1);
	}
	
	
	public void sendKeysPostCode(String postCodeKeys) {
		enterPostcode.sendKeys(postCodeKeys);
	}
	
	public void clickSearchCarsButton() {
		searchCarsButton.click();
	}
	
	public String carsFoundText() {
		return carsFound.getText();
	}
	
	// <!----------------------------------------------------------------------------!> \\
	
	@FindBy(xpath = "/html/body/main/div/section[1]/a/figure/div/img")
	private WebElement whatsItWorth;
	
	@FindBy(xpath = "/html/body/main/div/section[1]/div[2]/div/form/p/a")
	private WebElement selectByMakeModel;
	
	@FindBy(css = "#mmMakeSelect")
	private WebElement selectMake;
	
	@FindBy(css = "#mmModelSelect")
	private WebElement selectModel;
	
	@FindBy(css = "#mmVariantSelect")
	private WebElement selectVariant;
	
	@FindBy(css = "#mmDerivativeSelect")
	private WebElement selectDerivative;
	
	@FindBy(xpath = "/html/body/main/div/section[1]/div/form/div[9]/div/div")
	private WebElement selectRegDate;
	
	@FindBy(xpath = "/html/body/div[3]/div/div[1]/div[7]")
	private WebElement selectYear;
	
	@FindBy(xpath = "/html/body/div[3]/div/div[2]/div[9]")
	private WebElement selectMonth;	
	
	@FindBy(css = "#mmMileageEntry")
	private WebElement enterMileage;
	
	@FindBy(xpath = "/html/body/main/div/section[1]/div/form/button/span")
	private WebElement clickGetVal;
	
	public void clickWhatsItWorth() {
		whatsItWorth.click();
	}
	
	public void clickSelectByMakeModel() {
		selectByMakeModel.click();
	}
	
	public void selectMake(String makeSelect) {
		Select makeSelector = new Select(selectMake);
		makeSelector.selectByVisibleText(makeSelect);
	}
	
	public void selectModel(String modelSelect) {
		Select modelSelector = new Select(selectModel);
		modelSelector.selectByVisibleText(modelSelect);
	}
	
	public void selectVariant() {
		Select variantSelector = new Select(selectVariant);
		variantSelector.selectByIndex(4);
	}
	
	public void selectDerivative() {
		Select derivativeSelector = new Select(selectDerivative);
		derivativeSelector.selectByIndex(1);
	}
	
	public void selectRegDate() {
		selectRegDate.click();
	}
	
	public void clickyear() {
		selectYear.click();
	}
	
	public void clickMonth() {
		selectMonth.click();
	}
	
	public Point regDateGetLoc() {
		return selectRegDate.getLocation();
	}
	
	public void enterMileage(String mileageKeys) {
		enterMileage.sendKeys(mileageKeys);
	}
	
	public void clickGetValuation() {
		clickGetVal.click();
	}

	
	
	// <!----------------------------------------------------------------------------!> \\
	
	public void sleep(int time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
