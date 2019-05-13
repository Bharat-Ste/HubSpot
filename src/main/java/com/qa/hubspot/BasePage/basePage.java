package com.qa.hubspot.BasePage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import com.qa.hubspot.commons.constants;

import io.github.bonigarcia.wdm.WebDriverManager;

public class basePage 
{

	
	WebDriver driver;
	Properties prop;
	
	/**
	 * 
	 * @param prop
	 * @return
	 * Pass Properties Reference here
	 */
	public WebDriver initialize_driver(Properties prop)
	{
		
		String browserName = prop.getProperty("browser");
		String max = prop.getProperty("maximize");
		System.out.println("Maximize browser :: " + max);

		if (browserName.equalsIgnoreCase("chrome")) 
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if (browserName.equalsIgnoreCase("firefox")) 
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} 
		else if (browserName.equals("ie")) 
		{
	
		} 
		else 
		{
			System.out.println("no browser is defined");
		}

		driver.manage().timeouts().pageLoadTimeout(constants.PAGE_LOAD_TIME_OUT, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		if(max.equalsIgnoreCase("yes"))
		{
			driver.manage().window().maximize();
		}

		return driver;

	}
	
	/**
	 * 
	 * @return 
	 * return Prop object
	 */
	public Properties initialize_properties()
	{
		prop = new Properties();
		try {
			FileInputStream ip = new FileInputStream("/Users/bharat/eclipse-workspace/MarchPOMSeries_bharat/src/main/java/com/qa/hubspot/configuration/config.properties");
			try {
				prop.load(ip);
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		
		return prop;
		
		
	}
	
	
	
	
}
