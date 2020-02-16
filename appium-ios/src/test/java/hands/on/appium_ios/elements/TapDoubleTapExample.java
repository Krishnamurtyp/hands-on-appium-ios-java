package hands.on.appium_ios.elements;

import java.net.URL;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.touch.TapOptions;

public class TapDoubleTapExample {

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

		WebDriverWait wait = new WebDriverWait(iosDriverObj, 10);

		wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.AccessibilityId("Echo Box")));

		TapOptions action = new TapOptions();

		MobileElement element = (MobileElement) iosDriverObj.findElement(MobileBy.AccessibilityId("Echo Box"));

		action.tapOptions().withTapsCount(1);

	}

}
