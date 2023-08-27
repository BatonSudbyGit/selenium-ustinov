package ru.appline.framework.managers.blocks;

import static org.junit.jupiter.api.Assertions.fail;

public class PeripheryPageBlock {



    public Class<?> getClassSubCategoryOfPeriphery(String subCategory) {
        switch (subCategory) {
            case "Видеокарты":
                break;
            case "Оперативная память":
                break;
            default:
                fail("Передан класс, которого нет в списке: " + subCategory);
        }
        return this.getClass();
    }
}
