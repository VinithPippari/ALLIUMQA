package com.Classes;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.functions.ExplicitWait;
import com.properties.Driver;

public class MyAccountAllium {

	
	@Parameters({ "email", "password", "url" })
	@Test(alwaysRun = true, enabled = true)
	public void login(String email, String password, String url) throws InterruptedException {

		Driver.getDriver().get(url);

		Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		String loginButtonXpath = "//a[contains(text(),'Login')]";
		
		ExplicitWait.forClickableAndVisibility(loginButtonXpath, 10);

		WebElement login = Driver.getDriver().findElement(By.xpath(loginButtonXpath));

		//login = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Login')]")));

		login.click();

		Driver.getDriver().findElement(By.xpath("//input[@formcontrolname='email']")).sendKeys(email);

		Driver.getDriver().findElement(By.name("password")).sendKeys(password);

		Driver.getDriver().findElement(By.xpath("//span[contains(text(),'Login')]")).click();
	}

	@Test(dependsOnMethods = { "login" }, alwaysRun = true)
	public void clickOnMyAccount() {
		// Click on Account User

		String loginXpath = "//a[@id='menu1']";
		
		ExplicitWait.forClickableAndVisibility(loginXpath, 10);
		
		WebElement one = Driver.getDriver().findElement(By.xpath(loginXpath));
	//	one = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@id='menu1']")));
		one.click();

		 Driver.getDriver().findElement(By.xpath("//a[contains(text(),'Meet the"
		 		+ "chef')]/../following-sibling::li[2]")).click();

		// Click on My Account
		Driver.getDriver().findElement(By.xpath("//a[contains(text(),'My account')]")).click();
	}

	@Test(dependsOnMethods = { "clickOnMyAccount" }, alwaysRun = true , enabled=false)
	public void clickOnEditProfile() {
		// click on edit profile

		String editProfXpath = "//div[contains(text(),'Edit Profile')]/..//div[3]";
		
		ExplicitWait.forClickableAndVisibility(editProfXpath, 10);
		
		WebElement editProfile = Driver.getDriver().findElement(By.xpath(editProfXpath)) ;
	//	one = wait.until(
			//	ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(text(),'Edit Profile')]/..//div[3]")));
		
		editProfile.click();

		// driver.findElement(By.xpath("//div[contains(text(),'Edit
		// Profile')]")).click();

	}

	@Parameters({ "changeFirstName" })
	@Test(dependsOnMethods = { "clickOnEditProfile" }, alwaysRun = true ,  enabled=false)
	public void changeFirstname(String changeFirstName) throws InterruptedException {
		// Click ojn first name
		Driver.getDriver().findElement(By.xpath("//div[contains(text(),'First name')]/..")).click();

		Driver.getDriver().findElement(By
				.xpath("//form//div//input[@name='firstName']/../following-sibling::div/preceding-sibling::div//input"))
				.clear();

		Driver.getDriver().findElement(By
				.xpath("//form//div//input[@name='firstName']/../following-sibling::div/preceding-sibling::div//input"))
				.sendKeys(changeFirstName);

		Driver.getDriver().findElement(By.xpath("//button[contains(text(),'Save changes')]")).click();
		
		// input[@name='firstName']/parent::*/following-sibling::div

	}

	@Parameters({ "changeLastName" })
	@Test(dependsOnMethods = { "clickOnEditProfile" }, alwaysRun = true , enabled=false)
	public void changeLastname(String changeLastName) {
		WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 20);
		// click on last name

		WebElement lastName;

