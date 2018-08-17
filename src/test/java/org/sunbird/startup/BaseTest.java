package org.sunbird.startup;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;


public abstract class BaseTest implements IAutoConst {

	public static WebDriver driver;
	static 
	{
		System.setProperty(CHROME_KEY,CHROME_VAL);

	}

	@SuppressWarnings("deprecation")
	@BeforeMethod
	public void openApplication() throws IOException, InterruptedException 
	{
		/*DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless", "window-size=1024,768", "--no-sandbox");
		capabilities.setCapability("chrome.binary", "<Path to binary>");
		capabilities.setCapability(ChromeOptions.CAPABILITY, options);
		capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		capabilities.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
		capabilities.setCapability("applicationCacheEnabled", "true");
		capabilities.setCapability("browserConnectionEnabled", "true");
		capabilities.setCapability("databaseEnabled", "true");
		capabilities.setCapability("networkConnectionEnabled", "true");
		driver = new ChromeDriver(capabilities); */
		
		ChromeOptions options = new ChromeOptions();
		options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
  		options.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
  		//options.addArguments("--headless");
		//options.addArguments("start-fullscreen");
		//, "window-size=1024,768", "--no-sandbox");
  		
  		/*options.setAcceptInsecureCerts(true);
  		options.setCapability("applicationCacheEnabled", "true");
  		options.setCapability("browserConnectionEnabled", "true");
  		options.setCapability("databaseEnabled", "true");
  		options.setCapability("networkConnectionEnabled", "true");*/
  		driver = new ChromeDriver(options);
		
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		//driver.get(AUTO_APP_URL);
		driver.get(APP_URL);
		System.out.println("Scripts are executing on "+driver.getCurrentUrl());
		
	}

	@AfterMethod
	public void closeApplication() throws InterruptedException
	{
		
//		Thread.sleep(15000);
		driver.manage().deleteAllCookies();
		driver.quit();
		System.out.println("Test Execution Completed : Closing the browser");
		
	}

	public WebDriver getDriver() {
		// TODO Auto-generated method stub
		return driver;
	}

}

