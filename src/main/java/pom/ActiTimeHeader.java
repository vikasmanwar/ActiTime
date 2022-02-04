package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ActiTimeHeader {
	
	@FindBy (xpath="//a[@class='content users']")
	private WebElement user;
	
	@FindBy (xpath= "//a[@class='content reports']")
	private WebElement report;
	
	@FindBy (xpath= "//a[@class='content tasks']")
	private WebElement task;
	
	@FindBy (xpath="//a[text()='Logout']")
	private WebElement logout;
	
	public ActiTimeHeader(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnUser()
	{
		user.click();
	}
	
	public void clickOnReport()
	{
		report.click();
	}
	
	public void  clickOntask()
	{
		task.click();
	}
	
	public void clickOnLogout()
	{
		logout.click();
	}
	
	// all action calls from single class
	public void actionOnActiTimeHeader()
	{
		user.click();
		report.click();
		task.click();
	}
	
	
}
