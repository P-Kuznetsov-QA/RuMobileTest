package ui.android;

import io.appium.java_client.AppiumDriver;
import ui.OnboardingPage;

public class AndroidOnboardingPage extends OnboardingPage {
    static {
        SKIP_ONBOARDING_BUTTON = "accessibility id:Пропустить";
        NEXT_ONBOARDING_BUTTON = "accessibility id:Продолжить";
        START_ONBOARDING_BUTTON = "accessibility id:Начать";
        PRIMARY_TEXT_PAGE_1 = "accessibility id:Получение займа до 7 минут на карту";
        PRIMARY_TEXT_PAGE_2 = "accessibility id:Первый заём на карту\nбесплатно";
        PRIMARY_TEXT_PAGE_3 = "accessibility id:Возможность перенести дату возврата займа";
        PRIMARY_TEXT_PAGE_4 = "accessibility id:Быстрое и удобное\nпогашение";
        PRIMARY_TEXT_PAGE_BY_TITLE_TPL = "accessibility id:{TITLE}";
        MAIN_PAGE_TITLE = "accessibility id:Добро пожаловать";
    }

    public AndroidOnboardingPage(AppiumDriver driver) {
        super(driver);
    }
}
