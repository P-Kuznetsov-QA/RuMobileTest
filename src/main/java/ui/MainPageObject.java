package ui;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.qameta.allure.Attachment;
import lib.Platform;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;

public class MainPageObject {

    protected AppiumDriver driver;

    public MainPageObject(AppiumDriver driver) {
        this.driver = driver;
    }


    public WebElement waitForElementForPresent(String locator, String error_message, long timeoutInSeconds) {
        By by = this.getLocatorByString(locator);
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        wait.withMessage(error_message + "\n");
        return wait.until(
                ExpectedConditions.presenceOfElementLocated(by)
        );
    }


    public WebElement waitForElementAndClick(String locator, String error_message, long timeoutInSeconds) {
        WebElement element = waitForElementForPresent(locator, error_message, timeoutInSeconds);
        element.click();
        return element;
    }

    public WebElement waitForElementAndSendKeys(String locator, String value, String error_message, long timeoutInSeconds) {
        WebElement element = waitForElementForPresent(locator, error_message, timeoutInSeconds);
        element.sendKeys(value);
        return element;
    }


    public Boolean waitForElementNotPresent(String locator, String error_message, long timeoutInSeconds) {
        By by = this.getLocatorByString(locator);
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        wait.withMessage(error_message + "\n");
        return wait.until(
                ExpectedConditions.invisibilityOfElementLocated(by)
        );
    }

    public WebElement waitForElementAndClear(String locator, String error_message, long timeoutInSeconds) {
        WebElement element = waitForElementForPresent(locator, error_message, timeoutInSeconds);
        element.clear();
        return element;
    }

    public void assertElementHasText(String locator, String error_element_message, String expected_text) {
        // ждем появление элемента
        WebElement element = waitForElementForPresent(locator, "Cannot find element", 10);
        String actual_text = element.getText();
        Assert.assertEquals(
                error_element_message + " does not have the expected text available", // для удобства можно прописать названия элемента, а ассерт уже в ошибке покажет ожидаемый и фактический результат
                expected_text,
                actual_text
        );
    }

    public void assertElementContainsText(String locator, String error_element_message, String expected_text) {
        // Ждем появление элемента
        WebElement element = waitForElementForPresent(locator, "Cannot find element", 10);
        String actual_text = element.getText();

        Assert.assertTrue(
                error_element_message + " - '" + actual_text + "' - does not contain - " + expected_text, // для удобства можно прописать только начало ошибки
                actual_text.contains(expected_text)
        );
    }

