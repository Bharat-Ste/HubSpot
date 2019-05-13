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
import com.qa.hubspot.pages.Contects_ContactPage;
import com.qa.hubspot.pages.HomePage;
import com.qa.hubspot.pages.LoginPage;
import com.qa.hubspot.util.ExcelUtil;
import com.qa.hubspot.util.commonUtil;

public class Contacts_ContactPageTest 
{
	basePage basepage;
	WebDriver driver;
	Properties prop;
	LoginPage loginpage;
	HomePage homepage;
	Contects_ContactPage contects_contactPage;
	
	
	@BeforeMethod
	public void setUp()
	{
		basepage = new basePage();
		prop = basepage.initialize_properties();
		driver = basepage.initialize_driver(prop);
		System.out.println("URL :: " + prop.getProperty("url"));
		driver.get(prop.getProperty("url"));
		commonUtil.mediumWait();
		loginpage =new LoginPage(driver);
		homepage = loginpage.doLogin(prop.getProperty("username"), prop.getProperty("password")); 
		commonUtil.mediumWait();
		contects_contactPage= homepage.goToContacts_contactPage();

	}
	
	
	@Test(priority=1,enabled=false)
	public void verifyContactPageTile()
	{
		Assert.assertEquals(contects_contactPage.getPageitle(), constants.CONTACTPAGE_TITLE);
	}
	
	@Test(priority=2,enabled=false)
	public void verifyContactsPageHeader()
	{
		Assert.assertEquals(contects_contactPage.getContactsPageHeader(), constants.CONTACTPAGE_HEADER);
	}
	
	@Test(priority=3,enabled=false)
	public void verifysearchTxtBox_visibility()
	{
		Assert.assertTrue(contects_contactPage.searchTxtBox_visibility());
	}
	@Test(priority=4,enabled=false)
	public void verifyActionsBtn_visibility()
	{
		Assert.assertTrue(contects_contactPage.ActionsBtn_visibility());
	}
	@Test(priority=5,enabled=false)
	public void verifyImport_btn_visibility()
	{
		Assert.assertTrue(contects_contactPage.Import_btn_visibility());
	}
	@Test(priority=5,enabled=false)
	public void verifycreate_contact_btn_visibility()
	{
		Assert.assertTrue(contects_contactPage.create_contact_btn_visibility());
	}
	
	@Test(priority=6,enabled=false)
	public void createContactsTest1()
	{
		contects_contactPage.createContactsTest("abc@gmail.com", "Raveka", "joe", "SDET");
	}
	
	@DataProvider(name="getContactsData")
	public Object[][] getContextTestData()
	{
		Object contactData[][]=ExcelUtil.getTestData("contacts");
		return contactData;
	}

	@Test(priority=6,dataProvider="getContactsData",enabled=true)
	public void createContactsTest(String email,String firstname,String lastname,String jobtitle)
	{
		contects_contactPage.createContactsTest(email, firstname, lastname, jobtitle);
	}
	
	
	@AfterMethod
	public void exitSetup()
	{
		driver.quit();
	}

}
