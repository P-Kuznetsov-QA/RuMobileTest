package ui.android;

import io.appium.java_client.AppiumDriver;
import ui.RegistrationPage;

public class AndroidRegistrationPage extends RegistrationPage {
    static {
        SUPPORT_BOTTOM_SHEET = "xpath://android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.widget.ImageView[2]";
        TITLE_CONTACT_US = "accessibility id:Свяжись с нами";
        TEXT_SUPPORT_HOURS = "accessibility id:Время работы службы поддержки:\nПн-Пт с 08:00 до 17:00 (по Мск)";
        CALL_US_BUTTON = "accessibility id:Позвонить нам\nБесплатно по России";
        SUPPORT_CHAT_BUTTON = "accessibility id:Чат с поддержкой";
        TITLE_HELP_INFO = "accessibility id:Справочная информация";
        HOW_TO_GET_BUTTON = "accessibility id:Как получить";
        HOW_TO_PAY_OFF = "accessibility id:Как погасить";
        ASKED_QUESTIONS_BUTTON = "accessibility id:Часто задаваемые вопросы";
        CLOSE_SUPPORT_BOTTOM_SHEET = "xpath://android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.widget.ImageView";
        CLOSE_MENU_BOTTOM_SHEET = "xpath://android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.widget.ImageView";
        MENU_BOTTOM_SHEET = "xpath://android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.widget.ImageView[3]";
        DOCUMENTS_BOTTOM = "accessibility id:Документы";
        ABOUT_THE_COMPANY_BUTTON = "accessibility id:О компании";
        PSK_TEXT = "accessibility id:Полная стоимость кредита 292,000% годовых.";
        WELCOME_TITLE = "accessibility id:Добро пожаловать";
        LOGIN_OR_REGISTRATION_PROMPT = "accessibility id:Введите номер телефона, чтобы войти или зарегистрироваться";
        SBP_INFO_BANNER = "accessibility id:Для новых клиентов, номер телефона должен быть привязан к СБП для получения займа";
        PHONE_NUMBER_INPUT = "xpath://android.widget.EditText";
        VALIDATION_ERROR_CODE_OPERATOR = "accessibility id:Проверьте код оператора";
        VALIDATION_ERROR_FIELD_LENGTH_BY_TPL = "accessibility id:Неверная длина поля. Вы ввели {LENGTH}/10 символов";
        VALIDATION_ERROR_COMPLETE_FILL = "accessibility id:Заполните поле";
        ENTER_PHONE_NUMBER_BY_TPL = "xpath://*[@text='{PHONE}']";
        VALIDATION_ICON = "xpath://*[@content-desc=\"Номер телефона\"]/android.widget.ImageView";
        CONTINUE_BUTTON = "accessibility id:Продолжить";
        PRIVACY_POLICY_LINK = "accessibility id:Политика конфиденциальности обработки персональных данных";
        BACKGROUND_MASK = "accessibility id:Маска";
    }

    public AndroidRegistrationPage(AppiumDriver driver) {
        super(driver);
    }
}
