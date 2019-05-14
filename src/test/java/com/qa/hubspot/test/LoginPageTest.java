package com.qa.hubspot.test;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.hubspot.BasePage.basePage;
import com.qa.hubspot.commons.constants;
import com.qa.hubspot.pages.HomePage;
import com.qa.hubspot.pages.LoginPage;
import com.qa.hubspot.util.ExcelUtil;
import com.qa.hubspot.util.commonUtil;



public class LoginPageTest 
{
	
	basePage basepage;
	WebDriver driver;
	Properties prop;
	LoginPage loginpage;
	HomePage homepage;

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
	
	@Test(priority=1,enabled=true)
	public void verifyLoginPageTileTest()
	{
		String title =loginpage.getLoginPageTitle();
		System.out.println("Login page Title is  :"+ title);
		Assert.assertEquals(title, constants.LOGINPAGE_TITLE,"LoginPage title not correct");
	}
	
	@Test(priority=2,enabled=true)
	public void verifySignUpLinkTest()
	{
		Assert.assertTrue(loginpage.verifySignUpLink(),"Sign up is not visible");
	}
	
	@DataProvider(name="getLoginData")
	public Object[][] getContextTestData()
	{
		Object logindata[][]=ExcelUtil.getTestData("login");
		return logindata;
	}
	
	@Test(dataProvider="getLoginData",priority=3,enabled=true)
	public void verify_LoginPage_negative_tests(String username,String password)
	{
		commonUtil.mediumWait();
		String actualMsg=loginpage.userNamePwd_Negative_Tests(username,password);
		System.out.println("actualMsg : " + actualMsg);
		if(actualMsg.contains(constants.LOGINPAGE_INVALID_EMAIL_MSG))
		{
			Assert.assertTrue(actualMsg.contains(constants.LOGINPAGE_INVALID_EMAIL_MSG));
		}
		else if(actualMsg.contains(constants.LOGINPAGE_INVALID_PASSWORD_MSG))
		{
			Assert.assertTrue(actualMsg.contains(constants.LOGINPAGE_INVALID_PASSWORD_MSG));
		}
		else if(actualMsg.contains(constants.LOGINPAGE_INVALID_NoT_ExistEmailID_MSG))
		{
			Assert.assertTrue(actualMsg.contains(constants.LOGINPAGE_INVALID_NoT_ExistEmailID_MSG));
		}
		else
		{
			System.out.println("Check Login page for other errors.");
			Assert.fail();
		}
	}	
	@Test(priority=5,enabled=true)
	public void loginTest()
	{
		homepage = loginpage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		commonUtil.mediumWait();
		Assert.assertEquals(loginpage.getLoginPageTitle(), constants.HOMEPAGE_TITLE);
	}
	
	@Test(priority=6,enabled=true)
	public void EnterPress_test()
	{
		loginpage.PressEnterKey();
	}
	
	@Test(priority=7,enabled=true)
	public void gamilSignIN_TEST()
	{
		loginpage.gamil_signIN();
	}

	@AfterMethod
	public void tearDown()
	{
	    driver.quit();
	}

}
