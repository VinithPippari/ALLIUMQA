package com.Locaters;

import org.openqa.selenium.By;

public class HomePage {
	

	public static By mealPlans = By.xpath("//a[contains(text(),' Meal plans')]/..");

	public static By login = By.xpath("//a[contains(text(),'Login')]");

	public static By meetTheChef = By.xpath("//a[contains(text(),'Meet the chef')]");

	public static By home = By.xpath("//a[contains(text(),'Home')]/..");

	public static By createAccount = By.id("mat-tab-label-0-1");

}
