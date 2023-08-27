package ru.appline.framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static ru.appline.framework.utils.constants.CommonXPathConstants.*;

public class SubCategoryPage extends BasePage {

    @FindBy(xpath = "//a[contains(@class,'CardCategory_wrap')]")
    private List<WebElement> listOfSubCategory;

    @FindBy(xpath = "//div[contains(@class,'Card_wrap')]")
    private List<WebElement> listProducts;

    public SubCategoryPage checkSubCategoryPageOpened(String subCategoryPage) {
        checkListOfProductsIsReloaded();
        WebElement titleOfSubCategory = waitUtilElementToBeVisible(driverManager.getDriver()
                .findElement(By.xpath(String.format(TITLE_OF_SUB_CATEGORY_XPATH, subCategoryPage))));
        assertTrue(titleOfSubCategory.isDisplayed(), String.format("Страница '%s' открыта", subCategoryPage));
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
            case "Производитель":
                element = element.findElement(By.xpath(MANUFACTURER_INPUT_FIELD_XPATH));
                break;
            case "Поиск":
                element = driverManager.getDriver().findElement(By.xpath(MAIN_SEARCH_INPUT_STRING_XPATH));
                if (value.equals("сохраненным ранее")) value = dw.getTempValue();
                break;
            default:
                fail("Не написан функционал для данного поля: " + field);
        }
        fillFiltersBlockInputField(element, value);
        return this;
    }

    public SubCategoryPage selectCheckbox(String checkboxName) {
        WebElement filterBlock = driverManager.getDriver().findElement(By.xpath(FILTERS_BLOCK_XPATH));

        filterBlock.findElement(By.xpath(String.format(CHECKBOX_FOR_CLICK_XPATH, checkboxName))).click();

        assertTrue(filterBlock.findElement(By.xpath(String.format(CHECKBOX_FOR_CHECK_XPATH, checkboxName)))
                .getAttribute("class").contains("Checkbox_checked"), String.format("Чекбокс '%s' не выбран", checkboxName));
        return this;
    }

    public SubCategoryPage selectSubCategoryFromList(String subCategory) {
        waitUtilElementsToBeVisible(listOfSubCategory);
        for (WebElement category : listOfSubCategory) {
            waitUtilElementToBeClickable(category);
            if (category.getText().contains(subCategory)) {
                category.click();
                return this;
            }
        }
        fail("В списке каталога нет данной категории товаров: " + subCategory);
        return this;
    }

    public SubCategoryPage checkListOfProductsIsReloaded() {
        waitUtilElementToBePresence(FILTERS_BLOCK_XPATH);
        waitUtilElementToBePresence(COUNT_OF_PRODUCTS_IS_NOT_SKELETON_XPATH);
        return this;
    }

    public SubCategoryPage checkAmountOfProductOnPage(int amundOfProducts) {
        checkListOfProductsIsReloaded();
        assertEquals(amundOfProducts, listProducts.size());
        return this;
    }

    public SubCategoryPage saveOrCompareTitleOfElement(String actions, String elementNumber) {
        WebElement listOfElements = driverManager.getDriver()
                .findElement(By.xpath(String.format(ELEMENT_OF_LIST_PRODUCTS_XPATH, elementNumber)));
        if (!actions.contains("Сравнить")) {
            dw.setTempValue(listOfElements.getAttribute("outerText"));
            return this;
        } else {
            assertEquals(listOfElements.getText(), dw.getTempValue());
        }
        return this;
    }
}
