package testClasses;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import base.Browser;
import pom.AppicationHeaderPage;
import pom.LoginPage;
import util.Utility;

public class VerifyLoginTabs extends Browser{

	private WebDriver driver;
	private AppicationHeaderPage appicationHeaderPage;
	private LoginPage loginPage;
	String testID;
	
	@BeforeTest
	@Parameters("browser")
	public void lauchBrowser(String browserName)
	{
		if(browserName.equals("Chrome"))
		{
			driver = launchTheChromeBrowser();
		}
		if(browserName.equals("Opera"))
		{
			driver = launchTheOperaBrowser();
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	@BeforeClass
	public void CreateObjectsOfPOMClasses()
	{
		loginPage = new LoginPage(driver);
		appicationHeaderPage = new AppicationHeaderPage(driver);
	}
	@BeforeMethod
	public void lauchTheApplication()
	{
		driver.get("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");
	}
	@Test
	public void verifyCustomerLoginButton()
	{
		testID = "B101";
		loginPage.clickOnCoustomerLoginButton();
	}
	@Test
	public void verifyBankManagerLoginButton()
	{
		testID = "B102";
		loginPage.clickOnBankManagerLoginButton();
	}
	@AfterMethod
	public void gotoHomePage(ITestResult result) throws IOException
	{
		if(ITestResult.FAILURE==result.getStatus())
		{
			Utility.takeScreenshot(driver, testID);
		}
		appicationHeaderPage.clickOnHomeButton();
	}
	@AfterClass
	public void clearPOMObjects()
	{
		loginPage = null;
		appicationHeaderPage = null;
	}
	@AfterTest
	public void closeBrowser()
	{
		driver.close();
		System.gc();
	}

}
