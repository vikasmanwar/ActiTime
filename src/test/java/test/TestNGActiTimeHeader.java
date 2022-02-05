package test;


import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import pom.ActiTimeHeader;
import pom.LoginPage;
import utils.Utility;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.BeforeClass;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import base.Base;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;




public class TestNGActiTimeHeader extends Base {
	
	private int testId;
	WebDriver driver;
	ActiTimeHeader actiTimeHeader;
	LoginPage loginPage;
	SoftAssert softAssert;
	static ExtentTest test;
	static ExtentHtmlReporter reporter;
	
	@BeforeTest
	@Parameters("browser")
	public void launchBrowser(String browser) {
		reporter = new ExtentHtmlReporter("test-output"+File.separator+"ExtendReport"+File.separator+"extendReport.html");
		ExtentReports extend = new ExtentReports();
		extend.attachReporter(reporter);
		
		if(browser.equals("chrome")) 
		{
			driver = Base.openChromeDriver();
		}
		if(browser.equals("firefox"))
		{
			driver = Base.openFirefoxDriver();
		}
		if(browser.equals("opera"))
		{
			driver = Base.openOperaDriver();
		}
		if(browser.equals("edge"))
		{
			driver = Base.openEdgeDriver();
		}
		
		//driver.get("http://localhost/login.do");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	@BeforeClass
	public void initiationPomClasses(){
		System.out.println("initiationPomClasses");
		actiTimeHeader = new ActiTimeHeader(driver);
		loginPage = new LoginPage(driver);
	
 
	}
	
	@BeforeMethod
	public void launchActiTime() throws EncryptedDocumentException, IOException{
		System.out.println("LaunchActiTime");
		driver.get("http://localhost/login.do");
		loginPage.sendUser();
		loginPage.sendPassword();
		loginPage.clickOnLoginButton();
	
		softAssert = new SoftAssert();
	}
	
	@Test
	public void toVerifyUserTab(){
		testId= 101;
		System.out.println("toVerifyUserTab");
		actiTimeHeader.clickOnUser();
		String url = driver.getCurrentUrl();
		System.out.println(url);
		AssertJUnit.assertEquals(url, "http://localhost/administration/userlist.do");

	}
	
	@Test
	public void toVerifyReportTab() {
		testId= 102;
		System.out.println("toVerifyReportTab");
		actiTimeHeader.clickOnReport();
		String url = driver.getCurrentUrl();
		System.out.println(url);
//		if (url.equals("http://localhost/reports/reports.do"))
//		{
//			System.out.println("PASS");
//		}
//		else {
//			System.out.println("FAIL");
//		}
		
		// here we used Soft Assert
		AssertJUnit.assertEquals(url, "http://localhost/reports/reports.do");
		softAssert.assertAll();
	}
	
	@Test
	public void toVerifyTaskTab() {
		testId = 103;
		System.out.println("toVerifyTaskTab");
		actiTimeHeader.clickOntask();
		String url = driver.getCurrentUrl();
		System.out.println(url);
//		if (url.equals("http://localhost/tasks/otasklist.do"))
//		{
//			System.out.println("PASS");
//		}
//		else {
//			System.out.println("FAIL");
//		}
		
		
		AssertJUnit.assertEquals(url, "http://localhost/tasks/otasklist.do");
		
	}
	
	@AfterMethod
	public void logoutFromActiTime(ITestResult result) throws IOException{
		System.out.println("logoutFromActiTime");
		
		if(ITestResult.FAILURE == result.getStatus())
		{
		Utility.saveScreenshot(driver, testId);
		}
		
		actiTimeHeader.clickOnLogout();
	}
	
	@AfterClass
	public void clearObjects(){
		System.out.println("ClearObjects");
		
		actiTimeHeader = null;
		loginPage = null;
	
	}
	
	@AfterTest
	public void afterClass() {
		System.out.println("ClosedBrowser");
		driver.quit();
		driver = null;
		
		System.gc();
	}
}
