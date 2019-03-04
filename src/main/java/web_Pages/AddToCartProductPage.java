package web_Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import baseClass.testBase;

public class AddToCartProductPage extends testBase

{
	WebDriver driver;
	public AddToCartProductPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(id="primaryGroup_addToCart_0")
	public WebElement addToCartButton;
	
	@FindBy(id="btn-checkout")
	public WebElement checkOutButton;
	
	@FindBy(xpath="//div[@class='pip-summary']/child::h1")
	public WebElement productText;
	
}
