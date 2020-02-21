package hands.on.appium_ios.apps_native;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.IOSMobileCapabilityType;

public class SettingsExample {

	@Test
	public void settingsTest() throws MalformedURLException {

		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setCapability("platformName", "iOS");
		desiredCapabilities.setCapability("platformVersion", "13.3");
		desiredCapabilities.setCapability("deviceName", "iPhone 8");
		desiredCapabilities.setCapability(IOSMobileCapabilityType.BUNDLE_ID, "com.apple.Preferences");

		IOSDriver<IOSElement> iosDriver = new IOSDriver<IOSElement>(new URL("http://localhost:4723/wd/hub"),
				desiredCapabilities);

		iosDriver.quit();

	}

}