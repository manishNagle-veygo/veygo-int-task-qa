package org.example;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class AppiumTestRun {

    private AndroidDriver driver;

    @BeforeClass
    public void setUp() throws MalformedURLException {

//        UiAutomator2Options options = new UiAutomator2Options();
//        options.setDeviceName("emulator-5554");
//        options.setApp("src/test/java/org/example/Android.SauceLabs.Mobile.Sample.app.2.7.1.apk");
        File appDir =  new File("/Users/manishnagle/Downloads/mobile-app-automation-tests-tech-test-2025/AppiumLatestVersionRun/src/test/java/org/example/");
        File file = new File(appDir,"Android.SauceLabs.Mobile.Sample.app.2.7.1.apk");
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
        caps.setCapability(MobileCapabilityType.APP, file.getAbsolutePath());
        caps.setCapability("appPackage", "com.swaglabsmobileapp");
        caps.setCapability("appActivity", "com.swaglabsmobileapp.SplashActivity");

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);
        System.out.println("setUp");
    }

    @Test
    public void sampleTest() {
        System.out.println("Running Test");
        Assert.assertEquals(1, 1, "1 should be equal to 1");
        System.out.println("Test Passed");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
