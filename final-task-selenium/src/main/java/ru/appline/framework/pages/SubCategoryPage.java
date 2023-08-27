package ru.appline.framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static ru.appline.framework.utils.constants.CommonXPathConstants.*;
import static ru.appline.framework.utils.constants.CommonXPathConstants.ELEMENT_OF_LIST_PRODUCTS_XPATH;

public class SubCategoryPage extends BasePage {

    @FindBy(xpath = "//a[contains(@class,'CardCategory_wrap')]")
    private List<WebElement> listOfSubCategory;

    @FindBy(xpath = "//div[contains(@class,'Card_wrap')]")
    private List<WebElement> listProducts;


    public SubCategoryPage checkSubCategoryPageOpened(String subCategoryPage) {
        WebElement titleOfSubCategory = driverManager.getDriver().findElement(By.xpath(String.format(TITLE_OF_SUB_CATEGORY_XPATH, subCategoryPage)));
        assertTrue(waitUtilElementToBeVisible(titleOfSubCategory).isDisplayed(), String.format("Страница '%s' открыта", subCategoryPage));
        return this;
    }

    public SubCategoryPage fillFiltersBlockInputField(String field, String value) {
        WebElement element = driverManager.getDriver().findElement(By.xpath(FILTERS_BLOCK_XPATH));
        switch (field) {
            case "Цена от":
                element = element.findElement(By.xpath(String.format(PRICE_INPUT_FIELD_XPATH, "min")));
                break;
            case "Цена до":
                element = element.findElement(By.xpath(String.format(PRICE_INPUT_FIELD_XPATH, "max")));
                break;
            case "Производитель" :
                element = element.findElement(By.xpath(MANUFACTURER_INPUT_FIELD_XPATH));
                break;
            case "Поиск":
                element = driverManager.getDriver().findElement(By.xpath(MAIN_SEARCH_INPUT_STRING_XPATH));
                if (value.equals("сохраненным ранее")) value = dw.getListOfProducts();
                break;
            default:
                fail("Не написан функционал для данного поля: " + field);
        }
        fillFiltersBlockInputField(element, value);
        return this;
    }

    public SubCategoryPage selectSubCategoryFromList(String subCategory) {
//        List<WebElement> elementsList = driverManager.getDriver().findElements(By.xpath(LIST_OF_SUB_CATEGORY_XPATH));
        for (WebElement category : listOfSubCategory) {
//            waitUtilElementToBeClickable(category);
            if (category.getText().contains(subCategory)) {
                category.click();
                return this;
            }
        }
        fail("В списке каталога нет данной категории товаров: " + subCategory);
        return this;
    }

    public SubCategoryPage checkListOfProductsIsReloaded() {
        waitUtilElementToBeVisible(driverManager.getDriver().findElement(By.xpath(QUICK_SELECTION_PANEL_II_NOT_SKELETON_XPATH)));
        return this;
    }

    public SubCategoryPage checkAmountOfProductOnPage(int amundOfProducts) {
        assertEquals(amundOfProducts, listProducts.size());
        return this;
    }

    public SubCategoryPage saveOrCompareTitleOfElement(String actions, String elementNumber) {
        WebElement listOfElements = driverManager.getDriver().findElement(By.xpath(String.format(ELEMENT_OF_LIST_PRODUCTS_XPATH, elementNumber)));
        if (!actions.contains("Сравнить")) {
            dw.setListOfProducts(listOfElements.getAttribute("outerText"));
            return this;
        } else {
            assertEquals(listOfElements.getText(), dw.getListOfProducts());
        }
        return this;
    }
}
