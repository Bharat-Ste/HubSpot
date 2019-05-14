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
	
	@FindBy(xpath="//input[@id='username']") WebElement emailid_;
	@FindBy(xpath="//input[@id='password']") WebElement password_;
	@FindBy(xpath="//button[@id='loginBtn']") WebElement logingBtn;
	@FindBy(linkText="Sign up") WebElement SignUpLink;
	@FindBy(xpath="//i18n-string[@data-key='login.formValidation.invalidEmail']") WebElement invalidEmail_msg;
	@FindBy(xpath="//i18n-string[@data-key='login.errors.INVALID_PASSWORD.body']") WebElement invalidPwd_msg;
	
	@FindBy(xpath="//span[text()='Sign in with Google']") WebElement gmailLoginBtn;
	@FindBy(xpath="//input[@type='email']") WebElement gmail_emailID;
	@FindBy(xpath="//span[text()='Next']") WebElement gmail_nextBtn;
	@FindBy(xpath="//input[@type='password']") WebElement gmail_pwd; // click above next button again
	
	
	public void gamil_signIN()
	{
		commonUtil.shortWait();
		gmailLoginBtn.click();
		
		commonUtil.shortWait();
		gmail_emailID.sendKeys("bharatwiziq@gmail.com");
		gmail_nextBtn.click();
		commonUtil.shortWait();
		gmail_pwd.sendKeys("Auth@Bha!");
		commonUtil.shortWait();
		gmail_nextBtn.click();
		
	}
	

	
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
	
	
	
	public String userNamePwd_Negative_Tests(String username,String password)
	{
		commonUtil.shortWait();
		emailid_.sendKeys(username);
		password_.sendKeys(password);
		String msg="";
		logingBtn.click();
		commonUtil.longWait();
		try
		{
			msg =invalidEmail_msg.getText();
		}
		catch(Exception e)
		{
			try
			{
				msg= invalidPwd_msg.getText();
			}
			catch(Exception e1)
			{
				msg="Password catch block.";
			}
		}
		return msg;
		
	}
	
	
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
	
	
	
	public void PressEnterKey()
	{
		commonUtil.mediumWait();
		emailid_.sendKeys("2@#$@");
		commonUtil.shortWait();
//		Actions act = new Actions(driver);
//		act.sendKeys(Keys.RETURN).build().perform();
		System.out.println("actions for Enter performed ???");
		
		password_.sendKeys("");
		
	}
	
	
	public void gmailLogin()
	{
		
		gmailLoginBtn.click();
	}
	
}
