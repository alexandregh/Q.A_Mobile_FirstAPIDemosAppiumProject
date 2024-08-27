package createcapabilitdriversession;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.URL;

public class CreateDriverSession {
    public static AppiumDriver inicializeDriver(String platformName) throws Exception {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName",platformName);

        URL urlAppium = new URL("http://0.0.0.0:4723");

        switch (platformName) {
            case "Android":
                final String APP_ANDROID_URL = System.getProperty("user.dir") +
                        File.separator + "src" +
                        File.separator + "test" +
                        File.separator + "resources" +
                        File.separator + "appAndroid" +
                        File.separator + "ApiDemos-debug.apk";

                capabilities.setCapability("appium:deviceName", "pixel_5");
                capabilities.setCapability("appium:automationName", "UiAutomator2");
                capabilities.setCapability("appium:udid", "emulator-5554");
                capabilities.setCapability("appium:avd", "Pixel_5");
                capabilities.setCapability("appium:avdLaunchTimeout", 180000);
                capabilities.setCapability("appium:newCommandTimeout", 300);
                capabilities.setCapability("appium:appPackage", "io.appium.android.apis");
                capabilities.setCapability("appium:appActivity", ".ApiDemos");
                capabilities.setCapability("appium:app", APP_ANDROID_URL);

                return new AndroidDriver(urlAppium,capabilities);
            /*case "iOS":
                final String APP_IOS_URL = System.getProperty("user.dir") +
                        File.separator + "src" +
                        File.separator + "test" +
                        File.separator + "resources" +
                        File.separator + "appIOS" +
                        File.separator + "UIKitCatalog-iphonesimulator.app";
                capabilities.setCapability("deviceName", "iPhone 11");
                capabilities.setCapability("automationName", "XCUITest");
                capabilities.setCapability("udid", "");
                capabilities.setCapability("xcodeOrgId", "")
                capabilities.setCapability("xcodeSigningId", "iPhone Developer")
                capabilities.setCapability(MobileCapabilityType.APP, APP_IOS_URL)
                capabilities.setCapability("simulatorStartupTimeout", 180000)
                capabilities.setCapability("bundleId", "com.exemple.apple-samplecode.UICatalog")

                return new IOSDriver(urlAppium, capabilities);*/
            default:
                throw new Exception("invalid platform");
        }
    }
}
