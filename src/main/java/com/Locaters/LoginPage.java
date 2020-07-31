package com.Locaters;

import org.openqa.selenium.By;

public class LoginPage {

	public static By userName = By.xpath("//input[@formcontrolname='email']");

	public static By password = By.name("password");

	public static By login = By.xpath("//span[contains(text(),'Login')]");
	
	public static By createAcount = By.xpath("//div[@id='mat-tab-label-0-1']");
	
	public static By firstName = By.name("firstName");
	
	public static By lastName = By.name("lastName");
	
	public static By zipcode = By.name("zipcode");
	
	public static By email = By.name("email");
	
	public static By cliclOnCreateAccount = By.xpath("//span[contains(text(),'Create account')]/..");
	
}
