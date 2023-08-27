package ru.appline.framework.managers;

import ru.appline.framework.pages.*;

public class PageManager {

    private static PageManager pageManager;


    private StartPage startPage;

    private CatalogPage catalogPage;

    private SubCategoryPage subCategoryPage;

    public static PageManager getPageManager() {
        if (pageManager == null) {
            pageManager = new PageManager();
        }
        return pageManager;
    }

    public SubCategoryPage getSubCategoryPage() {
        if (subCategoryPage == null) {
            subCategoryPage = new SubCategoryPage();
        }
        return subCategoryPage;
    }

    public CatalogPage getCatalogPage() {
        if (catalogPage == null) {
            catalogPage = new CatalogPage();
        }
        return catalogPage;
    }

    public StartPage getStartPage() {
        if (startPage == null) {
            startPage = new StartPage();
        }
        return startPage;
    }
}
