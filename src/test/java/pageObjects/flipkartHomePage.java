package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class flipkartHomePage {
	WebDriver driver;
	By loginPopUp         = By.xpath("//button[@class='_2KpZ6l _2doB4z']");
	By searhInputField     = By.xpath("//input[@name='q']");
	By autoSuggestedResult = By.xpath("(//a[@class='_3izBDY'])[2]");
	By connectivityOption  = By.xpath("//div[text()='Connectivity']");
	By wifiOnlyOption      = By.xpath("//div[text()='Wi-Fi Only']");
	By resultItem          = By.xpath("(//div[@class='col col-7-12'])[2]/div[1]");
	
	public flipkartHomePage(WebDriver driver)
	{
		this.driver = driver;
	}
	public void clickOnloginpopupCloseBtn()
	{
		driver.findElement(loginPopUp).click();
	}
	public void enterSearchQuery(String query)
	{
		System.out.println("Entering Search Query");
		driver.findElement(searhInputField).sendKeys(query);
	}
	public void selectAutosuggestedResult()
	{
		System.out.println("Selecting First autosuggestion from Results");
		driver.findElement(autoSuggestedResult).click();
	}
	public void clickOnConnectivityOption()
	{
		driver.findElement(connectivityOption).click();
	}
	public void clickOnWifiOnly()
	{
		System.out.println("Selecting Wifi Only Option");
		driver.findElement(wifiOnlyOption).click();
	}
	public void clickOnResultItem()
	{
		driver.findElement(resultItem).click();
		System.out.println("Navigating To Add To Cart");
	}	
}