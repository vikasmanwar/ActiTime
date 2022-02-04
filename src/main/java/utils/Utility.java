package utils;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import java.text.SimpleDateFormat;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Utility {
   // xcell sheet 
	static String path = "V:\\Automation\\Actitime-Application\\src\\main\\resources\\datasheet.xlsx";
	//static FileInputStream file = new FileInputStream(path);
	//Sheet sheet = WorkbookFactory.create(file).getSheet("Sheet1");
	public static String getDataFromDatasheet(int row, int cell) throws EncryptedDocumentException, IOException 
	{
		//String data = "";
		FileInputStream file = new FileInputStream(path);
		try {
			String data1 = WorkbookFactory.create(file).getSheet("Sheet1").getRow(row).getCell(cell).getStringCellValue();
			return data1;
		}
		catch(NullPointerException a) {
			double d = WorkbookFactory.create(file).getSheet("Sheet1").getRow(row).getCell(cell).getNumericCellValue();
			String data1 = String.valueOf(d);
			return data1;
		}
		
	}
	
	// Screenshot 
	public static void saveScreenshot(WebDriver driver, int testId) throws IOException {
		
		File sorce= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		Date d = new Date();
		String timeStamp = new SimpleDateFormat("yyyy-MM-dd hhmmss").format(d);
		String path = "V:\\Automation\\Actitime-Application\\src\\main\\resources\\Screenshots\\ " +testId+" " +timeStamp +".jpg";
		File dest = new File(path);
		FileHandler.copy(sorce, dest);
	}

	
	
	
}
