package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;

public class Browser {

	public static WebDriver launchTheChromeBrowser()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Gaurav\\Downloads\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		return driver;
	}
	public static WebDriver launchTheOperaBrowser()
	{
		System.setProperty("webdriver.opera.driver", "F:\\photoes\\automation\\OperaNew\\operadriver_win64\\operadriver.exe");
		WebDriver driver = new OperaDriver();
		return driver;
	}
	public static WebDriver launchTheFirefoxBrowser()
	{
		System.setProperty("webdriver.gecko.driver", "F:\\photoes\\automation\\Firefoxdriver\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		return driver;
	}
}
