package QAConsulting.Autotrader;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import sun.security.util.*;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;



public class AutoTrader {
	
	private static ExtentReports report;
	private SpreadSheetReader reader = new SpreadSheetReader("autoTraderData.xlsx");
	private String url = "https://www.autotrader.co.uk/";
	private WebDriver driver;
	
	private AutoTraderPage page;
	
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
	public void signUpTest() {
		
		driver.navigate().to(url);
		
		page = PageFactory.initElements(driver, AutoTraderPage.class);
		Actions builder = new Actions(driver);
		
		page.clickSignInButton();
		page.sleep(100);
		page.clickSignUpButton();
		page.sendKeysNewSignUpEmail(reader.input(1, 0));
		page.sendKeysNewSignUpPassw(reader.input(1, 1));
		page.sleep(100);
		page.clickSignUpButton();
		page.sleep(100);
	}
	
	@Test //WORKS
	public void quickSearchForCars() {
		
		driver.navigate().to(url);
		
		page = PageFactory.initElements(driver, AutoTraderPage.class);
		//Actions builder = new Actions(driver);
		
		page.sleep(3000);
		page.clickEnterPostcode();
		page.sendKeysPostCode("M50 2TJ");
		page.sleep(100);
		page.clickSearchCarsButton();
		page.sleep(1000);
	
		String carsFound = page.carsFoundText();
		
		assertEquals(true, carsFound.contains("cars found"));
	}
	
	@Test  // REQUIRES ACCOUNT
	public void valueOfCar() {
		
		driver.navigate().to(url);
		
		page = PageFactory.initElements(driver, AutoTraderPage.class);
		Actions builder = new Actions(driver);
		
		page.clickWhatsItWorth();
		page.clickSelectByMakeModel();
		page.sleep(100);
		page.selectMake("AUDI");
		page.sleep(100);
		page.selectModel("A4");
		page.sleep(100);
		page.selectVariant();
		page.sleep(100);
		page.selectDerivative();
		page.sleep(1000);
		page.selectRegDate();
		page.sleep(1000);
		page.clickyear();
		page.sleep(100);
		page.clickMonth();
		page.enterMileage("25000");
		page.clickGetValuation();
		page.sleep(1000);		
		
		
	}

	
	
		
	@Test
	public void findLocalDealer() {
		throw new PendingException("Test Not Implemented");
	}

	@Test
	public void regCheck() {
		throw new PendingException("Test Not Implemented");
		//find if stolen, written off or outstanding finance
	}
	
	@Test
	public void signInTest() {
		throw new PendingException("Test Not Implemented");
	}
	
	@Test
	public void getInsuranceQuote() {
		throw new PendingException("Test Not Implemented");
	}
	
	@Test
	public void findDrivingInstructor() {
		throw new PendingException("Test Not Implemented");
	}
	
	@Test
	public void detailedSearch() {
		throw new PendingException("Test Not Implemented");
	}
	
	@Test
	public void getWarranty() {
		throw new PendingException("Test Not Implemented");
	}
	
	
	
	@After
	public void tearDown() {
		driver.quit();
		//BrowserFactory.closeAllDriver();
	}

}
