package com.example.framework.base;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {
    protected static AppiumDriver<MobileElement> driver;

    public void setup(String platform) throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        if (platform.equalsIgnoreCase("android")) {
            capabilities.setCapability("platformName", "Android");
            capabilities.setCapability("deviceName", "Android Emulator");
            capabilities.setCapability("app", "/path/to/your-android-app.apk");
            driver = new AndroidDriver<>(new URL("http://localhost:4723/wd/hub"), capabilities);
        } else if (platform.equalsIgnoreCase("ios")) {
            capabilities.setCapability("platformName", "iOS");
            capabilities.setCapability("deviceName", "iPhone Simulator");
            capabilities.setCapability("app", "/path/to/your-ios-app.app");
            driver = new IOSDriver<>(new URL("http://localhost:4723/wd/hub"), capabilities);
        }
    }

    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
