package com.qa.hubspot.test;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.hubspot.BasePage.basePage;
import com.qa.hubspot.commons.constants;
import com.qa.hubspot.pages.Contacts_CompaniesPage;
import com.qa.hubspot.pages.HomePage_dis;
import com.qa.hubspot.pages.LoginPage;
import com.qa.hubspot.util.commonUtil;

public class Contacts_CompaniesPage_Test 
{
	
	basePage basepage;
	WebDriver driver;
	Properties prop;
	LoginPage loginpage;
	HomePage_dis homepage;
	//Contects_ContactPage contects_contactPage;
	Contacts_CompaniesPage contacts_companiespage;
	
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
		homepage = loginpage.doLogin_(prop.getProperty("username"), prop.getProperty("password")); 
		
		commonUtil.longWait();
		
		contacts_companiespage= homepage.goToContacts_CompiesPage();

	}
	
	@Test(priority=1,groups="Compnies Page WebElement Test")
	public void verifyHomePageTitle_Test()
	{
		System.out.println("Page title is :: "  + contacts_companiespage.getCompaniesPageTitle() + " compare with expected is :: " + constants.COMPANIESPAGE_TITLE);
		Assert.assertEquals(contacts_companiespage.getCompaniesPageTitle(), constants.COMPANIESPAGE_TITLE);
	}
	
	@Test(priority=2,groups="Compnies Page WebElement Test")
	public void verifyHomePageHeader_Test()
	{
		Assert.assertEquals(contacts_companiespage.getCompaniesPageHeaderValue(), constants.COMPANIESPAGE_HEADER);
	}
	@Test(priority=3,groups="Compnies Page WebElement Test")
	public void verifyLoggedInAccountName_Test()
	{
		Assert.assertEquals(contacts_companiespage.getLoggedInAccountName(), prop.getProperty("accountname"));
	}
	@Test(priority=4,groups="Compnies Page WebElement Test")
	public void verifySearchInputTextBox_Test()
	{
		Assert.assertTrue(contacts_companiespage.SearchTextInput_visible_test());
	}
	@Test(priority=5,groups="Compnies Page WebElement Test")
	public void verifyActionsButton_Test()
	{
		Assert.assertTrue(contacts_companiespage.ActionsBtn_visible_test());
	}
	@Test(priority=6,groups="Compnies Page WebElement Test")
	public void verifyImportBtn_Test()
	{
		Assert.assertTrue(contacts_companiespage.ImportBtn_visible_test());
	}
	@Test(priority=7,groups="Compnies Page WebElement Test")
	public void verifyCreatecompanyBtn_Test()
	{
		Assert.assertTrue(contacts_companiespage.CreatecompanyBtn_visible_test());
	}
	
	@Test(priority=8,groups="Create Company - Feature Test")
	public void CreateComp_addRecord()
	{
		
	}
	
	
	
	@AfterMethod
	public void exitSetup()
	{
		//driver.quit();
	}
	
	

}
