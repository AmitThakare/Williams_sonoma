package testScripts;


import org.testng.Assert;
import org.testng.Reporter;
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
		Reporter.log("Landing on home page of the website");
		closePopupIfAppear(kettlePage.popupBoxCloseBtn);
		moveCursorOnWebElement(mainpage.CookwareDropDownButton);
		Thread.sleep(2000);
		moveCursorAndClickOnWebElement(mainpage.TeaKettlesLink);
		Reporter.log("Clicked the Tea kettles link");
		closePopupIfAppear(kettlePage.popupBoxCloseBtn);
		waitForAllElementsToBeVisible(kettlePage.totalKettles);
		
		kettlePage.selectRandomTeaKettles();
		Reporter.log("Select the Tea kettles");
		closePopupIfAppear(kettlePage.popupBoxCloseBtn);
		String ProductText=getText(addToCartPage.productText);
		
		clickOnWebElement(addToCartPage.addToCartButton);
		Reporter.log("Clicked on the Add To Cart button");
		closePopupIfAppear(kettlePage.popupBoxCloseBtn);
	
		clickOnWebElement(addToCartPage.checkOutButton);
		Reporter.log("Clicked on the checkout button");
		closePopupIfAppear(kettlePage.popupBoxCloseBtn);
		
		clickOnWebElement(sellPage.saveForLaterLink);	
		Reporter.log("Clicked on the Save for later link");
		Assert.assertTrue(sellPage.savedProduct.isDisplayed());
		
		clickOnWebElement(sellPage.savedProduct);
		
		Thread.sleep(2000);
		Assert.assertEquals(ProductText, getText(sellPage.productName).replace("[^a-zA-Z0-9]", "").contains(ProductText));
		Reporter.log("Saved product verified successfully");
		
		
		
	}
	
	@AfterSuite
	public void CloseBrowser()
	{
		driver.close();
	}
	
}
