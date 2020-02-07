package hands.on.appium_ios;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class MobileNativeAppExample {

	@Test
	public void test001() throws MalformedURLException {

		IOSDriver<IOSElement> iosDriver;

		URL url;

		DesiredCapabilities desiredCapabilities;

		url = new URL("http://127.0.0.1:4723/wd/hub");

		desiredCapabilities = new DesiredCapabilities();

		desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");

		desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "13.3");

		desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone Simulator");

		desiredCapabilities.setCapability(MobileCapabilityType.UDID, "3B73633F-25BE-4CAF-A231-F6FAE97E17FE");

		// desiredCapabilities.setCapability(MobileCapabilityType.APP,"/Users/gaurav.khanna/Downloads/Calculator_1.0.ipa");

		// desiredCapabilities.setCapability(IOSMobileCapabilityType.BUNDLE_ID,
		// "com.apple.reminders");

		desiredCapabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "safari");

		iosDriver = new IOSDriver<IOSElement>(url, desiredCapabilities);

		// iosDriver = new IOSDriver<IOSElement>(desiredCapabilities);

		// iosDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		iosDriver.get("https://not-just-a-tester.blogspot.com/");

		String title = iosDriver.getTitle();

		System.out.println("Page Title : " + title);

		iosDriver.quit();

	}

}
