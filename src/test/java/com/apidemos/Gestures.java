package com.apidemos;

import java.net.MalformedURLException;

import org.testng.annotations.Test;

import com.browserstack.AppiumTest;


import pageObjects.CommonObjects;
import pageObjects.ViewPageObjects;

public class Gestures extends AppiumTest{
	
	@Test
	public void longPress() throws MalformedURLException {
		
		clickElement(CommonObjects.Views);
		clickElement(ViewPageObjects.ExpandableList);
		clickElement(ViewPageObjects.CustomAdapter);
		longPressElement(ViewPageObjects.PeopleNames);
		assertElementText(ViewPageObjects.SampleMenu, "Sample menu");
		assertElementDisplayed(ViewPageObjects.SampleMenu);
		
	}
	
	@Test
	public void scrollGesture() throws MalformedURLException {
		
		clickElement(CommonObjects.Views);
		scrollDownGesture();
		scrollToElementByUIAutomator(ViewPageObjects.WebView);
		
		
	}
	
	@Test
	public void flingGestureMethod() throws MalformedURLException {
		
		clickElement(CommonObjects.Views);
		flingGesture(ViewPageObjects.Gallery);
		
	}
	
	@Test
	public void dragGestureMethod() throws MalformedURLException {
				
		clickElement(CommonObjects.Views);
		clickElement(ViewPageObjects.DragandDrop);
		dragGesture(ViewPageObjects.DragIcon, 835, 740);
		assertElementDisplayed(ViewPageObjects.DragResult);
		assertElementText(ViewPageObjects.DragResult, "Dropped!");
		
	}
	
}
