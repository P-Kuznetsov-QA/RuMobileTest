package utils;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.Alert;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.*;

public class IOSPermissionHandler {

    private final AppiumDriver driver;

    public IOSPermissionHandler(AppiumDriver driver) {
        this.driver = driver;
    }

    /**
     * Обрабатывает все последовательные алерты с разрешениями (до maxAlerts).
     */
    public void handleAllPermissionAlerts(int maxAlerts) {
        for (int i = 0; i < maxAlerts; i++) {
            try {
                WebDriverWait wait = new WebDriverWait(driver, 6);
                wait.until(ExpectedConditions.alertIsPresent());

                Alert alert = driver.switchTo().alert();
                String alertText = alert.getText();
                Object rawButtons = driver.executeScript("mobile: alert", Collections.singletonMap("action", "getButtons"));

                List<String> buttons = normalizeButtons(rawButtons);

                System.out.println("=== Permission alert found ===");
                System.out.println("Alert text: " + alertText);
                System.out.println("Buttons raw: " + rawButtons);
                System.out.println("Buttons normalized: " + buttons);

                String toClick = decideButtonToClick(alertText, buttons);

                if (toClick == null) {
                    // fallback: если ничего не подошло — попробуем нажать первую доступную кнопку, либо "Разрешить"
                    if (!buttons.isEmpty()) {
                        toClick = buttons.get(0);
                    } else {
                        toClick = "Разрешить";
                    }
                }

                Map<String, Object> args = new HashMap<>();
                args.put("action", "accept");
                args.put("buttonLabel", toClick);

                driver.executeScript("mobile: alert", args);

                System.out.println("Clicked button: " + toClick);

                // небольшая пауза, чтобы следующий алерт успел появиться
                Thread.sleep(1000);
            } catch (TimeoutException te) {
                // больше алертов нет — выходим
                System.out.println("No more permission alerts.");
                break;
            } catch (InterruptedException ie) {
                Thread.currentThread().interrupt();
                break;
            } catch (Exception e) {
                e.printStackTrace();
                break;
            }
        }
    }

    private List<String> normalizeButtons(Object rawButtons) {
        List<String> buttons = new ArrayList<>();
        if (rawButtons == null) return buttons;

        if (rawButtons instanceof List) {
            for (Object o : (List) rawButtons) {
                buttons.add(String.valueOf(o));
            }
        } else {
            // иногда возвращается строка или другой тип
            buttons.add(String.valueOf(rawButtons));
        }
        // trim all and remove empty
        List<String> cleaned = new ArrayList<>();
        for (String b : buttons) {
            if (b != null) {
                String t = b.trim();
                if (!t.isEmpty()) cleaned.add(t);
            }
        }
        return cleaned;
    }

    /**
     * Решаем, какую кнопку нажать. Смотрим и на текст алерта, и на реальные доступные кнопки.
     */
    private String decideButtonToClick(String alertText, List<String> availableButtons) {
        // варианты русских (и некоторые англ.) меток для геолокации, уведомлений и т.п.
        List<String> locationCandidates = Arrays.asList("Разрешить при использовании приложения", "При использовании приложения", "При использовании", "Разрешить в любое время", "Всегда", "Разрешить всегда", "Разрешить при использовании");

        List<String> notificationsCandidates = Arrays.asList("Разрешить", "Разрешить отправлять уведомления", "Разрешать уведомления");

        List<String> denyCandidates = Arrays.asList("Не разрешать", "Запретить", "Отклонить", "Не сейчас", "Не разрешать");

        List<String> okCandidates = Arrays.asList("OK", "Хорошо", "Понятно");

        // 1) Если в тексте алерта есть ключевые слова — попробуем соответствующие наборы
        String lc = (alertText == null) ? "" : alertText.toLowerCase();

        if (lc.contains("местополож") || lc.contains("геопозици") || lc.contains("определять ваше местополож")) {
            String found = findFirstPresent(locationCandidates, availableButtons);
            if (found != null) return found;
        } else if (lc.contains("уведомлен") || lc.contains("уведомления")) {
            String found = findFirstPresent(notificationsCandidates, availableButtons);
            if (found != null) return found;
        } else if (lc.contains("камера") || lc.contains("фото") || lc.contains("микрофон")) {
            String found = findFirstPresent(okCandidates, availableButtons);
            if (found != null) return found;
        }

        // 2) Если не определили по тексту — попробуем общие эвристики: предпочесть "Разрешить" и аналоги
        String found = findFirstPresent(concatLists(notificationsCandidates, locationCandidates, okCandidates), availableButtons);
        if (found != null) return found;

        // 3) Если кнопок нет либо ничего не подошло — вернем null (caller возьмет fallback)
        return null;
    }

    private String findFirstPresent(List<String> candidates, List<String> available) {
        if (available == null || available.isEmpty()) return null;
        for (String cand : candidates) {
            for (String avail : available) {
                if (avail.equalsIgnoreCase(cand)) return avail;
                // нормализованный contains — на случай обрезанной строки (e.g. "При использовании")
                if (avail.toLowerCase().contains(cand.toLowerCase())) return avail;
                if (cand.toLowerCase().contains(avail.toLowerCase())) return avail;
            }
        }
        return null;
    }

    private List<String> concatLists(List<String>... lists) {
        List<String> res = new ArrayList<>();
        for (List<String> l : lists) res.addAll(l);
        return res;
    }
}
