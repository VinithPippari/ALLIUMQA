package com.Classes;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.ExpectedConditions;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.functions.ExplicitWait;
import com.properties.Driver;

public class SelectAMealPlanWithNewMeals {
	
	JavascriptExecutor je = (JavascriptExecutor) Driver.getDriver();

	
	@Parameters({ "url" })
	@Test(alwaysRun = true ,enabled = true)
	public void clickOnGetStarted(String url) {
		
		Driver.getDriver().get(url);

		// click on Meal Plans
		
		String mealPlanButton = "//a[contains(text(),' Meal plans')]/..";
		
		WebElement mealPlan = Driver.getDriver().findElement(By.xpath(mealPlanButton));
		
        ExplicitWait.forClickableAndVisibility(mealPlanButton, 10);
        
		mealPlan.click();
	}

	@Parameters({ "mealPlanNumber" })
	@Test(alwaysRun = true, dependsOnMethods = { "clickOnGetStarted" }, enabled = true)
	public void chooseAMealPlan(String mealPlanNumber) throws InterruptedException {
		

		String mealPlanXpathPart1 = "//div[contains(text(),'";

		String mealPlanXpathPart2 = " Meals per week')]/..//button";

		String chooseAMealPlanXpath = mealPlanXpathPart1 + mealPlanNumber + mealPlanXpathPart2;

		System.out.println(chooseAMealPlanXpath);

		JavascriptExecutor je = (JavascriptExecutor) Driver.getDriver();

		ExplicitWait.forClickableAndVisibility(chooseAMealPlanXpath, 10);
		
		WebElement mealPlan = Driver.getDriver().findElement(By.xpath(chooseAMealPlanXpath));

		// now execute query which actually will scroll until that element is not
		// appeared on page.

		je.executeScript("arguments[0].scrollIntoView(true);", mealPlan);

		je.executeScript("window.scrollBy(0,-300)");
		
		mealPlan.click();
	}

