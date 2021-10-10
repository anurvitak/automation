package com.automation.demo.tests;

import java.net.MalformedURLException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.automation.demo.pages.*;
import com.automation.demo.pages.HomePage;
import com.google.common.collect.ImmutableMap;


public class DemoTests extends CommonMethods {

	@Test(priority = 1, description = "verify header UI elements of homepage")
	public void verification() throws InterruptedException {

		SoftAssert jaAssert = new SoftAssert();
		jaAssert.assertTrue(isDisplayed(HomePage.app_logo));
		jaAssert.assertTrue(isDisplayed(HomePage.profile_icon));
		jaAssert.assertTrue(isDisplayed(HomePage.cast_icon));
		jaAssert.assertTrue(isDisplayed(HomePage.first_video));
		jaAssert.assertTrue(isDisplayed(HomePage.search_icon));
		jaAssert.assertAll();

	}

	@Test(priority = 2, description = "search anything and play")
	public void playVideo() throws MalformedURLException, InterruptedException {
		click(HomePage.search_icon);

		driver.findElement(HomePage.search_editBox).sendKeys("music");
		driver.executeScript("mobile:performEditorAction", ImmutableMap.of("action", "done"));
		Thread.sleep(1000);
		click(HomePage.result);

	}

	@BeforeTest
	public void initialize() throws MalformedURLException, InterruptedException {
		setup();
	}

}
