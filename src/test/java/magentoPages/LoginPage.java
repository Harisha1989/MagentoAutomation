package magentoPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class LoginPage {
	
	@FindBy(xpath="//input[@title='Email']")
	WebElement emailEle;
	
	@FindBy(xpath="//input[@id='pass']")
	WebElement passEle;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement loginEle;
	
	@FindBy(className="error-msg")
	WebElement errorMsg;
	
	@FindBy(partialLinkText="Forgot Your Password")
	WebElement forgotPWDEle;
	
	WebDriverWait wait;
	WebDriver driver;
	
	public LoginPage(WebDriver driver, WebDriverWait wait) {
		this.driver=driver;
		this.wait=wait;
		PageFactory.initElements(driver, this);
	}
	public void enterEmailAddress(String username)
	{
		emailEle.sendKeys(username);
		
	}
	public void enterPassword(String password)
	{
		passEle.sendKeys(password);

	}
	public void clickOnLogin()
	{
		
		loginEle.click();
	}
	public String getPagesourceForInvalidMsg()
	{
		wait.until(ExpectedConditions.visibilityOf(errorMsg));
		String pageSource=driver.getPageSource();
		return pageSource;
	}
	public void clickonForgotPWD()
	{
		forgotPWDEle.click();
	}

}
