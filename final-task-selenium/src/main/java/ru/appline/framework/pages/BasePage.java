package ru.appline.framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.appline.framework.managers.DriverManager;
import ru.appline.framework.managers.InitManager;
import ru.appline.framework.managers.PageManager;
import ru.appline.framework.utils.DataWarehousing;

import java.time.Duration;
import java.util.List;

import static org.openqa.selenium.Keys.ENTER;

public class BasePage {

    protected final DriverManager driverManager = DriverManager.getDriverManager();

    protected PageManager pageManager = PageManager.getPageManager();

    protected JavascriptExecutor executor = (JavascriptExecutor) driverManager.getDriver();

    protected WebDriverWait wait = new WebDriverWait(driverManager.getDriver(), Duration.ofSeconds(15), Duration.ofSeconds(1));

    protected DataWarehousing dw = InitManager.getDW();


    public BasePage() {
        PageFactory.initElements(driverManager.getDriver(), this);
    }

    protected WebElement scrollToElementJs(WebElement element) {
        executor.executeScript("arguments[0].scrollIntoView(true);", element);
        return element;
    }

    protected WebElement waitUtilElementToBeClickable(WebElement element) {
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    protected WebElement waitUtilElementToBeVisible(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    protected List<WebElement> waitUtilElementsToBeVisible(List<WebElement> listElements) {
        return wait.until(ExpectedConditions.visibilityOfAllElements(listElements));
    }

    protected WebElement waitUtilElementToBePresence(String xPath) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xPath)));
    }

    protected void fillFiltersBlockInputField(WebElement field, String value) {
        scrollToElementJs(field);
        waitUtilElementToBeClickable(field).clear();
        field.sendKeys(value + Keys.DOWN + ENTER);
        field.sendKeys(ENTER);
    }
}
