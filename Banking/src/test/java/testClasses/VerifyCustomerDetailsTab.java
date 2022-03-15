package testClasses;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pom.AppicationHeaderPage;
import pom.CustomersDetailsPage;
import pom.LoginPage;


public class VerifyCustomerDetailsTab {

	
	private WebDriver driver;
    private AppicationHeaderPage appicationHeaderPage;
    
	@BeforeClass
	public void launchTheBrowser()
	{
		System.setProperty("webdriver.chrome.driver", "F:\\photoes\\automation\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	}
	@BeforeMethod
    public void launchTheApplication()
    {
        driver.get("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.clickOnBankManagerLoginButton();
    }
	@Test
	public void verifyCustomerDetailsTab()
	{
		appicationHeaderPage = new AppicationHeaderPage(driver);
		appicationHeaderPage.clickOnCustomersButton();
		CustomersDetailsPage customersDetailsPage = new CustomersDetailsPage(driver);
		customersDetailsPage.clickOnDeleteButton();
		
		driver.switchTo().alert().accept();
	}
	@AfterMethod
	public void backToPreviousPage()
	{
		appicationHeaderPage.clickOnHomeButton();
	}
	
	@AfterClass
	public void closeTheBrowser()
	{
		driver.close();
	}
}
