package com.automation.demo.pages;

import org.openqa.selenium.By;

public class HomePage {

	public static final By app_logo = By.id("youtube_logo");
	public static final By cast_icon = By.id("media_route_button");
	public static final By search_icon = By.xpath(
			"//android.widget.FrameLayout[contains(@resource-id,'com.google.android.youtube:id/menu_item_1')[2]]");
	public static final By profile_icon = By.id("mobile_topbar_avatar");
	public static final By first_video = By.xpath("//android.view.ViewGroup[contains(@index,'0')]");
	public static final By search_editBox = By.className("android.widget.EditText");
	public static final By result = By.xpath("//android.view.ViewGroup[contains(@index,'0')]");
}
