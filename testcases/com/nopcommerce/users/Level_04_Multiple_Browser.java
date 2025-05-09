package com.nopcommerce.users;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.nopcommerce.users.UserCustomerInfoPO;
import pageObjects.nopcommerce.users.UserHomePO;
import pageObjects.nopcommerce.users.UserLoginPO;
import pageObjects.nopcommerce.users.UserRegisterPO;

public class Level_04_Multiple_Browser extends BaseTest {
    WebDriver driver;
    UserCustomerInfoPO customerInfoPage;
    UserHomePO homePage;
    UserLoginPO loginPage;
    UserRegisterPO registerPage;
    private String firstName, lastName, email, password, companyName;

    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browserName) {
        driver = getBrowser(browserName);
        firstName = "An";
        lastName = "Le";
        email = "anle" + generateRandom() + "@gmail.com";
        password = "12345678";
        companyName ="Alex";
    }

    @Test
    public void User_01_Register() {
        UserHomePO homePage = new UserHomePO(driver);
        homePage.waitForRegisterLinkToClick();
        homePage.openRegisterPage();

        UserRegisterPO registerPage = new UserRegisterPO(driver);
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
        registerPage.clickToContinueButton();

        homePage.waitForLogoutLinkToClick();
        homePage.clickToLogoutLink();
    }

    @Test
    public void User_02_Login() {
        UserHomePO homePage = new UserHomePO(driver);
        homePage.waitForLoginLinkToClick();
        homePage.openLoginPage();

        UserLoginPO loginPage = new UserLoginPO(driver);
        loginPage.inputToEmailTextBox(email);
        loginPage.inputToPasswordTextBox(password);
        loginPage.clickToLoginButton();

        Assert.assertTrue(homePage.isDisplayedMyAccountLink());
        homePage.openCustomerInfoPage();
    }

    @Test
    public void User_03_CustomerInfo() {
        UserCustomerInfoPO customerInfoPage = new UserCustomerInfoPO(driver);
        Assert.assertTrue(customerInfoPage.isMaleRadioSelected());
        Assert.assertTrue(customerInfoPage.isFirstNameDisplayed(firstName));
        Assert.assertTrue(customerInfoPage.isLastNameDisplayed(lastName));
        Assert.assertTrue(customerInfoPage.isEmailDisplayed(email));
        Assert.assertTrue(customerInfoPage.isCompanyDisplayed(companyName));
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
