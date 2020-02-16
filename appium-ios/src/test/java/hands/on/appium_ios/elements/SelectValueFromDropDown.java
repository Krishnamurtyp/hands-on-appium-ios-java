package hands.on.appium_ios.elements;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.appium.java_client.MobileBy;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.IOSMobileCapabilityType;

public class SelectValueFromDropDown {

	@Test
	public void example() {

		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setCapability("platformName", "iOS");
		desiredCapabilities.setCapability("platformVersion", "13.3");
		desiredCapabilities.setCapability("deviceName", "iPhone 8");
		desiredCapabilities.setCapability(IOSMobileCapabilityType.BUNDLE_ID, "com.apple.MobileCal");

		IOSDriver<WebElement> iosDriver = null;
		
		try {

			iosDriver = new IOSDriver<WebElement>(new URL("http://localhost:4723/wd/hub"), desiredCapabilities);

		} catch (MalformedURLException e) {

			e.printStackTrace();

		}

		WebDriverWait wait = new WebDriverWait(iosDriver, 10);

		wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.AccessibilityId("Continue")));

		iosDriver.findElement(MobileBy.AccessibilityId("Continue")).click();

	}

}
