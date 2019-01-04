package magentoPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MyAccountPage {
	
	By waitLoc=By.xpath("//a[text()='Log Out']");
	@FindBy(linkText="Log Out")
	WebElement logoutEle;
	
	WebDriverWait wait;
	WebDriver driver;
	
	public MyAccountPage(WebDriver driver,WebDriverWait wait) 
	{
		this.driver=driver;
		this.wait=wait;
		PageFactory.initElements(driver, this);
	}
	
	
	public String getCurrentTitle() 
	{
		wait.until(ExpectedConditions.presenceOfElementLocated(waitLoc));
		String actualTitle=driver.getTitle();
		return actualTitle;	
	}
	public void clickLogout()
	{
		logoutEle.click();
	}
	

}
