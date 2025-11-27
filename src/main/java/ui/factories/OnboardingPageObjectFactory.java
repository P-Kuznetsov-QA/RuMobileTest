package ui.factories;

import io.appium.java_client.AppiumDriver;
import lib.Platform;
import ui.OnboardingPageObject;
import ui.android.AndroidOnboardingPageObject;
import ui.ios.iOSOnboardingPageObject;

public class OnboardingPageObjectFactory {

    public static OnboardingPageObject get(AppiumDriver driver) {
        if (Platform.getInstance().isAndroid()) {
            System.out.println("Creating AndroidOnboardingPageObject");
            return new AndroidOnboardingPageObject(driver);
        } else {
            System.out.println("Creating IOSOnboardingPageObject");
            return new iOSOnboardingPageObject(driver);
        }
    }
}
