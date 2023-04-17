package testScripts;
import java.io.FileReader;
import java.util.Properties;
import java.util.Set;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.flipkartAddToCartPage;
import pageObjects.flipkartHomePage;

public class placeOrderInFlipkart {
	
	WebDriver driver;
	String path;
	@BeforeTest
	public void browserSetUp()
	{
		// Setting Firefox Driver Path
		System.out.println("-------------------Broswer Setup---------------");
		path = System.getProperty("user.dir");
		System.out.println(path);
		System.setProperty("wendriver.gecko.driver",
				path + "\\src\\test\\resources\\Driver\\geckodriver.exe");
		driver = new FirefoxDriver();
	}
				
	@Test
	public void placeOrder() throws Exception{
						
			// Read data from Properties file
			Properties prop=new Properties();
			FileReader reader=new FileReader(path+"\\src\\test\\resources\\websiteDetails.properties");
			prop.load(reader);
			String url         = prop.getProperty("url");
			String searchQuery = prop.getProperty("searchQuery");
			String emailID	   = prop.getProperty("emailId");
			
			// Create objects for PageObject files used
			flipkartHomePage flipKartHomePage          = new flipkartHomePage(driver);
			flipkartAddToCartPage flipKartAddToCartPge = new flipkartAddToCartPage(driver);
			
			// Actual Script starts
			driver.get(url);
			System.out.println("Navigating to Flipkart");
			flipKartHomePage.clickOnloginpopupCloseBtn();
			flipKartHomePage.enterSearchQuery(searchQuery);
			Thread.sleep(2000);
			flipKartHomePage.selectAutosuggestedResult();
			Thread.sleep(2000);
			flipKartHomePage.clickOnConnectivityOption();
			flipKartHomePage.clickOnWifiOnly();
			Thread.sleep(2000);
			String parentWindow = driver.getWindowHandle();
			flipKartHomePage.clickOnResultItem();
			Thread.sleep(2000);
			Set<String> handles = driver.getWindowHandles();
			for (String handle : handles) {
				if (!handle.equals(parentWindow)) {
					driver.switchTo().window(handle);
					Thread.sleep(2000);
					flipKartAddToCartPge.clickOnAddToCartButton();
					Thread.sleep(5000);
					try {
						boolean isNotificationDisplayed = flipKartAddToCartPge.isNotificationDisplayed();
						if (isNotificationDisplayed) {
							flipKartAddToCartPge.clickOnCartSymbol();
							Thread.sleep(2000);
						}
					} catch (Exception e) {
						System.out.println(e);
					}
					flipKartAddToCartPge.clickOnplaceOrderButton();
					Thread.sleep(2000);
					flipKartAddToCartPge.enterEmail(emailID);
					flipKartAddToCartPge.clickOnContinue();
				}
			}
	}
	@AfterTest
	public void closeBrowser()
	{
		System.out.println("-------------------Broswer Closed---------------");
		driver.quit();
	}
}
