package ui.factories;

import io.appium.java_client.AppiumDriver;
import lib.Platform;
import ui.OnboardingPage;
import ui.android.AndroidOnboardingPage;
import ui.ios.iOSOnboardingPage;

public class OnboardingPageFactory {

    public static OnboardingPage get(AppiumDriver driver) {
        if (Platform.getInstance().isAndroid()) {
            System.out.println("Creating AndroidOnboardingPageObject");
            return new AndroidOnboardingPage(driver);
        } else {
            System.out.println("Creating IOSOnboardingPageObject");
            return new iOSOnboardingPage(driver);
        }
    }
}
