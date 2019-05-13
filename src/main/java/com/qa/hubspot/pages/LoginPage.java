package com.qa.hubspot.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.hubspot.BasePage.basePage;
import com.qa.hubspot.util.commonUtil;

public class LoginPage extends basePage
{
	WebDriver driver;
	
	//Page-Objects - With PageFectory OR By Locator
//	@FindBy(id="username") WebElement emailid;
//	@FindBy(id="password") WebElement password;
//	@FindBy(id="loginBtn") WebElement logingBtn;
//	@FindBy(linkText="Sign up") WebElement SignUpLink;
	
	@FindBy(xpath="//input[@id='username']") WebElement emailid;
	@FindBy(xpath="//input[@id='password']") WebElement password;
	@FindBy(xpath="//button[@id='loginBtn']") WebElement logingBtn;
	@FindBy(linkText="Sign up") WebElement SignUpLink;
	
	

	
	// Create a constructor in Init PageFectory
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
		
	}
	
	// Define your actions/methods
	
	public String getLoginPageTitle()
	{
		commonUtil.mediumWait();
		return driver.getTitle();
	}
	
	public boolean verifySignUpLink()
	{
		commonUtil.mediumWait();
		return SignUpLink.isDisplayed();
	}
	
	public HomePage doLogin(String un,String pwd)
	{
		
		
		emailid.sendKeys(un);
		password.sendKeys(pwd);
		commonUtil.mediumWait();
		logingBtn.click();
		
		
		return new HomePage(driver);
	}
	
	public HomePage_dis doLogin_(String un,String pwd)
	{
		
		
		emailid.sendKeys(un);
		password.sendKeys(pwd);
		commonUtil.mediumWait();
		logingBtn.click();
		
		
		return new HomePage_dis(driver);
	}
	
}
