package pack123;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pom.ApplicationHeaders;
import pom.LoginPage;
import pom.Users;

public class VerifyUserPageFunctionality {

	private WebDriver driver;
	private ApplicationHeaders applicationHeaders;
	
	@BeforeClass
	public void launchBrowser()
	{
		System.setProperty("webdriver.chrome.driver", "F:\\photoes\\automation\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	@BeforeMethod
	public void loginToApplication()
	{
		driver.get("http://localhost/user/submit_tt.do");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.sendUserName();
		loginPage.sendPassword();
		loginPage.clickOnCheckBox();
		loginPage.clickOnLoginButton();
		
	}
	@Test
	public void verifyUsersTabFunctionality()
	{
		SoftAssert ast = new SoftAssert();
		applicationHeaders = new ApplicationHeaders(driver);
		applicationHeaders.openUserPage();
		String url = driver.getCurrentUrl();
		String title = driver.getTitle();
		Assert.assertEquals(url, "http://localhost/administration/userlist.do");
		ast.assertEquals(title, "actiTIME - User List");
		Users user = new Users(driver);
		user.clickOnUserButton();
		user.sendFirstName();
		user.sendLastName();
		user.sendemailId();
		user.clickDateButton();
		user.selectDate();
		user.clickOnCancelButton();
		driver.switchTo().alert().accept();
		ast.assertAll();
	}
	@AfterMethod
	public void logout()
	{
		applicationHeaders.clickOnLogoutButton();
	}
	@AfterClass
	public void closeBrowser()
	{
		driver.close();
	}
}
