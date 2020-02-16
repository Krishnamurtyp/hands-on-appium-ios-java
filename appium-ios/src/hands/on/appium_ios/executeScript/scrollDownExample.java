package hands.on.appium_ios.executeScript;

import java.net.URL;
import java.util.HashMap;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.IOSMobileCapabilityType;

public class scrollDownExample {

	@Test
	public void testAppActivity() throws Exception {

		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setCapability("platformName", "iOS");
		desiredCapabilities.setCapability("platformVersion", "13.3");
		desiredCapabilities.setCapability("deviceName", "iPhone 8");
		desiredCapabilities.setCapability(IOSMobileCapabilityType.BUNDLE_ID, "com.apple.Preferences");

		IOSDriver<WebElement> iosDriver = new IOSDriver<WebElement>(new URL("http://localhost:4723/wd/hub"),
				desiredCapabilities);

		JavascriptExecutor js = (JavascriptExecutor) iosDriver;

		HashMap<String, String> scrollObject = new HashMap<String, String>();

		scrollObject.put("direction", "down");

		js.executeScript("mobile: scroll", scrollObject);

	}
}
