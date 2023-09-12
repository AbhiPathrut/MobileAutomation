package com.mymarquee.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

import com.mymarquee.qa.base.BasePage;
import com.mymarquee.qa.utils.Screenshot;

public class SignInPage extends BasePage {
	Screenshot screenshot;
	
	By signInBtn = By.id("btnConnexion");
	By signInPageTitle = By.xpath("//h2[contains(text(),'Connect to your MyPeugeot account:')]");
	By email = By.xpath("//input[contains(@id,'email')]");
	By pass = By.xpath("//input[contains(@id,'password')]");
	By submitBtn = By.xpath("//input[contains(@id,'submit')]");
	By loginSuccessMessage = By.xpath("//h2[contains(text(),'Login successful')]");
	By confirmBtn = By.xpath("//input[contains(@value,'CONFIRM')]");
	By checkboxBtn = By.id("checkbox");
	By continueBtn = By.id("btn_validate");
	By iAcceptBtn = By.id("gdpr_notification_validations_validate_btn");
	//By allowBtn = By.id("permission_allow_button");
	By allowBtn = 	By.xpath("//android.widget.Button[@text = 'Allow']");
	By closeBtn = By.id("btn_finish");
	//By whileUsingTheApp = By.id("permission_allow_foreground_only_button");
	By whileUsingTheApp = By.xpath("//android.widget.Button[@text = 'While using the app']");
	//By onlyThisTime = By.id("permission_allow_one_time_button");
	By onlyThisTime = By.xpath("//android.widget.Button[@text = 'Only this time']");
	//By dontAllow = By.id("permission_deny_button");
	By dontAllow = By.xpath("//android.widget.Button[@text = 'Don't allow']");
	
	public SignInPage() {
		PageFactory.initElements(driver, this);
		screenshot = new Screenshot();
	}

	public void clickOnSignInButton() {
		try {
			screenshot.captureScreenshot();
			driver.findElement(signInBtn).click();
			screenshot.captureScreenshot();
			Reporter.log("Clicked on signin button");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void validateTheTitlePresentOnSignInPage() throws Exception {
		String SignInPage = driver.findElement(signInPageTitle).getText();
		Thread.sleep(10000);
		Assert.assertEquals(SignInPage, "CONNECT TO YOUR MYPEUGEOT ACCOUNT:");
		if (SignInPage.equalsIgnoreCase("CONNECT TO YOUR MYPEUGEOT ACCOUNT:")) {
			System.out.println("The user is on login page.");
		} else {
			System.out.println("Not able to load login page.");
		}
	}

	public void enterEmail(String Email) {
		try {
			screenshot.captureScreenshot();
			driver.findElement(email).sendKeys(Email);
			screenshot.captureScreenshot();
			Reporter.log("Entered email.");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void enterPassword(String Password) {
		try {
			driver.findElement(pass).sendKeys(Password);
			screenshot.captureScreenshot();
			Reporter.log("Entered Password.");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void clickOnSubmitButton() {
		try {
			driver.findElement(submitBtn).click();
			screenshot.captureScreenshot();
			Reporter.log("Clicked on submit button");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void validateTheLoginSuccessMessage() {
		String LoginSuccessMessg = driver.findElement(loginSuccessMessage).getText();
		Assert.assertEquals(LoginSuccessMessg, "LOGIN SUCCESSFUL");
		if (LoginSuccessMessg.equalsIgnoreCase("LOGIN SUCCESSFUL")) {
			System.out.println("The user is logged successfully.");
		} else {
			System.out.println("The user is not able to login.");
		}
	}

	public void clickOnConfirmButton() {
		try {
			driver.findElement(confirmBtn).click();
			screenshot.captureScreenshot();
			Reporter.log("Clicked on confirm button");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void clickOnCheckBoxButton() {
		try {
			driver.findElement(checkboxBtn).click();
			screenshot.captureScreenshot();
			Reporter.log("Clicked on checkbox button");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void clickOnContinueButton() {
		try {
			driver.findElement(continueBtn).click();
			screenshot.captureScreenshot();
			Reporter.log("Clicked on continue button");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void clickOnIAcceptButton() {
		try {
			driver.findElement(iAcceptBtn).click();
			screenshot.captureScreenshot();
			Reporter.log("Clicked on IAccept button");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void clickOnAllowButton() {
		try {
			driver.findElement(allowBtn).click();
			screenshot.captureScreenshot();
			Reporter.log("Clicked on allow button");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void clickOnCloseButton() {
		try {
			driver.findElement(closeBtn).click();
			screenshot.captureScreenshot();
			Reporter.log("Clicked on close button");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void clickOnMapUsingOption(String element) {
		if (element.equals("whileUsingTheApp")) {
			try {
				driver.findElement(whileUsingTheApp).click();
				screenshot.captureScreenshot();
				Reporter.log("Clicked on +" + element + "+ button");
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (element.equals("onlyThisTime")) {
			try {
				driver.findElement(onlyThisTime).click();
				screenshot.captureScreenshot();
				Reporter.log("Clicked on +" + element + "+ button");
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			try {
				driver.findElement(dontAllow).click();
				screenshot.captureScreenshot();
				Reporter.log("Clicked on +" + element + "+ button");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

}
