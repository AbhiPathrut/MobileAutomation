package appiumDemo;

import java.net.URL;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;

import io.appium.java_client.android.AndroidDriver;

public class MyMarqueeTest {
	static AndroidDriver driver;

	public static void main(String[] args) throws Exception {
		desiredCapabilities();
		Thread.sleep(2000);
		homePage();
		signingIn();
		signingOut();
	}

	public static void desiredCapabilities() throws Exception {
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("deviceName", "OnePlusNord");
		cap.setCapability("udid", "b2f5ceb3");
		cap.setCapability("platformName", "Android");
		cap.setCapability("chromedriverExecutable",
				"C:\\Users\\APATHRUT\\OneDrive - Capgemini\\Desktop\\New folder\\chromedriver-win64\\chromedriver.exe");
		cap.setCapability("platformVersion", "13");
		cap.setCapability("automationName", "Appium");
		cap.setCapability("appPackage", "com.psa.mym.mypeugeot");
		cap.setCapability("appActivity", "com.psa.mym.activity.SplashscreenActivity");
		URL url = new URL("http://127.0.0.1:4723/wd/hub");
		driver = new AndroidDriver(url, cap);
		System.out.println("Application Started....");
		Thread.sleep(4000);
	}
	
	public static void homePage() throws Exception {
		//driver.findElement(By.id("com.psa.mym.mypeugeot:id/btn_validate")).click();
		driver.findElement(By.id("btn_validate")).click();
		Thread.sleep(2000);
		System.out.println("Clicked on Accept button...");
		String TitleMsg= driver.findElement(By.id("com.psa.mym.mypeugeot:id/tv_msg")).getText();
		Thread.sleep(2000);
		Assert.assertEquals(TitleMsg, "The best of PEUGEOT with you all the time");
		Thread.sleep(2000);
	}
	
	public static void signingIn() throws Exception {
		Thread.sleep(20000);
		driver.findElement(By.id("com.psa.mym.mypeugeot:id/btnConnexion")).click();
		Thread.sleep(10000);
		Set<String> contextHandles = driver.getContextHandles();
		for (String context : contextHandles) {
			System.out.println(context);
		}
		driver.context("WEBVIEW_chrome");
		System.out.println("Switched to webview");
		Thread.sleep(5000);
		String SignInPage= driver.findElement(By.xpath("//h2[contains(text(),'Connect to your MyPeugeot account:')]")).getText();
		Thread.sleep(10000);
		Assert.assertEquals(SignInPage, "CONNECT TO YOUR MYPEUGEOT ACCOUNT:");
		driver.findElement(By.xpath("//input[contains(@id,'email')]")).sendKeys("ap_pprod_sams_fr@yopmail.com");
		Thread.sleep(2000);
		System.out.println("Entered Email.");
		driver.findElement(By.xpath("//input[contains(@id,'password')]")).sendKeys("Test@123");
		Thread.sleep(2000);
		System.out.println("Entered Password.");
		driver.findElement(By.xpath("//input[contains(@id,'submit')]")).click();
		System.out.println("Clicked on submit button.");
		Thread.sleep(5000);
		String LoginSuccessMessg = driver.findElement(By.xpath("//h2[contains(text(),'Login successful')]")).getText();
		Assert.assertEquals(LoginSuccessMessg, "LOGIN SUCCESSFUL");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[contains(@value,'CONFIRM')]")).click();
		Thread.sleep(5000);
		System.out.println("Clicked on confirm button");
		driver.context("NATIVE_APP");
		Thread.sleep(5000);
		driver.findElement(By.id("com.psa.mym.mypeugeot:id/checkbox")).click();
		Thread.sleep(3000);
		System.out.println("Clicked on checkbox button.");
		driver.findElement(By.id("com.psa.mym.mypeugeot:id/btn_validate")).click();
		System.out.println("Clicked on continue button");
		Thread.sleep(15000);
		driver.findElement(By.id("com.psa.mym.mypeugeot:id/gdpr_notification_validations_validate_btn")).click();
		Thread.sleep(5000);
		driver.findElement(By.id("com.android.permissioncontroller:id/permission_allow_button")).click();
		Thread.sleep(5000);
		driver.findElement(By.id("com.psa.mym.mypeugeot:id/btn_finish")).click();
		Thread.sleep(5000);
		driver.findElement(By.id("com.android.permissioncontroller:id/permission_allow_foreground_only_button")).click();
		Thread.sleep(10000);
		//driver.findElement(By.id("com.android.permissioncontroller:id/permission_allow_button")).click();
		//Thread.sleep(3000);
	}
	
	public static void signingOut() throws Exception {
		Thread.sleep(5000);
		driver.findElement(By.id("com.psa.mym.mypeugeot:id/action_open_menu")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("com.psa.mym.mypeugeot:id/menu_user_footer")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("com.psa.mym.mypeugeot:id/txt_logout")).click();
		Thread.sleep(5000);
		String TitleMsg2= driver.findElement(By.id("com.psa.mym.mypeugeot:id/tv_msg")).getText();
		Thread.sleep(2000);
		Assert.assertEquals(TitleMsg2, "The best of PEUGEOT with you all the time");
	}
}
