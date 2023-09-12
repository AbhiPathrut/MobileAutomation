package com.mymarquee.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mymarquee.qa.pages.HomePage;
import com.mymarquee.qa.pages.SignInPage;
import com.mymarquee.qa.pages.SignOutPage;
import com.mymarquee.qa.base.BasePage;

public class LoginTestCases extends BasePage {
	HomePage homepage;
	SignInPage signinpage;
	SignOutPage signoutpage;

	@Parameters({ "appPackage", "appActivity" })
	@BeforeMethod
	public void setUp(String AppPackage, String AppActivity) throws Exception {
		desiredCapabilities(AppPackage, AppActivity);
		Thread.sleep(2000);
		homepage = new HomePage();
		signinpage = new SignInPage();
		signoutpage = new SignOutPage();
	}

	// *NOMINAL CASE - Login with an activated account after a fresh app install*//
	@Test(priority = 1)
	public void verifyUserIsAbleToLoginWithActivatedAccountCredientials() throws Exception {
		Thread.sleep(2000);
		homepage.clickOnAcceptButton();
		Thread.sleep(2000);
		homepage.verifyTitleOfHomePageOfApp();
		Thread.sleep(2000);
		signinpage.clickOnSignInButton();
		Thread.sleep(10000);
		getContexts();
		Thread.sleep(2000);
		switchToContext("WEBVIEW_chrome");
		Thread.sleep(10000);
		signinpage.validateTheTitlePresentOnSignInPage();
		Thread.sleep(10000);
		signinpage.enterEmail("ap_pprod_sams_fr@yopmail.com");
		Thread.sleep(2000);
		signinpage.enterPassword("Test@123");
		Thread.sleep(2000);
		signinpage.clickOnSubmitButton();
		Thread.sleep(5000);
		signinpage.validateTheLoginSuccessMessage();
		Thread.sleep(2000);
		signinpage.clickOnConfirmButton();
		Thread.sleep(5000);
		switchToContext("NATIVE_APP");
		Thread.sleep(5000);
		signinpage.clickOnCheckBoxButton();
		Thread.sleep(3000);
		signinpage.clickOnContinueButton();
		Thread.sleep(15000);
		signinpage.clickOnIAcceptButton();
		Thread.sleep(3000);
		signinpage.clickOnAllowButton();
		Thread.sleep(5000);
		signinpage.clickOnCloseButton();
		Thread.sleep(5000);
		signinpage.clickOnMapUsingOption("whileUsingTheApp");
		Thread.sleep(8000);
		// signinpage.clickOnAllowButton();
		signoutpage.clickOnActionMenuButton();
		Thread.sleep(5000);
		signoutpage.clickOnSettingButton();
		Thread.sleep(3000);
		signoutpage.clickOnLogoutButton();
		Thread.sleep(5000);
		homepage.verifyTitleOfHomePageOfApp();
		Thread.sleep(2000);
	}

	// *NOMINAL CASE - Delog from app*//
//	@Test(priority=2)
//	public void verifyUserIsAbleToLogoutFromAlreadyLoggedIn() throws Exception {
//		Thread.sleep(2000);
//		signoutpage.clickOnActionMenuButton();
//		Thread.sleep(5000);
//		signoutpage.clickOnSettingButton();
//		Thread.sleep(3000);
//		signoutpage.clickOnLogoutButton();
//		Thread.sleep(5000);
//		homepage.verifyTitleOfHomePageOfApp();
//		Thread.sleep(2000);
//	}
//	

	// *NOMINAL CASE - Login with an activated account after a delog & relog*//
//	@Test(priority = 2)
//	public void verifyUserIsAbleToLoginWithActivatedAccountCredientialsLogoutAndRelogin() throws Exception {
//		Thread.sleep(2000);	
//		homepage.clickOnAcceptButton();
//		Thread.sleep(2000);
//		homepage.verifyTitleOfHomePageOfApp();
//		Thread.sleep(2000);
//		signinpage.clickOnSignInButton();
//		Thread.sleep(10000);
//		getContexts();
//		Thread.sleep(2000);
//		switchToContext("WEBVIEW_chrome");
//		Thread.sleep(10000);
//		signinpage.validateTheTitlePresentOnSignInPage();
//		Thread.sleep(10000);
//		signinpage.enterEmail("ap_pprod_sams_fr@yopmail.com");
//		Thread.sleep(2000);
//		signinpage.enterPassword("Test@123");
//		Thread.sleep(2000);
//		signinpage.clickOnSubmitButton();
//		Thread.sleep(5000);
//		signinpage.validateTheLoginSuccessMessage();
//		Thread.sleep(2000);
//		signinpage.clickOnConfirmButton();
//		Thread.sleep(5000);
//		switchToContext("NATIVE_APP");
//		Thread.sleep(5000);
//		signinpage.clickOnCheckBoxButton();
//		Thread.sleep(3000);
//		signinpage.clickOnContinueButton();
//		Thread.sleep(15000);
//		signinpage.clickOnIAcceptButton();
//		Thread.sleep(3000);
//		signinpage.clickOnAllowButton();
//		Thread.sleep(5000);
//		signinpage.clickOnCloseButton();
//		Thread.sleep(5000);
//		signinpage.clickOnMapUsingOption("whileUsingTheApp");
//		Thread.sleep(8000);
//		// signinpage.clickOnAllowButton();
//		signoutpage.clickOnActionMenuButton();
//		Thread.sleep(5000);
//		signoutpage.clickOnSettingButton();
//		Thread.sleep(3000);
//		signoutpage.clickOnLogoutButton();
//		Thread.sleep(5000);
//		homepage.verifyTitleOfHomePageOfApp();
//		Thread.sleep(2000);
//		signinpage.clickOnSignInButton();
//		Thread.sleep(10000);
//		getContexts();
//		Thread.sleep(2000);
//		switchToContext("WEBVIEW_chrome");
//		Thread.sleep(10000);
//		signinpage.validateTheTitlePresentOnSignInPage();
//		Thread.sleep(10000);
//		signinpage.enterEmail("ap_pprod_sams_fr@yopmail.com");
//		Thread.sleep(2000);
//		signinpage.enterPassword("Test@123");
//		Thread.sleep(2000);
//		signinpage.clickOnSubmitButton();
//		Thread.sleep(5000);
//		signinpage.validateTheLoginSuccessMessage();
//		Thread.sleep(2000);
//		signinpage.clickOnConfirmButton();
//		Thread.sleep(5000);
//		switchToContext("NATIVE_APP");
//		Thread.sleep(5000);
//		signinpage.clickOnCheckBoxButton();
//		Thread.sleep(3000);
//		signinpage.clickOnContinueButton();
//		Thread.sleep(15000);
//		signinpage.clickOnIAcceptButton();
//		Thread.sleep(3000);
//		signinpage.clickOnAllowButton();
//		Thread.sleep(5000);
//		signinpage.clickOnCloseButton();
//		Thread.sleep(5000);
//		signinpage.clickOnMapUsingOption("whileUsingTheApp");
//		Thread.sleep(8000);
//		// signinpage.clickOnAllowButton();
//	}

//	@AfterMethod
//	public void tearDown() {
//		driver.quit();
//	}
}
