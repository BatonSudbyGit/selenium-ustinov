package ru.appline.framework.managers;

import org.junit.jupiter.api.condition.OS;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static ru.appline.framework.utils.constants.PropertiesConstants.*;

public class DriverManager {

    private WebDriver driver;

    private static DriverManager INSTANCE = null;

    private final PropertiesManager properties = PropertiesManager.getPropertyManager();

    private DriverManager() {
    }

    public static DriverManager getDriverManager() {
        if (INSTANCE == null) {
            INSTANCE = new DriverManager();
        }
        return INSTANCE;
    }

    public WebDriver getDriver() {
        if (driver == null) {
            initDriver();
        }
        return driver;
    }

    public void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

    private String os() {
        return OS.current().name();
    }

    private void initDriver() {
        String osName = OS.current().name();
        System.out.println(osName);
        if (osName.equals("WINDOWS")) {
            System.setProperty("webdriver.chrome.driver", properties.getProperty(PATH_CHROME_DRIVER_WINDOWS));
        } else if (osName.equals("LINUX")){
            System.setProperty("webdriver.chrome.driver", properties.getProperty(PATH_CHROME_DRIVER_LINUX));
        } else {
            System.setProperty("webdriver.chrome.driver", properties.getProperty(PATH_CHROME_DRIVER_MAC));
        }
        driver = new ChromeDriver();
    }
}