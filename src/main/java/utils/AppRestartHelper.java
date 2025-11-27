package utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.appmanagement.ApplicationState;
import io.appium.java_client.ios.IOSDriver;
import lib.Platform;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AppRestartHelper {

    private static final int DEFAULT_WAIT_SECONDS = 10;
    private static final int SHORT_WAIT_SECONDS = 3;

    public static void restartApp(AppiumDriver driver) {
        if (Platform.getInstance().isIOS()) {
            restartIOSApp((IOSDriver) driver);
        } else {
            restartAndroidApp(driver);
        }

        // Ждем пока приложение полностью запустится
        waitForAppToBecomeActive(driver);
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
                driver.runAppInBackground(Duration.ofMillis(100)); // убираем в background
                // Ждем пока приложение уйдет в background
                waitForAppToGoToBackground(driver, bundleId);
                driver.terminateApp(bundleId);
                // Ждем пока приложение завершится
                waitForAppToTerminate(driver, bundleId);
                driver.activateApp(bundleId);
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
            System.out.println("Fallback restart failed: " + e.getMessage());
            throw new RuntimeException("All restart methods failed", e);
        }
    }

    private static void waitForAppToGoToBackground(AppiumDriver driver, String appId) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, SHORT_WAIT_SECONDS);
            wait.until(d -> !driver.queryAppState(appId).equals(ApplicationState.RUNNING_IN_FOREGROUND));
        } catch (Exception e) {
            System.out.println("App might not be in background: " + e.getMessage());
        }
    }

    private static void waitForAppToTerminate(AppiumDriver driver, String appId) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, SHORT_WAIT_SECONDS);
            if (appId != null) {
                wait.until(d -> driver.queryAppState(appId).equals(ApplicationState.NOT_RUNNING));
            } else {
                Thread.sleep(2000);  // Только как крайняя мера
            }
        } catch (Exception e) {
            System.out.println("Timeout waiting for app to terminate: " + e.getMessage());
        }
    }

    private static void waitForAppToBecomeActive(AppiumDriver driver) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, DEFAULT_WAIT_SECONDS);
            wait.until(ExpectedConditions.jsReturnsValue("return document.readyState === 'complete'"));
        } catch (Exception e) {
            System.out.println("App might not be fully active: " + e.getMessage());
            try {
                Thread.sleep(3000);  // Fallback
            } catch (InterruptedException ie) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
