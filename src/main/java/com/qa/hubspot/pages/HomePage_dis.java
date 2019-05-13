package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.hubspot.BasePage.basePage;
import com.qa.hubspot.util.ElementActions;
import com.qa.hubspot.util.commonUtil;

public class HomePage_dis extends basePage
{
	
	
	
	
    WebDriver driver; 
    ElementActions elementaction=new ElementActions();//=new ElementActions(driver); 
	
	By HomePage_Header=By.xpath("//h1/i18n-string");
	By HOMEPAGE_LOGO= By.xpath("//div[@class='desktop-nav-left-container']//a/img");
	// Search Button
	By Search_btn= By.xpath("//input[@id='navSearch-input' and @class='navSearch-input']");
	// Settings Btn
	By Setting_btn = By.xpath("//a[@id='navSetting' and @class='primary-link primary-link--icon']");
	// Bell Btn
	By Bell_btn = By.xpath("//*[@id=\"Fill-1\"]");
	// Account display Name
	By Account_name = By.xpath("//span[@class='account-name ']");
	
		//--------------------------- Contacts ---------------------------------------------
	
		//Contacts 
				By Contacts_menu_lnkBtn=By.xpath("(//a[@id='nav-primary-contacts-branch'])[1]"); 
				By Contacts_Contacts_lnkbtn=By.xpath("(//a[@id='nav-secondary-contacts' and @class='navSecondaryLink'])[1]");
				By Contacts_Compnies_lnkBtn = By.xpath("(//a[@id='nav-secondary-companies' and @class='navSecondaryLink'])[1]");
				By Contacts_ActivityFeed_lnkBtn = By.xpath("(//a[@id='nav-secondary-activity' and @class='navSecondaryLink'])[1]");
				
		
//		By Contacts_menu_lnkBtn=By.id("nav-primary-contacts-branch");
//		By Contacts_Contacts_lnkbtn=By.id("nav-secondary-contacts");
//		By Contacts_Compnies_lnkBtn = By.id("nav-secondary-companies");
//		By Contacts_ActivityFeed_lnkBtn = By.id("nav-secondary-activity");
	
		//--------------------------- Conversations ---------------------------------------------*/
		
		//Conversations
		
		//		By Conversations_menu_btn=By.xpath("(//a[@id='nav-primary-conversations-branch' and @class='primary-link'])[1]");
		//		By Conversations_inbox_lnkbtn=By.xpath("(//a[@id='nav-secondary-inbox' and @class='navSecondaryLink'])[1]");
		//		By Conversations_ChatBoxFlows_lnkBtn = By.xpath("(//a[@id='nav-secondary-chatflows' and @class='navSecondaryLink'])[1]");
		//		By Conversations_Snippets_lnkBtn = By.xpath("(//a[@id='nav-secondary-snippets' and @class='navSecondaryLink'])[1]");
		//		By Conversations_templates_lnkBtn = By.xpath("(//a[@id='nav-secondary-templates' and @class='navSecondaryLink'])[1]");
		
		By Conversations_menu_btn=By.id("nav-primary-conversations-branch");
		By Conversations_inbox_lnkbtn=By.id("nav-secondary-inbox'");
		By Conversations_ChatBoxFlows_lnkBtn = By.id("nav-secondary-chatflows");
		By Conversations_Snippets_lnkBtn = By.id("nav-secondary-snippets");
		By Conversations_templates_lnkBtn = By.id("nav-secondary-templates");
			
		//-------------------------- Marketing ---------------------------------------------
			
		By Marketing_menu_btn=By.id("nav-primary-marketing-branch");
		By Marketing_Ads_lnkbtn=By.id("nav-secondary-ads-free");
		By Marketing_Email_lnkBtn = By.id("nav-secondary-email");
		By Marketing_landing_lnkBtn = By.id("nav-secondary-landing-pages");
		By Marketing_Forms_lnkBtn = By.id("nav-secondary-forms");
			
		//--------------------------- Sales ---------------------------------------------
		
		By Sales_menu_btn=By.id("nav-primary-sales-branch");
		By Sales_Deals_lnkbtn=By.id("nav-secondary-deals");
		By Sales_Tasks_lnkBtn = By.id("nav-secondary-tasks");
		By Sales_Documents_lnkBtn = By.id("nav-secondary-documents");
		By Sales_Meetings_lnkBtn = By.id("nav-secondary-meetings");
		By Sales_PlayBooks_lnkBtn = By.id("nav-secondary-playbooks");	
					
