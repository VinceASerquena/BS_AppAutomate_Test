package com.apidemos;

import java.net.MalformedURLException;

import org.testng.annotations.Test;

import com.browserstack.AppiumTest;

import pageObjects.CommonObjects;
import pageObjects.ViewPageObjects;

public class TestRun extends AppiumTest {
	
	@Test
	public void loopGetElementsText() throws MalformedURLException {
		
		clickElement(CommonObjects.Views);
		clickElement(ViewPageObjects.ExpandableList);
		clickElement(ViewPageObjects.CustomAdapter);
		
		getElementsTextByXpath("//android.widget.ExpandableListView/android.widget.TextView");
		
	}
}
