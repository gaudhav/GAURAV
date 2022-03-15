package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Tasks {

	@FindBy (xpath = "//span[text()='Create Tasks']")
	private WebElement createTaskButton;
	
	@FindBy (xpath = "//button[@type='button']")
	private WebElement dropButton1;
	
	@FindBy (xpath = "//a[text()='- New Customer -']")
	private WebElement option;
	
	@FindBy (xpath = "//input[@placeholder='Enter Customer Name']")
	private WebElement customerName;
	
	@FindBy (xpath = "//input[@placeholder='Enter Project Name']")
	private WebElement projectName;
	
	@FindBy (xpath = "(//input[@placeholder='Enter task name'])[1]")
	private WebElement taskName;
	
	@FindBy (xpath = "//div[@id='createTasksPopup_cancelBtn']")
	private WebElement cancelButton;
	
	
	public Tasks(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public void clickOnCreateTaskButton()
	{
		createTaskButton.click();
	}
	public boolean verifyCreateTaskButton()
	{
		boolean result =createTaskButton.isDisplayed();
		return result;
	}
	public void clickOnDropButton()
	{
		dropButton1.click();
	}
	public void selectOptionFromDropdown()
	{
		option.click();
	}
	public void enterCustomerName()
	{
		customerName.sendKeys("Allu Arjun");;
	}
	public void enterProjectName()
	{
		projectName.sendKeys("Pushpa");;
	}
	public void enterTaskName()
	{
		taskName.sendKeys("Main Zukega Nahi");;
	}
	public void clickOnCancelButton()
	{
		cancelButton.click();
	}
	
}
