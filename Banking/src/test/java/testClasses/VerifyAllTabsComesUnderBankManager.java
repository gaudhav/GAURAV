package testClasses;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
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
import pom.AddCustomePage;
import pom.AppicationHeaderPage;
import pom.CustomersDetailsPage;
import pom.LoginPage;
import pom.OpenAccountPage;
import util.Utility;

public class VerifyAllTabsComesUnderBankManager extends Browser{

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
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	}
	@BeforeClass
	public void createObjectsOfPOMClasses()
	{
		loginPage = new LoginPage(driver);
		appicationHeaderPage = new AppicationHeaderPage(driver);
	}
	@BeforeMethod
	public void lauchTheApplication()
	{
		driver.get("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");
		loginPage.clickOnBankManagerLoginButton();
	}
	@Test(priority = 1)
	public void verifyAddCustomerTab()
	{
		testID = "B201";
        appicationHeaderPage.cilckOnAddCustomerButton();
		AddCustomePage addCustomePage = new AddCustomePage(driver);
		addCustomePage.enterFirstName();
		addCustomePage.enterLastName();
		addCustomePage.enterPostCode();
		addCustomePage.clickOnAddCustomerButton();
		
		driver.switchTo().alert().accept();
	}
	@Test(priority = 2)
	public void verifyOpenAccountTab()
	{
		testID = "B202";
		appicationHeaderPage.clickOnOpenAccountButton();
		OpenAccountPage openAccountPage = new OpenAccountPage(driver);
		openAccountPage.SelectUserNameFromDropDown();
		openAccountPage.SelectCurrencyFromDropDown();
		openAccountPage.clickOnProcessButton();
		
		driver.switchTo().alert().accept();
	}
	@Test(priority = 3)
	public void verifyCustomersTab()
	{
		appicationHeaderPage.clickOnCustomersButton();
		CustomersDetailsPage customersDetailsPage = new CustomersDetailsPage(driver);
		customersDetailsPage.clickOnDeleteButton();
		
		driver.switchTo().alert().accept();
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
	public void clearPOmObjects()
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