		lastName = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(text(),'Last name')]/..")));

		lastName.click();

		// driver.findElement(By.xpath("//div[contains(text(),'Last
		// name')]/..")).click();
		Driver.getDriver().findElement(By.xpath("//form//div//input[@name='firstName']/../following-sibling::div//input")).clear();

		Driver.getDriver().findElement(By.xpath("//form//div//input[@name='firstName']/../following-sibling::div//input"))
				.sendKeys(changeLastName);

		Driver.getDriver().findElement(By.xpath("//button[contains(text(),'Save changes')]")).click();
	}
	
	@Parameters({ "upgradeMealPlanNumber" })
	@Test(dependsOnMethods = { "clickOnMyAccount" },alwaysRun = true , enabled=false)
	public void upgradeMealPlan(String upgradeMealPlanNumber) throws InterruptedException
	{
		Driver.getDriver().findElement(By.xpath("//span[contains(text(),'Meal plan')]/..")).click();
		
		String upgradeMealXpathPart1 ="//div[contains(text(),' ";
		
		String upgradeMealXpathPart2 = " Meals per week ')]/../following-sibling::div//button";
		
		String upgradeMealXpath = upgradeMealXpathPart1+upgradeMealPlanNumber+upgradeMealXpathPart2;
		
		System.out.println(upgradeMealXpath);
		
		WebElement upgradeMealPlan = Driver.getDriver().findElement(By.xpath(upgradeMealXpath));
		
		Thread.sleep(500);
		((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);", upgradeMealPlan);
		Thread.sleep(500);
		((JavascriptExecutor) Driver.getDriver()).executeScript("window.scrollBy(0,-300)");
		
		upgradeMealPlan.click();
		
	//driver.findElement(By.xpath("//div[contains(text(),' 6 Meals per week ')]/../following-sibling::div//button")).click();
	}
	
	@Test(dependsOnMethods = { "clickOnMyAccount" },alwaysRun = true , enabled=false)
	public void clickOnPayments() throws InterruptedException
	{
		Driver.getDriver().findElement(By.xpath("//span[contains(text(),'Payment options')]/..")).click();
		
		Driver.getDriver().findElement(By.
				xpath("//span[contains(text(),'4242')]/../preceding-sibling::div/following-sibling::div[3]/descendant::div[2]"))
		.click();
		
		//update  card
		Thread.sleep(500);
	//	driver.findElement(By.xpath("//div[contains(text(),'Update credit card')]")).click();
		
		//make it primary
		
		Driver.getDriver().findElement(By.xpath("//div[contains(text(),'Make it Primary')]")).click();
		
		//Remove 
		
	//	driver.findElement(By.xpath("//div[contains(text(),' Remove')]")).click();
	}
	
	//
	
	@Parameters({"orderNo"})
	@Test(dependsOnMethods = { "clickOnMyAccount" },alwaysRun = true , enabled=false)
	public void clickOnMyTransactions(String orderNo) throws InterruptedException
	{
		
		Driver.getDriver().findElement(By.xpath("//span[contains(text(),'Transactions')]/..")).click();
		
		String orderXpathPart1 ="//span[contains(text(),'ALLIUMQA";
		
		String orderXpathPart2 = "')]/../../../following-sibling::div";
		
		String orderXpath =orderXpathPart1+orderNo+orderXpathPart2;
		
		System.out.println(orderXpath);
		Driver.getDriver().findElement(By.xpath(orderXpath)).click();
		
	//	driver.findElement(By.xpath("//span[contains(text(),'ALLIUMQA2300')]/../../../following-sibling::div"))
	//	.click();
	}
	
	@Test(dependsOnMethods = { "clickOnMyAccount" },alwaysRun = true , enabled=true)
	public void clickOnMyAddresses() throws InterruptedException, AWTException
	{
		
		Driver.getDriver().findElement(By.xpath("//span[contains(text(),'Addresses')]/..")).click();
		
		Driver.getDriver().findElement(By.name("fullAddress")).sendKeys("92260");
		
		Robot rb = new Robot();
		Thread.sleep(500);
		rb.keyPress(KeyEvent.VK_DOWN);
		Thread.sleep(500);
		rb.keyPress(KeyEvent.VK_DOWN);
		
		Thread.sleep(2000);
		rb.keyPress(KeyEvent.VK_ENTER);
		
		
	}
}
