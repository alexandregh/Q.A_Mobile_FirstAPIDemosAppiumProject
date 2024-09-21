package androidgestures;

import com.google.common.collect.ImmutableMap;
import createcapabilitdriversession.CreateDriverSession;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Map;

public class AndroidGestures {
    static By views;
    static WebElement element;
    public static void main(String[] args) throws Exception {
        AppiumDriver driver = CreateDriverSession.inicializeDriver("Android");

        longClickGesture(driver);
        clickGesture(driver);
        dragGesture(driver);
        /* The two commands commented below belong to the appPackage and appActivity
         * commented in the "CreateDriverSession.java" file.
         */
        //pinchOpenGesture(driver);
        //doubleClickGestureMaps(driver);
        swipeGestureByCoordinates(driver);
        swipeGestureByElementId(driver);
        scrollGestureByCoordinates(driver);
        scrollGestureByElementId(driver);
        scrollGestureByFirstElementButton(driver);
        swipeGestureByGalleryPhotos(driver);
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

        driver.executeScript("mobile: pressKey", Map.ofEntries(Map.entry("keycode", 4)));
        driver.executeScript("mobile: pressKey", Map.ofEntries(Map.entry("keycode", 4)));
    }
    public static void clickGesture(@NotNull AppiumDriver driver) {
        executeWait(driver);
        WebElement element = driver.findElement(AppiumBy.accessibilityId("Views"));

        Assertions.assertEquals("Views", driver.findElement(AppiumBy.accessibilityId("Views"))
                .getAttribute("content-desc"));

        driver.executeScript("mobile: clickGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) element).getId()
        ));
        WebElement frameElement = driver.findElement(AppiumBy.id("android:id/list"));
        Assertions.assertEquals(frameElement.getAttribute("resource-id"), driver.findElement(AppiumBy.id("android:id/list"))
                .getAttribute("resource-id"));

        driver.executeScript("mobile: pressKey", Map.ofEntries(Map.entry("keycode", 4)));
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
                "speed", 200
        ));
        Assertions.assertTrue(true, "Dropped!");

        driver.executeScript("mobile: pressKey", Map.ofEntries(Map.entry("keycode", 4)));
        driver.executeScript("mobile: pressKey", Map.ofEntries(Map.entry("keycode", 4)));
    }
    public static void pinchOpenGesture(@NotNull AppiumDriver driver) throws InterruptedException {
        Thread.sleep(3000);

        driver.executeScript("mobile: pinchOpenGesture", ImmutableMap.of(
                "left", 347,
                "top", 516,
                "width", 113,
                "height", 200,
                "percent", 0.75
        ));
    }
    public static void doubleClickGestureMaps(@NotNull AppiumDriver driver) throws InterruptedException {
        Thread.sleep(3000);

        for (int i = 1; i <= 5; i++)
        {
            driver.executeScript("mobile: doubleClickGesture", ImmutableMap.of(
                "x",417,
                "y",557
            ));
        }
    }
    public static void swipeGestureByCoordinates(@NotNull AppiumDriver driver) throws InterruptedException {
        executeWait(driver);
        driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Views\")")).click();

        executeSwipeGestureByCoordinates(driver,"up");
        Thread.sleep(2000);
        driver.executeScript("mobile: pressKey", Map.ofEntries(Map.entry("keycode", 4)));
    }
    public static void swipeGestureByElementId(@NotNull AppiumDriver driver) throws InterruptedException {
        executeWait(driver);
        element = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"android:id/list\")"));

        executeSwipeGestureByElementId(driver, element,"up");
        Thread.sleep(2000);
    }
    public static void scrollGestureByCoordinates(@NotNull AppiumDriver driver) {
        executeWait(driver);
        driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Views\")")).click();
        executeScrollGestureByCoordinates(driver, "down");
        driver.executeScript("mobile: pressKey", Map.ofEntries(Map.entry("keycode", 4)));
    }
    public static void scrollGestureByElementId(@NotNull AppiumDriver driver) {
        executeWait(driver);
        driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Views\")")).click();
        element = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"android:id/list\")"));
        executeScrollGestureByElementId(driver, element, "down");
        driver.executeScript("mobile: pressKey", Map.ofEntries(Map.entry("keycode", 4)));
    }
    public static void scrollGestureByFirstElementButton(@NotNull AppiumDriver driver) throws InterruptedException {
        executeWait(driver);
        driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Views\")")).click();
        element = driver.findElement(AppiumBy.accessibilityId("Buttons"));
        executeScrollGestureByFirstElementButton(driver, element, "down");
        Thread.sleep(2000);
        executeScrollGestureByFirstElementButton(driver,element,"up");
        driver.executeScript("mobile: pressKey", Map.ofEntries(Map.entry("keycode", 4)));
    }
    public static void swipeGestureByGalleryPhotos(@NotNull AppiumDriver driver) throws InterruptedException {
        executeWait(driver);
        driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Views\")")).click();
        driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Gallery\")")).click();
        driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"1. Photos\")")).click();

        WebElement element = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.ImageView\").instance(0)"));
        executeGalleryPhotos(driver, element, "left");

        Thread.sleep(2000);

        element = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.ImageView\").instance(2)"));
        executeGalleryPhotos(driver, element, "right");
    }

    private static void executeWait(AppiumDriver driver) {
        views = AppiumBy.accessibilityId("Views");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(views));
    }
    private static void executeSwipeGestureByCoordinates(@NotNull AppiumDriver driver, String direction) {
        // By coordinates...
        driver.executeScript("mobile: swipeGesture", ImmutableMap.of(
                "left", 100, "top", 100, "width", 600, "height", 600,
                "direction", direction,
                "percent", 0.85
                //"speed", 5000
        ));
    }
    private static void executeSwipeGestureByElementId(@NotNull AppiumDriver driver, WebElement element, String direction) {
        // By elementId
        driver.executeScript("mobile: swipeGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) element).getId(),
                "direction", direction,
                "percent", 0.85
                //"speed", 5000
        ));
    }
    private static void executeScrollGestureByCoordinates(@NotNull AppiumDriver driver, String direction) {
        boolean canScrollMore = (Boolean) driver.executeScript("mobile: scrollGesture", ImmutableMap.of(
                "left", 100, "top", 100, "width", 600, "height", 600,
                "direction", direction,
                "percent", 1.0
        ));
    }
    private static void executeScrollGestureByElementId(@NotNull AppiumDriver driver, WebElement element, String direction) {
        boolean canScrollMore = (Boolean) driver.executeScript("mobile: scrollGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) element).getId(),
                "direction", direction,
                "percent", 1.0
        ));

    }
    private static void executeScrollGestureByFirstElementButton(@NotNull AppiumDriver driver, @NotNull WebElement element, String direction) {
        for (int i = 1; i <= 3; i++) {
            boolean canScrollMore = (Boolean) driver.executeScript("mobile: scrollGesture", ImmutableMap.of(
                    "elementId", ((RemoteWebElement) element).getId(),
                    "direction", direction,
                    "percent", 1.0
            ));
        }
    }
    private static void executeGalleryPhotos(@NotNull AppiumDriver driver, WebElement element, String direction) {
        // By GalleryPhotos
        driver.executeScript("mobile: swipeGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) element).getId(),
                "direction", direction,
                "percent", 0.85,
                "speed", 5000
        ));
    }
}
