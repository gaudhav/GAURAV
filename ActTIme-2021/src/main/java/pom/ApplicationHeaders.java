package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ApplicationHeaders {


	
	@FindBy (xpath = "((//table[@id='topnav']//td)[10]//img)[1]")
	private WebElement tasks;
	
	@FindBy (xpath = "(//table[@class='navTable']//td[9]//img)[1]")
	private WebElement users;
	
	@FindBy (xpath = "(//table[@class='navTable']//td[3]//img)[1]")
	private WebElement timetrack;
	
	@FindBy (xpath = "//a[text()='Logout']")
	private WebElement logout;
	
	private WebDriver driver;
	
	public ApplicationHeaders(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	public void openTasksPage()
	{
		tasks.click();
	}
	
	public void openUserPage()
	{
		users.click();
	}
	public void openTimeTrackPage()
	{
		Actions action = new Actions(driver);
		action.moveToElement(timetrack).click().build().perform();
	}
	public void clickOnLogoutButton()
	{
		logout.click();
	}
}
