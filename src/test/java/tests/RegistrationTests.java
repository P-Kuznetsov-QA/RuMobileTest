package tests;

import lib.CoreTestCase;
import org.junit.Test;
import ui.OnboardingPage;
import ui.RegistrationPage;
import ui.factories.OnboardingPageFactory;
import ui.factories.RegistrationPageFactory;
import utils.AppRestartHelper;

public class RegistrationTests extends CoreTestCase {
    @Test
    public void testOpenRegistrationScreen() {
        OnboardingPage onboardingPageObject = OnboardingPageFactory.get(driver);
        onboardingPageObject.clickSkipOnboarding();
        RegistrationPage registrationPageObject = RegistrationPageFactory.get(driver);
        registrationPageObject.waitTextRegistrationScreen();
    }

    @Test
    public void testOpenSupportModal() {
        AppRestartHelper.restartApp(driver);
        OnboardingPage onboardingPageObject = OnboardingPageFactory.get(driver);
        onboardingPageObject.clickSkipOnboarding();
        RegistrationPage registrationPageObject = RegistrationPageFactory.get(driver);
        registrationPageObject.openSupportBottomSheet();
        registrationPageObject.checkSupportModal();
    }

    @Test
    public void testCloseSupportModal() {
        OnboardingPage onboardingPageObject = OnboardingPageFactory.get(driver);
        onboardingPageObject.clickSkipOnboarding();
        RegistrationPage registrationPageObject = RegistrationPageFactory.get(driver);
        registrationPageObject.openSupportBottomSheet();
        registrationPageObject.closeSupportModal();
        registrationPageObject.waitTextRegistrationScreen();
    }

    @Test
    public void testOpenMenuModal() {
        OnboardingPage onboardingPageObject = OnboardingPageFactory.get(driver);
        onboardingPageObject.clickSkipOnboarding();
        RegistrationPage registrationPageObject = RegistrationPageFactory.get(driver);
        registrationPageObject.openMenuModal();
        registrationPageObject.checkMenuModal();
    }

    @Test
    public void testCloseMenuModal() {
        OnboardingPage onboardingPageObject = OnboardingPageFactory.get(driver);
        onboardingPageObject.clickSkipOnboarding();
        RegistrationPage registrationPageObject = RegistrationPageFactory.get(driver);
        registrationPageObject.openMenuModal();
        registrationPageObject.closeMenuModal();
        registrationPageObject.waitTextRegistrationScreen();
    }
}
