package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AppicationHeaderPage {

	@FindBy (xpath = "//button[contains(text(),'Add Customer')]")
	private WebElement addCustomer;
	
	@FindBy (xpath = "//button[contains(text(),'Open Account')]")
	private WebElement openAccount;
	
	@FindBy (xpath = "//button[contains(text(),'Customers')] 		")
	private WebElement Customers;
	
	@FindBy (xpath = "//button[text()='Home']")
	private WebElement homeButton;
	
	public AppicationHeaderPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void cilckOnAddCustomerButton()
	{
		addCustomer.click();
	}
	
	public void clickOnOpenAccountButton()
	{
		openAccount.click();
	}
	public void clickOnCustomersButton()
	{
		Customers.click();
	}
	public void clickOnHomeButton()
	{
		homeButton.click();
	}
	
}
