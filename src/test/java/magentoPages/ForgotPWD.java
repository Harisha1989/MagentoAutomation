package magentoPages;

import java.util.regex.Pattern;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ForgotPWD {
	
	@FindBy(id="email_address")
	WebElement emailEle;
	
	@FindBy(xpath="//span[text()='Submit']")
	WebElement submitEle;
	
	@FindBy(className="success-msg")
	WebElement successMsg;
	
	@FindBy(id="advice-validate-email-email_address")
	WebElement invalidEmailEle;
	
	@FindBy(id="advice-required-entry-email_address")
	WebElement reqEmailEle;
	WebDriver driver;
	WebDriverWait wait;
	
	public ForgotPWD(WebDriver driver,WebDriverWait wait)
	{
		this.driver=driver;
		this.wait=wait;
		PageFactory.initElements(driver, this);
	}
	
	public void enterEmail(String username)
	{
		emailEle.sendKeys(username);
	}
	
	public void clickOnSubmit()
	{
		submitEle.click();
	}
	public String getPgSrcORequireEmail()
	{
		wait.until(ExpectedConditions.visibilityOf(reqEmailEle));
		String pageSource=driver.getPageSource();
		return pageSource;
	}
	public String getPgSrcOfSuccessMsg()
	{
		wait.until(ExpectedConditions.visibilityOf(successMsg));
		String pageSource=driver.getPageSource();
		return pageSource;
	}
	public boolean emailValidation(String email) 
    { 
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+ 
                            "[a-zA-Z0-9_+&*-]+)*@" + 
                            "(?:[a-zA-Z0-9-]+\\.)+[a-z" + 
                            "A-Z]{2,7}$"; 
                              
        Pattern pat = Pattern.compile(emailRegex); 
        return pat.matcher(email).matches(); 
    } 
	public String getPgSrcOfInvalidMsg()
	{
		wait.until(ExpectedConditions.visibilityOf(invalidEmailEle));
		String pageInvalidEmail=driver.getPageSource();
		return pageInvalidEmail;		
	}

}
