package basicelements;

import createcapabilitdriversession.CreateDriverSession;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Map;

public class ExplicitlyWaits {
    private static AppiumDriver driver;
    static WebDriverWait wait;
    static By box;
    static String text;
    static String headerTitle;
    static String[] textVector;
    public static void main(String[] args) throws Exception {
        driver = CreateDriverSession.inicializeDriver("Android");

        By app = AppiumBy.accessibilityId("App");
        By alertDialog = AppiumBy.accessibilityId("Alert Dialogs");

        // OK CANCEL DIALOG WITH A MESSAGE
        By OK_CANCEL_DIALOG_WITH_A_MESSAGE = AppiumBy.id("io.appium.android.apis:id/two_buttons");
        By OK = AppiumBy.id("android:id/button1");
        By Cancel = AppiumBy.id("android:id/button2");
        triggerAlertDialogOK_CANCEL_DIALOG_WITH_A_MESSAGE(
                app,
                alertDialog,
                OK_CANCEL_DIALOG_WITH_A_MESSAGE,
                OK,
                Cancel);

        // OK CANCEL DIALOG WITH A LONG MESSAGE
        By OK_CANCEL_DIALOG_WITH_A_LONG_MESSAGE = AppiumBy.id("io.appium.android.apis:id/two_buttons2");
        OK = AppiumBy.id("android:id/button1");
        Cancel = AppiumBy.id("android:id/button2");
        By Something = AppiumBy.id("android:id/button3");
        triggerAlertDialogOK_CANCEL_DIALOG_WITH_A_LONG_MESSAGE(
                OK_CANCEL_DIALOG_WITH_A_LONG_MESSAGE,
                OK,
                Cancel,
                Something);

        // OK CANCEL DIALOG WITH ULTRA LONG MESSAGE
        By OK_CANCEL_DIALOG_WITH_ULTRA_LONG_MESSAGE = AppiumBy.id("io.appium.android.apis:id/two_buttons2ultra");
        OK = AppiumBy.id("android:id/button1");
        Cancel = AppiumBy.id("android:id/button2");
        Something = AppiumBy.id("android:id/button3");
        triggerAlertDialogOK_CANCEL_DIALOG_WITH_ULTRA_LONG_MESSAGE(
                OK_CANCEL_DIALOG_WITH_ULTRA_LONG_MESSAGE,
                OK,
                Cancel,
                Something);

        // LIST DIALOG
        By LIST_DIALOG = AppiumBy.id("io.appium.android.apis:id/select_button");

        By Command_one = AppiumBy.androidUIAutomator("new UiSelector().text(\"Command one\")");
        By Command_two = AppiumBy.androidUIAutomator("new UiSelector().text(\"Command two\")");
        By Command_three = AppiumBy.androidUIAutomator("new UiSelector().text(\"Command three\")");
        By Command_four = AppiumBy.androidUIAutomator("new UiSelector().text(\"Command four\")");
        triggerAlertDialogLIST_DIALOG(
                LIST_DIALOG,
                Command_one,
                Command_two,
                Command_three,
                Command_four,
                alertDialog);

        // SINGLE CHOICE LIST
        By SINGLE_CHOICE_LIST = AppiumBy.id("io.appium.android.apis:id/radio_button");
        OK = AppiumBy.id("android:id/button1");
        Cancel = AppiumBy.id("android:id/button2");
        By Map = AppiumBy.androidUIAutomator("new UiSelector().text(\"Map\")");
        By Satellite = AppiumBy.androidUIAutomator("new UiSelector().text(\"Satellite\")");
        By Traffic = AppiumBy.androidUIAutomator("new UiSelector().text(\"Traffic\")");
        By StreetView = AppiumBy.androidUIAutomator("new UiSelector().text(\"Street view\")");
        triggerAlertDialogSINGLE_CHOICE_LIST(
                SINGLE_CHOICE_LIST,
                OK,
                Cancel,
                Map,
                Satellite,
                Traffic,
                StreetView);

        // REPEAT ALARM
        By REPEAT_ALARM = AppiumBy.id("io.appium.android.apis:id/checkbox_button");
        OK = AppiumBy.id("android:id/button1");
        Cancel = AppiumBy.id("android:id/button2");
        By Every_Monday = AppiumBy.androidUIAutomator("new UiSelector().text(\"Every Monday\")");
        By Every_Tuesday = AppiumBy.androidUIAutomator("new UiSelector().text(\"Every Tuesday\")");
        By Every_Wednesday = AppiumBy.androidUIAutomator("new UiSelector().text(\"Every Wednesday\")");
        By Every_Thursday = AppiumBy.androidUIAutomator("new UiSelector().text(\"Every Thursday\")");
        By Every_Friday = AppiumBy.androidUIAutomator("new UiSelector().text(\"Every Friday\")");
        By Every_Saturday = AppiumBy.androidUIAutomator("new UiSelector().text(\"Every Saturday\")");
        By Every_Sunday = AppiumBy.androidUIAutomator("new UiSelector().text(\"Every Sunday\")");
        triggerAlertDialogREPEAT_ALARM(
                REPEAT_ALARM,
                OK,
                Cancel,
                Every_Monday,
                Every_Tuesday,
                Every_Wednesday,
                Every_Thursday,
                Every_Friday,
                Every_Saturday,
                Every_Sunday);

        // OK CANCEL DIALOG WITH TRADITIONAL THEME
        By OK_CANCEL_DIALOG_WITH_TRADITIONAL_THEME = AppiumBy.id("io.appium.android.apis:id/two_buttons_old_school");
        OK = AppiumBy.id("android:id/button1");
        Cancel = AppiumBy.id("android:id/button2");
        triggerAlertDialogOK_CANCEL_DIALOG_WITH_TRADITIONAL_THEME(
                OK_CANCEL_DIALOG_WITH_TRADITIONAL_THEME,
                OK,
                Cancel);

        // OK CANCEL DIALOG WITH HOLO LIGHT THEME
        By OK_CANCEL_DIALOG_WITH_HOLO_LIGHT_THEME = AppiumBy.id("io.appium.android.apis:id/two_buttons_holo_light");
        OK = AppiumBy.id("android:id/button1");
        Cancel = AppiumBy.id("android:id/button2");
        triggerAlertDialogOK_CANCEL_DIALOG_WITH_HOLO_LIGHT_THEME(
                OK_CANCEL_DIALOG_WITH_HOLO_LIGHT_THEME,
                OK,
                Cancel);

        // PROGRESS_DIALOG
        By PROGRESS_DIALOG = AppiumBy.id("io.appium.android.apis:id/progress_button");
        By Hyde = AppiumBy.id("android:id/button1");
        Cancel = AppiumBy.id("android:id/button2");
        triggerAlertDialogPROGRESS_DIALOG(
                PROGRESS_DIALOG,
                Hyde,
                Cancel);
    }

