package QAConsulting.AutomationPractice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;

import com.google.common.base.Function;

public class AutomationPracticePage {
	
	@FindBy(xpath = "//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a")
	private WebElement signInButton;

	@FindBy(xpath = "//*[@id=\"email_create\"]")
	private WebElement emailAddressField;
	
	@FindBy(css = "#create_account_error > ol > li")
	private WebElement invalidEmailText;
	
	@FindBy(xpath = "//*[@id=\"SubmitCreate\"]/span")
	private WebElement createAccountButton;
	
	@FindBy(xpath = "//*[@id=\"noSlide\"]/h1")
	private WebElement createNewAccount;
	
	@FindBy(xpath = "//*[@id=\"customer_firstname\"]")
	private WebElement firstName;
	
	@FindBy(xpath = "//*[@id=\"customer_lastname\"]")
	private WebElement lastName;
	
	@FindBy(xpath = "//*[@id=\"passwd\"]")
	private WebElement password;
	
	@FindBy(xpath = "//*[@id=\"address1\"]")
	private WebElement address;
	
	@FindBy(xpath = "//*[@id=\"city\"]")
	private WebElement city;
	
	@FindBy(xpath = "//*[@id=\"id_state\"]")
	private WebElement stateValue;
	
	@FindBy(xpath = "//*[@id=\"postcode\"]")
	private WebElement postCode;

	@FindBy(css = "#id_country")
	private WebElement countryValue;
	
	@FindBy(xpath = "//*[@id=\"phone_mobile\"]")
	private WebElement phone;
	
	@FindBy(xpath = "//*[@id=\"submitAccount\"]/span")
	private WebElement registerButton;
	
	@FindBy(className = "page-heading")
	private WebElement accountCreated;
	
	@FindBy(xpath = "//*[@id=\"header\"]/div[2]/div/div/nav/div[2]/a")
	private WebElement signOut;
	
	public String getInvalidEmailText() {
		return invalidEmailText.getAttribute("value");
	}
	
	public String getCreateNewAccountText() {
		return createNewAccount.getText();
	}
	
	public String getAccountCreatedText() {
		return accountCreated.getText();
	}
	
	public void clickSignInButton() {
		signInButton.click();
	}
	
	public void clickEmailAddressField() {
		emailAddressField.click();
	}
	
	public void sendEmailKeys(String email) {
		emailAddressField.sendKeys(email);
	}
	
	public void clickCreateAccountButton() {
		createAccountButton.click();
	}
	
	public void sendFirstNameKeys(String firstNameKeys) {
		firstName.sendKeys(firstNameKeys);
	}
	
	public void sendLastNameKeys(String lastNameKeys) {
		lastName.sendKeys(lastNameKeys);
	}
	
	public void sendPasswordKeys(String passwordKeys) {
		password.sendKeys(passwordKeys);
	}
	
	public void sendAddressKeys(String addressKeys) {
		address.sendKeys(addressKeys);
	}
	
	public void sendCityKeys(String cityKeys) {
		city.sendKeys(cityKeys);
	}
	
	public void sendStateValue(String state) {
		Select selectStateValue = new Select(stateValue);
		selectStateValue.selectByVisibleText(state);
	}
	
	public void sendCountryValue(String country) {
		Select selectCountryValue = new Select(countryValue);
		selectCountryValue.selectByVisibleText(country);
	}
	
	public void sendPostCodeKeys(String postCodeKeys) {
		postCode.sendKeys(postCodeKeys);
	}
	
	public void sendPhoneKeys(String phoneKeys) {
		phone.sendKeys(phoneKeys);
	}
	
	public void clickRegisterButton() {
		registerButton.click();
	}
	
	public void clickSignOut() {
		signOut.click();
	}
	
	// <!----------------------------------------------------------------------------!> \\

	@FindBy(xpath = "//*[@id=\"email\"]")
	private WebElement loginEmail;
	
