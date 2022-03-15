package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Utility {

	
	public static File takeScreenshot(WebDriver driver, String testID) throws IOException
	{
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String s = new SimpleDateFormat("DD-MM-YYYY HH-MM-SS").format(new Date());
		File dest = new File("F:\\photoes\\Velocity java project\\Banking\\src\\main\\java\\Screenshots\\Test"+testID+s+".jpg");
		FileHandler.copy(src, dest);
		return dest;
	}
	
}
