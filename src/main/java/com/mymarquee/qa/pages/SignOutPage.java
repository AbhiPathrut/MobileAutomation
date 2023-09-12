package com.mymarquee.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import com.mymarquee.qa.base.BasePage;
import com.mymarquee.qa.utils.Screenshot;

public class SignOutPage extends BasePage {
	Screenshot screenshot;

	By actionOpenMenuBtn = By.id("action_open_menu");
	By settingBtn = By.id("menu_user_footer");
	By logoutBtn = By.id("txt_logout");

	public SignOutPage() {
		PageFactory.initElements(driver, this);
		screenshot = new Screenshot();
	}

	public void clickOnActionMenuButton() {
		try {
			screenshot.captureScreenshot();
			driver.findElement(actionOpenMenuBtn).click();
			screenshot.captureScreenshot();
			Reporter.log("Clicked on actionOpenMenu button");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void clickOnSettingButton() {
		try {
			driver.findElement(settingBtn).click();
			Reporter.log("Clicked on setting button");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void clickOnLogoutButton() {
		try {
			driver.findElement(logoutBtn).click();
			screenshot.captureScreenshot();
			Reporter.log("Clicked on logout button");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
