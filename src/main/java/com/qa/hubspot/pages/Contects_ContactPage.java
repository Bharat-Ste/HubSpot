package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.BasePage.basePage;
import com.qa.hubspot.util.ElementActions;
import com.qa.hubspot.util.JavaScriptUtil;

public class Contects_ContactPage extends basePage 
{
	
	WebDriver driver;
	ElementActions ele_Actions;
	JavaScriptUtil javaS_Actions;
	
	By Contacts_Header=By.xpath("//*[@class='private-header__heading']/i18n-string");
	By Search_txtBox=By.xpath("//input[@data-selenium-test='list-search-input']");
	By Actions_btn=By.xpath("//i18n-string[text()='Actions']");
	By Import_btn=By.id("//span[text()='Import']");
	
	By create_contact_btn=By.xpath("//span[text()='Create contact']");
	
	By email=By.xpath("//input[@data-field='email']");
	By firstname=By.xpath("//input[@data-field='firstname']");
	By lastname=By.xpath("//input[@data-field='lastname']");
	By jobtitle=By.xpath("//input[@data-field='jobtitle']");
	By createContact_btn=By.xpath("//li/button/span[text()='Create contact']");
	
	By table=By.xpath("//div[@class='table-responsive']");
	

	public Contects_ContactPage(WebDriver driver)
	{
		this.driver=driver;
		ele_Actions=new ElementActions();
		javaS_Actions = new JavaScriptUtil(driver);
	}
	
	public String getPageitle()
	{
		System.out.println("contact Page tilte is :" + ele_Actions.getPageTitle());
		return ele_Actions.getPageTitle();
	}
	
	public String getContactsPageHeader()
	{
		String header_Text = ele_Actions.getTextWebEleemnt(Contacts_Header);
		System.out.println("contacts page header text is  : " + header_Text);
		return header_Text;
	}
	
	
	public boolean searchTxtBox_visibility()
	{
		return ele_Actions.getWebElement(Search_txtBox,driver).isDisplayed();
	}
	
	public boolean ActionsBtn_visibility()
	{
		return ele_Actions.getWebElement(Actions_btn,driver).isDisplayed();
	}
	
	public boolean Import_btn_visibility()
	{
		return ele_Actions.getWebElement(Import_btn,driver).isDisplayed();
	}
	public boolean create_contact_btn_visibility()
	{
		return ele_Actions.getWebElement(create_contact_btn,driver).isDisplayed();
	}
	
	public void ClickOn_CreateContact()
	{
		ele_Actions.clickOnWebEleemnt(create_contact_btn,driver);
	}
	
	
	public  void createContactsTest(String email_,String firstname_,String lastname_,String jobtitle_)
	{
		ele_Actions.clickOnWebEleemnt(create_contact_btn,driver);
		ele_Actions.sendKeysWebElement(email, email_,driver);
		ele_Actions.sendKeysWebElement(firstname, firstname_,driver);
		ele_Actions.sendKeysWebElement(lastname, lastname_,driver);
		ele_Actions.sendKeysWebElement(jobtitle, jobtitle_,driver);
		ele_Actions.clickOnWebEleemnt(createContact_btn,driver);
	
	}
	
	
	

}
