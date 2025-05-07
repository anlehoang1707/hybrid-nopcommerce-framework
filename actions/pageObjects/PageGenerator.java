package pageObjects;

import org.openqa.selenium.WebDriver;
import pageObjects.admin.AdminDashboardPO;
import pageObjects.admin.AdminLoginPO;
import pageObjects.users.UserCustomerInfoPO;
import pageObjects.users.UserHomePO;
import pageObjects.users.UserLoginPO;
import pageObjects.users.UserRegisterPO;
import pageObjects.users.sidebar.*;

public class PageGenerator {
    public static UserHomePO getUserHomePage(WebDriver driver) {
        return new UserHomePO(driver);
    }

    public static UserLoginPO getUserLoginPage(WebDriver driver) {
        return new UserLoginPO(driver);
    }

    public static UserRegisterPO getUserRegisterPage(WebDriver driver) {
        return new UserRegisterPO(driver);
    }

    public static UserCustomerInfoPO getUserCustomerInfoPage(WebDriver driver) {
        return new UserCustomerInfoPO(driver);
    }

    public static UserAddressPO getUserAddressPage(WebDriver driver) {
        return new UserAddressPO(driver);
    }


    public static UserBackInStockSubscriptionsPO getUserBackInStockSubscriptionsPage(WebDriver driver) {
        return new UserBackInStockSubscriptionsPO(driver);
    }


    public static UserChangePasswordPO getUserChangePasswordPage(WebDriver driver) {
        return new UserChangePasswordPO(driver);
    }


    public static UserDownloadableProductsPO getUserDownloadableProductsPage(WebDriver driver) {
        return new UserDownloadableProductsPO(driver);
    }


    public static UserMyProductReviewsPO getUserMyProductReviewsPage(WebDriver driver) {
        return new UserMyProductReviewsPO(driver);
    }


    public static UserOrdersPO getUserOrdersPage(WebDriver driver) {
        return new UserOrdersPO(driver);
    }


    public static UserRewardPointsPO getUserRewardPointsPage(WebDriver driver) {
        return new UserRewardPointsPO(driver);
    }

    public static AdminDashboardPO getAdminDashboardPage(WebDriver driver) {
        return new AdminDashboardPO(driver);
    }

    public static AdminLoginPO getAdminLoginPage(WebDriver driver) {
        return new AdminLoginPO(driver);
    }

}
