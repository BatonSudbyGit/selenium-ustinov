package ru.appline.framework.pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.appline.framework.managers.PageManager;
import ru.appline.framework.utils.DateTimeHandler;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import static ru.appline.framework.utils.constants.CommonXPathConstants.CATALOG_BUTTON_XPATH;

public class CatalogPage extends BasePage {

    PageManager pageManager = PageManager.getPageManager();

    @FindBy(xpath = "//div[contains(@class,'Catalog_mainCategoryName')]")
    private List<WebElement> mainCategoryList;

    public CatalogPage checkCatalogPageOpen(String actionPage) {
        DateTimeHandler.waitTimeOutSeconds(1);
        String color = waitUtilElementToBeVisible(driverManager.getDriver().findElement(By.xpath(CATALOG_BUTTON_XPATH)))
                .getCssValue("background-color");
        String colorName;
        switch (actionPage) {
            case "открыта":
                colorName = "белый";
                assertEquals(color, "rgba(255, 255, 255, 1)", "Страница 'Каталог' не открыта. Цвет кнопки: " + colorName);
                return this;
            case "закрыта":
                colorName = "красный";
                assertEquals(color, "rgba(242, 24, 39, 1)", "Страница 'Каталог' не открыта. Цвет кнопки: " + colorName);
                return this;
            default:
                Assertions.fail(String.format("Для данного цвета '%s' не написан функционал", color));
        }
        return this;
    }

    public SubCategoryPage selectCategory(String categoryName) {
        for (WebElement category : mainCategoryList) {
            if (category.getText().equalsIgnoreCase(categoryName)) {
                waitUtilElementToBeClickable(category).click();
                return pageManager.getSubCategoryPage();
            }
        }
        fail("В списке каталога нет данной категории товаров: " + categoryName);
        return pageManager.getSubCategoryPage();
    }
}