    public static void triggerAlertDialogOK_CANCEL_DIALOG_WITH_A_MESSAGE(By @NotNull ... args) {
        // OK (OK_CANCEL_DIALOG_WITH_A_MESSAGE)
        driver.findElement(args[0]).click(); // app
        driver.findElement(args[1]).click(); // alertDialog
        driver.findElement(args[2]).click(); // OK_CANCEL_DIALOG_WITH_A_MESSAGE

        // wait explícito
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        box = AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"android:id/parentPanel\")");
        wait.until(ExpectedConditions.visibilityOfElementLocated(box));

        // Assertions
        Assertions.assertNotNull(driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"android:id/icon\")")));
        text = driver.findElement(AppiumBy.className("android.widget.TextView"))
                .getAttribute("text");
        text = text.replace("<", "");
        text = text.replace(">", "");
        textVector = text.split("\\n");
        Assertions.assertEquals("Lorem ipsum dolor sit aie consectetur adipiscing", textVector[0]);
        Assertions.assertEquals("Plloaso mako nuto siwuf cakso dodtos anr koop.", textVector[1]);

        driver.findElement(args[3]).click(); // OK

        // Cancel (OK_CANCEL_DIALOG_WITH_A_MESSAGE)
        driver.findElement(args[2]).click(); // OK_CANCEL_DIALOG_WITH_A_MESSAGE

        // wait explícito
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        box = AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"android:id/parentPanel\")");
        wait.until(ExpectedConditions.visibilityOfElementLocated(box));

        driver.findElement(args[4]).click(); // Cancel
    }
    public static void triggerAlertDialogOK_CANCEL_DIALOG_WITH_A_LONG_MESSAGE(By @NotNull ... args ) {
        // OK (OK_CANCEL_DIALOG_WITH_A_LONG_MESSAGE)
        driver.findElement(args[0]).click(); // OK_CANCEL_DIALOG_WITH_A_LONG_MESSAGE

        // wait explícito
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        box = AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"android:id/parentPanel\")");
        wait.until(ExpectedConditions.visibilityOfElementLocated(box));

        // Assertions
        Assertions.assertNotNull(driver.findElement(AppiumBy.className("android.widget.ImageView")));
        headerTitle = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"android:id/alertTitle\")"))
                .getAttribute("text");
        Assertions.assertEquals("Header title", headerTitle);
        Assertions.assertTrue(driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"android:id/message\")"))
                .isDisplayed());

        driver.findElement(args[1]).click(); // OK

        // Cancel (OK_CANCEL_DIALOG_WITH_A_LONG_MESSAGE)
        driver.findElement(args[0]).click(); // OK_CANCEL_DIALOG_WITH_A_LONG_MESSAGE

        // wait explícito
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        box = AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"android:id/parentPanel\")");
        wait.until(ExpectedConditions.visibilityOfElementLocated(box));

        driver.findElement(args[2]).click(); // Cancel

        // Something (OK_CANCEL_DIALOG_WITH_A_LONG_MESSAGE)
        driver.findElement(args[0]).click(); // OK_CANCEL_DIALOG_WITH_A_LONG_MESSAGE

        // wait explícito
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        box = AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"android:id/parentPanel\")");
        wait.until(ExpectedConditions.visibilityOfElementLocated(box));

        driver.findElement(args[3]).click(); // Something
    }
    public static void triggerAlertDialogOK_CANCEL_DIALOG_WITH_ULTRA_LONG_MESSAGE(By @NotNull ... args ) {
        // OK (OK_CANCEL_DIALOG_WITH_ULTRA_LONG_MESSAGE)
        driver.findElement(args[0]).click(); // OK_CANCEL_DIALOG_WITH_ULTRA_LONG_MESSAGE

        // wait explícito
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        box = AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"android:id/parentPanel\")");
        wait.until(ExpectedConditions.visibilityOfElementLocated(box));

        // Assertions
        Assertions.assertNotNull(driver.findElement(AppiumBy.className("android.widget.ImageView")));
        headerTitle = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"android:id/alertTitle\")"))
                .getAttribute("text");
        Assertions.assertEquals("Header title", headerTitle);
        Assertions.assertTrue(driver.findElement(AppiumBy.id("android:id/message")).isDisplayed());

        driver.findElement(args[1]).click(); // OK

        // Cancel (OK_CANCEL_DIALOG_WITH_ULTRA_LONG_MESSAGE)
        driver.findElement(args[0]).click(); // OK_CANCEL_DIALOG_WITH_ULTRA_LONG_MESSAGE

        // wait explícito
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        box = AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"android:id/parentPanel\")");
        wait.until(ExpectedConditions.visibilityOfElementLocated(box));// wait explícito
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        box = AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"android:id/parentPanel\")");
        wait.until(ExpectedConditions.visibilityOfElementLocated(box));

        driver.findElement(args[2]).click(); // Cancel

        // Something (OK_CANCEL_DIALOG_WITH_ULTRA_LONG_MESSAGE)
        driver.findElement(args[0]).click(); // OK_CANCEL_DIALOG_WITH_ULTRA_LONG_MESSAGE

        // wait explícito
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        box = AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"android:id/parentPanel\")");
        wait.until(ExpectedConditions.visibilityOfElementLocated(box));

        driver.findElement(args[3]).click(); // Something
    }
    public static void triggerAlertDialogLIST_DIALOG(By @NotNull ... args) {
        pressButtonReturn();

        // Command_one (LIST_DIALOG)
        driver.findElement(args[5]).click(); // alertDialog
        driver.findElement(args[0]).click(); // LIST_DIALOG

        // wait explícito
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        box = AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"android:id/parentPanel\")");
        wait.until(ExpectedConditions.visibilityOfElementLocated(box));

        // Assertions
        headerTitle = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"android:id/alertTitle\")"))
                .getAttribute("text");
        Assertions.assertEquals("Header title", headerTitle);
        text = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Command one\")"))
                .getAttribute("text");
        Assertions.assertEquals("Command one", text);
        text = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Command two\")"))
                .getAttribute("text");
        Assertions.assertEquals("Command two", text);
        text = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Command three\")"))
                .getAttribute("text");
        Assertions.assertEquals("Command three", text);
        text = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Command four\")"))
                .getAttribute("text");
        Assertions.assertEquals("Command four", text);

        driver.findElement(args[1]).click(); // Command_one

        // wait explícito
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        box = AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"android:id/parentPanel\")");
        wait.until(ExpectedConditions.visibilityOfElementLocated(box));

        // Assertions
        text = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"android:id/message\")"))
                .getAttribute("text");
        Assertions.assertEquals("You selected: 0 , Command one", text);
        pressButtonReturn();

        // Command_tho (LIST_DIALOG)
        driver.findElement(args[0]).click(); // LIST_DIALOG
        driver.findElement(args[2]).click(); // Command_tho

        // wait explícito
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        box = AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"android:id/parentPanel\")");
        wait.until(ExpectedConditions.visibilityOfElementLocated(box));

        // Assertions
        text = driver.findElement(AppiumBy.className("android.widget.TextView"))
                .getAttribute("text");
        Assertions.assertEquals("You selected: 1 , Command two", text);
        pressButtonReturn();

        // Command_three (LIST_DIALOG)
        driver.findElement(args[0]).click(); // LIST_DIALOG

        // wait explícito
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        box = AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"android:id/parentPanel\")");
        wait.until(ExpectedConditions.visibilityOfElementLocated(box));

        driver.findElement(args[3]).click(); // Command_three

        // wait explícito
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        box = AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"android:id/parentPanel\")");
        wait.until(ExpectedConditions.visibilityOfElementLocated(box));

        // Assertions
        text = driver.findElement(AppiumBy.className("android.widget.TextView"))
                .getAttribute("text");
        Assertions.assertEquals("You selected: 2 , Command three", text);
        pressButtonReturn();

        // Command_four (LIST_DIALOG)
        driver.findElement(args[0]).click(); // LIST_DIALOG

        // wait explícito
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        box = AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"android:id/parentPanel\")");
        wait.until(ExpectedConditions.visibilityOfElementLocated(box));

        driver.findElement(args[4]).click(); // Command_four

        // Assertions
        text = driver.findElement(AppiumBy.className("android.widget.TextView"))
                .getAttribute("text");
        Assertions.assertEquals("You selected: 3 , Command four", text);
        pressButtonReturn();
    }
    public static void triggerAlertDialogSINGLE_CHOICE_LIST(By @NotNull ... args) {
        // Map
        driver.findElement(args[0]).click(); // SINGLE_CHOICE_LIST

        // wait explícito
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        box = AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"android:id/parentPanel\")");
        wait.until(ExpectedConditions.visibilityOfElementLocated(box));

        // Assertions
        Assertions.assertNotNull(driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"android:id/icon\")")));
        headerTitle = driver.findElement(AppiumBy.className("android.widget.TextView"))
                .getAttribute("text");
        Assertions.assertEquals("Single choice list", headerTitle);

        text = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Map\")"))
                .getAttribute("text");
        driver.findElement(args[3]).click(); // Map
        driver.findElement(args[1]).click(); // OK

        // Satellite
        driver.findElement(args[0]).click(); // SINGLE_CHOICE_LIST

        // wait explícito
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        box = AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"android:id/parentPanel\")");
        wait.until(ExpectedConditions.visibilityOfElementLocated(box));

        // Assertions
        text = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Satellite\")"))
                .getAttribute("text");
        driver.findElement(args[4]).click(); // Satellite
        driver.findElement(args[1]).click(); // OK

        // Traffic
        driver.findElement(args[0]).click(); // SINGLE_CHOICE_LIST

        // wait explícito
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        box = AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"android:id/parentPanel\")");
        wait.until(ExpectedConditions.visibilityOfElementLocated(box));

        // Assertions
        text = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Traffic\")"))
                .getAttribute("text");
        driver.findElement(args[5]).click(); // Traffic
        driver.findElement(args[1]).click(); // OK

        // StreetView
        driver.findElement(args[0]).click(); // SINGLE_CHOICE_LIST

        // wait explícito
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        box = AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"android:id/parentPanel\")");
        wait.until(ExpectedConditions.visibilityOfElementLocated(box));

        // Assertions
        text = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Street view\")"))
                .getAttribute("text");
        driver.findElement(args[6]).click(); // StreetView
        driver.findElement(args[1]).click(); // OK

        // Cancel
        driver.findElement(args[0]).click(); // SINGLE_CHOICE_LIST

        // wait explícito
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        box = AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"android:id/parentPanel\")");
        wait.until(ExpectedConditions.visibilityOfElementLocated(box));

        driver.findElement(args[2]).click(); // Cancel
    }
    public static void triggerAlertDialogREPEAT_ALARM(By @NotNull ... args) {
        // Select All Repeat Alarm
        driver.findElement(args[0]).click(); // REPEAT_ALARM

        // wait explícito
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        box = AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"android:id/parentPanel\")");
        wait.until(ExpectedConditions.visibilityOfElementLocated(box));

        // Assertions
        Assertions.assertNotNull(driver.findElement(AppiumBy.className("android.widget.ImageView")));
        headerTitle = driver.findElement(AppiumBy.className("android.widget.TextView"))
                .getAttribute("text");
        Assertions.assertEquals("Repeat alarm", headerTitle);

        // Assertions
        Assertions.assertEquals("Every Monday", driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Every Monday\")"))
                .getAttribute("text"));
        Assertions.assertEquals("Every Tuesday", driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Every Tuesday\")"))
                .getAttribute("text"));
        Assertions.assertEquals("Every Wednesday", driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Every Wednesday\")"))
                .getAttribute("text"));
        Assertions.assertEquals("Every Thursday", driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Every Thursday\")"))
                .getAttribute("text"));
        Assertions.assertEquals("Every Friday", driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Every Friday\")"))
                .getAttribute("text"));
        Assertions.assertEquals("Every Saturday", driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Every Saturday\")"))
                .getAttribute("text"));
        Assertions.assertEquals("Every Sunday", driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Every Sunday\")"))
                .getAttribute("text"));
        selectAllRepeatAlarm(args);

        driver.findElement(args[1]).click(); // OK

        // Deselect All Repeat Alarm
        driver.findElement(args[0]).click(); // REPEAT_ALARM

        // wait explícito
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        box = AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"android:id/parentPanel\")");
        wait.until(ExpectedConditions.visibilityOfElementLocated(box));

        deselectAllRepeatAlarm(args);
        driver.findElement(args[1]).click(); // OK

        // Cancel Repeat Alarm
        driver.findElement(args[0]).click(); // REPEAT_ALARM

        // wait explícito
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        box = AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"android:id/parentPanel\")");
        wait.until(ExpectedConditions.visibilityOfElementLocated(box));

        driver.findElement(args[2]).click(); // Cancel
    }
    public static void triggerAlertDialogOK_CANCEL_DIALOG_WITH_TRADITIONAL_THEME(By @NotNull ... args) {
        driver.findElement(args[0]).click(); // OK_CANCEL_DIALOG_WITH_TRADITIONAL_THEME

        // wait explícito
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        box = AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"android:id/parentPanel\")");
        wait.until(ExpectedConditions.visibilityOfElementLocated(box));

        // Assertions
        Assertions.assertNotNull(driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"android:id/icon\")")));
        text = driver.findElement(AppiumBy.className("android.widget.TextView"))
                .getAttribute("text");
        text = text.replace("<", "");
        text = text.replace(">", "");
        textVector = text.split("\\n");
        Assertions.assertEquals("Lorem ipsum dolor sit aie consectetur adipiscing", textVector[0]);
        Assertions.assertEquals("Plloaso mako nuto siwuf cakso dodtos anr koop.", textVector[1]);

        text = driver.findElement(AppiumBy.id("android:id/button1")).getAttribute("text");
        Assertions.assertEquals("OK", text);
        text = driver.findElement(AppiumBy.id("android:id/button2")).getAttribute("text");
        Assertions.assertEquals("Cancel", text);

        driver.findElement(args[1]).click(); // OK

        driver.findElement(args[0]).click(); // OK_CANCEL_DIALOG_WITH_TRADITIONAL_THEME

        // wait explícito
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        box = AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"android:id/parentPanel\")");
        wait.until(ExpectedConditions.visibilityOfElementLocated(box));

        driver.findElement(args[2]).click(); // Cancel
    }
    public static void triggerAlertDialogOK_CANCEL_DIALOG_WITH_HOLO_LIGHT_THEME(By @NotNull ... args) {
        driver.findElement(args[0]).click(); // OK_CANCEL_DIALOG_WITH_HOLO_LIGHT_THEME

        // wait explícito
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        box = AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"android:id/parentPanel\")");
        wait.until(ExpectedConditions.visibilityOfElementLocated(box));

        // Assertions
        Assertions.assertNotNull(driver.findElement(AppiumBy.id("android:id/icon")));
        text = driver.findElement(AppiumBy.id("android:id/alertTitle"))
                .getAttribute("text");
        text = text.replace("<", "");
        text = text.replace(">", "");
        textVector = text.split("\\n");
        Assertions.assertEquals("Lorem ipsum dolor sit aie consectetur adipiscing", textVector[0]);
        Assertions.assertEquals("Plloaso mako nuto siwuf cakso dodtos anr koop.", textVector[1]);

        text = driver.findElement(AppiumBy.id("android:id/button1")).getAttribute("text");
        Assertions.assertEquals("OK", text);
        text = driver.findElement(AppiumBy.id("android:id/button2")).getAttribute("text");
        Assertions.assertEquals("Cancel", text);

        driver.findElement(args[1]).click(); // OK

        driver.findElement(args[0]).click(); // OK_CANCEL_DIALOG_WITH_HOLO_LIGHT_THEME

        // wait explícito
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        box = AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"android:id/parentPanel\")");
        wait.until(ExpectedConditions.visibilityOfElementLocated(box));

        driver.findElement(args[2]).click(); // Cancel
    }
    public static void triggerAlertDialogPROGRESS_DIALOG(By @NotNull ... args) {
        // Timer (PROGRESS_DIALOG)
        driver.findElement(args[0]).click(); // PROGRESS_DIALOG
    }

    private static void pressButtonReturn() {
        driver.executeScript("mobile: pressKey", Map.ofEntries(Map.entry("keycode", 4)));
    }
    private static void selectAllRepeatAlarm(By @NotNull ... args) {
        // Every Monday
        if(!driver.findElement(args[3]).isSelected()) {
            driver.findElement(args[3]).click();
        }

        // Every Wednesday
        if(!driver.findElement(args[5]).isSelected()) {
            driver.findElement(args[5]).click();
        }

        // Every Friday
        if(!driver.findElement(args[7]).isSelected()) {
            driver.findElement(args[7]).click();
        }

        // Every Saturday
        if(!driver.findElement(args[8]).isSelected()) {
            driver.findElement(args[8]).click();
        }

        // Every Sunday
        if(!driver.findElement(args[9]).isSelected()) {
            driver.findElement(args[9]).click();
        }
    }
    private static void deselectAllRepeatAlarm(By @NotNull ... args) {
        // Every Monday
        if(!driver.findElement(args[3]).isSelected()) {
            driver.findElement(args[3]).click();
        }

        // Every Tuesday
        if(!driver.findElement(args[4]).isSelected()) {
            driver.findElement(args[4]).click();
        }

        // Every Wednesday
        if(!driver.findElement(args[5]).isSelected()) {
            driver.findElement(args[5]).click();
        }

        // Every Thursday
        if(!driver.findElement(args[6]).isSelected()) {
            driver.findElement(args[6]).click();
        }

        // Every Friday
        if(!driver.findElement(args[7]).isSelected()) {
            driver.findElement(args[7]).click();
        }

        // Every Saturday
        if(!driver.findElement(args[8]).isSelected()) {
            driver.findElement(args[8]).click();
        }

        // Every Sunday
        if(!driver.findElement(args[9]).isSelected()) {
            driver.findElement(args[9]).click();
        }
    }
}
