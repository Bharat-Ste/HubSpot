package com.qa.hubspot.util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.hubspot.commons.constants;

public class commonUtil {

	
	public static void shortWait()
	{
		try 
		{
			Thread.sleep(3000);
		} 
		catch (InterruptedException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void mediumWait()
	{
		try 
		{
			Thread.sleep(6000);
		} 
		catch (InterruptedException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void longWait()
	{
		try 
		{
			Thread.sleep(9000);
		} 
		catch (InterruptedException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public static WebElement getWebElement(By locator,WebDriver driver)
	{
		WebDriverWait wait=new WebDriverWait(driver,constants.WebElement_Explicit_Wait);
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
		WebElement ele= driver.findElement(locator);
		return ele;
	}
	
}
