package ui.factories;

import io.appium.java_client.AppiumDriver;
import lib.Platform;
import ui.RegistrationPage;
import ui.android.AndroidRegistrationPage;
import ui.ios.iOSRegistrationPage;

public class RegistrationPageFactory {
    public static RegistrationPage get(AppiumDriver driver) {
        if (Platform.getInstance().isAndroid()) {
            System.out.println("Creating AndroidRegistrationPageObject");
            return new AndroidRegistrationPage(driver);
        } else {
            System.out.println("Creating iOSRegistrationPageObject");
            return new iOSRegistrationPage(driver);
        }
    }
}
