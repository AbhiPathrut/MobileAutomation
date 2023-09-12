package com.mymarquee.qa.base;

import java.net.URL;
import java.util.Set;

import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.android.AndroidDriver;

public class BasePage {
	public static AndroidDriver driver;

	public static void desiredCapabilities(String appPackage, String appActivity) throws Exception {
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("deviceName", "OnePlusNord");
		cap.setCapability("udid", "b2f5ceb3");
		cap.setCapability("platformName", "Android");
		cap.setCapability("chromedriverExecutable",
				"C:\\Users\\APATHRUT\\OneDrive - Capgemini\\Desktop\\New folder\\chromedriver-win64\\chromedriver.exe");
		cap.setCapability("platformVersion", "13");
		cap.setCapability("automationName", "Appium");
		cap.setCapability("appPackage", appPackage);
		cap.setCapability("appActivity", appActivity);
		URL url = new URL("http://127.0.0.1:4723/wd/hub");
		driver = new AndroidDriver(url, cap);
		System.out.println("Application Started....");
		Thread.sleep(4000);
	}

	public void getContexts() {
		Set<String> contextHandles = driver.getContextHandles();
		for (String context : contextHandles) {
			System.out.println(context);
		}
	}

	public void switchToContext(String context) {
		driver.context(context);
		System.out.println("Switched to " + context);
	}
}
