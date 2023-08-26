package ru.appline.framework.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BusinessTrips extends BasePage {

    @FindBy(xpath = "//a[@title='Создать командировку']")
    private WebElement createBusinessTripButton;

    @Step("Нажимаем на кнопку 'Создать командировку'")
    public CreateBusinessTripPage clickCreateBusinessTripButton() {
        waitUtilElementToBeClickable(createBusinessTripButton).click();
        checkLoadingWindow();
        return pageManager.getCreateBusinessTripPage();
    }
}
