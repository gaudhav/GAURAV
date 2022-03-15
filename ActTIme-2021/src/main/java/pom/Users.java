package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Users {

	@FindBy (xpath = "//span[text()='User']")
	private WebElement userButton;
	
	@FindBy (xpath = "//input[@placeholder='First Name']")
	private WebElement firstName;
	
	@FindBy (xpath = "//input[@placeholder='Last Name']")
	private WebElement lastName;
	
	@FindBy (xpath = "//input[@name='email']")
	private WebElement email;
	
	@FindBy (xpath = "(//button[contains(@id,'ext')])[4]")
	private WebElement date;
	
	@FindBy (xpath = "(//td[@class='x-date-active'])[10]")
	private WebElement option;
	
	@FindBy (xpath = "(//input[@type='checkbox'])[4]")
	private WebElement checkbox;
	
	@FindBy (xpath = "//div[text()='Cancel']")
	private WebElement cancelbutton;
	
	
	public Users(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public void clickOnUserButton()
	{
		userButton.click();
	}
	public void sendFirstName()
	{
		firstName.sendKeys("Akshay");;
	}
	public void sendLastName()
	{
		lastName.sendKeys("Kumar");;
	}
	public void sendemailId()
	{
		email.sendKeys("akshay.kumar@gmail.com");;
	}
	public void clickDateButton()
	{
		date.click();
	}
	public void selectDate()
	{
		option.click();
	}
	public void clickOnCheckbox()
	{
		checkbox.click();
	}
	public void clickOnCancelButton()
	{
		cancelbutton.click();
	}
	
}
