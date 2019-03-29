package com.kebab;

import com.thoughtworks.gauge.AfterScenario;
import com.thoughtworks.gauge.AfterSuite;
import com.thoughtworks.gauge.BeforeScenario;
import com.thoughtworks.gauge.BeforeSuite;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.net.URL;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class DriverSetup {
    public static AppiumDriver<MobileElement> driver;
    public static DesiredCapabilities capabilities;
    public static final String APPPACKAGE = "com.pozitron.pegasus";
    public static final String APPACTIVITY = "com.monitise.mea.pegasus.ui.splash.SplashActivity";





@BeforeScenario
        public void setup () throws IOException {
//        DesiredCapabilities capabilities = new DesiredCapabilities();
//        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
//        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "ASUS_Z00AD");
//        capabilities.setCapability("platformName", "Android");
//        capabilities.setCapability("udid", "192.168.0.35:4000");
//        capabilities.setCapability("appPackage", "com.pozitron.hepsiburada");
//        capabilities.setCapability("appActivity", "com.hepsiburada.ui.startup.SplashActivity");
//        capabilities.setCapability(MobileCapabilityType.NO_RESET, true);
//        capabilities.setCapability(MobileCapabilityType.FULL_RESET, false);
//        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
//
//        // driver = (AndroidDriver<MobileElement>) new RemoteWebDriver( new URL("http://192.168.60.134:4444/wd/hub"), capabilities);
//        driver = new  AndroidDriver<MobileElement> (new URL("http://0.0.0.0:5000/wd/hub"), capabilities);

            //EMULATOR
            capabilities = new DesiredCapabilities();
            capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
            capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Nexus 5 API 27");
            capabilities.setCapability("platformName", "Android");
            capabilities.setCapability("VERSION", "8.1.0");
            capabilities.setCapability("udid", "emulator-5554");
            capabilities.setCapability(MobileCapabilityType.NO_RESET, false);

            capabilities.setCapability("appPackage", APPPACKAGE);
            capabilities.setCapability("appActivity", APPACTIVITY);


            driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);


        }

        @AfterScenario
        public void tearDown () {
            if (driver != null) {
                driver.quit();
            }
        }

}
