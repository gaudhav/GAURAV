package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class OpenAccountPage {

	@FindBy (xpath = "//select[@id='userSelect']")
	private WebElement userSelect;
	
	@FindBy (xpath = "//select[@id='currency']")
	private WebElement currency;
	
	@FindBy (xpath = "//button[@type='submit']")
	private WebElement process;
	
	public OpenAccountPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void SelectUserNameFromDropDown()
	{
		userSelect.click();
		Select s = new Select(userSelect);
		s.selectByVisibleText("Sachin Tendulkar");
	}
	public void SelectCurrencyFromDropDown()
	{
		currency.click();
		Select t = new Select(currency);
		t.selectByVisibleText("Rupee");				
	}
	public void clickOnProcessButton()
	{
		process.click();
	}
}
