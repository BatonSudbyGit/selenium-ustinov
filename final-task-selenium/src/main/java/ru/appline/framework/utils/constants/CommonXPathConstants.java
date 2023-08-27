package ru.appline.framework.utils.constants;

public class CommonXPathConstants {

    public static final String CATALOG_BUTTON_XPATH = "//span[text()='Каталог']/..";

    public static final String TITLE_OF_SUB_CATEGORY_XPATH = "//h1[text()='%s']";

    public static final String LIST_OF_SUB_CATEGORY_XPATH= "//a[contains(@class,'CardCategory_wrap')]";

    public static final String FILTERS_BLOCK_XPATH = "//section[contains(@class,'Dropdown_wrap__llzLj Dropdown_wrap_open')]";

    public static final String PRICE_INPUT_FIELD_XPATH = "//input[contains(@class,'RangeSelector_input') and @name='%s']";

    public static final String MANUFACTURER_INPUT_FIELD_XPATH = "//span[text()='Производитель']/../../../..//input[contains(@class,'Input_input') and @placeholder='Поиск']";

    public static final String QUICK_SELECTION_PANEL_II_NOT_SKELETON_XPATH = "//div[contains(@class,'ExpandableTags_tagsRow')]";

    public static final String LIST_PRODUCTS_XPATH = "//div[contains(@class,'Card_wrap')]";

    public static final String ELEMENT_OF_LIST_PRODUCTS_XPATH = "//div[contains(@class,'Card_wrap')][%s]//h6";

    public static final String MAIN_SEARCH_INPUT_STRING_XPATH = "//input[contains(@aria-label,'Поиск') and @id='searchInput']";

}
