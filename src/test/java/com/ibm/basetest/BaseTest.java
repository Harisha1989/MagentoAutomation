package com.ibm.basetest;

import org.testng.annotations.Test;

import magentoPages.HomePage;
import magentoPages.LoginPage;
import magentoPages.MyAccountPage;

import org.testng.AssertJUnit;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BaseTest {
	@Test
	public void LoginTest()
	{
		System.setProperty("webdriver.gecko.driver", "./Drivers/geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 60); // 60 to 90


		driver.get("https://magento.com");
		

		HomePage home = new HomePage(driver);
		home.clickOnMyAccountIcon();

		LoginPage login = new LoginPage(driver, wait);
		login.enterEmailAddress("balajidinakaran1@gmail.com");
		login.enterPassword("Welcome123");
		login.clickOnLogin();

		MyAccountPage myAccount = new MyAccountPage(driver, wait);
		String actualTitle = myAccount.getCurrentTitle();

		AssertJUnit.assertEquals(actualTitle, "My Account","Title check after login");
		
		myAccount.clickLogout();
	}

	
}