    public void swipe(int startX, int startY, int endX, int endY, int timeOfSecond) {
        PointerInput touchDevice = new PointerInput(PointerInput.Kind.TOUCH, "touchDevice");
        Sequence swipe = new Sequence(touchDevice, 1);

        swipe.addAction(touchDevice.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY));
        swipe.addAction(touchDevice.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        swipe.addAction(touchDevice.createPointerMove(Duration.ofMillis(timeOfSecond), PointerInput.Origin.viewport(), endX, endY));
        swipe.addAction(touchDevice.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(Collections.singletonList(swipe));
    }

    public void swipeDown(int timeOfSecond) {
        Dimension size = driver.manage().window().getSize();
        int startY = (int) (size.height * 0.2);
        int endY = (int) (size.height * 0.8);
        int x = size.width / 2;

        swipe(x, startY, x, endY, timeOfSecond);


    }

    public void swipeUp(int timeOfSecond) {
        Dimension size = driver.manage().window().getSize();
        int startY = (int) (size.height * 0.8);
        int endY = (int) (size.height * 0.2);
        int x = size.width / 2;

        swipe(x, startY, x, endY, timeOfSecond);

    }

    public void swipeLeft(int timeOfSeconds) {
        Dimension size = driver.manage().window().getSize();
        int startX = (int) (size.width * 0.8);
        int endX = (int) (size.width * 0.2);
        int y = size.height / 2;

        swipe(startX, y, endX, y, timeOfSeconds);

    }

    public void swipeRight(int timeOfSeconds) {
        Dimension size = driver.manage().window().getSize();
        int startX = (int) (size.width * 0.2);
        int endX = (int) (size.width * 0.8);
        int y = size.height / 2;

        swipe(startX, y, endX, y, timeOfSeconds);
    }

    public void swipeUpToFindElement(String locator, String error_message, int swipeMax) {
        By by = this.getLocatorByString(locator);
        int already_swipe = 0;
        while (driver.findElements(by).size() == 0) {

            if (already_swipe > swipeMax) {
                waitForElementForPresent(locator, "Cannot find element by swiping up. \n" + error_message, 0);
                return;
            }
            swipeUp(200);
            ++already_swipe;
        }
    }

    public void swipeDownToFindElement(String locator, String error_message, int swipeMax) {
        By by = this.getLocatorByString(locator);
        int already_swipe = 0;
        while (driver.findElements(by).size() == 0) {

            if (already_swipe > swipeMax) {
                waitForElementForPresent(locator, "Cannot find element by swiping up. \n" + error_message, 0);
                return;
            }
            swipeDown(200);
            ++already_swipe;
        }
    }

    public void swipeLeftToFindElement(String locator, String error_message, int swipeMax) {
        By by = this.getLocatorByString(locator);
        int already_swipe = 0;
        while (driver.findElements(by).size() == 0) {

            if (already_swipe > swipeMax) {
                waitForElementForPresent(locator, "Cannot find element by swiping up. \n" + error_message, 0);
                return;
            }
            swipeLeft(200);
            ++already_swipe;
        }
    }

    public void swipeRightToFindElement(String locator, String error_message, int swipeMax) {
        By by = this.getLocatorByString(locator);
        int already_swipe = 0;
        while (driver.findElements(by).size() == 0) {

            if (already_swipe > swipeMax) {
                waitForElementForPresent(locator, "Cannot find element by swiping up. \n" + error_message, 0);
                return;
            }
            swipeRight(200);
            ++already_swipe;
        }
    }

    public void swipeElementToLeft(String locator, String error_message) {
        WebElement element = waitForElementForPresent(
                locator,
                error_message,
                10);

        int leftX = element.getLocation().getX();
        int rightX = leftX + element.getSize().getWidth();
        int upperY = element.getLocation().getY();
        int lowerY = upperY + element.getSize().getHeight();
        int middleY = (upperY + lowerY) / 2;

        // Добавляем отступы от краев для более надежного свайпа, так как срабатывает жест системы
        int startX = rightX + 50;    // Начинаем не с самого края
        int endX = leftX - 20;     // Заканчиваем не у самого края

        swipe(startX, middleY, endX, middleY, 150);

    }

    public void swipeElementToRight(String locator, String error_message) {
        By by = this.getLocatorByString(locator);
        WebElement element = waitForElementForPresent(
                locator,
                error_message,
                10);

        int leftX = element.getLocation().getX(); // крайняя верхняя левая точка
        int rightX = leftX + element.getSize().getWidth(); // крайняя правя точка
        int upperY = element.getLocation().getY();
        int lowerY = upperY + element.getSize().getHeight();
        int middleY = (upperY + lowerY) / 2;

        // Добавляем отступы от краев для более надежного свайпа, так как срабатывает жест системы
        int startX = leftX + 50;    // Начинаем не с самого края
        int endX = rightX - 20;     // Заканчиваем не у самого края

        swipe(startX, middleY, endX, middleY, 150);

    }

    public int getAmountOfElements(String locator) {
        By by = this.getLocatorByString(locator);
        List elements = driver.findElements(by);
        return elements.size();
    }

    public void assertElementNotPresent(String locator, String error_message) {
        int amount_of_elements = getAmountOfElements(locator);
        if (amount_of_elements > 0) {
            String default_message = "An element '" + locator.toString() + "' supposed to be not present";
            throw new AssertionError(default_message + " " + error_message);
        }
    }

    public void assertElementPresent(String locator, String error_message) {
        int amount_of_elements = getAmountOfElements(locator);
        if (amount_of_elements == 0) {
            String default_message = "An element '" + locator.toString() + "' supposed to be present";
            throw new AssertionError(default_message + " " + error_message);
        }
    }

    public String waitForElementAndAttribute(String locator, String attribute, String error_message, long timeOfSeconds) {
        WebElement element = waitForElementForPresent(
                locator,
                error_message,
                timeOfSeconds
        );
        return element.getAttribute(attribute);

    }

    private By getLocatorByString(String locator_with_type) {
        String[] exploded_locator = locator_with_type.split(Pattern.quote(":"), 2);
        String by_type = exploded_locator[0];
        String locator = exploded_locator[1];

        if (by_type.equals("xpath")) {
            return By.xpath(locator);
        } else if (by_type.equals("id")) {
            return By.id(locator);
        } else if (by_type.equals("accessibility id")) {
            return MobileBy.AccessibilityId(locator);
        } else {
            throw new IllegalArgumentException("Cannot get type of locator. Locator " + locator_with_type);
        }

    }

    public String takeScreenshot(String name)
    {
        TakesScreenshot ts = (TakesScreenshot) this.driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        String path = System.getProperty("user.dir") + "/" + name +"_screenshot.png";
        try {
            FileUtils.copyFile(source, new File(path));
            System.out.println("The screenshot was taken :" + path);
        } catch (Exception e){
            System.out.println("Cannot take screenshor. Error: " + e.getMessage());
        }
        return path;
    }

    @Attachment
    public static byte[] screenshot(String path)
    {
        byte[] bytes = new byte[0];

        try {
            bytes = Files.readAllBytes(Paths.get(path));
        }catch (IOException e){
            System.out.println("Cannot get bytes from screenshot. Error " + e.getMessage());
        }
        return bytes;
    }
}
