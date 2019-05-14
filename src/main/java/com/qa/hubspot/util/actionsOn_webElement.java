package com.qa.hubspot.util;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.hubspot.BasePage.basePage;
import com.qa.hubspot.commons.constants;

public class actionsOn_webElement extends basePage
{

	static WebDriver driver;
	static Properties prop;
	static basePage basepage;
	
	public actionsOn_webElement(WebDriver driver)
	{
		this.driver=driver;
		basepage=new basePage();
		prop=basepage.initialize_properties();
		
	}

	public WebElement getWebElement(By selector)
	{
			WebDriverWait wait=new WebDriverWait(driver,constants.WebElement_Explicit_Wait);
			wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(selector));
			WebElement ele= driver.findElement(selector);
			flash(ele);
			return ele;
	}
	
	
	public String getTextWebEleemnt(By locator)
	{
		   WebElement ele = getWebElement(locator);
		   flash(ele);
		   return ele.getText();
	}

	// Java script Functions
	
	public static void flash(WebElement element) 
	{
		
	    if(prop.getProperty("flashElement").equalsIgnoreCase("yes"))
	    {
	    	System.out.println("flashElement :: " + prop.getProperty("flashElement"));
	    	JavascriptExecutor js = ((JavascriptExecutor) driver);
			String bgcolor = element.getCssValue("backgroundColor");
			for (int i = 0; i < 8; i++) 
			{
				changeColor("rgb(0,200,0)", element);// 1
				changeColor(bgcolor, element);// 2
			}
	    }

	}

	private static void changeColor(String color, WebElement element) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].style.backgroundColor = '" + color + "'", element);

		try {
			Thread.sleep(50);
		} catch (InterruptedException e) {
		}
	}

	public static void drawBorder(WebElement element) 
	{
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].style.border='3px solid red'", element);
	}
	
	
	
	//Other Java Script functions
	
	public static void clickElementByJS(WebElement element)
	{
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].click();", element);

	}

	
	public static String getTitleByJS() {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		String title = js.executeScript("return document.title;").toString();
		return title;
	}
	
	public static void scrollIntoView(WebElement element) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}
	
	public static void sendKeysUsingJS(String id, String value){
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("document.getElementById('" + id + "').value='"+value+"'");
	}
	
}
