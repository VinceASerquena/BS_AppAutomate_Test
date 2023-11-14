package com.browserstack;

import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.android.options.UiAutomator2Options;


public class AppiumTest {

    public AndroidDriver driver;
    
    public static final String AUTOMATE_USERNAME = "vincealecserquen_PUL7Gx";
	public static final String AUTOMATE_ACCESS_KEY = "6Nakjv6gG8CQfeyCxTHW";
	
	public static final String URL = "http://" + AUTOMATE_USERNAME + ":" + AUTOMATE_ACCESS_KEY + "@hub-cloud.browserstack.com/wd/hub";
	
    @BeforeMethod(alwaysRun=true)
    public void setUp() throws Exception {
        MutableCapabilities capabilities = new UiAutomator2Options();
        HashMap<String, Object> browserstackOptions = new HashMap<String, Object>();
        browserstackOptions.put("appiumVersion", "2.0.1");
        capabilities.setCapability("bstack:options", browserstackOptions);
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
        
//        capabilities.setCapability("deviceName", "Samsung Galaxy S21");
//        capabilities.setCapability("os_Version", "12.0");
//        capabilities.setCapability("Project", "Vince's BrowserStack Android Sample");
//        capabilities.setCapability("build", "Vince's Android BSBuild");
//        capabilities.setCapability("name", "Vince's Android BSBuild - JAVA");
//        capabilities.setCapability("app", "bs://99b25759762ff8a21adafe2d47d9906110a72069");
        //
        driver = new AndroidDriver(new URL(URL),capabilities);
    }

    @AfterMethod(alwaysRun=true)
    public void tearDown() throws Exception {
        driver.quit();
    }
    
    public void navigateBack() {
		driver.navigate().back();
		System.out.println("Navigated to Previous page");
	}
	
	public void pressBackKey() {
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
	}
	
	public void clickElement(String[] element) {
		String locatorBy = element[2];
		if (locatorBy == "accessibilityId") {
			WebElement elm = driver.findElement(AppiumBy.accessibilityId(element[0]));
			try {
				elm.click();
				System.out.println(element[1] + " was Clicked");
			} catch (StaleElementReferenceException e) {
				elm = driver.findElement(AppiumBy.accessibilityId(element[0]));
				elm.click();
				System.out.println(element[1] + " was Clicked");
			}	
		}
		else if (locatorBy == "id") {
			WebElement elm = driver.findElement(AppiumBy.id(element[0]));
			try {
				elm.click();
				System.out.println(element[1] + " was Clicked");
			} catch (StaleElementReferenceException e) {
				elm = driver.findElement(AppiumBy.id(element[0]));
				elm.click();
				System.out.println(element[1] + " was Clicked");
			}	
		}
		else if (locatorBy == "xpath") {
			WebElement elm = driver.findElement(AppiumBy.xpath(element[0]));
			try {
				elm.click();
				System.out.println(element[1] + " was Clicked");
			} catch (StaleElementReferenceException e) {
				elm = driver.findElement(AppiumBy.xpath(element[0]));
				elm.click();
				System.out.println(element[1] + " was Clicked");
			}	
		}
		
	}
	
