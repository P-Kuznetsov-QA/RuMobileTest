package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import lib.CoreTestCase;
import org.junit.Test;
import ui.OnboardingPageObject;
import ui.factories.OnboardingPageObjectFactory;
import utils.AppRestartHelper;


public class OnboardingTests extends CoreTestCase {


    @Test
    @DisplayName("Click start button")
    @Description("Check the flow by pressing the buttons sequentially")
    @Step("Starting test testFlowOnboarding")
    public void testFlowOnboarding() {
        OnboardingPageObject onboardingPageObject = OnboardingPageObjectFactory.get(driver);
        onboardingPageObject.waitForFirstScreen();
        onboardingPageObject.clickNextPageOnboarding();
        onboardingPageObject.waitForSecondScreen();
        onboardingPageObject.clickNextPageOnboarding();
        onboardingPageObject.waitForThirdScreen();
        onboardingPageObject.clickNextPageOnboarding();
        onboardingPageObject.waitForFourthScreen();
        onboardingPageObject.clickStartOnboarding();
        onboardingPageObject.waitForMainPage();
    }

    @Test
    @DisplayName("Swipe pages and click start button")
    @Description("Check the flow with scrolling on the start button")
    @Step("Starting test testSwipeOnboarding")
    public void testSwipeOnboarding() {
        OnboardingPageObject onboardingPageObject = OnboardingPageObjectFactory.get(driver);
        onboardingPageObject.waitForFirstScreen();
        onboardingPageObject.swipeLeftToSecondScreen();
        onboardingPageObject.swipeLeftToThirdScreen();
        onboardingPageObject.swipeLeftToFourScreen();
        onboardingPageObject.clickStartOnboarding();
        onboardingPageObject.waitForMainPage();
    }

    @Test
    @DisplayName("Skip button")
    @Description("Checking the flow with the onboarding pass")
    @Step("Starting test testPassOnboarding")
    public void testPassOnboarding() {
        OnboardingPageObject onboardingPageObject = OnboardingPageObjectFactory.get(driver);
        onboardingPageObject.waitForFirstScreen();
        onboardingPageObject.clickSkipOnboarding();
        onboardingPageObject.waitForTitleOnboardingScreenToDisappear("Получение займа до 7 минут на карту");
        onboardingPageObject.waitForMainPage();
    }

    @Test
    @DisplayName("Restart app")
    @Description("")
    @Step("Starting test testRestartApp")
    public void testRestartApp() {
        OnboardingPageObject onboardingPageObject = OnboardingPageObjectFactory.get(driver);
        onboardingPageObject.waitForFirstScreen();
        onboardingPageObject.clickSkipOnboarding();

        AppRestartHelper.restartApp(driver);
        onboardingPageObject.waitForSecondScreen();
        onboardingPageObject.waitForMainPage();
    }
}
