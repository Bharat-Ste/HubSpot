package com.qa.hubspot.test;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.hubspot.BasePage.basePage;
import com.qa.hubspot.commons.constants;
import com.qa.hubspot.pages.HomePage;
import com.qa.hubspot.pages.LoginPage;
import com.qa.hubspot.util.commonUtil;



public class LoginPageTest 
{
	
	basePage basepage;
	WebDriver driver;
	Properties prop;
	LoginPage loginpage;
	HomePage homepage;
	
	//ElementActions elementActions;
	
	
	@BeforeMethod
	public void setUp()
	{
		basepage = new basePage();
		prop = basepage.initialize_properties();
		driver = basepage.initialize_driver(prop);
		//elementActions=new ElementActions(driver);
		
		System.out.println("URL :: " + prop.getProperty("url"));
		driver.get(prop.getProperty("url"));
		commonUtil.mediumWait();
		loginpage =new LoginPage(driver);
		
	}
	
	@Test(priority=1)
	public void verifyLoginPageTileTest()
	{
		String title =loginpage.getLoginPageTitle();
		System.out.println("Login page Title is  :"+ title);
		Assert.assertEquals(title, constants.LOGINPAGE_TITLE,"LoginPage title not correct");
		
	}
	
	
	@Test(priority=2)
	public void verifySignUpLinkTest()
	{
		Assert.assertTrue(loginpage.verifySignUpLink(),"Sign up is not visible");
	}
	
	
	@Test(priority=3,enabled=true)
	public void loginTest()
	{
		
		homepage = loginpage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		commonUtil.mediumWait();
		Assert.assertEquals(loginpage.getLoginPageTitle(), constants.HOMEPAGE_TITLE);
		
	}
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

}
