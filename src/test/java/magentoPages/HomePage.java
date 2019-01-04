package magentoPages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	@FindBy(xpath="//span[text()='Account']/ancestor::a")
	WebElement AccEle;
	
	//finding no of links
	@FindAll(@FindBy(tagName="a"))
	List<WebElement> linksEle;
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void clickOnMyAccountIcon()
	{		
		AccEle.click();
	}
	
	//returns no of links
	public int noOfLinks()
	{
		return linksEle.size();
	}
}
