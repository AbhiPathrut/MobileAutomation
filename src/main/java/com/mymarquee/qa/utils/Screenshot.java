package com.mymarquee.qa.utils;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Reporter;
import com.mymarquee.qa.base.BasePage;

public class Screenshot extends BasePage {

	public void captureScreenshot() throws Exception {
		String ScreenshotName = new SimpleDateFormat("MMddmmssSSS").format(new Date());
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File screenshotName = new File("./screenshots/" + ScreenshotName + ".png");
		FileUtils.copyFile(scrFile, screenshotName);
		Reporter.log("<a target=\"_blank\" href= \"C:\\Users\\APATHRUT\\eclipse-workspace\\appiumDemo\\screenshots\\"
				+ ScreenshotName + ".png\">Screenshot</a>");
	}

}
