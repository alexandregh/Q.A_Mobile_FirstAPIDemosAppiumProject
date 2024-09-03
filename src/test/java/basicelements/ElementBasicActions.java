import com.google.common.collect.ImmutableMap;
import createcapabilitdriversession.CreateDriverSession;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import java.util.function.BooleanSupplier;

public class ElementBasicActions {
    private static AppiumDriver driver;
    public static void main(String[] args) throws Exception {
        driver = CreateDriverSession.inicializeDriver("Android");

        By btnViews = AppiumBy.accessibilityId("Views");
        By btnTextFields = AppiumBy.accessibilityId("TextFields");

        By txtUser = AppiumBy.id("io.appium.android.apis:id/edit");
        By txtPassword = AppiumBy.id("io.appium.android.apis:id/edit1");
        By txtFullName = AppiumBy.id("io.appium.android.apis:id/edit2");
        By txtCountry = AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"io.appium.android.apis:id/edit3\").instance(0)");
        By txtEmail = AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"io.appium.android.apis:id/edit3\").instance(1)");

        String user= "Shakespeare";
        String password = "@123456@";
        String confirmPassword = password;
        String fullName = "William Shakespeare";
        String country = "Inglaterra";
        String email = "william.shakespeare@shakespeare.com";

        driver.findElement(btnViews).click();
        performScrolling();
        driver.findElement(btnTextFields).click();

        String titlePage = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Views/TextFields\")"))
                .getAttribute("text");
        Assertions.assertEquals("Views/TextFields", titlePage);

        driver.findElement(txtUser).sendKeys(user);
        driver.findElement(txtPassword).sendKeys(password);
        driver.findElement(txtFullName).sendKeys(fullName);
        driver.findElement(txtCountry).sendKeys(country);
        driver.findElement(txtEmail).sendKeys(email);
        Assertions.assertEquals("Shakespeare", user);
        Assertions.assertEquals("@123456@", password);
        Assertions.assertEquals(confirmPassword, password);
        Assertions.assertEquals("William Shakespeare", fullName);
        Assertions.assertEquals("Inglaterra", country);
        Assertions.assertEquals("william.shakespeare@shakespeare.com", email);

        Thread.sleep(3000);
        driver.findElement(txtUser).clear();
        driver.findElement(txtPassword).clear();
        Assertions.assertNull(null);
        driver.findElement(txtFullName).clear();
        driver.findElement(txtCountry).clear();
        driver.findElement(txtEmail).clear();
        Thread.sleep(3000);
    }
    private static void performScrolling() {
        //scrolling
        WebElement elementScrolling = driver.findElement(AppiumBy.id("android:id/list"));
        driver.executeScript("mobile: swipeGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) elementScrolling).getId(),
                "direction", "up",
                "percent", 0.75
        ));
    }
}
