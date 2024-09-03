package basicelements;

import createcapabilitdriversession.CreateDriverSession;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class AndroidUiAutomator {
    public static void main(String[] args) throws Exception {
        AppiumDriver driver = CreateDriverSession.inicializeDriver("Android");

        WebElement elementByWebElement;
        By elementBy;

        // WebElement
        System.out.println("### By WebElement ###" + "\n");

        elementByWebElement = driver.findElements(AppiumBy.androidUIAutomator("new UiSelector().index(" + 1 + ")")).get(1);
        System.out.println("WebElement - By UIAutomator (index): " + elementByWebElement.getText());

        elementByWebElement = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().packageName(\"io.appium.android.apis\")"));
        System.out.println("WebElement - By UIAutomator (package): " + elementByWebElement.getAttribute("package"));

        elementByWebElement = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.TextView\")"));
        System.out.println("WebElement - By UIAutomator (className): " + elementByWebElement.getAttribute("className"));

        elementByWebElement = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Accessibility\")"));
        System.out.println("WebElement - By UIAutomator (text): " + elementByWebElement.getAttribute("text"));

        elementByWebElement = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().description(\"Accessibility\")"));
        System.out.println("WebElement - By UIAutomator (content-desc): " + elementByWebElement.getAttribute("content-desc"));

        elementByWebElement = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"android:id/text1\")"));
        System.out.println("WebElement - By UIAutomator (resource-id): " + elementByWebElement.getAttribute("resource-id"));

        elementByWebElement = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().checkable(" + false + ")"));
        System.out.println("WebElement - By UIAutomator (checkable): " + elementByWebElement.getAttribute("checkable"));

        elementByWebElement = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().checked(" + false + ")"));
        System.out.println("WebElement - By UIAutomator (checked): " + elementByWebElement.getAttribute("checked"));

        elementByWebElement = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().clickable(" + true + ")"));
        System.out.println("WebElement - By UIAutomator (clickable): " + elementByWebElement.getAttribute("clickable"));

        elementByWebElement = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().enabled(" + true + ")"));
        System.out.println("WebElement - By UIAutomator (enabled): " + elementByWebElement.getAttribute("enabled"));

        elementByWebElement = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().focusable(" + false + ")"));
        System.out.println("WebElement - By UIAutomator (focusable): " + elementByWebElement.getAttribute("focusable"));

        elementByWebElement = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().focused(" + false + ")"));
        System.out.println("WebElement - By UIAutomator (focused): " + elementByWebElement.getAttribute("focused"));

        elementByWebElement = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().scrollable(" + false + ")"));
        System.out.println("WebElement - By UIAutomator (scrollable): " + elementByWebElement.getAttribute("scrollable"));

        elementByWebElement = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().selected(" + false + ")"));
        System.out.println("WebElement - By UIAutomator (selected): " + elementByWebElement.getAttribute("selected"));

        // By
        System.out.println("""

                ### By element (By) ###
                """);

//        elementBy = By.id("Accessibility");
//        System.out.println("By - By.accessibility id: " + driver.findElement(elementBy).getText());

//        elementBy = By.name("Accessibility");
//        System.out.println("By - By.name: " + driver.findElement(elementBy).getText());

        elementBy = By.className("android.widget.TextView");
        System.out.println("By - By.className: " + driver.findElement(elementBy).getText());

        elementBy = By.xpath("//android.widget.TextView[@content-desc=\"Accessibility\"]");
        System.out.println("By - By.xpath: " + driver.findElement(elementBy).getText());
    }
}
