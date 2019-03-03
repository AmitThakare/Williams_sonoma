package testScripts;


import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;

import baseClass.testBase;
import web_Pages.AddToCartProductPage;
import web_Pages.ElectricTeaKettlesPage;
import web_Pages.MainPage;
import web_Pages.SellPage;

public class addToCartProductTestScript extends testBase{

	@Test()
	public void addProductToCart() throws InterruptedException
	{
		MainPage mainpage=new MainPage(driver);
		ElectricTeaKettlesPage kettlePage=new ElectricTeaKettlesPage(driver);
		AddToCartProductPage addToCartPage=new AddToCartProductPage(driver);
		SellPage sellPage=new SellPage(driver);
		
		closePopupIfAppear(kettlePage.popupBoxCloseBtn);
		moveCursorOnWebElement(mainpage.CookwareDropDownButton);
		Thread.sleep(2000);
		moveCursorAndClickOnWebElement(mainpage.TeaKettlesLink);
		
		waitForAllElementsToBeVisible(kettlePage.totalKettles);
		closePopupIfAppear(kettlePage.popupBoxCloseBtn);
		kettlePage.selectRandomTeaKettles();
		closePopupIfAppear(kettlePage.popupBoxCloseBtn);
		clickOnWebElement(addToCartPage.addToCartButton);
		closePopupIfAppear(kettlePage.popupBoxCloseBtn);
	
		clickOnWebElement(addToCartPage.checkOutButton);
		closePopupIfAppear(kettlePage.popupBoxCloseBtn);
		
		clickOnWebElement(sellPage.saveForLaterLink);	
		Assert.assertTrue(sellPage.savedProduct.isDisplayed());
		
	}
	
	@AfterSuite
	public void CloseBrowser()
	{
		driver.close();
	}
	
}
