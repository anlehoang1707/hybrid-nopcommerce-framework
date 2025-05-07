package com.nopcommerce.users;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageFactory.CustomerInfoPageFactory;
import pageFactory.HomePageFactory;
import pageFactory.LoginPageFactory;
import pageFactory.RegisterPageFactory;

public class Level_05_PageFactory extends BaseTest {
    WebDriver driver;
    CustomerInfoPageFactory customerInfoPageFactory;
    HomePageFactory homePageFactory;
    LoginPageFactory loginPageFactory;
    RegisterPageFactory registerPageFactory;
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
        HomePageFactory homePage = new HomePageFactory(driver);
        homePage.waitForRegisterLinkToClick();
        homePage.clickToRegisterLink();

        RegisterPageFactory registerPage = new RegisterPageFactory(driver);
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
        HomePageFactory homePage = new HomePageFactory(driver);
        homePage.waitForLoginLinkToClick();
        homePage.clickToLoginLink();

        LoginPageFactory loginPage = new LoginPageFactory(driver);
        loginPage.inputToEmailTextBox(email);
        loginPage.inputToPasswordTextBox(password);
        loginPage.clickToLoginButton();

        Assert.assertTrue(homePage.isDisplayedMyAccountLink());
        homePage.clickToMyAccountLink();
    }

    @Test
    public void User_03_CustomerInfo() {
        CustomerInfoPageFactory customerInfoPage = new CustomerInfoPageFactory(driver);
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
