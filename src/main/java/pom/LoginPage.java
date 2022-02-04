package pom;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.Utility;

public class LoginPage {

	@FindBy (xpath="//input[@id='username']")
	private WebElement user;
	
	@FindBy (xpath="(//input[@type='password'])[1]")
	private WebElement password;
	
	@FindBy (xpath="//a[@id='loginButton']")
	private  WebElement loginButton;
	
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void sendUser() throws EncryptedDocumentException, IOException
	{
		String id = Utility.getDataFromDatasheet(1, 0);
		//System.out.println(userID);
		user.sendKeys(id);
		///user.sendKeys("admin");
	}
	
	public void sendPassword() throws EncryptedDocumentException, IOException
	{
		String pw = Utility.getDataFromDatasheet(1, 1);
		password.sendKeys(pw);
		//password.sendKeys("manager");
	}
	
	public void clickOnLoginButton()
	{
		loginButton.click();
	}
	
	// sometimes all action write in single method 
	public void testActiTimeLoginPage()
	{
		user.sendKeys("admin");
		password.sendKeys("manager");
		loginButton.click();
	}
	
//	public static void main(String[] args) throws EncryptedDocumentException, IOException {
//		String userID = Utility.getDataFromDatasheet(1, 0);
//		System.out.println(userID);
//	}
	
}
