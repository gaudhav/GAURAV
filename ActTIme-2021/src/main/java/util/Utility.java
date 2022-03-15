package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Utility {

	
	public static File takeScreenshot(WebDriver driver, String testID) throws IOException
	{
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String s = new SimpleDateFormat("DD-MM-YYYY HH-MM-SS").format(new Date());
		File dest = new File("C:\\Users\\Gaurav\\Desktop\\New folder\\SS\\Test"+testID+s+".jpg");
		FileHandler.copy(src, dest);
		return dest;
	}

	public static String getExcelSheetData(String sheet, int row, int cell) throws EncryptedDocumentException, IOException
	{
		String data = "";
		
		FileInputStream file = new FileInputStream("C:\\Users\\Gaurav\\Desktop\\New Microsoft Office Excel Worksheet.xlsx");
		Workbook woorkbook = WorkbookFactory.create(file);
		try
		{
		    data =  woorkbook.getSheet(sheet).getRow(row).getCell(cell).getStringCellValue();
		}
		catch(IllegalStateException e)
		{
		    double value =  woorkbook.getSheet(sheet).getRow(row).getCell(cell).getNumericCellValue();
		    data = String.valueOf(value);   
		}
		catch(Exception e)
		{
			e.getStackTrace();  
		}
		return data;
	}
	
	
	
	
}
