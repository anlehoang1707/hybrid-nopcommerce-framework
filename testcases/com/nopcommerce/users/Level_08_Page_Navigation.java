package com.nopcommerce.users;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.nopcommerce.PageGenerator;
import pageObjects.nopcommerce.users.UserCustomerInfoPO;
import pageObjects.nopcommerce.users.UserHomePO;
import pageObjects.nopcommerce.users.UserLoginPO;
import pageObjects.nopcommerce.users.UserRegisterPO;
import pageObjects.nopcommerce.users.sidebar.*;

public class Level_08_Page_Navigation extends BaseTest {
    WebDriver driver;
    UserCustomerInfoPO customerInfoPage;
    UserHomePO homePage;
    UserLoginPO loginPage;
    UserRegisterPO registerPage;
    UserAddressPO addressPage;
    UserBackInStockSubscriptionsPO userBackInStockSubscriptionsPO;
    UserChangePasswordPO changePasswordPage;
    UserDownloadableProductsPO downloadableProductsPage;
    UserMyProductReviewsPO myProductReviewsPage;
    UserOrdersPO ordersPage;
    UserRewardPointsPO rewardPointsPage;

    private String firstName, lastName, email, password, companyName;


    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browserName) {
        driver = getBrowser(browserName);
        homePage = PageGenerator.getUserHomePage(driver);
        firstName = "An";
        lastName = "Le";
        email = "anle" + generateRandom() + "@gmail.com";
        password = "12345678";
        companyName ="Alex";
    }

    @Test
    public void User_01_Register() {
        homePage.waitForRegisterLinkToClick();
        registerPage = homePage.openRegisterPage();

        registerPage.waitForMaleRadioClickable();
        registerPage.checkMaleRadio();
        registerPage.inputToFirstNameTextBox(firstName);
        registerPage.inputToLastNameTextBox(lastName);
        registerPage.inputToEmailTextBox(email);
        registerPage.inputToCompanyTextBox(companyName);
        registerPage.inputToPasswordTextBox(password);
        registerPage.inputToConfirmPasswordTextBox(password);
        registerPage.clickToRegisterButton();
        Assert.assertEquals(registerPage.getRegisterSuccessMessageText(),"Your registration completed");

        homePage = registerPage.clickToContinueButton();
        homePage.waitForLogoutLinkToClick();
        homePage.clickToLogoutLink();
    }

    @Test
    public void User_02_Login() {
        homePage.waitForLoginLinkToClick();

        loginPage = homePage.openLoginPage();
        loginPage.inputToEmailTextBox(email);
        loginPage.inputToPasswordTextBox(password);
        homePage = loginPage.clickToLoginButton();

        Assert.assertTrue(homePage.isDisplayedMyAccountLink());
    }

    @Test
    public void User_03_CustomerInfo() {
        customerInfoPage = homePage.openCustomerInfoPage();
        Assert.assertTrue(customerInfoPage.isMaleRadioSelected());
        Assert.assertTrue(customerInfoPage.isFirstNameDisplayed(firstName));
        Assert.assertTrue(customerInfoPage.isLastNameDisplayed(lastName));
        Assert.assertTrue(customerInfoPage.isEmailDisplayed(email));
        Assert.assertTrue(customerInfoPage.isCompanyDisplayed(companyName));
    }

    @Test
    public void User_04_Switch_Page() {
        addressPage = customerInfoPage.openAddressPage(driver);

        myProductReviewsPage = addressPage.openMyProductReviewsPage();

        ordersPage = myProductReviewsPage.openOrdersPage();

        downloadableProductsPage = ordersPage.openDownloadableProductsPage();

        addressPage = downloadableProductsPage.openAddressPage();

        myProductReviewsPage = addressPage.openMyProductReviewsPage();

    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
