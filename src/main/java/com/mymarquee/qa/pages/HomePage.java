package com.mymarquee.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;
import com.mymarquee.qa.base.BasePage;
import com.mymarquee.qa.utils.Screenshot;

public class HomePage extends BasePage {
	Screenshot screenshot;
	
	By acceptBtn = By.id("btn_validate");
	By titleMessage = By.id("tv_msg");

	public HomePage() {
		PageFactory.initElements(driver, this);
		screenshot = new Screenshot();
	}

	public void clickOnAcceptButton() {
		try {
			screenshot.captureScreenshot();
			driver.findElement(acceptBtn).click();
			screenshot.captureScreenshot();
			Reporter.log("Clicked on Accept button");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void verifyTitleOfHomePageOfApp() {
		String TitleMsg = driver.findElement(titleMessage).getText();
		Assert.assertEquals(TitleMsg, "The best of PEUGEOT with you all the time");
		if (TitleMsg.equalsIgnoreCase("The best of PEUGEOT with you all the time")) {
			System.out.println("The app is loaded successfully.");
		} else {
			System.out.println("The app is not loaded successfully.");
		}

	}
}
