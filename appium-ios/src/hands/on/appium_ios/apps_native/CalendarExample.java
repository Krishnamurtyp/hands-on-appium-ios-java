package hands.on.appium_ios.apps_native;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.IOSMobileCapabilityType;

public class CalendarExample {

	@Test
	public void calculatorTest() throws MalformedURLException {

		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setCapability("platformName", "iOS");
		desiredCapabilities.setCapability("platformVersion", "13.3");
		desiredCapabilities.setCapability("deviceName", "iPhone 8");
		desiredCapabilities.setCapability(IOSMobileCapabilityType.BUNDLE_ID, "com.apple.MobileCal");

		IOSDriver<IOSElement> iosDriver = new IOSDriver<IOSElement>(new URL("http://localhost:4723/wd/hub"),
				desiredCapabilities);

		iosDriver.quit();

	}

}