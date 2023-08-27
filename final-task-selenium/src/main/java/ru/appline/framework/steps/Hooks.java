package ru.appline.framework.steps;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;
import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import ru.appline.framework.managers.DriverManager;
import ru.appline.framework.managers.InitManager;

import java.io.ByteArrayInputStream;

public class Hooks {

    private final DriverManager driverManager = DriverManager.getDriverManager();

    @BeforeAll
    public static void beforeAll() {
        InitManager.initFramework();
    }

    @After
    public void after(Scenario scenario) {
        if (scenario.isFailed()) {
            Allure.addAttachment(scenario.getId(), new ByteArrayInputStream(((TakesScreenshot) driverManager.getDriver())
                    .getScreenshotAs(OutputType.BYTES)));
        }
    }

    @AfterAll
    public static void afterAll() {
        InitManager.quitFramework();
    }
}
