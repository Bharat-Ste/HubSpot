package com.qa.hubspot.util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.hubspot.BasePage.basePage;

public class actionsOn_webElement extends basePage
{

	WebDriver driver;
	
	public actionsOn_webElement(WebDriver driver)
	{
		this.driver=driver;
		
	}
	
	public WebElement getWebElement(By selector)
	{
		WebElement ele= driver.findElement(selector);
		return ele;
		
	}
	
	
}
