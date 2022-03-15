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
import pom.Tasks;
import pom.TimeTrack;
import util.Utility;

public class VerifyTaskTabAndTimeTrackFunctionality extends Browser{

	private WebDriver driver;
	private LoginPage loginPage;
	private ApplicationHeaders applicationHeaders;
	private Tasks tasks;
	private TimeTrack timeTrack;
	String testID;
	static ExtentTest test;
	static ExtentHtmlReporter reporter;
	
	@BeforeTest
	@Parameters("browser")
	public void launchTheBrowser(String bowserName)
	{
		reporter = new ExtentHtmlReporter("test-output"+File.separator+"ExtendReport"+File.separator+"extendReport.html");
		ExtentReports extend = new ExtentReports();
		extend.attachReporter(reporter);
		if(bowserName.equals("Chrome"))
		{
			driver = launchTheChromeBrowser();
		}
		if(bowserName.equals("Opera"))
		{
			driver = launchTheOperaBrowser();
		}
		if(bowserName.equals("Firefox"))
		{
			driver = launchTheFirefoxBrowser();
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}
	@BeforeClass
	public void creatObjectOfPOMClasses()
	{
		 loginPage = new LoginPage(driver);
		 applicationHeaders = new ApplicationHeaders(driver);
		 tasks = new Tasks(driver);
		 timeTrack = new TimeTrack(driver);
	}
	
	@BeforeMethod
	public void loginToApplication() throws EncryptedDocumentException, IOException
	{
		driver.get("http://localhost/user/submit_tt.do");
		String userName = Utility.getExcelSheetData("Sheet2", 1, 0);
		String password = Utility.getExcelSheetData("Sheet2", 1, 1);
		loginPage.sendUserName(userName);
		loginPage.sendPassword(password);
		loginPage.clickOnCheckBox();
		loginPage.clickOnLoginButton();
		
	}
	
	@Test
	public void verifyTaskTabFunctionality()
	{
		testID = "A201";
		SoftAssert ast = new SoftAssert();
		applicationHeaders.openTasksPage();
		String url = driver.getCurrentUrl();
		String title = driver.getTitle();
		Assert.assertEquals(url, "http://localhost/tasks/otasklist.do");
		ast.assertEquals(title, "actiTIME - Open Tasks");
		tasks.clickOnCreateTaskButton();
		boolean result = tasks.verifyCreateTaskButton();
		ast.assertTrue(result);
		tasks.clickOnDropButton();
		tasks.selectOptionFromDropdown();
		tasks.enterCustomerName();
		tasks.enterProjectName();
		tasks.enterTaskName();
		tasks.clickOnCancelButton();
		driver.switchTo().alert().accept();
		ast.assertAll();
	}
	@Test
	public void verifyTimeTrackTabFunctionality()
	{
		testID = "A202";
		SoftAssert ast = new SoftAssert();
		applicationHeaders.openTimeTrackPage();
		String url = driver.getCurrentUrl();
		String title = driver.getTitle();
		Assert.assertEquals(url, "http://localhost/user/submit_tt.do?submitted=");
		ast.assertEquals(title, "actiTIME - Enter Time-Track");
		String text = timeTrack.getTextOnNewButton();
		ast.assertEquals(text, "New");
		timeTrack.clickOnNewButton();
		timeTrack.clickOnSelectCustomers();
		timeTrack.clickOnNewCustomer();
		timeTrack.enterCustomerName();
		timeTrack.enterProjectName();
		timeTrack.clickAndEnterDataInTaskName();
		timeTrack.clickOnCancelButton();
		driver.switchTo().alert().accept();
		ast.assertAll();
	}
	@AfterMethod
	public void logout() throws IOException
	{
		Utility.takeScreenshot(driver, testID);
		applicationHeaders.clickOnLogoutButton();
	}
	
	@AfterClass
	public void clearPOMObject()
	{
		 loginPage = null;
		 applicationHeaders = null;
		 tasks = null;
		 timeTrack = null;
	}
	@AfterTest
	public void closeBrowser()
	{
		driver.close();
		driver = null;
		System.gc();
	}
}
