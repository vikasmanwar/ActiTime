package base;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;

import org.apache.poi.hpsf.Date;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.opera.OperaDriver;

import pom.LoginPage;

public class Base {

	public static WebDriver openChromeDriver() {
		System.setProperty("webdriver.chrome.driver", "V:\\Automation\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		return driver;
	}
	
	public static WebDriver openFirefoxDriver() {
		System.setProperty("webdriver.gecko.driver", "V:\\Automation\\geckodriver-v0.30.0-win64\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		return driver;
	}
	
	public static WebDriver openOperaDriver() {
		System.setProperty("webdriver.opera.driver", "V:\\Automation\\operadriver_win64\\operadriver_win64\\operadriver.exe");
		WebDriver driver = new OperaDriver();
		return driver;
	}
	
	public static WebDriver openEdgeDriver() {
		System.setProperty("webdriver.edge.driver", "V:\\Automation\\edgedriver_win64\\msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		return driver;
	}
	
	public static void main(String[] args) throws IOException {
		System.setProperty("webdriver.chrome.driver", "V:\\Automation\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://facebook.com");
//		LoginPage loginPage = new LoginPage(driver);
//		loginPage.sendUser();
//		loginPage.sendPassword();
//		loginPage.clickOnLoginButton();
		
		File sorce= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		Date d = new Date();
		
		String timeStamp =new SimpleDateFormat("yyyyMMddhhmmss").format(d);
		
		String path = "V:\\Automation\\Actitime-Application\\src\\main\\resources\\Screenshots\\Test "+timeStamp+".jpg";
		File dest = new File(path);
		FileHandler.copy(sorce, dest);
		System.out.println("END");
	}
}
