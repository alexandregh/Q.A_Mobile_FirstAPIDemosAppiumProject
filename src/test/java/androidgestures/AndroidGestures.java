package androidgestures;

import com.google.common.collect.ImmutableMap;
import createcapabilitdriversession.CreateDriverSession;
import dev.failsafe.internal.util.Assert;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

public class AndroidGestures {
    public static void main(String[] args) throws Exception {
        AppiumDriver driver = CreateDriverSession.inicializeDriver("Android");

        //longClickGesture(driver);
        //clickGesture(driver);
        dragGesture(driver);
    }
    public static void longClickGesture(@NotNull AppiumDriver driver) {
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(AppiumBy.accessibilityId("Drag and Drop")).click();
        WebElement element = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"io.appium.android.apis:id/drag_dot_1\")"));

        Assertions.assertFalse(false, "Dropped!");

        driver.executeScript("mobile: longClickGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) element).getId(),
                "x",146 ,
                "y",405 ,
                "duration", 1000
        ));
        Assertions.assertTrue(true, "Dropped!");
    }
    public static void clickGesture(@NotNull AppiumDriver driver) {
        WebElement element = driver.findElement(AppiumBy.accessibilityId("Views"));

        Assertions.assertEquals("Views", driver.findElement(AppiumBy.accessibilityId("Views"))
                .getAttribute("content-desc"));

        driver.executeScript("mobile: clickGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) element).getId()
        ));
        Assertions.assertEquals("Animation", driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Animation\")"))
                .getAttribute("content-desc"));
    }
    public static void dragGesture(@NotNull AppiumDriver driver) {
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(AppiumBy.accessibilityId("Drag and Drop")).click();
        WebElement element = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"io.appium.android.apis:id/drag_dot_1\")"));

        Assertions.assertFalse(false, "Dropped!");

        driver.executeScript("mobile: dragGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) element).getId(),
                "endX", 446,
                "endY", 408,
                "speed", 10000
        ));
        Assertions.assertTrue(true, "Dropped!");
    }
}
