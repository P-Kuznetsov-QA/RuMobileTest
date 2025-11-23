package ui.factories;

import io.appium.java_client.AppiumDriver;
import lib.Platform;
import ui.RegistrationPageObject;
import ui.android.AndroidRegistrationPageObject;
import ui.ios.iOSRegistrationPageObject;

public class RegistrationPageObjectFactory {
    public static RegistrationPageObject get(AppiumDriver driver) {
        if (Platform.getInstance().isAndroid()) {
            System.out.println("Creating AndroidRegistrationPageObject");
            return new AndroidRegistrationPageObject(driver);
        } else {
            System.out.println("Creating iOSRegistrationPageObject");
            return new iOSRegistrationPageObject(driver);
        }
    }
}
