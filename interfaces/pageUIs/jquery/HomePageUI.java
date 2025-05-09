package pageUIs.jquery;

public class HomePageUI {
    public static final String DYNAMIC_PAGE_BUTTON_LINK ="xpath=//a[contains(@class, 'qgrd-pagination-page-link') and text()='%s']";

    public static final String DYNAMIC_HEADER_SEARCH_TEXT_BOX = "xpath=//div[contains(@class,'qgrd-header-text') and text() = '%s']//parent::div//following-sibling::input";

    public static final String LOAD_DATA_BUTTON = "css=button#load";
    public static final String DYNAMIC_PRECEDING_SIBLING_COLUMN_NUMBER = "xpath=//th[text()='%s']//preceding-sibling::th";

    public static final String DYNAMIC_INPUT_BY_ROW_AND_COLUMN_INDEX = "xpath=//tr[%s]//td[%s]//input";

    public static final String DYNAMIC_DROPDOWN_BY_ROW_AND_COLUMN_INDEX = "xpath=//tr[%s]//td[%s]//select";

    public static final String DYNAMIC_ACTION_BY_ROW_INDEX_AND_ACTION_TITLE = "xpath=//tr[%s]//td//button[contains(@title,'%s')]";

    public static final String
    DYNAMIC_CHECKBOX_BY_ROW_AND_COLUMN_INDEX = "xpath=//tr[%s]//td[%s]//input[@type='checkbox']";

    public static final String DYNAMIC_CELL_BY_ROW_AND_COLUMN_INDEX = "xpath=//tr[%s]//td[%s]";

    public static final String ROW_DATA_BY_COLUMN_INDEX = "xpath=//tr//td[%s]";

}
