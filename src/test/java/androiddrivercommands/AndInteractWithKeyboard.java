package androiddrivercommands;

import com.google.common.collect.ImmutableMap;
import createcapabilitdriversession.CreateDriverSession;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import java.time.Duration;

public class AndInteractWithKeyboard {
    public static void main(String[] args) throws Exception {
        AppiumDriver driver = CreateDriverSession.inicializeDriver("Android");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        ((AndroidDriver) driver).unlockDevice();
        System.out.println("Unlock: " + ((AndroidDriver) driver).isDeviceLocked());

        By btnViews = AppiumBy.accessibilityId("Views");
        By btnTextFields = AppiumBy.accessibilityId("TextFields");
        By txtEdit = AppiumBy.id("io.appium.android.apis:id/edit");

        driver.findElement(btnViews).click();
        performScrolling(driver);
        driver.findElement(btnTextFields).click();
        driver.findElement(txtEdit).click();
        Thread.sleep(2000);

        System.out.println("Keyboard: " + ((AndroidDriver) driver).isKeyboardShown());

        ((AndroidDriver) driver).pressKey(new KeyEvent().withKey(AndroidKey.C));
        ((AndroidDriver) driver).pressKey(new KeyEvent().withKey(AndroidKey.A));
        ((AndroidDriver) driver).pressKey(new KeyEvent().withKey(AndroidKey.B));
        Thread.sleep(2000);

        ((AndroidDriver) driver).hideKeyboard();
        System.out.println("Keyboard: " + ((AndroidDriver) driver).isKeyboardShown());
    }
    private static void performScrolling(@NotNull AppiumDriver driver) {
        //scrolling
        WebElement elementScrolling = driver.findElement(AppiumBy.id("android:id/list"));
        driver.executeScript("mobile: swipeGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) elementScrolling).getId(),
                "direction", "up",
                "percent", 0.75
        ));
    }
}
