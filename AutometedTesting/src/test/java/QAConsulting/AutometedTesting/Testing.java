package QAConsulting.AutometedTesting;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class Testing {		

	String url = "http://www.thedemosite.co.uk/";
	
	private WebDriver driver;
	private HomePage home;
	private AddUserPage addUser;
	private LoginPage login;
	private String username = "Username";
	private String password = "Password";
	
	
	@Before
	public void setUp() {
		driver = new ChromeDriver();
	}
	
	@Test
	public void demoSiteTest() {
		driver.navigate().to(url);
		
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
		
	}
	
	@After
	public void tearDown() {
		driver.quit();
	}

	@AfterClass
	public static void destroy() {
		
	}
}
