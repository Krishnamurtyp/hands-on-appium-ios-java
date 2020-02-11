package hands.on.appium_ios.basic;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class MobileWebAppExample2 {

	private static By EMAIL = By.id("contactEmail");
	private static By MESSAGE = By.id("contactText");
	private static By SEND = By.cssSelector("input[type=submit]");
	private static By ERROR = By.cssSelector(".contactResponse");

	@Test
	public void testAppiumProSite_iOS() throws MalformedURLException {

		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("platformName", "iOS");
		capabilities.setCapability("platformVersion", "13.3");
		capabilities.setCapability("deviceName", "iPhone 8");
		capabilities.setCapability("browserName", "Safari");

		IOSDriver<WebElement> driver = new IOSDriver<WebElement>(new URL("http://localhost:4723/wd/hub"), capabilities);

		actualTest(driver);
	}

	public void actualTest(AppiumDriver driver) {

		WebDriverWait wait = new WebDriverWait(driver, 10);

		try {
			driver.get("http://appiumpro.com/contact");
			wait.until(ExpectedConditions.visibilityOfElementLocated(EMAIL)).sendKeys("foo@foo.com");
			driver.findElement(MESSAGE).sendKeys("Hello!");
			driver.findElement(SEND).click();
			String response = wait.until(ExpectedConditions.visibilityOfElementLocated(ERROR)).getText();
			System.out.println("Response : " + response);
		} finally {
			driver.quit();
		}

	}
}