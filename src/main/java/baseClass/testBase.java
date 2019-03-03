package baseClass;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeSuite;

public class testBase {
	public WebDriver driver=null;
	public Properties prop;
	
	
	
	
	@BeforeSuite(alwaysRun=true)
	public void ConfigReader() throws IOException
	{
		
		prop =new Properties();
		try {
			FileInputStream fip=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\configurations\\config.properties");
		
			prop.load(fip);
		}
		catch(FileNotFoundException e)
		{
			System.out.println("File not found, please check the config file path");
		}
		
		
		
	}
	
	
	
	/*
	 * //Method will select the browser based on browser name mentioned in the config file
	 * 
	 */
	@BeforeSuite(alwaysRun=true)
		public  void SetupBrowser() 
	{
		String BrowserUrl=prop.getProperty("BrowserUrl");
		String Browser=prop.getProperty("BrowserName");
		String DriverPath=prop.getProperty("DriverPath");
		
	
		if(Browser.equalsIgnoreCase("Firefox"))
		{
			System.setProperty("webdriver.gecko.driver",DriverPath);
			driver=new FirefoxDriver();
		}
		else if(Browser.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver", DriverPath);
			driver=new ChromeDriver();
		}
		else if(Browser.equalsIgnoreCase("Chrome"))
		{
			System.setProperty("webdriver.ie.driver", DriverPath);
			driver=new InternetExplorerDriver();
			
		}
		
		driver.manage().window().maximize();
		driver.get(BrowserUrl);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
	}
		
		/*
		 * clickOnWebElement method click on weblement present on the webpage
		 */
		
		public void clickOnWebElement(WebElement element)
		{
			element.click();
		}
		
		/*
		 * moveCursorAndClickOnWebElement method move the mouse curson to the weblement and then click on that.
		 */
		
		public void moveCursorAndClickOnWebElement(WebElement element)
		{
			Actions action=new Actions(driver);
			action.moveToElement(element).click().build().perform();
			
		}
		
		public void moveCursorOnWebElement(WebElement element)
		{
			Actions action=new Actions(driver);
			action.moveToElement(element).build().perform();
			
		}
		
		public void waitForAllElementsToBeVisible(List<WebElement> element)
		{
			WebDriverWait wait=new WebDriverWait(driver, 5);
			wait.until(ExpectedConditions.visibilityOfAllElements(element));
			
		}
		
		public void waitForElementToBeVisible(WebElement element)
		{
			WebDriverWait wait=new WebDriverWait(driver, 5);
			wait.until(ExpectedConditions.visibilityOf(element));
			
		}
		
		
		public boolean isPopupPresent(WebElement element) throws InterruptedException
		{
		
		try
		{
		
			Thread.sleep(2000);
			
				return element.isDisplayed();
		}
			catch(NoSuchElementException ex)
			{
				return false;
			}
			
		}

		
		public void closePopupIfAppear(WebElement element) throws InterruptedException
		{
			
			if(isPopupPresent(element))
			{
			
				element.click();
			}

		}
		
		
}
