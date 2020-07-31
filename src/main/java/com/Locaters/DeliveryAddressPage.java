package com.Locaters;

import org.openqa.selenium.By;

public class DeliveryAddressPage {
	
public static By firstName = By.name("firstName");
	
	public static By addrline1 = By.name("addrline1");
	
	public static By addrline2 = By.name("addrline2");
	
	public static By zip = By.name("zip");
	
	public static By phonenumber = By.name("phonenumber");
	
	public static By continueButton = By.xpath("//div[contains(.,'Total payable')]//button[contains(text(),'Continue')]");

}
