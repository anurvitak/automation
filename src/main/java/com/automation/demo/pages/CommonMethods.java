package com.automation.demo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.automation.demo.base.Setup;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class CommonMethods extends Setup {

	public void defaultWait(int timeout) {
		try {
			Thread.sleep(timeout);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void reLaunchApp() {
		driver.closeApp();
		driver.launchApp();
		defaultWait(3000);

	}

	protected boolean isDisplayed(By locator) {
		try {
			// waitForElementPresence(3, locator);
			MobileElement mobileElement = getWebElement(driver, locator, 3);
			return mobileElement.isDisplayed();
		} catch (Exception e) {

		}
		return false;
	}

	public MobileElement getWebElement(AppiumDriver<MobileElement> driver, final By byLocator, int seconds)
			throws Exception {

		MobileElement mobileELement = null;
		mobileELement = (new WebDriverWait(driver, 5)).until(new ExpectedCondition<MobileElement>() {

			public MobileElement apply(WebDriver d) {
				return (MobileElement) d.findElement(byLocator);
			}
		});
		return mobileELement;
	}

	/**
	 * wait for element presence
	 * 
	 * @param driver
	 * @param timeout
	 * @param by
	 */
	public void waitForElementPresence(int timeout, By by) {
		new WebDriverWait(driver, 20).until(ExpectedConditions.presenceOfElementLocated(by));
	}

	public void click(By locator) {
		waitForElementPresence(15, locator);

		driver.findElement(locator).click();
	}

}
