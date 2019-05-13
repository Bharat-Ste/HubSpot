package com.qa.hubspot.test;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.hubspot.BasePage.basePage;
import com.qa.hubspot.commons.constants;
import com.qa.hubspot.pages.HomePage_dis;
import com.qa.hubspot.pages.LoginPage;
import com.qa.hubspot.util.commonUtil;

public class HomePageTest_dis 
{
	basePage basepage;
	WebDriver driver;
	Properties prop;
	LoginPage loginpage;
	HomePage_dis homepage;

	@BeforeMethod
	public void setUp()
	{
		basepage = new basePage();
		prop = basepage.initialize_properties();
		driver = basepage.initialize_driver(prop);
		//System.out.println("URL :: " + prop.getProperty("url"));
		driver.get(prop.getProperty("url"));
		
		
		commonUtil.mediumWait();
		
		loginpage =new LoginPage(driver);
		homepage = loginpage.doLogin_(prop.getProperty("username"), prop.getProperty("password"));
		commonUtil.longWait();

	}
	
	@Test(priority=1)
	public void verifyHomePageTitleTest()
	{	
		String title = homepage.getHomePageTitle();
		System.out.println("home page title is: "+ title);
		Assert.assertEquals(title, constants.HOMEPAGE_TITLE);
	}
	
	@Test(priority=2)
	public void verifyHomePageHeaderTest(){
		String header = homepage.getHomePageHeaderValue();
		System.out.println("home page header is: "+ header);
		Assert.assertEquals(header, constants.HOMEPAGE_HEADER);
	}
	
	@Test(priority=3)
	public void verifyLoggedInAccountNameTest(){
		String accountName = homepage.getLoggedInAccountName();
		System.out.println("Logged in account name is: "+ accountName);
		Assert.assertEquals(accountName, prop.getProperty("accountname"));
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

}
