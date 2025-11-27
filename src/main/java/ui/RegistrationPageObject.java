package ui;

import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Step;

public class RegistrationPageObject extends MainPageObject {
    protected static String
            SUPPORT_BOTTOM_SHEET,
            TITLE_CONTACT_US,
            TEXT_SUPPORT_HOURS,
            CALL_US_BUTTON,
            SUPPORT_CHAT_BUTTON,
            TITLE_HELP_INFO,
            HOW_TO_GET_BUTTON,
            HOW_TO_PAY_OFF,
            ASKED_QUESTIONS_BUTTON,
            CLOSE_SUPPORT_BOTTOM_SHEET,
            CLOSE_MENU_BOTTOM_SHEET,
            MENU_BOTTOM_SHEET,
            DOCUMENTS_BOTTOM,
            ABOUT_THE_COMPANY_BUTTON,
            PSK_TEXT,
            WELCOME_TITLE,
            LOGIN_OR_REGISTRATION_PROMPT,
            SBP_INFO_BANNER,
            PHONE_NUMBER_INPUT,
            VALIDATION_ERROR_CODE_OPERATOR,
            VALIDATION_ERROR_FIELD_LENGTH_BY_TPL,
            VALIDATION_ERROR_COMPLETE_FILL,
            ENTER_PHONE_NUMBER_BY_TPL,
            VALIDATION_ICON,
            CONTINUE_BUTTON,
            PRIVACY_POLICY_LINK,
            BACKGROUND_MASK;


    public RegistrationPageObject(AppiumDriver driver) {
        super(driver);
    }

    /* TEMPLATES METHODS */
    private static String getErrorMessageLength(String length) {
        return VALIDATION_ERROR_FIELD_LENGTH_BY_TPL.replace("{LENGTH}", length);
    }

    private static String getResultEnteringPhoneNumber(String phone_number) {
        return ENTER_PHONE_NUMBER_BY_TPL.replace("{PHONE}", phone_number);
    }
    /* TEMPLATES METHODS */

    @Step("Waiting for the text of the Registration screen")
    public void waitTextRegistrationScreen() {
        this.waitForElementForPresent(PSK_TEXT, "Cannot find text 'PSK' " + PSK_TEXT, 5);
        this.waitForElementForPresent(WELCOME_TITLE, "Cannot find text 'Welcome Title' " + WELCOME_TITLE, 5);
        this.waitForElementForPresent(LOGIN_OR_REGISTRATION_PROMPT, "Cannot find text 'Login or Registration promt' " + LOGIN_OR_REGISTRATION_PROMPT, 5);
    }

    @Step("Opening the Support modal")
    public void openSupportBottomSheet() {
        this.waitForElementAndClick(SUPPORT_BOTTOM_SHEET, "Cannot find and click open Support modal button", 5);
    }

    @Step("Checking text the Support modal")
    public void checkSupportModal() {
        this.waitForElementForPresent(TITLE_CONTACT_US, "Cannot find text title 'contact us' :" + TITLE_CONTACT_US, 5);
        this.waitForElementForPresent(TEXT_SUPPORT_HOURS, "Cannot find text 'support hours work' :" + TEXT_SUPPORT_HOURS, 5);
        this.waitForElementForPresent(CALL_US_BUTTON, "Cannot find 'Call us' button :" + CALL_US_BUTTON, 5);
        this.waitForElementForPresent(SUPPORT_CHAT_BUTTON, "Cannot find 'Support chat' button: " + SUPPORT_CHAT_BUTTON, 5);
        this.waitForElementForPresent(TITLE_HELP_INFO, "Cannot find text title 'help information' :" + TITLE_HELP_INFO, 5);
        this.waitForElementForPresent(HOW_TO_GET_BUTTON, "Cannot find  button 'How to get' " + HOW_TO_GET_BUTTON, 5);
        this.waitForElementForPresent(HOW_TO_PAY_OFF, "Cannot find button 'How to pay off' :" + HOW_TO_PAY_OFF, 5);
        this.waitForElementForPresent(ASKED_QUESTIONS_BUTTON, "Cannot find button 'Frequently asked questions' :" + ASKED_QUESTIONS_BUTTON, 5);
    }

    @Step("Closing the Support modal")
    public void closeSupportModal() {
        this.waitForElementAndClick(CLOSE_SUPPORT_BOTTOM_SHEET, "Cannot find and click close bottom sheet", 5);
    }

    @Step("Opening the Menu modal")
    public void openMenuModal() {
        this.waitForElementAndClick(MENU_BOTTOM_SHEET, "Cannot find and click open Menu modal button", 5);
    }

    @Step("Checking text the Menu modal")
    public void checkMenuModal() {
        this.waitForElementForPresent(DOCUMENTS_BOTTOM, "Cannot find 'Documents' button", 5);
        this.waitForElementForPresent(ABOUT_THE_COMPANY_BUTTON, "Cannot find 'About the company' button", 5);
    }

    @Step("Closing the Menu modal")
    public void closeMenuModal() {
        this.waitForElementAndClick(CLOSE_MENU_BOTTOM_SHEET, "Cannot find and click close bottom sheet", 5);
    }
}
