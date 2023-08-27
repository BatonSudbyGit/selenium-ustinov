package ru.appline.framework.steps;

import io.cucumber.java.ru.Когда;
import ru.appline.framework.managers.PageManager;

public class CatalogPageSteps {

    PageManager pageManager = PageManager.getPageManager();

    @Когда("^Проверяем, что страница 'Каталог' (открыта|закрыта)$")
    public void checkCatalogPageOpen(String actionPage) {
        pageManager.getCatalogPage().checkCatalogPageOpen(actionPage);
    }

    @Когда("^Выбираем категорию товаров (Комплектующие для ПК|Периферия)$")
    public void selectCategory(String categoryName) {
        pageManager.getCatalogPage().selectCategory(categoryName);
    }
}
