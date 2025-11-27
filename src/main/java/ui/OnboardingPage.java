package ui;

import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Step;

public class OnboardingPage extends BasePage {

    protected static String
            SKIP_ONBOARDING_BUTTON,
            NEXT_ONBOARDING_BUTTON,
            START_ONBOARDING_BUTTON,
            PRIMARY_TEXT_PAGE_1,
            PRIMARY_TEXT_PAGE_2,
            PRIMARY_TEXT_PAGE_3,
            PRIMARY_TEXT_PAGE_4,
            PRIMARY_TEXT_PAGE_BY_TITLE_TPL,
            MAIN_PAGE_TITLE;


    public OnboardingPage(AppiumDriver driver) {
        super(driver);
    }

    /* TEMPLATES METHODS */
    private static String getTitleOnboardingPage(String title) {
        return PRIMARY_TEXT_PAGE_BY_TITLE_TPL.replace("{TITLE}", title);
    }
    /* TEMPLATES METHODS */

    @Step("Waiting for 1 onboarding screen")
    public void waitForFirstScreen() {
        this.waitForElementForPresent(PRIMARY_TEXT_PAGE_1, "Cannot find primary text 1 page onboarding", 20);
    }

    @Step("Waiting for 2 onboarding screen")
    public void waitForSecondScreen() {
        this.waitForElementForPresent(PRIMARY_TEXT_PAGE_2, "Cannot find primary text 2 page onboarding", 5);
    }

    @Step("Waiting for 3 onboarding screen")
    public void waitForThirdScreen() {
        this.waitForElementForPresent(PRIMARY_TEXT_PAGE_3, "Cannot find primary text 3 page onboarding", 5);
    }

    @Step("Waiting for 4 onboarding screen")
    public void waitForFourthScreen() {
        this.waitForElementForPresent(PRIMARY_TEXT_PAGE_4, "Cannot find primary text 4 page onboarding", 5);
    }

    @Step("Waiting for the onboarding screen with the '{title}'")
    public void waitForTitleOnboardingScreen(String title) {
        String title_screen_tpl = getTitleOnboardingPage(title);
        this.waitForElementForPresent(title_screen_tpl, "Cannot find title onboarding screen " + title_screen_tpl, 5);
    }

    @Step("Waiting for the onboarding screen with the '{title}' is not displayed")
    public void waitForTitleOnboardingScreenToDisappear(String title) {
        String title_screen_tpl = getTitleOnboardingPage(title);
        this.waitForElementNotPresent(title_screen_tpl, "Onboarding screen still present " + title_screen_tpl, 10);
    }

    public void waitForMainPage() {
        screenshot(this.takeScreenshot("onboarding_page"));
        this.waitForElementForPresent(MAIN_PAGE_TITLE, "Main Page is not present", 10);
    }

    @Step("Click on the skip button")
    public void clickSkipOnboarding() {
        this.waitForElementAndClick(SKIP_ONBOARDING_BUTTON, "Cannot find and click skip onboarding element " + SKIP_ONBOARDING_BUTTON, 5);
    }

    @Step("Click on the next button")
    public void clickNextPageOnboarding() {
        this.waitForElementAndClick(NEXT_ONBOARDING_BUTTON, "Cannot find and click next onboarding element " + NEXT_ONBOARDING_BUTTON, 5);
    }

    @Step("Click on the start button")
    public void clickStartOnboarding() {
        this.waitForElementAndClick(START_ONBOARDING_BUTTON, "Cannot find and click start Onboarding " + START_ONBOARDING_BUTTON, 5);
    }

    @Step("Scroll left the page to 2 screens")
    public void swipeLeftToSecondScreen() {
        this.swipeLeftToFindElement(PRIMARY_TEXT_PAGE_2, "Cannot find primary text 2 page after swiping to the left", 1);
    }

    @Step("Scroll left the page to 3 screens")
    public void swipeLeftToThirdScreen() {
        this.swipeLeftToFindElement(PRIMARY_TEXT_PAGE_3, "Cannot find primary text 3 page after swiping to the left", 1);
    }

    @Step("Scroll left the page to 4 screens")
    public void swipeLeftToFourScreen() {
        this.swipeLeftToFindElement(PRIMARY_TEXT_PAGE_4, "Cannot find primary text 4 page after swiping to the left", 1);
    }

    @Step("Scroll left the page to screens with the '{title}'")
    public void swipeLeftToPrimaryPageByTitle(String title) {
        String title_page_xpath = getTitleOnboardingPage(title);
        this.swipeLeftToFindElement(title_page_xpath, "Cannot find primary text page", 2);
    }

    @Step("Scroll right the page to 1 screens")
    public void swipeRightToFirstScreen() {
        this.swipeRightToFindElement(PRIMARY_TEXT_PAGE_1, "Cannot find primary text 1 page after swiping to the right", 2);
    }

    @Step("Scroll right the page to 2 screens")
    public void swipeRightToSecondScreen() {
        this.swipeRightToFindElement(PRIMARY_TEXT_PAGE_2, "Cannot find primary text 1 page", 2);
    }

    @Step("Scroll right the page to 3 screens")
    public void swipeRightToThirdScreen() {
        this.swipeRightToFindElement(PRIMARY_TEXT_PAGE_3, "Cannot find primary text 1 page", 2);
    }

    @Step("Scroll right the page to screens with the '{title}'")
    public void swipeRightPrimaryPage(String title) {
        String title_page_xpath = getTitleOnboardingPage(title);
        this.swipeRightToFindElement(title_page_xpath, "Cannot find primary text page", 2);
    }
}
