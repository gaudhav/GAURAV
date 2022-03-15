package pack123;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pom.ApplicationHeaders;
import pom.LoginPage;
import pom.Tasks;
import pom.TimeTrack;
import pom.Users;

public class TestClass {

	
	public static void main(String[] args) throws InterruptedException {
		
		
		System.setProperty("webdriver.chrome.driver", "F:\\photoes\\automation\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://localhost/user/submit_tt.do");
		
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.sendUserName();
		loginPage.sendPassword();
		loginPage.clickOnCheckBox();
		loginPage.clickOnLoginButton();

		ApplicationHeaders applicationHeaders = new ApplicationHeaders(driver);
		applicationHeaders.openTasksPage();
		String url = driver.getCurrentUrl();
		String title = driver.getTitle();
		if(url.equals("http://localhost/tasks/otasklist.do"))
		{
			System.out.println("PASS");
		}
		else
		{
			System.out.println("FAIL");
		}
		if(title.equals("actiTIME -  Open Tasks"))
		{
			System.out.println("PASS");
		}
		else
		{
			System.out.println("FAIL");
		}
		Tasks tasks = new Tasks(driver);
		tasks.clickOnCreateTaskButton();
		tasks.clickOnDropButton();
		tasks.selectOptionFromDropdown();
		tasks.enterCustomerName();
		tasks.enterProjectName();
		tasks.enterTaskName();
		tasks.clickOnCancelButton();
		driver.switchTo().alert().accept();
		
		applicationHeaders.openUserPage();
		Users user = new Users(driver);
		user.clickOnUserButton();
		user.sendFirstName();
		user.sendLastName();
		user.sendemailId();
		user.clickDateButton();
		user.selectDate();
		user.clickOnCancelButton();
		driver.switchTo().alert().accept();
		
		applicationHeaders.openTimeTrackPage();
		TimeTrack timeTrack = new TimeTrack(driver);
		timeTrack.clickOnNewButton();
		timeTrack.clickOnSelectCustomers();
		timeTrack.clickOnNewCustomer();
		timeTrack.enterCustomerName();
		timeTrack.enterProjectName();
		timeTrack.clickAndEnterDataInTaskName();
		timeTrack.clickOnCancelButton();
		driver.switchTo().alert().accept();
	}
}
