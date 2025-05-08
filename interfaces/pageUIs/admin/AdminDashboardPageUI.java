package pageUIs.admin;

public class AdminDashboardPageUI {
    public static final String PROMOTIONS_NAVIGATION_LINK = "xpath=//p[contains(text(),'Promotions')]//parent::a";

    public static final String PROMOTIONS_NAVIGATION_CHILDREN_LINKS = "xpath=//p[contains(text(),'Promotions')]//parent::a//following-sibling::ul//a";
}