	@Parameters({ "mealPlanNumber" })
	@Test(alwaysRun = true, dependsOnMethods = { "chooseAMealPlan" }, enabled = true)
	public void selectTheMeals(String mealPlanNumber) throws InterruptedException {

		String mealNumberXpathPart1 = "//div[contains(text(),'";

		String mealNumberXpathPart2 = " meals to continue')]";

		String mealNumberXpath = mealNumberXpathPart1 + "" + mealPlanNumber + "" + mealNumberXpathPart2;

		System.out.println(mealNumberXpath);

		ExplicitWait.forClickableAndVisibility(mealNumberXpath, 10);
		
		String mealNoText = Driver.getDriver().findElement(By.xpath(mealNumberXpath)).getText();

		if (mealNoText.equals("Add 4 meals to continue")) {
			System.out.println("4meals you have selected");

			String firstMeal = "//div[contains(text(),'Sunflunflower Seed Pate Ramaine wraps ')]/..//div//button";
			
			WebElement one = Driver.getDriver().findElement(By.xpath(firstMeal));
			
			ExplicitWait.forClickableAndVisibility(firstMeal, 10);
			
			one.click();

			
			String secondMeal = "//div[contains(text(),'Masuman Red Curry Vegetable Tofu ')]/..//div//button";
			
			WebElement two = Driver.getDriver().findElement(By.xpath(secondMeal));

			ExplicitWait.forClickableAndVisibility(secondMeal, 10);
			
			two.click();

			
			String thirdMeal = "//div[contains(text(),'Masuman Red Curry Vegetable Tofu ')]/..//div//button";
			
			WebElement three = Driver.getDriver().findElement(By.xpath(thirdMeal));

			ExplicitWait.forClickableAndVisibility(thirdMeal, 10);
			
			three.click();

			
			String fourthMeal = "//div[contains(text(),'South west Corn bread ')]/..//div//button";
			
			WebElement four = Driver.getDriver().findElement(By.xpath(fourthMeal));

			ExplicitWait.forClickableAndVisibility(fourthMeal, 10);
			
			four.click();

			String continueButtonXpath = "//button//span[contains(text(),'Continue')]";
			
			ExplicitWait.forClickableAndVisibility(continueButtonXpath, 10);
			
			WebElement continueButton = Driver.getDriver().findElement(By.xpath(continueButtonXpath));
	
			continueButton.click();

			Driver.getDriver().findElement(By.xpath("//button[contains(text(),'Continue')]")).click();
		}

		else if (mealNoText.equals("Add 6 meals to continue")) {
			System.out.println("6 meals you have selected");

            String firstMeal = "//div[contains(text(),'Sunflunflower Seed Pate Ramaine wraps ')]/..//div//button";
			
			WebElement one = Driver.getDriver().findElement(By.xpath(firstMeal));
			
			ExplicitWait.forClickableAndVisibility(firstMeal, 10);
			
			one.click();

			
			String secondMeal = "//div[contains(text(),'Masuman Red Curry Vegetable Tofu ')]/..//div//button";
			
			WebElement two = Driver.getDriver().findElement(By.xpath(secondMeal));

			ExplicitWait.forClickableAndVisibility(secondMeal, 10);
			
			two.click();

			
			String thirdMeal = "//div[contains(text(),'Masuman Red Curry Vegetable Tofu ')]/..//div//button";
			
			WebElement three = Driver.getDriver().findElement(By.xpath(thirdMeal));

			ExplicitWait.forClickableAndVisibility(thirdMeal, 10);
			
			three.click();

			
			String fourthMeal = "//div[contains(text(),'South west Corn bread ')]/..//div//button";
			
			WebElement four = Driver.getDriver().findElement(By.xpath(fourthMeal));

			ExplicitWait.forClickableAndVisibility(fourthMeal, 10);
			
			four.click();

			String FifthMeal = "//div[contains(text(),'Kelp Noodle Miso Bowl ')]/..//div//button";

			WebElement five = Driver.getDriver().findElement(By.xpath(FifthMeal));

			((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);", five);
			
			((JavascriptExecutor) Driver.getDriver()).executeScript("window.scrollBy(0,-300)");

			ExplicitWait.forClickableAndVisibility(FifthMeal, 10);
			
			five.click();

			String sixthMeal ="//div[contains(text(),'Raw-Chilada ')]/..//div//button";
			
			WebElement six= Driver.getDriver().findElement(By.xpath(sixthMeal));

			ExplicitWait.forClickableAndVisibility(sixthMeal, 10);
			
			six.click();

            String continueButtonXpath = "//button//span[contains(text(),'Continue')]";
			
			ExplicitWait.forClickableAndVisibility(continueButtonXpath, 10);
			
			WebElement continueButton = Driver.getDriver().findElement(By.xpath(continueButtonXpath));
	
			continueButton.click();

			Driver.getDriver().findElement(By.xpath("//button[contains(text(),'Continue')]")).click();
		}

		else if (mealNoText.equals("Add 9 meals to continue")) {
			System.out.println("9 meals you have selected");

String firstMeal = "//div[contains(text(),'Sunflunflower Seed Pate Ramaine wraps ')]/..//div//button";
			
			WebElement one = Driver.getDriver().findElement(By.xpath(firstMeal));
			
			ExplicitWait.forClickableAndVisibility(firstMeal, 10);
			
			one.click();

			
			String secondMeal = "//div[contains(text(),'Masuman Red Curry Vegetable Tofu ')]/..//div//button";
			
			WebElement two = Driver.getDriver().findElement(By.xpath(secondMeal));

			ExplicitWait.forClickableAndVisibility(secondMeal, 10);
			
			two.click();

			
			String thirdMeal = "//div[contains(text(),'Masuman Red Curry Vegetable Tofu ')]/..//div//button";
			
			WebElement three = Driver.getDriver().findElement(By.xpath(thirdMeal));

			ExplicitWait.forClickableAndVisibility(thirdMeal, 10);
			
			three.click();

			
			String fourthMeal = "//div[contains(text(),'South west Corn bread ')]/..//div//button";
			
			WebElement four = Driver.getDriver().findElement(By.xpath(fourthMeal));

			ExplicitWait.forClickableAndVisibility(fourthMeal, 10);
			
			four.click();

			String FifthMeal = "//div[contains(text(),'Kelp Noodle Miso Bowl ')]/..//div//button";

			WebElement five = Driver.getDriver().findElement(By.xpath(FifthMeal));

			((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);", five);
			
			((JavascriptExecutor) Driver.getDriver()).executeScript("window.scrollBy(0,-300)");

			ExplicitWait.forClickableAndVisibility(FifthMeal, 10);
			
			five.click();

			String sixthMeal ="//div[contains(text(),'Raw-Chilada ')]/..//div//button";
			
			WebElement six= Driver.getDriver().findElement(By.xpath(sixthMeal));

			ExplicitWait.forClickableAndVisibility(sixthMeal, 10);
			
			six.click();


			String seventhMeal = "//div[contains(text(),'Masuman Red Curry Vegetable Tofu ')]/..//div//button";

			WebElement seven = Driver.getDriver().findElement(By.xpath(seventhMeal));

			((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);", seven);
			
			((JavascriptExecutor) Driver.getDriver()).executeScript("window.scrollBy(0,-300)");

			ExplicitWait.forClickableAndVisibility(seventhMeal, 10);
			
			seven.click();

			String eightMeal = "//div[contains(text(),'South west Corn bread ')]/..//div//button";

			WebElement eight = Driver.getDriver().findElement(By.xpath(eightMeal));

			((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);", eight);
			
			((JavascriptExecutor) Driver.getDriver()).executeScript("window.scrollBy(0,-300)");

			//eight = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(eightMeal)));

			ExplicitWait.forClickableAndVisibility(eightMeal, 10);
			
			eight.click();

			String ninethMeal = "//div[contains(text(),'South west Corn bread ')]/..//div//button";

			WebElement nine = Driver.getDriver().findElement(By.xpath(ninethMeal));

			Thread.sleep(500);
			((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);", nine);
			Thread.sleep(500);
			((JavascriptExecutor) Driver.getDriver()).executeScript("window.scrollBy(0,-300)");

			//nine = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(nineMeal)));

			ExplicitWait.forClickableAndVisibility(ninethMeal, 10);
			nine.click();

			String continueButtonXpath = "//button//span[contains(text(),'Continue')]";
			ExplicitWait.forClickableAndVisibility(continueButtonXpath, 10);
			WebElement continueButton = Driver.getDriver().findElement(By.xpath(continueButtonXpath));

		//	continueButton = wait.until(
			//		ExpectedConditions.elementToBeClickable(By.xpath("//button//span[contains(text(),'Continue')]")));

			
			continueButton.click();

			Driver.getDriver().findElement(By.xpath("//button[contains(text(),'Continue')]")).click();

		}

		else if (mealNoText.equals("Add 12 meals to continue")) {
			System.out.println("12 meals you have selected");

			String firstMeal = "//div[contains(text(),'Sunflunflower Seed Pate Ramaine wraps ')]/..//div//button";
			
			ExplicitWait.forClickableAndVisibility(firstMeal, 10);
			//one = wait.until(ExpectedConditions.elementToBeClickable(
				//	By.xpath("//div[contains(text(),'Sunflunflower Seed Pate Ramaine wraps ')]/..//div//button")));

			WebElement one = Driver.getDriver().findElement(By.xpath(firstMeal));
					
			one.click();
			
			String secondMeal = "//div[contains(text(),'Masuman Red Curry Vegetable Tofu ')]/..//div//button";
			WebElement two = Driver.getDriver().findElement(By.xpath(secondMeal));

		//	two = wait.until(ExpectedConditions.elementToBeClickable(
			//		By.xpath("//div[contains(text(),'Masuman Red Curry Vegetable Tofu ')]/..//div//button")));

			ExplicitWait.forClickableAndVisibility(secondMeal, 10);
			
			two.click();

			String thirdMeal = "//div[contains(text(),'Masuman Red Curry Vegetable Tofu ')]/..//div//button";
			WebElement three = Driver.getDriver().findElement(By.xpath(thirdMeal));

		//	three = wait.until(ExpectedConditions.elementToBeClickable(
			//		By.xpath("//div[contains(text(),'Masuman Red Curry Vegetable Tofu ')]/..//div//button")));

			ExplicitWait.forClickableAndVisibility(thirdMeal, 10);
			three.click();
			
			String fourthMeal = "//div[contains(text(),'South west Corn bread ')]/..//div//button";
			
			WebElement four = Driver.getDriver().findElement(By.xpath(fourthMeal));

		//	four = wait.until(ExpectedConditions.elementToBeClickable(
			//		By.xpath("//div[contains(text(),'South west Corn bread ')]/..//div//button ")));
			ExplicitWait.forClickableAndVisibility(fourthMeal, 10);
			four.click();

			String FifthMeal = "//div[contains(text(),'Kelp Noodle Miso Bowl ')]/..//div//button";

			WebElement five = Driver.getDriver().findElement(By.xpath(FifthMeal));

			System.out.println(five);
			
			((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);", five);
			
			((JavascriptExecutor) Driver.getDriver()).executeScript("window.scrollBy(0,-300)");

		//	five = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(FifthMeal)));

			ExplicitWait.forClickableAndVisibility(FifthMeal, 10);
			five.click();

			String sixthMeal ="//div[contains(text(),'Raw-Chilada ')]/..//div//button";
			WebElement six= Driver.getDriver().findElement(By.xpath(sixthMeal));

		//	six = wait.until(ExpectedConditions
			//		.elementToBeClickable(By.xpath("//div[contains(text(),'Raw-Chilada ')]/..//div//button")));

			ExplicitWait.forClickableAndVisibility(sixthMeal, 10);
			
			six.click();

			String seventhMeal = "//div[contains(text(),'Masuman Red Curry Vegetable Tofu ')]/..//div//button";

			WebElement seven = Driver.getDriver().findElement(By.xpath(seventhMeal));

			Thread.sleep(500);
			((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);", seven);
			Thread.sleep(500);
			((JavascriptExecutor) Driver.getDriver()).executeScript("window.scrollBy(0,-300)");

		//	seven = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(seventhMeal)));

			ExplicitWait.forClickableAndVisibility(seventhMeal, 10);
			seven.click();

			String eightMeal = "//div[contains(text(),'South west Corn bread ')]/..//div//button";

			WebElement eight = Driver.getDriver().findElement(By.xpath(eightMeal));

			Thread.sleep(500);
			((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);", eight);
			Thread.sleep(500);
			((JavascriptExecutor) Driver.getDriver()).executeScript("window.scrollBy(0,-300)");

			//eight = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(eightMeal)));

			ExplicitWait.forClickableAndVisibility(eightMeal, 10);
			eight.click();

			String ninethMeal = "//div[contains(text(),'South west Corn bread ')]/..//div//button";

			WebElement nine = Driver.getDriver().findElement(By.xpath(ninethMeal));

			Thread.sleep(500);
			((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);", nine);
			Thread.sleep(500);
			((JavascriptExecutor) Driver.getDriver()).executeScript("window.scrollBy(0,-300)");

			//nine = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(nineMeal)));

			ExplicitWait.forClickableAndVisibility(ninethMeal, 10);
			nine.click();


			String tenthMeal = "//div[contains(text(),'Kelp Noodle Miso Bowl ')]/..//div//button";

			WebElement tenth = Driver.getDriver().findElement(By.xpath(tenthMeal));

			Thread.sleep(500);
			((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);", tenth);
			Thread.sleep(500);
			((JavascriptExecutor) Driver.getDriver()).executeScript("window.scrollBy(0,-300)");

		//	tenth = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(tenthMeal)));
			ExplicitWait.forClickableAndVisibility(tenthMeal, 10);

			tenth.click();

			String eleventhMeal = "//div[contains(text(),'Raw-Chilada ')]/..//div//button";

			WebElement eleventh = Driver.getDriver().findElement(By.xpath(eightMeal));

			Thread.sleep(500);
			((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);", eleventh);
			Thread.sleep(500);
			((JavascriptExecutor) Driver.getDriver()).executeScript("window.scrollBy(0,-300)");

		//	eleventh = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(eleventhMeal)));
			ExplicitWait.forClickableAndVisibility(eleventhMeal, 10);

			eleventh.click();

			String twelvethMeal = "//div[contains(text(),'South west Corn bread ')]/..//div//button";

			WebElement twelve = Driver.getDriver().findElement(By.xpath(eightMeal));

			Thread.sleep(500);
			((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);", twelve);
			Thread.sleep(500);
			((JavascriptExecutor) Driver.getDriver()).executeScript("window.scrollBy(0,-300)");

	//		twelve = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(twelvethMeal)));

			ExplicitWait.forClickableAndVisibility(twelvethMeal, 10);
			twelve.click();
			

			String continueButtonXpath = "//button//span[contains(text(),'Continue')]";
			ExplicitWait.forClickableAndVisibility(continueButtonXpath, 10);
			WebElement continueButton = Driver.getDriver().findElement(By.xpath(continueButtonXpath));

			//	continueButton = wait.until(
				//		ExpectedConditions.elementToBeClickable(By.xpath("//button//span[contains(text(),'Continue')]")));

				continueButton.click();

				Driver.getDriver().findElement(By.xpath("//button[contains(text(),'Continue')]")).click();
		}

		else if (mealNoText.equals("Add 7 meals to continue")) {
			System.out.println("7 meals you have selected");

			String firstMeal = "//div[contains(text(),'Sunflunflower Seed Pate Ramaine wraps ')]/..//div//button";
			//one = wait.until(ExpectedConditions.elementToBeClickable(
				//	By.xpath("//div[contains(text(),'Sunflunflower Seed Pate Ramaine wraps ')]/..//div//button")));

			WebElement one = Driver.getDriver().findElement(By.xpath(firstMeal));
			
			ExplicitWait.forClickableAndVisibility(firstMeal, 10);
			one.click();

			
			String secondMeal = "//div[contains(text(),'Masuman Red Curry Vegetable Tofu ')]/..//div//button";
			WebElement two = Driver.getDriver().findElement(By.xpath(secondMeal));

		//	two = wait.until(ExpectedConditions.elementToBeClickable(
			//		By.xpath("//div[contains(text(),'Masuman Red Curry Vegetable Tofu ')]/..//div//button")));

			ExplicitWait.forClickableAndVisibility(secondMeal, 10);
			two.click();

			
			String thirdMeal = "//div[contains(text(),'Masuman Red Curry Vegetable Tofu ')]/..//div//button";
			WebElement three = Driver.getDriver().findElement(By.xpath(thirdMeal));

		//	three = wait.until(ExpectedConditions.elementToBeClickable(
			//		By.xpath("//div[contains(text(),'Masuman Red Curry Vegetable Tofu ')]/..//div//button")));

			ExplicitWait.forClickableAndVisibility(thirdMeal, 10);
			three.click();

			
			String fourthMeal = "//div[contains(text(),'South west Corn bread ')]/..//div//button";
			
			WebElement four = Driver.getDriver().findElement(By.xpath(fourthMeal));

		//	four = wait.until(ExpectedConditions.elementToBeClickable(
			//		By.xpath("//div[contains(text(),'South west Corn bread ')]/..//div//button ")));
			ExplicitWait.forClickableAndVisibility(fourthMeal, 10);
			four.click();

			String FifthMeal = "//div[contains(text(),'Kelp Noodle Miso Bowl ')]/..//div//button";

			WebElement five = Driver.getDriver().findElement(By.xpath(FifthMeal));

			System.out.println(five);
			
			((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);", five);
			
			((JavascriptExecutor) Driver.getDriver()).executeScript("window.scrollBy(0,-300)");

		//	five = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(FifthMeal)));

			ExplicitWait.forClickableAndVisibility(FifthMeal, 10);
			five.click();

			String sixthMeal ="//div[contains(text(),'Raw-Chilada ')]/..//div//button";
			WebElement six= Driver.getDriver().findElement(By.xpath(sixthMeal));

		//	six = wait.until(ExpectedConditions
			//		.elementToBeClickable(By.xpath("//div[contains(text(),'Raw-Chilada ')]/..//div//button")));

			ExplicitWait.forClickableAndVisibility(sixthMeal, 10);
			six.click();

			String seventhMeal = "//div[contains(text(),'Masuman Red Curry Vegetable Tofu ')]/..//div//button";

			WebElement seven = Driver.getDriver().findElement(By.xpath(seventhMeal));

			Thread.sleep(500);
			((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);", seven);
			Thread.sleep(500);
			((JavascriptExecutor) Driver.getDriver()).executeScript("window.scrollBy(0,-300)");

		//	seven = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(seventhMeal)));

			ExplicitWait.forClickableAndVisibility(seventhMeal, 10);
			seven.click();

			String continueButtonXpath = "//button//span[contains(text(),'Continue')]";
			
			ExplicitWait.forClickableAndVisibility(continueButtonXpath, 10);
			WebElement continueButton = Driver.getDriver().findElement(By.xpath(continueButtonXpath));

			//	continueButton = wait.until(
				//		ExpectedConditions.elementToBeClickable(By.xpath("//button//span[contains(text(),'Continue')]")));

				continueButton.click();

				Driver.getDriver().findElement(By.xpath("//button[contains(text(),'Continue')]")).click();
		}

	}

	@Parameters({ "email", "password" })
	@Test(alwaysRun = true, dependsOnMethods = { "selectTheMeals" }, enabled = true)
	public void loginAfterSelectingTheMeals(String email, String password) throws InterruptedException {
		Thread.sleep(3000);
		Driver.getDriver().findElement(By.xpath("//mat-tab-body[@id='mat-tab-content-1-0']//input[@formcontrolname='email']"))
				.sendKeys(email);

		// Password
		Thread.sleep(2000);
		Driver.getDriver().findElement(By.xpath("//mat-tab-body[@id='mat-tab-content-1-0']//input[@formcontrolname='password']"))
				.sendKeys(password);

		Thread.sleep(2000);

		Driver.getDriver().findElement(By.xpath("//mat-tab-body[@id='mat-tab-content-1-0']//span[contains(.,'Login')]")).click();

	}

	@Test(alwaysRun = true, dependsOnMethods = { "loginAfterSelectingTheMeals" }, enabled = false)
	public void enterTheDeliveryAddress() {
		// Choose a delivery Address
		JavascriptExecutor je = (JavascriptExecutor) Driver.getDriver();

		WebElement firstName = Driver.getDriver().findElement(By.name("firstName"));

		// now execute query which actually will scroll until that element is not
		// appeared on page.

		je.executeScript("arguments[0].scrollIntoView(true);", firstName);

		Driver.getDriver().findElement(By.name("firstName")).sendKeys("vinith kumar pippari");

		Driver.getDriver().findElement(By.name("addrline1")).sendKeys("automation station");

		Driver.getDriver().findElement(By.name("addrline2")).sendKeys("8-54");

		Driver.getDriver().findElement(By.name("zip")).sendKeys("92260");

		Driver.getDriver().findElement(By.name("phonenumber")).sendKeys("8566477899");

		//// div[contains(.,'Total payable')]//button[contains(text(),'Continue')]
	}

	@Parameters({ "addressPhoneNumber" })
	@Test(alwaysRun = true, dependsOnMethods = { "loginAfterSelectingTheMeals" }, enabled = true)
	public void selectTheAddressByDeafult(String addressPhoneNumber) throws InterruptedException {
		// Select a delivery address by default
		Thread.sleep(2000);

		String addressXpathPart1 = "//div[contains(text(),'";

		String addressXpathPart2 = "')]/../..//div//input[@type='radio']";

		String addressXpath = addressXpathPart1 + addressPhoneNumber + addressXpathPart2;

		System.out.println(addressXpath);

		Thread.sleep(1000);
		Driver.getDriver().findElement(By.xpath(addressXpath)).click();

		// Driver.getDriver().findElement(By.xpath("//div[contains(text(),'addressPhoneNumber')]/../..//div//input[@type='radio']")).click();

		Thread.sleep(2000);
		Driver.getDriver().findElement(
				By.xpath("//div[contains(text(),' Order summary ')]/..//button[contains(text(),'Continue')]")).click();

	}

	@Test(alwaysRun = true, dependsOnMethods = { "selectTheAddressByDeafult" }, enabled = false)
	public void clickOnAddNewAndEnterTheCardDetailsForPayment() throws InterruptedException {
		Thread.sleep(2000);
		Driver.getDriver().findElement(By.xpath("//div[contains(text(),'ADD NEW')]/..")).click();
		Thread.sleep(2000);
		Driver.getDriver().findElement(By.xpath("//input[@formcontrolname='ccNumber']")).sendKeys("4242424242424242");

		Driver.getDriver().findElement(By.xpath("//input[@formcontrolname='ccName']")).sendKeys("Vinith");

		Driver.getDriver().findElement(By.xpath("//input[@formcontrolname='ccExpDate']")).sendKeys("12/24");

		Driver.getDriver().findElement(By.xpath("//input[@formcontrolname='ccCvv']")).sendKeys("548");

		Driver.getDriver().findElement(By.xpath("//input[@name='ccCvv']/../../..//button")).click();

	}

	@Parameters({ "atmDebitCardNumber" })
	@Test(alwaysRun = true, dependsOnMethods = { "selectTheAddressByDeafult" }, enabled = true)
	public void selectTheCardByDefault(String atmDebitCardNumber) throws InterruptedException {

		Thread.sleep(4000);

		String cardXpathPart1 = "//span[contains(text(),'";

		String cardXpathPart2 = "')]/../../..//div//input[@type='radio']";

		String cardXpath = cardXpathPart1 + atmDebitCardNumber + cardXpathPart2;

		Driver.getDriver().findElement(By.xpath(cardXpath)).click();

		// Driver.getDriver().findElement(By.xpath("//span[contains(text(),'4242')]/../../..//div//input[@type='radio']")).click();

		Driver.getDriver().findElement(By.name("ccCvv")).sendKeys("457");

		Thread.sleep(2000);

		Driver.getDriver().findElement(By.xpath("//input[@name='ccCvv']/..//button")).click();

	}


}
