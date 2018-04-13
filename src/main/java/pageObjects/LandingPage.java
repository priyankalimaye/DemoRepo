package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
	public WebDriver driver;
	By Signin=By.cssSelector("a[href*='sign_in']");
	By title=By.cssSelector("#content > div > div > h2");
	
	public LandingPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	
	public WebElement getLogin()
	{
		return driver.findElement(Signin);
	}
	public WebElement getTitle()
	{
		return driver.findElement(title);
	}
}
