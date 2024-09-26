package androiddrivercommands;

import createcapabilitdriversession.CreateDriverSession;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.junit.jupiter.api.Assertions;

import java.time.Duration;

public class AndLockAndUnlockDevices {
    static boolean result;
    public static void main(String[] args) throws Exception {
        AppiumDriver driver = CreateDriverSession.inicializeDriver("Android");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //lockDeviceScreenByTimeDefined(driver);
        //lockDeviceScreenByTimeIndefinite(driver);
        //unlockDeviceScreenByTimeIndefinite(driver);
        //lockDeviceScreenByPIN(driver);
        //lockDeviceScreenByPattern(driver);
    }
    public static void lockDeviceScreenByTimeDefined(AppiumDriver driver) {
        System.out.println("*** Method: lockDeviceScreenByTimeDefined ***");

        Assertions.assertTrue(true, String.valueOf(checkLockedDevice(driver)));
        result = checkLockedDevice(driver);
        System.out.println(result);

        ((AndroidDriver) driver).lockDevice(Duration.ofSeconds(5));
        result = checkLockedDevice(driver);
        System.out.println(result);

        Assertions.assertTrue(true, String.valueOf(checkLockedDevice(driver)));
        result = checkLockedDevice(driver);
        System.out.println(result);
    }
    public static void lockDeviceScreenByTimeIndefinite(AppiumDriver driver) {
        System.out.println("*** Method: lockDeviceScreenByTimeIndefinite ***");
        Assertions.assertTrue(true, String.valueOf(checkLockedDevice(driver)));
        result = checkLockedDevice(driver);
        System.out.println(result);

        ((AndroidDriver) driver).lockDevice();

        Assertions.assertFalse(false, String.valueOf(checkLockedDevice(driver)));
        result = checkLockedDevice(driver);
        System.out.println(result);
    }
    public static void unlockDeviceScreenByTimeIndefinite(AppiumDriver driver) {
        System.out.println("*** Method: unlockDeviceScreenByTimeIndefinite ***");
        Assertions.assertFalse(false, String.valueOf(checkLockedDevice(driver)));
        result = checkLockedDevice(driver);
        System.out.println(result);

        ((AndroidDriver) driver).unlockDevice();

        Assertions.assertTrue(true, String.valueOf(checkLockedDevice(driver)));
        result = checkLockedDevice(driver);
        System.out.println(result);
    }
    public static boolean checkLockedDevice(AppiumDriver driver) {
        return ((AndroidDriver) driver).isDeviceLocked();
    }
    public static void lockDeviceScreenByPIN(AppiumDriver driver) throws InterruptedException {
        ((AndroidDriver) driver).lockDevice();
        Assertions.assertTrue(true, String.valueOf(checkLockedDevice(driver)));
        System.out.println(((AndroidDriver) driver).isDeviceLocked());
        ((AndroidDriver) driver).unlockDevice();
    }
    public static void lockDeviceScreenByPattern(AppiumDriver driver) {
        ((AndroidDriver) driver).lockDevice();
        Assertions.assertTrue(true, String.valueOf(checkLockedDevice(driver)));
        System.out.println(((AndroidDriver) driver).isDeviceLocked());
        ((AndroidDriver) driver).unlockDevice();
        Assertions.assertFalse(false, String.valueOf(checkLockedDevice(driver)));
        System.out.println(((AndroidDriver) driver).isDeviceLocked());
    }
}
