package ru.appline.framework.managers;

import ru.appline.framework.managers.blocks.PcAccessoriesPageBlockManager;
import ru.appline.framework.managers.blocks.PeripheryPageBlock;
import ru.appline.framework.pages.*;
import ru.appline.framework.pages.catalog.PcAccessoriesPage;
import ru.appline.framework.pages.catalog.PeripheryPage;

import static org.junit.jupiter.api.Assertions.fail;

public class PageManager {

    private static PageManager pageManager;


    private StartPage startPage;

    private CatalogPage catalogPage;

    private SubCategoryPage subCategoryPage;

//    /**
//     * Классы блока 'Каталог'
//     */
//    private PcAccessoriesPage pcAccessoriesPage;
//
//    private PeripheryPage peripheryPage;
//
//    /**
//     * Блоки. Классы подмодулей каталога
//     */
//    private PcAccessoriesPageBlockManager pcAccessoriesPageBlockManager;
//    private PeripheryPageBlock peripheryPageBlock;

    public static PageManager getPageManager() {
        if (pageManager == null) {
            pageManager = new PageManager();
        }
        return pageManager;
    }

//    public Class<?> getClassMainCategory(String category) {
//        switch (category) {
//            case "Комплектующие для ПК":
//                getPcAccessoriesPage();
//                break;
//            case "Периферия":
//                getPeripheryPage();
//                break;
//            default:
//                fail("Передан класс, которого нет в списке: " + category);
//        }
//        return this.getClass();
//    }

//    public Class<?> getClassSubMainCategory(String mainCategory, String subCategory) {
//        switch (mainCategory) {
//            case "Комплектующие для ПК":
//                getPcAccessoriesPageBlockManager().getClassSubCategoryOfPcAccessories(subCategory);
//                break;
//            case "Периферия":
//                getPeripheryPageBlock().getClassSubCategoryOfPeriphery(subCategory);
//                break;
//            default:
//                fail("Передан класс, которого нет в списке: " + mainCategory);
//        }
//        return this.getClass();
//    }

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

//    /**
//     * Классы блока 'Каталог'
//     */
//    public PcAccessoriesPage getPcAccessoriesPage() {
//        if (pcAccessoriesPage == null) {
//            pcAccessoriesPage = new PcAccessoriesPage();
//        }
//        return pcAccessoriesPage;
//    }
//
//    public PeripheryPage getPeripheryPage() {
//        if (peripheryPage == null) {
//            peripheryPage = new PeripheryPage();
//        }
//        return peripheryPage;
//    }
//
//    /**
//     * Блоки. Классы подмодулей каталога
//     */
//    public PcAccessoriesPageBlockManager getPcAccessoriesPageBlockManager() {
//        if (pcAccessoriesPageBlockManager == null) {
//            pcAccessoriesPageBlockManager = new PcAccessoriesPageBlockManager();
//        }
//        return pcAccessoriesPageBlockManager;
//    }
//
//    public PeripheryPageBlock getPeripheryPageBlock() {
//        if (peripheryPageBlock == null) {
//            peripheryPageBlock = new PeripheryPageBlock();
//        }
//        return peripheryPageBlock;
//    }


}
