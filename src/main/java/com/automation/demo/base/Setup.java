package com.automation.demo.base;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class Setup {
	
	public AppiumDriver<MobileElement> driver = null;

	public void setup() throws MalformedURLException, InterruptedException {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("VERSION", "4.4.2");
		capabilities.setCapability("deviceName", "Emulator");
		capabilities.setCapability("platformName", "Android");

		capabilities.setCapability("appPackage", "com.google.android.youtube");// This package name of your application
		capabilities.setCapability("appActivity", "com.google.android.apps.youtube.app.watchwhile.WatchWhileActivity"); // This is Launcher activity of application
		capabilities.setCapability("noReset", "true");	
		capabilities.setCapability("unicodeKeyboard", "true");                                     
		capabilities.setCapability("resetKeyboard", "true");
		
		// It will launch the app in Android device/emulator using the configurations
		// specified in Desired Capabilities'
		capabilities.setCapability("isHeadless", true);
		driver = new AppiumDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        Thread.sleep(5000);
      
	}
}
