package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.hubspot.BasePage.basePage;
import com.qa.hubspot.util.ElementActions;
import com.qa.hubspot.util.actionsOn_webElement;
import com.qa.hubspot.util.commonUtil;

public class Contacts_CompaniesPage extends basePage{
	
	WebDriver driver;
	ElementActions actions=new ElementActions();
	actionsOn_webElement ac;
	
	// Page Repository
	By CompniesPage_Header = By.xpath("//i18n-string[text()='Companies']");
	By Account_name = By.xpath("//span[@class='account-name ']");
	
	//TOP Panel Compnies Buttons
	By CompanySearch_btn = By.xpath("//input[@data-selenium-test='list-search-input']");
	By Action_btn = By.xpath("//i18n-string[text()='Actions']");
	By Import_btn = By.xpath("//span[text()='Import']");
	By CreateCompany_btn = By.xpath("//span[text()='Create company']");
	
	//RIGHT panel Table
	By Table=By.xpath("//table[@data-reagan-test='data-table']//tbody/tr");
	
	//LEFT panel link Buttons
	By left_panel_allCompnies=By.xpath("//span[text()='All companies']");
	By left_panel_allSavedFilters=By.xpath("//i18n-string[text()='All saved filters']");
	By left_panel_allCompnies_two=By.xpath("//strong[text()='All companies']");
	By left_panel_addFilter_lnkBtn=By.xpath("//i18n-string[text()='Add filter']");
	By left_panel_addFilter_lnkBt1n=By.xpath("//i18n-string[text()='Add filter']");
	public Contacts_CompaniesPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	// Methods
	
	
	public String getCompaniesPageTitle()
	{
		commonUtil.mediumWait();
		System.out.println("Page Title : " +driver.getTitle() );
		return driver.getTitle();
	}
	
	public String getCompaniesPageHeaderValue()
	{
		WebElement ele= actions.getWebElement(CompniesPage_Header,driver);
		return ele.getText();
	}
	
	public String getLoggedInAccountName()
	{
		WebElement ele=actions.getWebElement(Account_name,driver);
		return ele.getText();
	}
	
	//TOP Panel Compnies Buttons 
	
	public boolean SearchTextInput_visible_test()
	{
		return actions.getWebElement(CompanySearch_btn,driver).isDisplayed();
	}
	public boolean ActionsBtn_visible_test()
	{
		return actions.getWebElement(Action_btn,driver).isDisplayed();
	}
	public boolean ImportBtn_visible_test()
	{
		ac= new actionsOn_webElement(driver);
		return ac.getWebElement(Import_btn).isDisplayed();
	}
	public boolean CreatecompanyBtn_visible_test()
	{
		//return actions.getWebElement(CreateCompany_btn,driver).isDisplayed();
		ac= new actionsOn_webElement(driver);
		return ac.getWebElement(CreateCompany_btn).isDisplayed();
		
		
	}
	
	
	
}