	@FindBy(xpath = "//*[@id=\"passwd\"]")
	private WebElement loginPassword;
	
	@FindBy(css = "#SubmitLogin > span")
	private WebElement loginButton;
	
	@FindBy(xpath = "//*[@id=\"center_column\"]/ul/li/a/span")
	private WebElement goHomeButton;
	
	@FindBy(xpath = "//*[@id=\"homefeatured\"]/li[1]/div/div[1]/div/a[1]/img")
	private WebElement clickOnItem;
	
	@FindBy(xpath = "//*[@id=\"quantity_wanted_p\"]/a[2]/span/i")
	private WebElement increaseItemQuantity;
	
	@FindBy(xpath = "//*[@id=\"add_to_cart\"]/button/span")
	private WebElement addToCartButton;
	
	@FindBy(css = "#layer_cart > div.clearfix > div.layer_cart_product.col-xs-12.col-md-6 > h2") 
	private WebElement itemIsInCart;
	
	@FindBy(xpath = "//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a/span")
	private WebElement proceedToCheckOut;
	
	public void sendLoginEmailKeys(String emailKeys) {
		loginEmail.sendKeys(emailKeys);
	}
	
	public void sendLoginPasswordKeys(String passwordKeys) {
		loginPassword.sendKeys(passwordKeys);
	}
	
	public void clickLogInButton() {
		loginButton.click();
	}
	
	public void clickGoHome() {
		goHomeButton.click();
	}
	
	public void clickOnItemToView() {
		clickOnItem.click();
	}
	
	public void clickToIncrease() {
		increaseItemQuantity.click();
	}
	
	public void clickAddToCartButton() {
		addToCartButton.click();
	}
	
	public String itemInCart() {
		return itemIsInCart.getText();
	}
	
	public void proceedToCheckout() {
		proceedToCheckOut.click();
	}
	
	// <!----------------------------------------------------------------------------!> \\
	
	@FindBy(xpath = "//*[@id=\"login_form\"]/div/p[1]/a")
	private WebElement forgotPasswordLink;
	
	@FindBy(xpath = "//*[@id=\"email\"]")
	private WebElement knownEmailForForgotPass;
	
	@FindBy(xpath = "//*[@id=\"form_forgotpassword\"]/fieldset/p/button/span")
	private WebElement retrievePass;
	
	@FindBy(css = "#center_column > div > p")
	private WebElement confirmationEmailSent;
	
	public void clickForgotPassword() {
		forgotPasswordLink.click();
	}
	
	public void sendKeysEmailForForgotPassword(String emailKeys) {
		knownEmailForForgotPass.sendKeys(emailKeys);
	}
	
	public void clickRetrievePass() {
		retrievePass.click();
	}
	
	public String confirmationEmailSent() {
		return confirmationEmailSent.getText();
	}
	
	// <!----------------------------------------------------------------------------!> \\
	
	
	@FindBy(xpath = "//*[@id=\"block_top_menu\"]/ul/li[1]/a")
	private WebElement clickOnWomenTab;
	
	@FindBy(xpath = "//*[@id=\"ul_layered_id_attribute_group_3\"]/li[5]/label/a")
	private WebElement clickOnBlueColourFilter;
	
	@FindBy(xpath = "//*[@id=\"center_column\"]/ul/li[2]/div/div[1]/div/a[1]/img")
	private WebElement filteredItemClick;
	
	@FindBy(css= "#color_14")
	private WebElement blueIsPresent;
	
	public void clickOnWomenTab() {
		clickOnWomenTab.click();
	}
	
	public void clickOnBlueColourFilter() {
		clickOnBlueColourFilter.click();
	}
	
	public void clickOnFiltersItemView() {
		filteredItemClick.click();
	}
	
	public String isBlueColourOnItem() {
		return blueIsPresent.getAttribute("name");
	}
	
	
	
	
	
	
	

	public void sleep(int time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
