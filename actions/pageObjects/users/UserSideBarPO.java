package pageObjects.users;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageObjects.PageGenerator;
import pageObjects.users.sidebar.*;
import pageUIs.users.UserSideBarPageUI;

public class UserSideBarPO extends BasePage {
    private WebDriver driver;
    public UserSideBarPO(WebDriver driver) {
        this.driver = driver;
    }

    public UserAddressPO openAddressPage() {
        waitForElementClickable(driver, UserSideBarPageUI.ADDRESS_LINK);
        clickToElement(driver, UserSideBarPageUI.ADDRESS_LINK);
        return PageGenerator.getUserAddressPage(driver);
    }

    public UserBackInStockSubscriptionsPO openBackInStockSubscriptionsPage() {
        waitForElementClickable(driver, UserSideBarPageUI.BACK_IN_STOCK_SUBSCRIPTIONS_LINK);
        clickToElement(driver, UserSideBarPageUI.BACK_IN_STOCK_SUBSCRIPTIONS_LINK);
        return PageGenerator.getUserBackInStockSubscriptionsPage(driver);
    }

    public UserChangePasswordPO openChangePasswordPage() {
        waitForElementClickable(driver, UserSideBarPageUI.CHANGE_PASSWORD_LINK);
        clickToElement(driver, UserSideBarPageUI.CHANGE_PASSWORD_LINK);
        return PageGenerator.getUserChangePasswordPage(driver);
    }

    public UserDownloadableProductsPO openDownloadableProductsPage() {
        waitForElementClickable(driver, UserSideBarPageUI.DOWNLOADABLE_PRODUCTS_LINK);
        clickToElement(driver, UserSideBarPageUI.DOWNLOADABLE_PRODUCTS_LINK);
        return PageGenerator.getUserDownloadableProductsPage(driver);
    }

    public UserMyProductReviewsPO openMyProductReviewsPage() {
        waitForElementClickable(driver, UserSideBarPageUI.MY_PRODUCT_REVIEWS_LINK);
        clickToElement(driver, UserSideBarPageUI.MY_PRODUCT_REVIEWS_LINK);
        return PageGenerator.getUserMyProductReviewsPage(driver);
    }

    public UserOrdersPO openOrdersPage() {
        waitForElementClickable(driver, UserSideBarPageUI.ORDERS_LINK);
        clickToElement(driver, UserSideBarPageUI.ORDERS_LINK);
        return PageGenerator.getUserOrdersPage(driver);
    }

    public UserRewardPointsPO openRewardPointsPage() {
        waitForElementClickable(driver, UserSideBarPageUI.REWARD_POINTS_LINK);
        clickToElement(driver, UserSideBarPageUI.REWARD_POINTS_LINK);
        return PageGenerator.getUserRewardPointsPage(driver);
    }
}
