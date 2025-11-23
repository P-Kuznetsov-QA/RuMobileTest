package tests;

import lib.CoreTestCase;
import org.junit.Test;
import ui.OnboardingPageObject;
import ui.RegistrationPageObject;
import ui.factories.OnboardingPageObjectFactory;
import ui.factories.RegistrationPageObjectFactory;
import utils.AppRestartHelper;

public class RegistrationTests extends CoreTestCase {

    @Test
    public void testOpenRegistrationScreen(){
        OnboardingPageObject onboardingPageObject = OnboardingPageObjectFactory.get(driver);
        onboardingPageObject.clickSkipOnboarding();

        RegistrationPageObject registrationPageObject = RegistrationPageObjectFactory.get(driver);
        registrationPageObject.waitTextRegistrationScreen();
    }

    @Test
    public void testOpenSupportModal(){
        AppRestartHelper.restartApp(driver);
        OnboardingPageObject onboardingPageObject = OnboardingPageObjectFactory.get(driver);
        onboardingPageObject.clickSkipOnboarding();
        RegistrationPageObject registrationPageObject = RegistrationPageObjectFactory.get(driver);
        registrationPageObject.openSupportBottomSheet();
        registrationPageObject.checkSupportModal();
    }

    @Test
    public void testCloseSupportModal(){
        OnboardingPageObject onboardingPageObject = OnboardingPageObjectFactory.get(driver);
        onboardingPageObject.clickSkipOnboarding();

        RegistrationPageObject registrationPageObject = RegistrationPageObjectFactory.get(driver);
        registrationPageObject.openSupportBottomSheet();
        registrationPageObject.closeSupportModal();
        registrationPageObject.waitTextRegistrationScreen();
    }

    @Test
    public void testOpenMenuModal(){
        OnboardingPageObject onboardingPageObject = OnboardingPageObjectFactory.get(driver);
        onboardingPageObject.clickSkipOnboarding();

        RegistrationPageObject registrationPageObject = RegistrationPageObjectFactory.get(driver);
        registrationPageObject.openMenuModal();
        registrationPageObject.checkMenuModal();
    }

    @Test
    public void testCloseMenuModal(){
        OnboardingPageObject onboardingPageObject = OnboardingPageObjectFactory.get(driver);
        onboardingPageObject.clickSkipOnboarding();

        RegistrationPageObject registrationPageObject = RegistrationPageObjectFactory.get(driver);
        registrationPageObject.openMenuModal();
        registrationPageObject.closeMenuModal();
        registrationPageObject.waitTextRegistrationScreen();
    }
}
