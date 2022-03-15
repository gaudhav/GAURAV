package testClasses;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pom.AddCustomePage;
import pom.AppicationHeaderPage;
import pom.CustomersDetailsPage;
import pom.LoginPage;
import pom.OpenAccountPage;

public class TestClass {

	
	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "F:\\photoes\\automation\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");
		
		LoginPage loginpage = new LoginPage(driver);
		loginpage.clickOnBankManagerLoginButton();
		
		AppicationHeaderPage appicationHeaderPage = new AppicationHeaderPage(driver);
		appicationHeaderPage.cilckOnAddCustomerButton();
		
		AddCustomePage addCustomePage = new AddCustomePage(driver);
		addCustomePage.enterFirstName();
		addCustomePage.enterLastName();
		addCustomePage.enterPostCode();
		addCustomePage.clickOnAddCustomerButton();
		
		driver.switchTo().alert().accept();
		
		appicationHeaderPage.clickOnOpenAccountButton();
		OpenAccountPage openAccountPage = new OpenAccountPage(driver);
		openAccountPage.SelectUserNameFromDropDown();
		openAccountPage.SelectCurrencyFromDropDown();
		openAccountPage.clickOnProcessButton();
		
		driver.switchTo().alert().accept();
		
		appicationHeaderPage.clickOnCustomersButton();
		CustomersDetailsPage customersDetailsPage = new CustomersDetailsPage(driver);
		customersDetailsPage.clickOnDeleteButton();
		appicationHeaderPage.clickOnHomeButton();
	}
	
	
}
