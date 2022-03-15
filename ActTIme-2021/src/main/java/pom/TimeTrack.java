package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TimeTrack {

	@FindBy (xpath = "//span[text()='New']")
	private WebElement newButton;
	
	@FindBy (xpath = "//button[text()='- Select Customer -']")
	private WebElement selectCustomer;
	
	@FindBy (xpath = "//a[text()='- New Customer -']")
	private WebElement newCustomer;
	
	@FindBy (xpath = "//input[@placeholder='Enter Customer Name']")
	private WebElement customerName;
	
	@FindBy (xpath = "//input[@placeholder='Enter Project Name']")
	private WebElement projectName;
	
	@FindBy (xpath = "(//input[@placeholder='Enter task name'])[1]")
	private WebElement taskName;
	
	@FindBy (xpath = "//div[@id='createTasksPopup_cancelBtn']")
	private WebElement cancelButton;
	
	public TimeTrack(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public String getTextOnNewButton()
	{
		String text = newButton.getText();
		return text;
	}
	public void clickOnNewButton()
	{
		newButton.click();
	}
	public void clickOnSelectCustomers()
	{
		selectCustomer.click();
	}
	public void clickOnNewCustomer()
	{
		newCustomer.click();
	}
	public void enterCustomerName()
	{
		customerName.sendKeys("Rahul");
	}
	public void enterProjectName()
	{
		projectName.sendKeys("velocity");
	}
	public void clickAndEnterDataInTaskName()
	{
		taskName.click();
		taskName.sendKeys("J1 Zal ka");
	}
	public void clickOnCancelButton()
	{
		cancelButton.click();
	}
	
}
