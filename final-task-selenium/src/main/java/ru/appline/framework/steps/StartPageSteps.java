package ru.appline.framework.steps;

import io.cucumber.java.ru.Когда;
import ru.appline.framework.managers.DriverManager;
import ru.appline.framework.managers.PageManager;
import ru.appline.framework.managers.PropertiesManager;

import static ru.appline.framework.utils.constants.PropertiesConstants.BASE_URL;

public class StartPageSteps {

    private final DriverManager driverManager = DriverManager.getDriverManager();

    PageManager pageManager = PageManager.getPageManager();

    @Когда("Открываем стартовую страницу сайта 'Регард'")
    public void openBrowser() {
        driverManager.getDriver().get(PropertiesManager.getPropertyManager().getProperty(BASE_URL));
    }

    @Когда("Нажимаем на кнопку 'Каталог'")
    public void clickCatalogButton() {
        pageManager.getStartPage().clickCatalogButton();
    }
}
