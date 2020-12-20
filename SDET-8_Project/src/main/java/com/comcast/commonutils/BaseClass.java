package com.comcast.commonutils;

import java.sql.SQLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.comcast.objectrepositorylib.Home;
import com.comcast.objectrepositorylib.Login;

public class BaseClass {
	public WebDriverUTils wLib = new WebDriverUTils();
	public FileUtility fLib = new FileUtility();
	public ExcelUtility elib = new ExcelUtility();
	public DataBaseUtilities dbLib = new DataBaseUtilities();
	public static WebDriver driver;
	
	
	@BeforeSuite(groups = {"SmokeTest", "RegressionTest"})
	public void configBeforeSuite() {
		System.out.println("====================Connect To DB========================");
		dbLib.connectToDB();
	}
	
	
	@BeforeClass(groups = {"SmokeTest", "RegressionTest"})
	public void configBeforeClass() throws Throwable {
		System.out.println("=========launch the browser==============");
		/*Common  Data*/
		String URL  = fLib.getPropertyKeyValue("url");

		String BROWSER  = fLib.getPropertyKeyValue("browser");

		 if(BROWSER.equals("chrome")) {
		    driver = new ChromeDriver();
		 }else if(BROWSER.equals("firefox")) {
			 driver = new FirefoxDriver();
		 }else if(BROWSER.equals("ie")) {
			 driver = new InternetExplorerDriver();
		 }else {
			 driver = new ChromeDriver(); 
		 }
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(URL);
	}
	
	//@Parameters("browser")
	//@BeforeClass(groups = {"SmokeTest", "RegressionTest"})
	public void configBeforeParllelClass(String BROWSER) throws Throwable {
		System.out.println("=========launch the browser==============");
		/*Common  Data*/
		String URL  = fLib.getPropertyKeyValue("url");


		 if(BROWSER.equals("chrome")) {
		    driver = new ChromeDriver();
		 }else if(BROWSER.equals("firefox")) {
			 driver = new FirefoxDriver();
		 }else if(BROWSER.equals("ie")) {
			 driver = new InternetExplorerDriver();
		 }else {
			 driver = new ChromeDriver(); 
		 }
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(URL);
	}
	
	
	@BeforeMethod(groups = {"SmokeTest", "RegressionTest"})
	public void cofigBeforeMtd() throws Throwable {
		System.out.println("=======login======");
		String USERNAME  = fLib.getPropertyKeyValue("username");
		String PASSWORD  = fLib.getPropertyKeyValue("password");
		
		/*step 1 : login to app*/
		Login lp = new Login(driver);
		lp.loginToApp(USERNAME, PASSWORD);
	}
	
	
	@AfterMethod(groups = {"SmokeTest", "RegressionTest"})
	public void configAfterMethode() {
		System.out.println("=======logout======");
		Home hp = new Home(driver);
		hp.logout();
		
	}
	  
	
	@AfterClass(groups = {"SmokeTest", "RegressionTest"})
	public void confifAfterClass() {
		System.out.println("=========close the browser==============");
		driver.quit();
	}

	@AfterSuite(groups = {"SmokeTest", "RegressionTest"})
	public void configAsterSuite() throws Throwable {
		System.out.println("====================DissConnect To DB========================");
		dbLib.closeDb();
	}
}
