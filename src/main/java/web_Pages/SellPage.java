package web_Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SellPage {

	public WebDriver driver;
	
	public SellPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//a[@class='moveToSFL save-for-later-link']")
	public WebElement saveForLaterLink;
	
	@FindBy(xpath="//a[contains(text(),'saved')]")
	public WebElement savedProduct;
}
