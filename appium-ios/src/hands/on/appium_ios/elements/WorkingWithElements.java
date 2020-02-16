package hands.on.appium_ios.elements;

import java.net.URL;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.MobileBy;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.IOSMobileCapabilityType;

public class WorkingWithElements {

	@Test
	public void testAppActivity() throws Exception {

		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setCapability("platformName", "iOS");
		desiredCapabilities.setCapability("platformVersion", "13.3");
		desiredCapabilities.setCapability("deviceName", "iPhone 8");
		desiredCapabilities.setCapability(IOSMobileCapabilityType.BUNDLE_ID, "io.cloudgrey.the-app");

		IOSDriver<WebElement> iosDriver = new IOSDriver<WebElement>(new URL("http://localhost:4723/wd/hub"),
				desiredCapabilities);

		Boolean status = iosDriver.findElement(MobileBy.AccessibilityId("Choose An Awesome View")).isDisplayed();

		System.out.println("Status : " + status);

		Boolean status1 = iosDriver.findElement(MobileBy.AccessibilityId("Choose An Awesome View")).isEnabled();

		System.out.println("Status : " + status1);

		Boolean status2 = iosDriver.findElement(MobileBy.AccessibilityId("Choose An Awesome View")).isSelected();

		System.out.println("Status : " + status2);

		iosDriver.quit();

	}

}