	public void longPressElement(String[] element) {
		String locatorBy = element[2];
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		
		if (locatorBy == "accessibilityId") {
			WebElement elm = driver.findElement(AppiumBy.accessibilityId(element[0]));
			try {
//				((JavascriptExecutor) driver).executeScript("mobile: longClickGesture", ImmutableMap.of(
//					    "elementId", ((RemoteWebElement) elm).getId()
//					));
				Map<String, Object> params = new HashMap<>();
				params.put("elementId", ((RemoteWebElement) elm).getId());
				params.put("duration", 2000);
				js.executeScript("mobile: longClickGesture", params);
				
				System.out.println(element[1] + " long pressed");
			} catch (StaleElementReferenceException e) {
				elm = driver.findElement(AppiumBy.accessibilityId(element[0]));
//				((JavascriptExecutor) driver).executeScript("mobile: longClickGesture", ImmutableMap.of(
//					    "elementId", ((RemoteWebElement) elm).getId()
//					));
				
				Map<String, Object> params = new HashMap<>();
				params.put("elementId", ((RemoteWebElement) elm).getId());
				params.put("duration", 2000);
				js.executeScript("mobile: longClickGesture", params);
				
				System.out.println(element[1] + " long pressed");
			}
		}
		else if (locatorBy == "xpath") {
			WebElement elm = driver.findElement(AppiumBy.xpath(element[0]));
			try {
//				((JavascriptExecutor) driver).executeScript("mobile: longClickGesture", ImmutableMap.of(
//					    "elementId", ((RemoteWebElement) elm).getId(), "duration",2000
//					));
				Map<String, Object> params = new HashMap<>();
				params.put("elementId", ((RemoteWebElement) elm).getId());
				params.put("duration", 2000);
				js.executeScript("mobile: longClickGesture", params);
				System.out.println(element[1] + " long pressed");
			} catch (StaleElementReferenceException e) {
				elm = driver.findElement(AppiumBy.xpath(element[0]));
//				((JavascriptExecutor) driver).executeScript("mobile: longClickGesture", ImmutableMap.of(
//					    "elementId", ((RemoteWebElement) elm).getId(), "duration",2000
//					));
				Map<String, Object> params = new HashMap<>();
				params.put("elementId", ((RemoteWebElement) elm).getId());
				params.put("duration", 2000);
				js.executeScript("mobile: longClickGesture", params);
				System.out.println(element[1] + " long pressed");
			}
		}
		
		
	}
	
	public void assertElementText(String[] element, String expectedValue) {
		String val;
		if (element[2] == "accessibilityId") {
			val=driver.findElement(AppiumBy.accessibilityId(element[0])).getText();
			Assert.assertEquals(val, expectedValue);
		}
		else if (element[2] == "id") {
			val=driver.findElement(AppiumBy.id(element[0])).getText();
			Assert.assertEquals(val, expectedValue);
		}
		
		else if (element[2] == "xpath") {
			val=driver.findElement(AppiumBy.xpath(element[0])).getText();
			Assert.assertEquals(val, expectedValue);
		}
	}
	
	public void assertElementDisplayed(String[] element) {
		if (element[2] == "accessibilityId") {
			Assert.assertTrue(driver.findElement(AppiumBy.accessibilityId(element[0])).isDisplayed());
		}
		else if (element[2] == "id") {
			Assert.assertTrue(driver.findElement(AppiumBy.id(element[0])).isDisplayed());
		}
		
		else if (element[2] == "xpath") {
			Assert.assertTrue(driver.findElement(AppiumBy.xpath(element[0])).isDisplayed());
		}
	}
	
	public boolean scrollDownGesture() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
//		boolean canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
//			    "left", 100, "top", 300, "width", 1300, "height", 2900,
//			    "direction", "down",
//			    "percent", 0.5
//			));
		Map<String, Object> params = new HashMap<>();
		params.put("left", 100);
		params.put("top", 300);
		params.put("width", 1300);
		params.put("height", 2900);
		params.put("direction", "down");
		params.put("percent", 0.5);
		
		boolean canScrollMore = (Boolean) (js.executeScript("mobile: scrollGesture", params));
		
