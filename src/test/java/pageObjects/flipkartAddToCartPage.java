package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class flipkartAddToCartPage {
	WebDriver driver;
	By addToCartButton  = By.xpath("//button[text()= 'Add to cart']");
	By errNotification  = By.xpath("//div[contains(text(),'sorry! Only 1 unit(s) for each customer')]");
	By cartSymbol       = By.xpath("//span[text()='Cart']/parent::a");
	By placeOrderButton = By.xpath("//span[text()='Place Order']/parent::Button");
	By emailInputField  = By.xpath("//span[text()='Enter Email/Mobile number']/parent::label/parent::div/input");
	By continueButton   = By.xpath("//span[text()='CONTINUE']//parent::button");
	public flipkartAddToCartPage(WebDriver driver)
	{
		this.driver = driver;
	}
	public void clickOnAddToCartButton()
	{
		System.out.println("Clicking On Add To Cart Button");
		driver.findElement(addToCartButton).click();
	}
	public boolean isNotificationDisplayed()
	{
		return driver.findElement(errNotification).isDisplayed();
	}
	public void clickOnCartSymbol()
	{
		System.out.println("Clicking On Cart Symbol");
		driver.findElement(cartSymbol).click();
	}
	public void clickOnplaceOrderButton()
	{
		System.out.println("Clicking On Place Order Button");
		driver.findElement(placeOrderButton).click();
	}
	public void enterEmail(String email)
	{
		System.out.println("Entering an Email");
		driver.findElement(emailInputField).sendKeys(email);
	}
	public void clickOnContinue()
	{
		System.out.println("Clicking On Continue Button");
		driver.findElement(continueButton).click();
	}
}
