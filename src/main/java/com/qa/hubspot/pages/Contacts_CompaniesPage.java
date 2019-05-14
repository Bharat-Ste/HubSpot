package com.qa.hubspot.pages;

import java.util.List;

import org.openqa.selenium.Alert;
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
	By CreateCompany_btn_one = By.xpath("//span[text()='Create company']");
	By Comp_DominName_txt=By.xpath("(//input[@class='form-control private-form__control'])[1]");
	By Comp_Name_txt = By.xpath("(//input[@class='form-control private-form__control'])[2]");
	By Create_Comp_Btn_Two = By.xpath("//button/span[text()='Create company']");
	
	
	
	By fist_CompanyCheckBox= By.xpath("//table/tbody/tr[1]/td[2]/div/div[1]//ancestor::td//preceding::td");
	By PermanentDelete_Comp_header_btn= By.xpath("//span[text()='Permanently delete']");
	
	By Delete_recording_alrt_bt =By.xpath("//div[@role='dialog']//button[@data-confirm-button='accept']");
	By comp_deletePop_input= By.xpath("//div[@role='dialog']//textarea");
	//RIGHT panel Table
	By Table=By.xpath("//table[@data-reagan-test='data-table']//tbody/tr");
	
	//LEFT panel link Buttons
	By left_panel_allCompnies=By.xpath("//span[text()='All companies']");
	By left_panel_allSavedFilters=By.xpath("//i18n-string[text()='All saved filters']");
	By left_panel_allCompnies_two=By.xpath("//strong[text()='All companies']");
	By left_panel_addFilter_lnkBtn=By.xpath("//i18n-string[text()='Add filter']");
	//By left_panel_addFilter_lnkBt4n=By.xpath("//i18n-string[text()='Add filter']");
	
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
		//ac= new actionsOn_webElement(driver);
		return ac.getWebElement(Import_btn).isDisplayed();
	}
	public boolean CreatecompanyBtn_visible_test()
	{
		
		ac= new actionsOn_webElement(driver);
		return ac.getWebElement(CreateCompany_btn_one).isDisplayed();

	}
	
	public int getTableRowsCount()
	{
		ac= new actionsOn_webElement(driver);
		WebElement ele = ac.getWebElement(Table);
		List<WebElement> list= driver.findElements(Table);
		return list.size();
	}
	
	public List<WebElement> getTable_ListCount(By Table)
	{
		ac= new actionsOn_webElement(driver);
		WebElement ele = ac.getWebElement(Table);
		List<WebElement> list= driver.findElements(Table);
		return list;
	}
	
	public void AddCompany_test()
	{
		ac= new actionsOn_webElement(driver);
		WebElement ele = ac.getWebElement(CreateCompany_btn_one);
		ele.click();
		
		WebElement ele1=ac.getWebElement(Comp_DominName_txt);
		ele1.sendKeys("Automation_qa_5.com");
		WebElement ele2=ac.getWebElement(Comp_Name_txt);
		ele2.sendKeys("Bbs_automation_5");

		WebElement ele3=ac.getWebElement(Create_Comp_Btn_Two);
		ele3.click();
		commonUtil.shortWait();

	}
	
	public void DeleteCompany_topRecord()
	{
		WebElement ele = ac.getWebElement(fist_CompanyCheckBox);
		ele.click();
		commonUtil.shortWait();
		WebElement ele2 = ac.getWebElement(PermanentDelete_Comp_header_btn);
		ele2.click();
		commonUtil.mediumWait();
		WebElement el3=ac.getWebElement(comp_deletePop_input);
		el3.sendKeys("1");
		
		WebElement delete_btn=ac.getWebElement(Delete_recording_alrt_bt);
		delete_btn.click();
		commonUtil.shortWait();
	}
	
}
