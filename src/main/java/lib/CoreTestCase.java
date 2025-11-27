package lib;

import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Step;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import utils.IOSPermissionHandler;

import java.io.FileOutputStream;
import java.util.Properties;

public class CoreTestCase extends TestCase {

    protected AppiumDriver driver;
    protected IOSPermissionHandler iosPermissionHandler;


    @Before
    @Step("Run driver and session")
    public void setUp() throws Exception {
        driver = Platform.getInstance().getDriver();
        this.createAllurePropertyFile();
        if (Platform.getInstance().isIOS()) {
            iosPermissionHandler = new IOSPermissionHandler(driver);
            iosPermissionHandler.handleAllPermissionAlerts(3); // пробуем обработать до 3 алертов подряд
        }
    }

    @After
    @Step("Remove driver and session")
    public void tearDown() {
        driver.quit();
    }

    private void createAllurePropertyFile() {
        String path = System.getProperty("allure.results.directory");
        try {
            Properties props = new Properties();
            FileOutputStream fos = new FileOutputStream(path + "/environment.properties");
            props.setProperty("Environment", Platform.getInstance().getPlatformVar());
            props.store(fos, "See https://docs.qameta.io/allure/#_environment");
            fos.close();
        } catch (Exception e) {
            System.out.println("IO problem when writing allure properties file");
            e.printStackTrace();
        }
    }
}
