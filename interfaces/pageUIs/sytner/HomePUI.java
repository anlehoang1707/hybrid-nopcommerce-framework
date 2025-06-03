package pageUIs.sytner;

public class HomePUI {

    public static final String ACCEPT_ALL_COOKIES_BUTTON = "css=button#onetrust-accept-btn-handler";

    public static final String DYNAMIC_NAV_LINK_BY_CATEGORY_NAME_AND_SUB_CATEGORY_NAME = "Xpath=//footer//h6[text()='%s']//following-sibling::nav//a[text() ='%s']";

    public static final String DYNAMIC_NAV_LINK_BY_SUB_CATEGORY_NAME = "Xpath=//footer//h6//following-sibling::nav//a[text() ='%s']";

    public static final String DYNAMIC_MENU_ITEM_LINK_BY_SUB_CATEGORY_NAME = "Xpath=//h6//following-sibling::ul//a[text() ='%s']";

    public static final String OPEN_MENU_BUTTON = "Xpath=//button[@title = 'Open Menu']";

    public static final String DYNAMIC_MENU_ITEM_LINK_BY_BRAND_NAME = "Xpath=//ul[@role = 'tablist']//following-sibling::div//nav//ul//a[text() ='%s']";
}
