package com.nopcommerce.users;

import commons.BaseTest;
import org.openqa.selenium.By;
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

public class Level_19_Pattern_Object extends BaseTest {
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
        System.out.println(driver);
    }

    @Test
    public void User_01_Register() {
        System.out.println(driver);
        driver.findElement(By.xpath("//a[@class='ico-register']")).click();

        homePage.waitForLinkByClassToClick(driver,"ico-register");

        homePage.clickToLinkByClass(driver, "ico-register");
        registerPage = PageGenerator.getUserRegisterPage(driver);

        registerPage.waitForRadioByIDToClick(driver, "gender-male");

        registerPage.checkRadioByID(driver,"gender-male");

        registerPage.sendkeyToTextboxByID(driver,"FirstName",firstName);

        registerPage.sendkeyToTextboxByID(driver,"LastName",lastName);

        registerPage.sendkeyToTextboxByID(driver,"Email",email);

        registerPage.sendkeyToTextboxByID(driver,"Company",companyName);

        registerPage.sendkeyToTextboxByID(driver,"Password",password);

        registerPage.sendkeyToTextboxByID(driver,"ConfirmPassword",password);

        registerPage.clickToButtonByText(driver,"Register");

        Assert.assertEquals(registerPage.getRegisterSuccessMessageText(),"Your registration completed");

        registerPage.clickToButtonByText(driver,"Continue");
        homePage = PageGenerator.getUserHomePage(driver);

//        homePage.waitForLogoutLinkToClick();
//        homePage.waitForLinkByClassToClick("className");

        homePage.clickToLinkByClass(driver,"ico-logout");

    }

    @Test
    public void User_02_Login() {

        loginPage = PageGenerator.getUserLoginPage(driver);

        loginPage.sendkeyToTextboxByID(driver,"Email",email);

        loginPage.sendkeyToTextboxByID(driver,"Password",password);

        loginPage.clickToButtonByText(driver,"Login");

        homePage = PageGenerator.getUserHomePage(driver);

        Assert.assertTrue(homePage.isDisplayedMyAccountLink());
    }



    @AfterClass(alwaysRun = true)
    public void afterClass() {
        //driver.quit();
        closeBrowserDriver();
    }
}
