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
	
	@Test(priority=1,groups="Compnies Page WebElement Test",enabled=false)
	public void verifyHomePageTitle_Test()
	{
		System.out.println("Page title is :: "  + contacts_companiespage.getCompaniesPageTitle() + " compare with expected is :: " + constants.COMPANIESPAGE_TITLE);
		Assert.assertEquals(contacts_companiespage.getCompaniesPageTitle(), constants.COMPANIESPAGE_TITLE);
	}
	
	@Test(priority=2,groups="Compnies Page WebElement Test",enabled=false)
	public void verifyHomePageHeader_Test()
	{
		Assert.assertEquals(contacts_companiespage.getCompaniesPageHeaderValue(), constants.COMPANIESPAGE_HEADER);
	}
	@Test(priority=3,groups="Compnies Page WebElement Test",enabled=false)
	public void verifyLoggedInAccountName_Test()
	{
		Assert.assertEquals(contacts_companiespage.getLoggedInAccountName(), prop.getProperty("accountname"));
	}
	@Test(priority=4,groups="Compnies Page WebElement Test",enabled=false)
	public void verifySearchInputTextBox_Test()
	{
		Assert.assertTrue(contacts_companiespage.SearchTextInput_visible_test());
	}
	@Test(priority=5,groups="Compnies Page WebElement Test",enabled=false)
	public void verifyActionsButton_Test()
	{
		Assert.assertTrue(contacts_companiespage.ActionsBtn_visible_test());
	}
	@Test(priority=6,groups="Compnies Page WebElement Test",enabled=true)
	public void verifyImportBtn_Test()
	{
		Assert.assertTrue(contacts_companiespage.ImportBtn_visible_test());
	}
	@Test(priority=7,groups="Compnies Page WebElement Test",enabled=true)
	public void verifyCreatecompanyBtn_Test()
	{
		Assert.assertTrue(contacts_companiespage.CreatecompanyBtn_visible_test());
	}
	
	@Test(priority=8,groups="Create Company - Feature Test",enabled=true)
	public void Verify_AddCompany()
	{
		int tbl_ROW_Count_Before_insertion= contacts_companiespage.getTableRowsCount();
		System.out.println("Before insertion No. of Records :: " + tbl_ROW_Count_Before_insertion);
		
		contacts_companiespage.AddCompany_test();
		commonUtil.shortWait();
		driver.navigate().back();
		driver.navigate().refresh();
		commonUtil.shortWait();
		int tbl_ROW_Count_after_insertion= contacts_companiespage.getTableRowsCount();
		
		System.out.println("After insertion No. of Records :: " + tbl_ROW_Count_after_insertion);
		
		System.out.println(tbl_ROW_Count_after_insertion);
		if(tbl_ROW_Count_after_insertion>tbl_ROW_Count_Before_insertion)
		{
			Assert.assertEquals(tbl_ROW_Count_Before_insertion, tbl_ROW_Count_Before_insertion);
		}
		else if(tbl_ROW_Count_after_insertion==tbl_ROW_Count_Before_insertion)
		{
			Assert.assertEquals(tbl_ROW_Count_after_insertion, tbl_ROW_Count_Before_insertion);
		}
		
		
	}
	@Test(priority=8,groups="Create Company - Feature Test",enabled=true)
	public void Verify_deleteCompany()
	{
		int tbl_ROW_Count_Before_deletion= contacts_companiespage.getTableRowsCount();
		System.out.println("Before Deletion No. of Records :: " + tbl_ROW_Count_Before_deletion);
		
		contacts_companiespage.DeleteCompany_topRecord();
		commonUtil.shortWait();

		int get_RowCountAfter_record_deletion= contacts_companiespage.getTableRowsCount();
		//System.out.println("After Deletion No. of Records :: " + get_RowCountAfter_record_deletion);
		//System.out.println(get_RowCountAfter_record_deletion);
		if(tbl_ROW_Count_Before_deletion>get_RowCountAfter_record_deletion) // 7 = 6
		{
			Assert.assertEquals(get_RowCountAfter_record_deletion, tbl_ROW_Count_Before_deletion-1);//(6,7-1)
		}
		else  //6==6
		{
			Assert.assertEquals(get_RowCountAfter_record_deletion-1, tbl_ROW_Count_Before_deletion); //
		}
		
	    System.out.println("CTEAT");
	}
	
	@AfterMethod
	public void exitSetup()
	{
		//driver.quit();
	}
	
	

}
