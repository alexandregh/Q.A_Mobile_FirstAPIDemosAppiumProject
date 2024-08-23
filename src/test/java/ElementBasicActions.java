import com.google.common.collect.ImmutableMap;
import createcapabilitdriversession.CreateDriverSession;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

public class ElementBasicActions {
    public static void main(String[] args) throws Exception {
        AppiumDriver driver = CreateDriverSession.inicializeDriver("Android");

        By btnViews = AppiumBy.accessibilityId("Views");
        By btnTextFields = AppiumBy.accessibilityId("TextFields");
        By txtHintText = AppiumBy.id("io.appium.android.apis:id/edit");

        driver.findElement(btnViews).click();

        //scrolling
        WebElement elementScrolling = driver.findElement(AppiumBy.id("android:id/list"));
        driver.executeScript("mobile: swipeGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) elementScrolling).getId(),
                "direction", "up",
                "percent", 0.75
        ));

        driver.findElement(btnTextFields).click();
        driver.findElement(txtHintText).sendKeys("My Text!");
        Thread.sleep(3000);
        driver.findElement(txtHintText).clear();
        Thread.sleep(3000);
    }
}
