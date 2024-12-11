package Tests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {
    protected AppiumDriver driver;

    @BeforeMethod
    public void setUp() throws MalformedURLException {
        //  DesiredCapabilities for iOS
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "iOS");
        capabilities.setCapability("deviceName", "iPhone SE (3rd generation)");
        capabilities.setCapability("platformVersion", "18.1"); //
        capabilities.setCapability("automationName", "XCUITest");
        capabilities.setCapability("app", "/Users/ariasandres/Library/Developer/Xcode/DerivedData/grameen-gjbrkxroppverubpmublfthhiwey/Build/Products/Debug-iphonesimulator/grameen.app"); // O .ipa si es para un dispositivo físico
        capabilities.setCapability("updatedWDABundleId", "com.andres.WebDriverAgentRunner");
        capabilities.setCapability("useNewWDA", true);
        capabilities.setCapability("wdaStartupRetries", 4);
        capabilities.setCapability("wdaStartupRetryInterval", 20000);
        capabilities.setCapability("showXcodeLog", true);
        capabilities.setCapability("clearSystemFiles", true);
        capabilities.setCapability("appium:autoAcceptAlerts", true);

        // Initialize driver
        driver = new IOSDriver(new URL("http://localhost:4723"), capabilities);
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
