package com.sampleproject.testyantra.genericutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.sampleproject.testyantra.pomrepositorylib.HomePage;
import com.sampleproject.testyantra.pomrepositorylib.LoginPage;

public class BaseClass {

	public WebDriver driver;
	public static WebDriver sDriver;
	public JavaUtility jLib = new JavaUtility();
	public WebDriverUtility wLib = new WebDriverUtility();
	public FileUtility fLib = new FileUtility();
	public ExcelUtility eLib = new ExcelUtility();
	public int randomInt = jLib.getRandomNumber();
	
	@Parameters("BROWSER")
	@BeforeClass(groups = {"smokeTest", "regressionTest"})
	public void configureBeforeClass(@Optional("chrome") String BROWSER) throws Throwable {
		//String BROWSER=fLib.getPropertyKeyValue("browser");
		if(BROWSER.equals("chrome")) {
			driver = new ChromeDriver();
		} else if(BROWSER.equals("firefox")){
			driver = new FirefoxDriver();
		} else if(BROWSER.equals("ie")){
			driver = new InternetExplorerDriver();
		}	else {
			driver = new ChromeDriver();
		}
		sDriver = driver;
		wLib.waitUntilPageLoad(driver);
		wLib.maximizeWindow(driver);	
	}
	
	@BeforeMethod(groups = {"smokeTest", "regressionTest"})
	public void configureBeforeMethod() throws Throwable {
		//Common data
		
		String URL = fLib.getPropertyKeyValue("url");
		String USERNAME = fLib.getPropertyKeyValue("username");
		String PASSWORD = fLib.getPropertyKeyValue("password");
		driver.get(URL);
		System.out.println("Login page displayed successfully");
		LoginPage login = new LoginPage(driver);
		login.login(USERNAME, PASSWORD);
		System.out.println("Home page displayed successfully");
	}
	
	@AfterMethod(groups = {"smokeTest", "regressionTest"})
	public void configureAfterMethod() {
		HomePage home = new HomePage(driver);
		home.logout();
		System.out.println("Logged out successfully");
	}
	
	@AfterClass(groups = {"smokeTest", "regressionTest"})
	public void configureAfterClass() {
		driver.quit();
	}

}