		//--------------------------- Service ---------------------------------------------
		//				By Service_menu_btn=By.xpath("(//a[@id='nav-primary-service-branch' and @class='primary-link'])[1]");
		//				By Service_Tickets_lnkbtn=By.xpath("(//a[@id='nav-secondary-tickets' and @class='navSecondaryLink'])[1]");
		//				By Service_Customer_FeedBack_lnkBtn = By.xpath("(//a[@id='nav-secondary-feedback' and @class='navSecondaryLink'])[1]");
		//				By Service_knowledgeBase_lnkBtn = By.xpath("(//a[@id='nav-secondary-knowledge' and @class='navSecondaryLink'])[1]");							
		By Service_menu_btn=By.id("nav-primary-service-branch");
		By Service_Tickets_lnkbtn=By.id("nav-secondary-tickets");
		By Service_Customer_FeedBack_lnkBtn = By.id("nav-secondary-feedback");
		By Service_knowledgeBase_lnkBtn = By.id("nav-secondary-knowledge");
				
		//--------------------------- Automation ---------------------------------------------
		//				By Automation_menu_btn=By.xpath("(//a[@id='nav-primary-automation-branch' and @class='primary-link'])[1]");
		//				By Automation_sequences_lnkbtn=By.xpath("(//a[@id='nav-secondary-sequences' and @class='navSecondaryLink'])[1]");
		//				By Automation_workflows_lnkBtn = By.xpath("(//a[@id='nav-secondary-workflows' and @class='navSecondaryLink'])[1]")
		By Automation_menu_btn=By.id("nav-primary-automation-branch");
		By Automation_sequences_lnkbtn=By.id("nav-secondary-sequences");
		By Automation_workflows_lnkBtn = By.id("nav-secondary-workflows");
					
		//--------------------------- Reports ---------------------------------------------
					
		//			By Reports_menu_btn=By.xpath("(//a[@id='nav-primary-reports-branch' and @class='primary-link'])[1]");
		//			By Reports_analyticsTools_lnkbtn=By.xpath("(//a[@id='nav-secondary-analytics-tools' and @class='navSecondaryLink'])[1]");
		//			By Reports_dashboards_lnkBtn = By.xpath("(//a[@id='nav-secondary-dashboards' and @class='navSecondaryLink'])[1]");
		//			By Reports_reports_lnkBtn = By.xpath("(//a[@id='nav-secondary-reports-list' and @class='navSecondaryLink'])[1]");
		By Reports_menu_btn=By.id("nav-primary-reports-branch");
		By Reports_analyticsTools_lnkbtn=By.id("nav-secondary-analytics-tools");
		By Reports_dashboards_lnkBtn = By.id("nav-secondary-dashboards");
		By Reports_reports_lnkBtn = By.id("nav-secondary-reports-list");	
					
	

		public HomePage_dis(WebDriver driver)
		{
			this.driver = driver;
			
		}

		
		public String getHomePageTitle()
		{
			commonUtil.mediumWait();
			return driver.getTitle();
		}
		
		public String getHomePageHeaderValue()
		{
			WebElement ele= elementaction.getWebElement(HomePage_Header,driver);
			return ele.getText();
		}
		
		public String getLoggedInAccountName()
		{
			WebElement ele=elementaction.getWebElement(Account_name,driver);
			return ele.getText();
		}
		
		
	//-------------------------- Contacts ---------------------------------------------
	
		
			public Contects_ContactPage goToContacts_contactPage()
			{
				elementaction.getWebElement(Contacts_menu_lnkBtn,driver).click();
				elementaction.getWebElement(Contacts_Contacts_lnkbtn,driver).click();
				return new Contects_ContactPage(driver);
			}
			
			
			public Contacts_CompaniesPage goToContacts_CompiesPage()
			{
				System.out.println("inside goToContacts_CompiesPage() page.");
				WebElement ele = driver.findElement(Contacts_menu_lnkBtn);
				ele.click();
				commonUtil.mediumWait();
				WebElement ele_ = driver.findElement(Contacts_Compnies_lnkBtn);
				ele_.click();			
				return new Contacts_CompaniesPage(driver);
			}
			
			public Contacts_CompaniesPage goToContacts_CompiesPage1()
			{
				System.out.println("inside goToContacts_CompiesPage() page.");
				WebElement ele = elementaction.getWebElement(Contacts_menu_lnkBtn,driver);
				ele.click();
				WebElement ele1 =elementaction.getWebElement(Contacts_Compnies_lnkBtn,driver);
				ele1.click();
				
				return new Contacts_CompaniesPage(driver);
			}
			public Contects_ContactPage goToContacts_ActivityFeedPage()
			{
				elementaction.getWebElement(Contacts_menu_lnkBtn,driver).click();
				elementaction.getWebElement(Contacts_ActivityFeed_lnkBtn,driver).click();
				return new Contects_ContactPage(driver);
			}

	
			
	
}
