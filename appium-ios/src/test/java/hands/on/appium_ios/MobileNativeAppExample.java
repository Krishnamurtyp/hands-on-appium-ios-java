package hands.on.appium_ios;

import io.appium.java_client.MobileBy;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.IOSMobileCapabilityType;

import java.net.URL;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MobileNativeAppExample {

	@Test
	public void testAppActivity() throws Exception {

		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setCapability("platformName", "iOS");
		desiredCapabilities.setCapability("platformVersion", "13.3");
		desiredCapabilities.setCapability("deviceName", "iPhone 8");
		desiredCapabilities.setCapability(IOSMobileCapabilityType.BUNDLE_ID, "io.cloudgrey.the-app");

		IOSDriver<WebElement> iosDriver = new IOSDriver<WebElement>(new URL("http://localhost:4723/wd/hub"),
				desiredCapabilities);

		performActions(iosDriver);

		iosDriver.quit();

	}

	public void performActions(IOSDriver<WebElement> iosDriverObj) {

		System.out.println(
				iosDriverObj.findElement(MobileBy.AccessibilityId("Choose An Awesome View")).getAttribute("name"));

		System.out.println(
				iosDriverObj.findElement(MobileBy.AccessibilityId("Choose An Awesome View")).getAttribute("label"));

		System.out.println(
				iosDriverObj.findElement(MobileBy.AccessibilityId("Choose An Awesome View")).getAttribute("enabled"));

		System.out.println(
				iosDriverObj.findElement(MobileBy.AccessibilityId("Choose An Awesome View")).getAttribute("visible"));

		System.out.println(
				iosDriverObj.findElement(MobileBy.AccessibilityId("Choose An Awesome View")).getAttribute("label"));

		WebDriverWait wait = new WebDriverWait(iosDriverObj, 10);

		wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.AccessibilityId("Echo Box"))).click();

		wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//XCUIElementTypeTextField[@name=\"messageInput\"]")))
				.sendKeys("Hello World");

		wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.AccessibilityId("messageSaveBtn"))).click();

		String savedText = wait
				.until(ExpectedConditions.presenceOfElementLocated(MobileBy.AccessibilityId("savedMessage"))).getText();

		Assert.assertEquals(savedText, "Hello World");

		iosDriverObj.navigate().back();
	}
}
