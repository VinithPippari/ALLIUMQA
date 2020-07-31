package com.properties;

import java.io.FileReader;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

public class SystemConfguration {
	public static WebDriver driver;
	public static void getProperties()
	
	{
		Properties props=new Properties();  
		try {
			FileReader reader=new FileReader(""
					+ "C:\\git projects\\ALLIUM\\ALLIUM\\src\\test\\resources\\config.properties");   
			props.load(reader);   
			
			String s1 = props.getProperty("webdriver");
			System.out.println(s1);
			String s2 =props.getProperty("webdriverpath");
		    System.out.println(props.getProperty("webdriverpath"));
		    System.setProperty(s1 , s2);
		  
		}
		catch(Exception e)
		{
			
		}
	 
}
}
