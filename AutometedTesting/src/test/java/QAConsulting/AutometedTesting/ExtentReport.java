package QAConsulting.AutometedTesting;

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
	
	String url = "http://www.thedemosite.co.uk";
	
	private WebDriver driver;
	private HomePage home;
	private AddUserPage addUser;
	private LoginPage login;
	private String username = "Username";
	private String password = "Password";
	
    private static ExtentReports report;
    private WebDriver webDriver;

    @BeforeClass
    public static void init() {
        report = new ExtentReports();
        String fileName = "MyReport" + ".html";
        String filePath = System.getProperty("user.dir")
                + File.separatorChar + fileName;
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
    public void MyFirstTestReportTest() {
        ExtentTest test = report.createTest("MyFirstTest");
        test.log(Status.INFO, "My First Test is Starting ");
                
        home = PageFactory.initElements(driver, HomePage.class);
		addUser = PageFactory.initElements(driver, AddUserPage.class);
		login = PageFactory.initElements(driver, LoginPage.class);
        
		home.clickAddUserLink();
		addUser.setUsernameTextfield(username);
		addUser.setPasswordTextField(password);
		addUser.clickSaveUser();	
		login.setUsernameTextField(username);
		login.setPasswordTextField(password);
		login.clickLoginButton();
        
        
//        for (int i = 0; i < 100; i++) {
//            test.log(Status.DEBUG, "On iteration: " + i); 
//        }
        
        try {
        	assertEquals("Error", url, "http://www.thedemosite.co.uk/");
        	test.pass("Pass");
        }
        catch (AssertionError e) {
        	test.fail("Fail");
        	   throw e;
        }
    }

}
