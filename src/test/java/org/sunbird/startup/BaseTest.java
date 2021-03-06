package org.sunbird.startup;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import org.openqa.selenium.chrome.ChromeOptions;

public abstract class BaseTest implements IAutoConst {

	public static WebDriver driver;
	static 
	{
		System.setProperty(CHROME_KEY,CHROME_VAL);

	}

	@BeforeMethod(alwaysRun = true)
	public void openApplication() throws IOException, InterruptedException 
	{
		ChromeOptions ChromeOptions = new ChromeOptions();
		ChromeOptions.addArguments("--headless");
		ChromeOptions.addArguments("--no-sandbox");
		ChromeOptions.addArguments("--disable-dev-shm-usage");
		ChromeOptions.addArguments("--start-maximized");
		driver = new ChromeDriver(ChromeOptions);
		
		//driver = new ChromeDriver(); 
		//driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		//driver.get(AUTO_APP_URL);
		driver.get(APP_URL);
		System.out.println("Scripts are executing on "+driver.getCurrentUrl());
		
	}

	@AfterMethod (alwaysRun = true)
	public void closeApplication() throws InterruptedException
	{
		
//		Thread.sleep(15000);
//		driver.manage().deleteAllCookies();
		driver.quit();
		System.out.println("Test Execution Completed : Closing the browser");
		
	}

	public WebDriver getDriver() {
		// TODO Auto-generated method stub
		return driver;
	}

}

