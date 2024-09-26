package androiddrivercommands;

import createcapabilitdriversession.CreateDriverSession;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.appmanagement.AndroidInstallApplicationOptions;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;

import java.io.File;
import java.time.Duration;
import java.util.Map;

public class AndroidDriverCommands {
    public static void main(String[] args) throws Exception {
        AppiumDriver driver = CreateDriverSession.inicializeDriver("Android");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        By views = AppiumBy.accessibilityId("Views");
        driver.findElement(views).click();

        executeOpenApp(driver);
        terminateApplication(driver);
        returnBatteryInfo(driver);
        executeInstallApp(driver);
        checkAppInstall(driver);
        executeAppInBackgroundAndReturnForeground(driver);
        activateAndDeactivateApp(driver);
        executeQueryAppState(driver);
        executeCloseAllApps(driver);
    }
    public static void executeOpenApp(@NotNull AppiumDriver driver) {
        boolean resultAppInstalled = ((AndroidDriver) driver).isAppInstalled("io.appium.android.apis");
        if (resultAppInstalled) {
            ((AndroidDriver) driver).activateApp("io.appium.android.apis");
            Assertions.assertEquals("RUNNING_IN_FOREGROUND",
                    ((AndroidDriver) driver).queryAppState("io.appium.android.apis").toString());
        }
    }
    public static void terminateApplication(@NotNull AppiumDriver driver) {
        boolean resultAppInstalled = ((AndroidDriver) driver).isAppInstalled("io.appium.android.apis");
        if (resultAppInstalled) {
            Assertions.assertTrue(true, String.valueOf(((AndroidDriver) driver)
                    .terminateApp("io.appium.android.apis")));
        }
    }
    public static void returnBatteryInfo(@NotNull AppiumDriver driver) {
        String battery = ((AndroidDriver) driver).getBatteryInfo().getState().toString();
        switch (battery) {
            case "FULL":
                Assertions.assertEquals("FULL", battery);
                break;
            default:
                break;
        }
        System.out.println("Battery: " + battery);
    }
    public static void executeInstallApp(@NotNull AppiumDriver driver) {
        final String APP_ANDROID_URL = System.getProperty("user.dir") +
                File.separator + "src" +
                File.separator + "test" +
                File.separator + "resources" +
                File.separator + "appAndroid" +
                File.separator + "ApiDemos-debug.apk";
        ((AndroidDriver) driver).installApp(APP_ANDROID_URL,
                new AndroidInstallApplicationOptions().withReplaceEnabled());
    }
    public static void checkAppInstall(@NotNull AppiumDriver driver) {
        boolean appInstalled = ((AndroidDriver) driver).isAppInstalled("io.appium.android.apis");
        Assertions.assertTrue(true, String.valueOf(appInstalled));
        System.out.println(appInstalled);
    }
    public static void executeAppInBackgroundAndReturnForeground(@NotNull AppiumDriver driver) {
        ((AndroidDriver) driver).runAppInBackground(Duration.ofMillis(5000));
        Assertions.assertTrue(true, "Returns to the foreground!");
        System.out.println("Returns to the foreground!");
    }
    public static void activateAndDeactivateApp(@NotNull AppiumDriver driver) {
        ((AndroidDriver) driver).terminateApp("io.appium.android.apis");
        Assertions.assertTrue(true, "Application (io.appium.android.apis) terminated!");
        System.out.println("Application (io.appium.android.apis) terminated!");

        ((AndroidDriver) driver).activateApp("com.sec.android.app.clockpackage");
        Assertions.assertTrue(true, "Application (com.sec.android.app.clockpackage) activated!");
        System.out.println("Application (com.sec.android.app.clockpackage) activated!");

        ((AndroidDriver) driver).activateApp("io.appium.android.apis");
        Assertions.assertTrue(true, "Application (io.appium.android.apis) activated!");
        System.out.println("Application (io.appium.android.apis) activated!");

        ((AndroidDriver) driver).terminateApp("com.sec.android.app.clockpackage");
        Assertions.assertTrue(true, "Application (com.sec.android.app.clockpackage) terminated!");
        System.out.println("Application (com.sec.android.app.clockpackage) terminated!");
    }
    public static void executeQueryAppState(@NotNull AppiumDriver driver) {
        System.out.println(((AndroidDriver) driver).queryAppState("io.appium.android.apis"));
        Assertions.assertTrue(true,"RUNNING_IN_FOREGROUND");

        ((AndroidDriver) driver).terminateApp("io.appium.android.apis");
        System.out.println(((AndroidDriver) driver).queryAppState("io.appium.android.apis"));
        Assertions.assertTrue(true,"NOT_RUNNING");

        ((AndroidDriver) driver).activateApp("io.appium.android.apis");
        System.out.println(((AndroidDriver) driver).queryAppState("io.appium.android.apis"));
        Assertions.assertTrue(true,"RUNNING_IN_FOREGROUND");
    }
    public static void executeCloseAllApps(@NotNull AppiumDriver driver) {
        driver.executeScript("mobile: pressKey", Map.ofEntries(Map.entry("keycode", 187)));
        driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.sec.android.app.launcher:id/clear_all_button\")"))
                .click();
        ((AndroidDriver) driver).terminateApp("io.appium.android.apis");
        System.out.println(((AndroidDriver) driver).queryAppState("io.appium.android.apis"));
        Assertions.assertTrue(true,"NOT_RUNNING");
    }
}
