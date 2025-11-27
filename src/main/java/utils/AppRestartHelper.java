package utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import lib.Platform;

public class AppRestartHelper {

    public static void restartApp(AppiumDriver driver) {
        if (Platform.getInstance().isIOS()) {
            restartIOSApp((IOSDriver) driver);
        } else {
            restartAndroidApp(driver);
        }
    }

    private static void restartIOSApp(IOSDriver driver) {
        try {
            System.out.println("Restarting iOS app...");
            // Получаем bundleId
            String bundleId = (String) driver.getCapabilities().getCapability("appium:bundleId");
            if (bundleId == null) {
                bundleId = (String) driver.getCapabilities().getCapability("bundleId");
            }

            if (bundleId != null) {
                // Запускаем приложение через background и reset
                driver.runAppInBackground(java.time.Duration.ofSeconds(-1)); // убираем в background
                Thread.sleep(2000);
                driver.terminateApp(bundleId);
                Thread.sleep(3000);
                driver.activateApp(bundleId);
                Thread.sleep(8000);
                System.out.println("Hard iOS restart completed");
            } else {
                System.out.println("Cannot perform hard restart - bundleId not found");
            }
        } catch (Exception e) {
            System.out.println("Error in closeApp/launchApp: " + e.getMessage());
            fallbackRestart(driver);
        }
    }

    private static void restartAndroidApp(AppiumDriver driver) {
        try {
            String appPackage = (String) driver.getCapabilities().getCapability("appPackage");
            driver.terminateApp(appPackage);
            driver.activateApp(appPackage);
            Thread.sleep(5000);
        } catch (Exception e) {
            System.out.println("Error restarting Android app: " + e.getMessage());
        }
    }

    private static void fallbackRestart(AppiumDriver driver) {
        try {
            System.out.println("Using fallback restart method...");
            driver.closeApp();
            Thread.sleep(3000);
            driver.launchApp();
            Thread.sleep(5000);
        } catch (Exception e) {
            System.out.println("Fallback restart also failed: " + e.getMessage());
        }
    }
}
