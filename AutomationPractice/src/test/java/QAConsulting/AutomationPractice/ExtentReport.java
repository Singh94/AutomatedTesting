package QAConsulting.AutomationPractice;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import org.junit.Assert.*;

import static org.junit.Assert.*;

import java.io.File;

public class ExtentReport {
	
	String url = "http://automationpractice.com/index.php";
	
	private WebDriver driver;
	private AutomationPractice automation;
	
    private static ExtentReports report;
    private WebDriver webDriver;

    @BeforeClass
    public static void init() {
        report = new ExtentReports();
        String fileName = "MyReport" + ".html";
        String filePath = System.getProperty("user.dir") + File.separatorChar + fileName;
        report.attachReporter(new ExtentHtmlReporter(filePath));
    }

    @Before
    public void setUp() {
        webDriver = new ChromeDriver();
    }

    @After
    public void tearDown() {
        webDriver.quit();
    }

    @AfterClass
    public static void cleanUp() {
        report.flush();
    }

    @Test    
    public void createNewUserAccount() {
        ExtentTest test = report.createTest("Create New User Account");
        test.log(Status.INFO, "Create New User Account Test is Starting ");
        automation = PageFactory.initElements(driver, AutomationPractice.class);
        
        automation.createNewAccountTest(); 
    }
    
    @Test
    public void createNewItemBasket() {
    	ExtentTest test = report.createTest("Add Items To Basket");
        test.log(Status.INFO, "Add Items To Basket Test is Starting ");
        automation = PageFactory.initElements(driver, AutomationPractice.class);
        
        automation.createNewItemBasketTest();
    }

    @Test
    public void retrieveLostAccountPassword() {
    	ExtentTest test = report.createTest("Retrieve Lost Account Password");
        test.log(Status.INFO, "Add Items To Basket Test is Starting ");
        automation = PageFactory.initElements(driver, AutomationPractice.class);
        
        automation.retrieveLostAccountPasswordTest();
    }
    
    @Test
    public void colourFiltersFunction() {
    	ExtentTest test = report.createTest("Colour Filter");
        test.log(Status.INFO, "Colour Filter Test is Starting ");
        automation = PageFactory.initElements(driver, AutomationPractice.class);
        
        automation.colourFiltersFunctionTest();
    }
}
