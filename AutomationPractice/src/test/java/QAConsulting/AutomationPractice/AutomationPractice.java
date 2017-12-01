package QAConsulting.AutomationPractice;

import static org.junit.Assert.*;

import java.io.File;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.google.common.base.Function;

public class AutomationPractice {
	
	private static ExtentReports report;
	private BrowserFactory browser;
	
	private SpreadSheetReader reader = new SpreadSheetReader("testData.xlsx");
	
	private String url = "http://automationpractice.com/index.php";
	
	private WebDriver driver;
	private AutomationPracticePage page;
	private String expectedString = null;
	private String returnedString = null;
	
	private String temp1 = null;
	private String temp2 = null;
	
	private String phoneNumber = null;
	
	 @BeforeClass
	 public static void init() {
		 report = new ExtentReports();
	     String fileName = "MyReport" + ".html";
	     String filePath = System.getProperty("user.dir") + File.separatorChar + fileName;
	     report.attachReporter(new ExtentHtmlReporter(filePath));
	 }
	
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
	public void createNewAccountTest() {		
		
		driver.navigate().to(url);
		
		page = PageFactory.initElements(driver, AutomationPracticePage.class);
		Actions builder = new Actions(driver);
		
		// Validate email Address Entered - Invalid Email \\
		page.clickSignInButton();
		page.clickEmailAddressField();
		
		page.sleep(100);
		page.sendEmailKeys("email");
		page.clickCreateAccountButton();
		page.sleep(100);
		
		assertEquals(expectedString, returnedString);
		
		
		driver.navigate().refresh();
		// Validate email Address Entered - Valid Email \\
		page.clickEmailAddressField();
				
		page.sendEmailKeys(reader.input(1, 3));
		page.clickCreateAccountButton();
		page.sleep(5000);
				
		expectedString = "CREATE AN ACCOUNT";
		returnedString = page.getCreateNewAccountText();
		
		page.sleep(1000);
		assertEquals(expectedString, returnedString);
		// Valid Email - New Account \\
		
		temp1 = (reader.input(1, 10).substring(0, 1));
		temp2 = (reader.input(1, 10).substring(2, 11));
		phoneNumber = (temp1 += temp2);		
		
		page.sendFirstNameKeys(reader.input(1, 1));
		page.sendLastNameKeys(reader.input(1, 2));
		page.sendPasswordKeys(reader.input(1, 4));
		page.sendAddressKeys(reader.input(1, 5));
		page.sendCityKeys(reader.input(1, 6));
		page.sendStateValue(reader.input(1, 7));
		page.sendPostCodeKeys(reader.input(1, 8).substring(0, 5));
		page.sendCountryValue(reader.input(1, 9));
		page.sendPhoneKeys(phoneNumber);
		page.sleep(100);
		page.clickRegisterButton();
		page.sleep(1000);
		
		expectedString = "MY ACCOUNT";
		returnedString = page.getAccountCreatedText();
		assertEquals(expectedString, returnedString);
		
		page.clickSignOut();
	}
	
	@Test
	public void createNewItemBasketTest() {
		
		driver.navigate().to(url);
		
		page = PageFactory.initElements(driver, AutomationPracticePage.class);
		Actions builder = new Actions(driver);
		
		temp1 = (reader.input(2, 10).substring(0, 1));
		temp2 = (reader.input(2, 10).substring(2, 11));
		phoneNumber = (temp1 += temp2);	

		page.clickSignInButton();
		page.sleep(100);
		page.clickEmailAddressField();
		page.sendEmailKeys(reader.input(2, 3));
		page.clickCreateAccountButton();
		page.sleep(5000);
		page.sendFirstNameKeys(reader.input(2, 1));
		page.sendLastNameKeys(reader.input(2, 2));
		page.sendPasswordKeys(reader.input(2, 4));
		page.sendAddressKeys(reader.input(2, 5));
		page.sendCityKeys(reader.input(2, 6));
		page.sendStateValue(reader.input(2, 7));
		page.sendPostCodeKeys(reader.input(2, 8).substring(0, 5));
		page.sendCountryValue(reader.input(2, 9));
		page.sendPhoneKeys(phoneNumber);
		page.sleep(100);
		page.clickRegisterButton();
		page.sleep(1000);
		page.clickSignOut();
		page.sleep(1000);
		
		page.sendLoginEmailKeys(reader.input(2, 3));
		page.sendPasswordKeys(reader.input(2, 4));
		page.sleep(5000);
		page.clickLogInButton();
		page.sleep(100);
		page.clickGoHome();
		page.sleep(100);
		
		page.clickOnItemToView();
		page.clickToIncrease();
		page.clickAddToCartButton();
		page.sleep(5000);
		
		expectedString = "Product successfully added to your shopping cart";
		returnedString = page.itemInCart();
		
		page.proceedToCheckout();
		page.sleep(5000);
		
		assertEquals(expectedString, returnedString);
	}
	
	@Test
	public void retrieveLostAccountPasswordTest() {
		
		driver.navigate().to(url);
		
		page = PageFactory.initElements(driver, AutomationPracticePage.class);
		Actions builder = new Actions(driver);
		
		page.sleep(100);
		page.clickSignInButton();
		page.sleep(100);
		page.clickForgotPassword();
		page.sleep(100);
		page.sendKeysEmailForForgotPassword(reader.input(2, 3));
		page.clickRetrievePass();
		page.sleep(100);
		
		expectedString = "A confirmation email has been sent to your address: ";
		returnedString = page.confirmationEmailSent();
		
		assertEquals(expectedString, returnedString);
		
	}
	
	@Test
	public void colourFiltersFunctionTest() {
		driver.navigate().to(url);
		
		page = PageFactory.initElements(driver, AutomationPracticePage.class);
		Actions builder = new Actions(driver);
		
		page.clickOnWomenTab();
		page.sleep(2000);
		page.clickOnBlueColourFilter();
		page.sleep(2000);
		page.clickOnBlueColourFilter();
		page.sleep(1000);
		
		page.clickOnFiltersItemView();
		page.sleep(1000);
		
		expectedString = "Blue";
		returnedString = page.isBlueColourOnItem();
		
		assertEquals(expectedString, returnedString);
		
	}
	
	@After
	public void tearDown() {
		driver.quit();
		//BrowserFactory.closeAllDriver();
	}
	
	
	
}
