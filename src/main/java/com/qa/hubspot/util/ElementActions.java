package com.qa.hubspot.util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.hubspot.BasePage.basePage;
import com.qa.hubspot.commons.constants;

public class ElementActions extends basePage       // baseClass not extending by me
{
	WebDriver driver;
	
//	public ElementActions(WebDriver driver)
//	{
//		this.driver=driver;
//	}
	
	public WebElement getWebElement(By locator,WebDriver driver)
	{
			WebDriverWait wait=new WebDriverWait(driver,constants.WebElement_Explicit_Wait);
			wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
			WebElement ele= driver.findElement(locator);
			HighlightWebElement(ele);
			return ele;
	}
	
	public void sendKeysWebElement(By locator,String value,WebDriver driver)
	{
		WebElement ele=getWebElement(locator,driver);
		try
		{
			WebDriverWait wait=new WebDriverWait(driver,constants.WebElement_Explicit_Wait);
			wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
			
			HighlightWebElement(ele);
			
			ele.sendKeys(value);
			
		}
		catch(Exception e)
		{
			try
			{
				WebDriverWait wait=new WebDriverWait(driver,constants.WebElement_Explicit_Wait);
				wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
				
				HighlightWebElement(ele);
				
				//javaS_Actions.sendKeysUsingJS(locator, value);           un-implemented 
			}
			catch(Exception e2)
			{
				System.out.println("some issue with JavaScript send keys!!");
				e2.printStackTrace();
				System.out.println(e2.getMessage());
			}
			
		}
		
	}
	
	public void clickOnWebEleemnt(By locator,WebDriver driver)
	{
		try
		{
			WebDriverWait wait=new WebDriverWait(driver,constants.WebElement_Explicit_Wait);
			wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
			WebElement ele= getWebElement(locator,driver);
			
			HighlightWebElement(ele);

			ele.click();
		}
		catch(Exception e)
		{
			try
			{
				WebElement ele= getWebElement(locator,driver);
				HighlightWebElement(ele);
				JavaScriptUtil.clickElementByJS(ele);
			}
			catch(Exception e1)
			{
				System.out.println("JavaScript failed in performing actions !!");
			}
			
			System.out.println("enable to click on button!!");
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
	}
	
	public String getTextWebEleemnt(By locator)
	{
		WebElement ele=null;
		
		try
		{
			WebDriverWait wait=new WebDriverWait(driver,constants.WebElement_Explicit_Wait);
			wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
			ele= getWebElement(locator,driver);
			HighlightWebElement(ele);
			
			return ele.getText();
		}

		catch(Exception e)
		{
			System.out.println("Failed to getText !!");
			e.printStackTrace();
			System.out.println(e.getMessage());
			return null;
		}
		
		
	}
	
	public void HighlightWebElement(WebElement ele)
	{

			JavaScriptUtil.flash(ele);
		
	}
	
	
	public String getPageTitle()
	{
		String title="";
		try
		{
			commonUtil.mediumWait();
			title= driver.getTitle(); 
			System.out.println("Fialed in getting Page title using Driver!!");
		}
		catch(Exception e)
		{
			try
			{
				title=JavaScriptUtil.getTitleByJS();
				//return JavaScriptUtil.getTitleByJS();
				
			}
			catch(Exception e1)
			{
				System.out.println("Fialed in getting Page title using JS!!");
			}
		}
		return title;
	}

}
