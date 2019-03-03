package web_Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import baseClass.testBase;

public class MainPage extends testBase {

	WebDriver driver;
	
	public MainPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//a[@class='topnav-cookware ']")
	public WebElement CookwareDropDownButton;
	
	@FindBy(xpath="//a[contains(text(),'Tea Kettles')]")
	public WebElement TeaKettlesLink;
	
	
	
}
