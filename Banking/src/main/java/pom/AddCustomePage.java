package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddCustomePage {

	@FindBy (xpath = "//input[@placeholder='First Name']")
	private WebElement firstName;
	
	@FindBy (xpath = "//input[@placeholder='Last Name']")
	private WebElement lastName;
	
	@FindBy (xpath = "//input[@placeholder='Post Code']")
	private WebElement postCode;
	
	@FindBy (xpath = "//button[text()='Add Customer']")
	private WebElement addCustomer;
	
	public AddCustomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void enterFirstName()
	{
		firstName.sendKeys("Sachin");
	}
	public void enterLastName()
	{
		lastName.sendKeys("Tendulkar");
	}
	public void enterPostCode()
	{
		postCode.sendKeys("444101");
	}
	public void clickOnAddCustomerButton()
	{
		addCustomer.click();
	}
	
}

