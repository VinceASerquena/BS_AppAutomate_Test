package com.apidemos;

import java.net.MalformedURLException;

import org.testng.annotations.Test;

import com.browserstack.AppiumTest;

import pageObjects.CommonObjects;

public class LaunchAndroidApp extends AppiumTest {
	
	@Test
	public void navigateApp() throws MalformedURLException  {
	
		clickElement(CommonObjects.Accessibility1);
		pressBackKey();
		clickElement(CommonObjects.Accessibilty2);
		navigateBack();
		clickElement(CommonObjects.Animation);
		navigateBack();
		clickElement(CommonObjects.App);
		navigateBack();
		clickElement(CommonObjects.Content);
		navigateBack();
		clickElement(CommonObjects.Graphics);
		navigateBack();
		clickElement(CommonObjects.Media);
		navigateBack();
		clickElement(CommonObjects.NFC);
		navigateBack();
		clickElement(CommonObjects.OS);
		navigateBack();
		clickElement(CommonObjects.Preference);
		navigateBack();
		clickElement(CommonObjects.Text);
		navigateBack();
		clickElement(CommonObjects.Views);
		navigateBack();
	
	}

	
}
