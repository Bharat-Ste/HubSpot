package com.qa.hubspot.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.hubspot.BasePage.basePage;
import com.qa.hubspot.util.ExcelUtil;
import com.qa.hubspot.util.commonUtil;

public class LoginPage extends basePage
{
	WebDriver driver;
	
	//Page-Objects - With PageFectory OR By Locator
//	@FindBy(id="username") WebElement emailid;
//	@FindBy(id="password") WebElement password;
//	@FindBy(id="loginBtn") WebElement logingBtn;
//	@FindBy(linkText="Sign up") WebElement SignUpLink;
	
	@FindBy(xpath="//input[@id='username']") WebElement emailid_;
	@FindBy(xpath="//input[@id='password']") WebElement password_;
	@FindBy(xpath="//button[@id='loginBtn']") WebElement logingBtn;
	@FindBy(linkText="Sign up") WebElement SignUpLink;
	@FindBy(xpath="//i18n-string[@data-key='login.formValidation.invalidEmail']") WebElement invalidEmail_msg;
	@FindBy(xpath="//i18n-string[@data-key='login.errors.INVALID_PASSWORD.body']") WebElement invalidPwd_msg;
	@FindBy(xpath="/b") WebElement ab1;
	@FindBy(xpath="//a") WebElement ab2;
	
	
	

	
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
	
	
	
	public String enterWrongEmail(String username,String password)
	{
		emailid_.sendKeys(username);
		Actions act= new Actions(driver);
		act.sendKeys(Keys.ENTER);
		
		commonUtil.shortWait();
		
		System.out.println(" Invalid Email Text : " + invalidEmail_msg.getText());
		return invalidEmail_msg.getText();
	}
	

	public String enterWrongPassword(String username,String password)
	{
		password_.sendKeys(password);
		Actions act= new Actions(driver);
		act.sendKeys(Keys.ENTER);
		
		commonUtil.shortWait();
		
		System.out.println(" Invalid Email Text : " + invalidPwd_msg.getText());
		return invalidPwd_msg.getText();
	}
	
	@Test(enabled=false)
	public HomePage doLogin(String un,String pwd)
	{
		
		
		emailid_.sendKeys(un);
		password_.sendKeys(pwd);
		commonUtil.mediumWait();
		logingBtn.click();
		
		
		return new HomePage(driver);
	}
	
	public HomePage_dis doLogin_(String un,String pwd)
	{
		
		
		emailid_.sendKeys(un);
		password_.sendKeys(pwd);
		commonUtil.mediumWait();
		logingBtn.click();
		
		
		return new HomePage_dis(driver);
	}
	
	
	
}
