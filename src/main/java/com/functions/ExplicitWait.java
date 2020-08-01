package com.functions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.properties.Driver;

public class ExplicitWait {

	public static void forClickableAndVisibility(String locater , int sec)
	{
		WebDriverWait wait = new WebDriverWait(Driver.getDriver() , sec);
		wait.pollingEvery(Duration.ofMillis(100));
		wait.ignoring(org.openqa.selenium.NoSuchElementException.class);
		wait.ignoring(org.openqa.selenium.StaleElementReferenceException.class);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locater)));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(locater)));
	}
}
