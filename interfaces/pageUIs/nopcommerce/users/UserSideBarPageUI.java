package pageUIs.nopcommerce.users;

public class UserSideBarPageUI {
    public static final String ADDRESS_LINK = "xpath=//li[contains(@class,'customer-address')]";

    public static final String ORDERS_LINK = "xpath=//li[contains(@class,'customer-orders')]";

    public static final String DOWNLOADABLE_PRODUCTS_LINK = "xpath=//li[contains(@class,'downloadable-products')]";

    public static final String BACK_IN_STOCK_SUBSCRIPTIONS_LINK = "xpath=//li[contains(@class,'back-in-stock-subscriptions')]";

    public static final String REWARD_POINTS_LINK = "xpath=//li[contains(@class,'reward-points')]";

    public static final String CHANGE_PASSWORD_LINK = "xpath=//li[contains(@class,'change-password')]";

    public static final String MY_PRODUCT_REVIEWS_LINK = "xpath=//li[contains(@class,'customer-reviews')]";

    // Dynamic Page Locator
    public static final String DYNAMIC_NAVIGATION_PAGE_LINK = "xpath=//li[contains(@class,'%s')]";
}
