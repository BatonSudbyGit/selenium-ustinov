package ru.appline.framework.pages.catalog;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.appline.framework.pages.BasePage;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class PcAccessoriesPage  extends BasePage {

//    @FindBy(xpath = "//h1[text()='Комплектующие для ПК']") //Видеокарты
//    private WebElement pcAccessoriesTitle;

//    @FindBy(xpath = "//a[contains(@class,'CardCategory_wrap')]")
//    private List<WebElement> pcAccessoriesList;
//
////    @Step("Проверяем, что страница 'Комплектующие для ПК' открыта")
////    public PcAccessoriesPage checkPcAccessoriesPageOpened() {
////        assertTrue(waitUtilElementToBeVisible(pcAccessoriesTitle).isDisplayed(), "Страница 'Комплектующие для ПК' не открыта");
////        return this;
////    }
//
//    public void selectSubCategoryFromList(String mainCategory, String subCategory) {
//////        checkPcAccessoriesPageOpened();
////        super.selectSubCategoryFromList(mainCategory, subCategory, pcAccessoriesList);
////    }
}
