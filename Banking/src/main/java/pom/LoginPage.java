package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	@FindBy (xpath = "//button[text()='Customer Login']")
	private WebElement customerLogin ;
	
	@FindBy (xpath = "//button[text()='Bank Manager Login']")
	private WebElement bankManagerLogin ;
	
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnCoustomerLoginButton()
	{
		customerLogin.click();
	}
	public void clickOnBankManagerLoginButton()
	{
		bankManagerLogin.click();
	}
	
	
	
	
	
	
	

}
