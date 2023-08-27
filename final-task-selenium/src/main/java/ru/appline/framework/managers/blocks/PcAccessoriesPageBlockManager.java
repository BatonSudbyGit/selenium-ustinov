package ru.appline.framework.managers.blocks;

import ru.appline.framework.pages.categories.psaccessories.VideoCardsPage;

import static org.junit.jupiter.api.Assertions.fail;

public class PcAccessoriesPageBlockManager {

    private static PcAccessoriesPageBlockManager pcAccessoriesPageBlockManager;

    private VideoCardsPage videoCardsPage;

    public Class<?> getClassSubCategoryOfPcAccessories(String subCategory) {
        switch (subCategory) {
            case "Видеокарты":
                getVideoCardsPage();
                break;
            case "Оперативная память":
                break;
            default:
                fail("Передан класс, которого нет в списке: " + subCategory);
        }
        return this.getClass();
    }

    public VideoCardsPage getVideoCardsPage() {
        if (videoCardsPage == null) {
            videoCardsPage = new VideoCardsPage();
        }
        return videoCardsPage;
    }
}
