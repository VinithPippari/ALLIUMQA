package com.properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



public class Driver {

private static WebDriver driver;
	
	private Driver()
	{
		
	}

	public static WebDriver getDriver()
	{
		if(driver==null)
		{
			SystemConfguration.getProperties();
			driver = new ChromeDriver();
			driver.manage().window().maximize();
		}
			
		
		return driver;

	}
	
	public static void setBrowserNull()
	{
		driver=null;
	}
}
