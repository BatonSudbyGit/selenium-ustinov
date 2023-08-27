package ru.appline.framework.pages;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static ru.appline.framework.utils.constants.CommonXPathConstants.CATALOG_BUTTON_XPATH;

public class StartPage extends BasePage {

    @FindBy(xpath = "//div[contains(@class,'swiper swiper-fade swiper-initialized')]")
    private WebElement startPageSwiperSlide;

    @Step("Проверяем, что основная страница открылась")
    public StartPage checkStartPageOpen() {
        Assertions.assertTrue(startPageSwiperSlide.isDisplayed(), "Основная страница не открылась");
        return this;
    }

    public CatalogPage clickCatalogButton() {
        checkStartPageOpen();
        waitUtilElementToBeClickable(driverManager.getDriver().findElement(By.xpath(CATALOG_BUTTON_XPATH))).click();
        return pageManager.getCatalogPage();
    }
}
