package com.nopcommerce.users;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.nopcommerce.PageGenerator;
import pageObjects.nopcommerce.admin.AdminDashboardPO;
import pageObjects.nopcommerce.admin.AdminLoginPO;
import pageObjects.nopcommerce.users.UserCustomerInfoPO;
import pageObjects.nopcommerce.users.UserHomePO;
import pageObjects.nopcommerce.users.UserLoginPO;
import pageObjects.nopcommerce.users.UserRegisterPO;
import pageObjects.nopcommerce.users.sidebar.*;

public class Level_09_Switch_Site_Url extends BaseTest {


    private String firstName, lastName, email, password, companyName;
    private String adminUrl, userUrl,adminUserName,adminPassword;


    @Parameters({"browser","adminUrl","userUrl"})
    @BeforeClass
    public void beforeClass(String browserName,String adminUrl, String userUrl) {
        this.adminUrl = adminUrl;
        this.userUrl = userUrl;

        driver = getBrowser(browserName,this.userUrl);

        userHomePage = PageGenerator.getUserHomePage(driver);
        firstName = "An";
        lastName = "Le";
        email = "anle" + generateRandom() + "@gmail.com";
        password = "12345678";
        companyName ="Alex";
        adminUserName ="admin@yourstore.com";
        adminPassword = "admin";


        userHomePage.waitForRegisterLinkToClick();
        userRegisterPage = userHomePage.openRegisterPage();

        userRegisterPage.waitForMaleRadioClickable();
        userRegisterPage.checkMaleRadio();
        userRegisterPage.inputToFirstNameTextBox(firstName);
        userRegisterPage.inputToLastNameTextBox(lastName);
        userRegisterPage.inputToEmailTextBox(email);
        userRegisterPage.inputToCompanyTextBox(companyName);
        userRegisterPage.inputToPasswordTextBox(password);
        userRegisterPage.inputToConfirmPasswordTextBox(password);
        userRegisterPage.clickToRegisterButton();
        Assert.assertEquals(userRegisterPage.getRegisterSuccessMessageText(),"Your registration completed");

        userHomePage = userRegisterPage.clickToContinueButton();
        userHomePage.waitForLogoutLinkToClick();
        userHomePage.clickToLogoutLink();
    }



    @Test
    public void Role_01_User_Site_Switch_To_Admin_Site() {
        userHomePage.waitForLoginLinkToClick();

        userLoginPage = userHomePage.openLoginPage();
        userLoginPage.inputToEmailTextBox(email);
        userLoginPage.inputToPasswordTextBox(password);
        userHomePage = userLoginPage.clickToLoginButton();

        Assert.assertTrue(userHomePage.isDisplayedMyAccountLink());

        userCustomerInfoPage = userHomePage.openCustomerInfoPage();

        userCustomerInfoPage.openPageUrl(driver,this.adminUrl);

        adminLoginPage = PageGenerator.getAdminLoginPage(driver);

        adminLoginPage.inputUserNameTextBox(adminUserName);
        adminLoginPage.inputPasswordTextBox(adminPassword);
        adminDashboardPage = adminLoginPage.clickToLoginButton();

    }

    @Test
    public void Role_02_Admin_Site_Switch_To_User_Site() {
        adminDashboardPage.clickToPromotionNavigationLink();

        Assert.assertEquals(adminDashboardPage.getChildrenCountInPromotionNavigationLink(),4);

        adminDashboardPage.openPageUrl(driver,this.userUrl);

        Assert.assertTrue(userHomePage.isDisplayedMyAccountLink());

    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

    WebDriver driver;
    UserCustomerInfoPO userCustomerInfoPage;
    UserHomePO userHomePage;
    UserLoginPO userLoginPage;
    UserRegisterPO userRegisterPage;
    UserAddressPO userAddressPage;
    UserBackInStockSubscriptionsPO userBackInStockSubscriptionsPage;
    UserChangePasswordPO userChangePasswordPage;
    UserDownloadableProductsPO userDownloadableProductsPage;
    UserMyProductReviewsPO userMyProductReviewsPage;
    UserOrdersPO userOrdersPO;
    UserRewardPointsPO userRewardPointsPage;
    AdminLoginPO adminLoginPage;
    AdminDashboardPO adminDashboardPage;
}
