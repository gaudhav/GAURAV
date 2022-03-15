package pack123;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import base.Browser;
import pom.ApplicationHeaders;
import pom.LoginPage;
import util.Utility;


public class VerifyApplicationHeaders extends Browser {

	private WebDriver driver;
	private LoginPage loginPage;
	private ApplicationHeaders applicationHeaders;
    String testID;
	String name;
	static ExtentTest test;
	static ExtentHtmlReporter reporter;
	
	@BeforeTest
	@Parameters("browser")
	public void launchTheBrowser(String browserName)
	{
		reporter = new ExtentHtmlReporter("test-output"+File.separator+"ExtendReport"+File.separator+"extendReport.html");
		ExtentReports extend = new ExtentReports();
		extend.attachReporter(reporter);
		if(browserName.equals("Chrome"))
	    {
			driver = launchTheChromeBrowser();
		}	
		if(browserName.equals("Opera"))
	    {
			driver = launchTheOperaBrowser();
		}	
		if(browserName.equals("Firefox"))
	    {
			driver = launchTheFirefoxBrowser();
		}	
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	@BeforeClass
	public void createObjectOfPOMClasses()
	{
		loginPage = new LoginPage(driver);
		applicationHeaders = new ApplicationHeaders(driver);
	}
	
	@BeforeMethod
	public void loginToApplication() throws EncryptedDocumentException, IOException
	{
		driver.get("http://localhost/user/submit_tt.do");
		String username = Utility.getExcelSheetData("Sheet2", 1, 0);
		String password = Utility.getExcelSheetData("Sheet2", 1, 1);
		loginPage.sendUserName(username);
		loginPage.sendPassword(password);
		loginPage.clickOnCheckBox();
		loginPage.clickOnLoginButton();
	}
	
	@Test
	public void verifyTaskTabFunctionality()
	{
		testID = "A101";
		SoftAssert ast = new SoftAssert();
		applicationHeaders.openTasksPage();
		String url = driver.getCurrentUrl();
		String title = driver.getTitle();
		Assert.assertEquals(url, "http://localhost/tasks/otasklist.do");
		ast.assertEquals(title, "actiTIME - Open Tasks");
		ast.assertAll();
		
	}
	
	@Test
	public void verifyUsersTabFunctionality()
	{
		testID = "A102";
		SoftAssert ast = new SoftAssert();
		applicationHeaders.openUserPage();
		String url = driver.getCurrentUrl();
		String title = driver.getTitle();
		Assert.assertEquals(url, "http://localhost/administration/userlist.do");
		ast.assertEquals(title, "actiTIME - User List");
		ast.assertAll();
	}
	@AfterMethod
	public void logout() throws IOException
	{
		Utility.takeScreenshot(driver,testID);
		applicationHeaders.clickOnLogoutButton();
	}
	
	@AfterClass
	public void clearPOMObject()
	{
		loginPage = null;
		applicationHeaders = null;
	}
	@AfterTest
	public void closeBrowser()
	{
		driver.close();
		driver = null;
		System.gc();
	}
}
