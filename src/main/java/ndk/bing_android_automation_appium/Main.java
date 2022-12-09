package ndk.bing_android_automation_appium;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;

public class Main {

    public static void main(String[] args) {

        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();

        desiredCapabilities.setCapability("automationName", "UiAutomator2");
        desiredCapabilities.setCapability("udid", "127.0.0.1:21503");
        desiredCapabilities.setCapability(CapabilityType.PLATFORM_NAME, "Android");
        desiredCapabilities.setCapability("platformVersion", "7.1.2");
        desiredCapabilities.setCapability("appPackage", "com.microsoft.bing");
        desiredCapabilities.setCapability("appActivity", "com.microsoft.sapphire.app.main.SapphireHomeV3Activity");
        desiredCapabilities.setCapability("noReset", "true");

        try {

            AndroidDriver remoteWebDriver = new AndroidDriver(new URI("http://127.0.0.1:4723/wd/hub").toURL(), desiredCapabilities);

            remoteWebDriver.findElement(By.id("com.microsoft.bing:id/sa_hp_header_search_box")).click();
            remoteWebDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            remoteWebDriver.findElement(By.id("com.microsoft.bing:id/sapphire_search_header_input")).sendKeys("Automation of android apps");
            remoteWebDriver.pressKey(new KeyEvent(AndroidKey.ENTER));

        } catch (MalformedURLException | URISyntaxException e) {

            System.out.println(e.getLocalizedMessage());
        }
    }
}
