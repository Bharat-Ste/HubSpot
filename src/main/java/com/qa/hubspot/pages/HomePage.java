package com.qa.hubspot.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.qa.hubspot.BasePage.basePage;
import com.qa.hubspot.util.commonUtil;


public class HomePage extends basePage{
	
    WebDriver driver;
	
	@FindBy(xpath = "//h1[@class='private-header__heading']/i18n-string")
	WebElement homePageHeader;
		
	@FindBy(xpath = "//span[@class='account-name ']")
	WebElement accountName;
	
	@FindBy(id="nav-primary-contacts-branch")
	WebElement contactMainLink;
	
	@FindBy(id="nav-secondary-contacts")
	WebElement contactSubLink;
	
	public HomePage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public String getHomePageTitle(){
		commonUtil.mediumWait();
		return driver.getTitle();
	}
	
	public String getHomePageHeaderValue(){
		commonUtil.mediumWait();
		return homePageHeader.getText();
	}
	
	public String getLoggedInAccountName(){
		commonUtil.mediumWait();
		System.out.println("AccountName :: " + accountName.getText() );
		return accountName.getText();
	}
	
	public Contects_ContactPage goToContacts_contactPage(){
		contactMainLink.click();
		commonUtil.shortWait();
		contactSubLink.click();
		return new Contects_ContactPage(driver);
	}
}