		return canScrollMore;
	}
	
	public void scrollToElementByUIAutomator(String[] element) {
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView("+element[0]+")"));
		
		System.out.println("Scrolled to: " + element[1]);
	}
	
	public boolean flingGesture(String[] element) {
		String locatorBy = element[2];
		boolean canScrollMore = true;
		JavascriptExecutor js = (JavascriptExecutor) driver;
		if (locatorBy == "accessibilityId") {
			WebElement elm = driver.findElement(AppiumBy.accessibilityId(element[0]));
//			canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: flingGesture", ImmutableMap.of(
//				    "elementId", ((RemoteWebElement) elm).getId(),
//				    "direction", "down",
//				    "speed", 5000
//				));
			Map<String, Object> params = new HashMap<>();
			params.put("elementId", ((RemoteWebElement) elm).getId());
			params.put("direction", "down");
			params.put("speed", 5000);
			canScrollMore = (Boolean) (js.executeScript("mobile: flingGesture", params));
		}
		else if (locatorBy == "id") {
			WebElement elm = driver.findElement(AppiumBy.id(element[0]));
//			canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: flingGesture", ImmutableMap.of(
//				    "elementId", ((RemoteWebElement) elm).getId(),
//				    "direction", "down",
//				    "speed", 5000
//				));
			Map<String, Object> params = new HashMap<>();
			params.put("elementId", ((RemoteWebElement) elm).getId());
			params.put("direction", "down");
			params.put("speed", 5000);
			canScrollMore = (Boolean) (js.executeScript("mobile: flingGesture", params));
		}		
		else if (locatorBy == "xpath") {
			WebElement elm = driver.findElement(AppiumBy.xpath(element[0]));
//			canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: flingGesture", ImmutableMap.of(
//				    "elementId", ((RemoteWebElement) elm).getId(),
//				    "direction", "down",
//				    "speed", 5000
//				));	
			Map<String, Object> params = new HashMap<>();
			params.put("elementId", ((RemoteWebElement) elm).getId());
			params.put("direction", "down");
			params.put("speed", 5000);
			canScrollMore = (Boolean) (js.executeScript("mobile: flingGesture", params));
		}
		
		return canScrollMore;
	}
	
	public void dragGesture(String[] element, int coordinateX, int coordinateY) {
		String locatorBy = element[2];
		JavascriptExecutor js = (JavascriptExecutor) driver;
		if (locatorBy == "accessibilityId") {
			WebElement elm = driver.findElement(AppiumBy.accessibilityId(element[0]));
//			((JavascriptExecutor) driver).executeScript("mobile: dragGesture", ImmutableMap.of(
//				    "elementId", ((RemoteWebElement) elm).getId(),
//				    "endX", coordinateX,
//				    "endY", coordinateY
//				));
			Map<String, Object> params = new HashMap<>();
			params.put("elementId", ((RemoteWebElement) elm).getId());
			params.put("endX", coordinateX);
			params.put("endY", coordinateY);
			js.executeScript("mobile: dragGesture", params);
		}
		else if (locatorBy == "id") {
			WebElement elm = driver.findElement(AppiumBy.id(element[0]));
//			((JavascriptExecutor) driver).executeScript("mobile: dragGesture", ImmutableMap.of(
//				    "elementId", ((RemoteWebElement) elm).getId(),
//				    "endX", coordinateX,
//				    "endY", coordinateY
//				));
			Map<String, Object> params = new HashMap<>();
			params.put("elementId", ((RemoteWebElement) elm).getId());
			params.put("endX", coordinateX);
			params.put("endY", coordinateY);
			js.executeScript("mobile: dragGesture", params);
		}
		else if (locatorBy == "xpath") {
			WebElement elm = driver.findElement(AppiumBy.xpath(element[0]));
//			((JavascriptExecutor) driver).executeScript("mobile: dragGesture", ImmutableMap.of(
//				    "elementId", ((RemoteWebElement) elm).getId(),
//				    "endX", coordinateX,
//				    "endY", coordinateY
//				));
			Map<String, Object> params = new HashMap<>();
			params.put("elementId", ((RemoteWebElement) elm).getId());
			params.put("endX", coordinateX);
			params.put("endY", coordinateY);
			js.executeScript("mobile: dragGesture", params);
		}
	}
	
	public void getElementsTextByXpath(String locatorByXpath) {
		List<WebElement> elements = driver.findElements(By.xpath(locatorByXpath));
        
		for(WebElement element: elements){
		    System.out.println(element.getText());
		}
	}
}
