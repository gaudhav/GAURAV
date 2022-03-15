package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CustomersDetailsPage {

	
	@FindBy (xpath = "(//button[text()='Delete'])[6]")
	private WebElement delete;
	
	public CustomersDetailsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnDeleteButton()
	{
		delete.click();
	}
	
}
