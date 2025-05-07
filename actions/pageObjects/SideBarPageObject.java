package pageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageObjects.sidebar.*;
import pageUIs.SideBarPageUI;

public class SideBarPageObject extends BasePage {
    private WebDriver driver;
    public SideBarPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public AddressPageObject openAddressPage() {
        waitForElementClickable(driver, SideBarPageUI.ADDRESS_LINK, 15);
        clickToElement(driver, SideBarPageUI.ADDRESS_LINK);
        return PageGenerator.getAddressPage(driver);
    }

    public BackInStockSubscriptionsPageObject openBackInStockSubscriptionsPage() {
        waitForElementClickable(driver, SideBarPageUI.BACK_IN_STOCK_SUBSCRIPTIONS_LINK, 15);
        clickToElement(driver, SideBarPageUI.BACK_IN_STOCK_SUBSCRIPTIONS_LINK);
        return PageGenerator.getBackInStockSubscriptionsPage(driver);
    }

    public ChangePasswordPageObject openChangePasswordPage() {
        waitForElementClickable(driver, SideBarPageUI.CHANGE_PASSWORD_LINK, 15);
        clickToElement(driver, SideBarPageUI.CHANGE_PASSWORD_LINK);
        return PageGenerator.getChangePasswordPage(driver);
    }

    public DownloadableProductsPageObject openDownloadableProductsPage() {
        waitForElementClickable(driver, SideBarPageUI.DOWNLOADABLE_PRODUCTS_LINK, 15);
        clickToElement(driver, SideBarPageUI.DOWNLOADABLE_PRODUCTS_LINK);
        return PageGenerator.getDownloadableProductsPage(driver);
    }

    public MyProductReviewsPageObject openMyProductReviewsPage() {
        waitForElementClickable(driver, SideBarPageUI.MY_PRODUCT_REVIEWS_LINK, 15);
        clickToElement(driver, SideBarPageUI.MY_PRODUCT_REVIEWS_LINK);
        return PageGenerator.getMyProductReviewsPage(driver);
    }

    public OrdersPageObject openOrdersPage() {
        waitForElementClickable(driver, SideBarPageUI.ORDERS_LINK, 15);
        clickToElement(driver, SideBarPageUI.ORDERS_LINK);
        return PageGenerator.getOrdersPage(driver);
    }

    public RewardPointsPageObject openRewardPointsPage() {
        waitForElementClickable(driver, SideBarPageUI.REWARD_POINTS_LINK, 15);
        clickToElement(driver, SideBarPageUI.REWARD_POINTS_LINK);
        return PageGenerator.getRewardPointsPage(driver);
    }
}
