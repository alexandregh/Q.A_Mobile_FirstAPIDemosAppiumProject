import createcapabilitdriversession.CreateDriverSession;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.By;

import java.time.Duration;
import java.util.Map;

public class ImplicitlyWaits {
    private static AppiumDriver driver;
    public static void main(String[] args) throws Exception {
        driver = CreateDriverSession.inicializeDriver("Android");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

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
        driver.findElement(args[3]).click(); // OK

        // Cancel (OK_CANCEL_DIALOG_WITH_A_MESSAGE)
        driver.findElement(args[2]).click(); // OK_CANCEL_DIALOG_WITH_A_MESSAGE
        driver.findElement(args[4]).click(); // Cancel
    }
    public static void triggerAlertDialogOK_CANCEL_DIALOG_WITH_A_LONG_MESSAGE(By @NotNull ... args ) {
        // OK (OK_CANCEL_DIALOG_WITH_A_LONG_MESSAGE)
        driver.findElement(args[0]).click(); // OK_CANCEL_DIALOG_WITH_A_LONG_MESSAGE
        driver.findElement(args[1]).click(); // OK

        // Cancel (OK_CANCEL_DIALOG_WITH_A_LONG_MESSAGE)
        driver.findElement(args[0]).click(); // OK_CANCEL_DIALOG_WITH_A_LONG_MESSAGE
        driver.findElement(args[2]).click(); // Cancel

        // Something (OK_CANCEL_DIALOG_WITH_A_LONG_MESSAGE)
        driver.findElement(args[0]).click(); // OK_CANCEL_DIALOG_WITH_A_LONG_MESSAGE
        driver.findElement(args[3]).click(); // Something
    }
    public static void triggerAlertDialogOK_CANCEL_DIALOG_WITH_ULTRA_LONG_MESSAGE(By @NotNull ... args ) {
        // OK (OK_CANCEL_DIALOG_WITH_ULTRA_LONG_MESSAGE)
        driver.findElement(args[0]).click(); // OK_CANCEL_DIALOG_WITH_ULTRA_LONG_MESSAGE
        driver.findElement(args[1]).click(); // OK

        // Cancel (OK_CANCEL_DIALOG_WITH_ULTRA_LONG_MESSAGE)
        driver.findElement(args[0]).click(); // OK_CANCEL_DIALOG_WITH_ULTRA_LONG_MESSAGE
        driver.findElement(args[2]).click(); // Cancel

        // Something (OK_CANCEL_DIALOG_WITH_ULTRA_LONG_MESSAGE)
        driver.findElement(args[0]).click(); // OK_CANCEL_DIALOG_WITH_ULTRA_LONG_MESSAGE
        driver.findElement(args[3]).click(); // Something
    }
    public static void triggerAlertDialogLIST_DIALOG(By @NotNull ... args) {
        pressButtonReturn();

        // Command_one (LIST_DIALOG)
        driver.findElement(args[5]).click(); // alertDialog
        driver.findElement(args[0]).click(); // LIST_DIALOG
        driver.findElement(args[1]).click(); // Command_one
        pressButtonReturn();

        // Command_tho (LIST_DIALOG)
        driver.findElement(args[0]).click(); // LIST_DIALOG
        driver.findElement(args[2]).click(); // Command_tho
        pressButtonReturn();

        // Command_three (LIST_DIALOG)
        driver.findElement(args[0]).click(); // LIST_DIALOG
        driver.findElement(args[3]).click(); // Command_three
        pressButtonReturn();

        // Command_four (LIST_DIALOG)
        driver.findElement(args[0]).click(); // LIST_DIALOG
        driver.findElement(args[4]).click(); // Command_four
        pressButtonReturn();
    }
    public static void triggerAlertDialogSINGLE_CHOICE_LIST(By @NotNull ... args) {
        // Map
        driver.findElement(args[0]).click(); // SINGLE_CHOICE_LIST
        driver.findElement(args[3]).click(); // Map
        driver.findElement(args[1]).click(); // OK

        // Satellite
        driver.findElement(args[0]).click(); // SINGLE_CHOICE_LIST
        driver.findElement(args[4]).click(); // Satellite
        driver.findElement(args[1]).click(); // OK

        // Traffic
        driver.findElement(args[0]).click(); // SINGLE_CHOICE_LIST
        driver.findElement(args[5]).click(); // Traffic
        driver.findElement(args[1]).click(); // OK

        // StreetView
        driver.findElement(args[0]).click(); // SINGLE_CHOICE_LIST
        driver.findElement(args[6]).click(); // StreetView
        driver.findElement(args[1]).click(); // OK

        // Cancel
        driver.findElement(args[0]).click(); // SINGLE_CHOICE_LIST
        driver.findElement(args[2]).click(); // Cancel
    }
    public static void triggerAlertDialogREPEAT_ALARM(By @NotNull ... args) {
        // Select All Repeat Alarm
        driver.findElement(args[0]).click(); // REPEAT_ALARM
        selectAllRepeatAlarm(args);
        driver.findElement(args[1]).click(); // OK

        // Deselect All Repeat Alarm
        driver.findElement(args[0]).click(); // REPEAT_ALARM
        deselectAllRepeatAlarm(args);
        driver.findElement(args[1]).click(); // OK

        // Cancel Repeat Alarm
        driver.findElement(args[0]).click(); // REPEAT_ALARM
        driver.findElement(args[2]).click(); // Cancel
    }
    public static void triggerAlertDialogOK_CANCEL_DIALOG_WITH_TRADITIONAL_THEME(By @NotNull ... args) {
        driver.findElement(args[0]).click(); // OK_CANCEL_DIALOG_WITH_TRADITIONAL_THEME
        driver.findElement(args[1]).click(); // OK

        driver.findElement(args[0]).click(); // OK_CANCEL_DIALOG_WITH_TRADITIONAL_THEME
        driver.findElement(args[2]).click(); // Cancel
    }
    public static void triggerAlertDialogOK_CANCEL_DIALOG_WITH_HOLO_LIGHT_THEME(By @NotNull ... args) {
        driver.findElement(args[0]).click(); // OK_CANCEL_DIALOG_WITH_HOLO_LIGHT_THEME
        driver.findElement(args[1]).click(); // OK

        driver.findElement(args[0]).click(); // OK_CANCEL_DIALOG_WITH_HOLO_LIGHT_THEME
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
