import createcapabilitdriversession.CreateDriverSession;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;

public class AndroidFindElements {
    public static void main(String[] args) throws Exception {
        AppiumDriver driver = CreateDriverSession.inicializeDriver("Android");

        WebElement element;

        element = driver.findElement(AppiumBy.accessibilityId("Accessibility"));
        System.out.println("By Accessibility: " + element.getText());

        element = driver.findElement(AppiumBy.id("android:id/text1"));
        System.out.println("By Id (resource-id): " + element.getText());

        element = driver.findElement(AppiumBy.className("android.widget.TextView"));
        System.out.println("By Class: " + element.getText());

        element = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc=\"Accessibility\"]"));
        System.out.println("By XPath: " + element.getText());

        element = driver.findElement(AppiumBy.xpath("//*[@content-desc=\"Accessibility\"]"));
        System.out.println("By Name/XPath (content-desc): " + element.getText());

        boolean elementIsEnabled = driver.findElement(AppiumBy.accessibilityId("Accessibility")).isEnabled();
        System.out.println("By Enabled: " + elementIsEnabled);

        boolean elementIsSelected = driver.findElement(AppiumBy.accessibilityId("Accessibility")).isSelected();
        System.out.println("By Selected: " + elementIsSelected);

        boolean elementIsDisplayed = driver.findElement(AppiumBy.accessibilityId("Accessibility")).isDisplayed();
        System.out.println("By Displayed: " + elementIsDisplayed);
    }
}
