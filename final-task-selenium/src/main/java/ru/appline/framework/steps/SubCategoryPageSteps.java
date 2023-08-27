package ru.appline.framework.steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.ru.Когда;
import ru.appline.framework.managers.PageManager;

public class SubCategoryPageSteps {

    PageManager pageManager = PageManager.getPageManager();

    @Когда("^Выбираем подкатегорию товаров (.*)$")
    public void selectSubCategoryFromMainCategory( String subCategory) {
        pageManager.getSubCategoryPage().selectSubCategoryFromList(subCategory);
    }

    @Когда("Проверить, что открыта страница подкатегории товаров (.*)")
    public void checkSubCategoryPageOpened(String subModulePage) {
        pageManager.getSubCategoryPage().checkSubCategoryPageOpened(subModulePage);
    }

    @Когда("^Заполняем поле (Цена от|Цена до|Производитель|Поиск) значением (.*)$")
    public void fillInputField(String field, String value) {
        pageManager.getSubCategoryPage().fillFiltersBlockInputField(field, value);
    }

    @Когда("Заполняем поля формы:")
    public void fillTravelFields(DataTable mapFieldsAndValue) {
        mapFieldsAndValue.asMap(String.class, String.class).forEach((key, value) ->
                pageManager.getSubCategoryPage().fillFiltersBlockInputField(key, value));
    }

    @Когда("^Проверяем, что список товаров на странице обновился$")
    public void checkProductsListIsReload() {
        pageManager.getSubCategoryPage().checkListOfProductsIsReloaded();
    }

    @Когда("^Проверяем, что на странице отображается (.*) това(?:(ра|р|ров))$")
    public void checkAmountOfProductOnPage(int amundOfProducts, String temp) {
        pageManager.getSubCategoryPage().checkAmountOfProductOnPage(amundOfProducts);
    }

    @Когда("^(Сохранить|Сравнить) название товара под номером (.*) (?:(с сохраненным|во временную переменную))$")
    public void saveTitleOfElement(String actions, String elementNumber, String temp) {
        pageManager.getSubCategoryPage().saveOrCompareTitleOfElement(actions, elementNumber);
    }
}