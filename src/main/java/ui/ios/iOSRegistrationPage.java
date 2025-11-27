package ui.ios;

import io.appium.java_client.AppiumDriver;
import ui.RegistrationPage;

public class iOSRegistrationPage extends RegistrationPage {
    static {
        SUPPORT_BOTTOM_SHEET = "xpath://*[@name=\"Белка Кредит\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeButton[1]";
        TITLE_CONTACT_US = "accessibility id:Свяжись с нами";
        TEXT_SUPPORT_HOURS = "accessibility id:Время работы службы поддержки:\nПн-Пт с 08:00 до 17:00 (по Мск)";
        CALL_US_BUTTON = "accessibility id:Позвонить нам\nБесплатно по России";
        SUPPORT_CHAT_BUTTON = "accessibility id:Чат с поддержкой";
        TITLE_HELP_INFO = "accessibility id:Справочная информация";
        HOW_TO_GET_BUTTON = "accessibility id:Как получить";
        HOW_TO_PAY_OFF = "accessibility id:Как погасить";
        ASKED_QUESTIONS_BUTTON = "accessibility id:Часто задаваемые вопросы";
        CLOSE_SUPPORT_BOTTOM_SHEET = "xpath://XCUIElementTypeButton";
        MENU_BOTTOM_SHEET = "xpath://*[@name=\"Белка Кредит\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeButton[2]";
        CLOSE_MENU_BOTTOM_SHEET = "xpath://XCUIElementTypeButton";
        DOCUMENTS_BOTTOM = "accessibility id:Документы";
        ABOUT_THE_COMPANY_BUTTON = "accessibility id:О компании";
        PSK_TEXT = "accessibility id:Полная стоимость кредита 292,000% годовых.";
        WELCOME_TITLE = "accessibility id:Добро пожаловать";
        LOGIN_OR_REGISTRATION_PROMPT = "accessibility id:Введите номер телефона, чтобы войти или зарегистрироваться";
        SBP_INFO_BANNER = "accessibility id:Для новых клиентов, номер телефона должен быть привязан к СБП для получения займа";
        PHONE_NUMBER_INPUT = "accessibility id:Номер телефона";
        VALIDATION_ERROR_CODE_OPERATOR = "accessibility id:Проверьте код оператора";
        VALIDATION_ERROR_FIELD_LENGTH_BY_TPL = "accessibility id:Неверная длина поля. Вы ввели {LENGTH}/10 символов";
        VALIDATION_ERROR_COMPLETE_FILL = "accessibility id:Заполните поле";
        ENTER_PHONE_NUMBER_BY_TPL = "xpath://*[@value='{PHONE}']";
        VALIDATION_ICON = "xpath://XCUIElementTypeApplication[@name=\"Белка Кредит\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther[3]/XCUIElementTypeOther/XCUIElementTypeImage";
        CONTINUE_BUTTON = "accessibility id:Продолжить";
        PRIVACY_POLICY_LINK = "accessibility id:Политика конфиденциальности обработки персональных данных";
        BACKGROUND_MASK = "accessibility id:Маска";
    }

    public iOSRegistrationPage(AppiumDriver driver) {
        super(driver);
    }
}
