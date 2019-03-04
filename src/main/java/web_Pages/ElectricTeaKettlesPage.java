package web_Pages;

import java.util.List;
import java.util.Random;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import baseClass.testBase;

public class ElectricTeaKettlesPage extends testBase{

	public ElectricTeaKettlesPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//div[@id='subCatListContainer']/ul/li")
	public List<WebElement> totalKettles;
	
	@FindBy(xpath="//a[@class='stickyOverlayMinimizeButton']") 
	public WebElement popupBoxCloseBtn;
	
	
	
	public void selectRandomTeaKettles()
	{
		
		Random random=new Random();
		int randomSelectedKettle=random.nextInt(totalKettles.size());
		String kettleXpath ="//div[@id='subCatListContainer']/ul/li["+randomSelectedKettle+"]";
		
		clickOnWebElement(driver.findElement(By.xpath(kettleXpath)));
		
	}
	
	
}
