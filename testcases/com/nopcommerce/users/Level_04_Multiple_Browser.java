package com.nopcommerce.users;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.CustomerInfoPageObject;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.RegisterPageObject;

import java.time.Duration;

public class Level_04_Multiple_Browser extends BaseTest {
    WebDriver driver;
    CustomerInfoPageObject customerInfoPageObject;
    HomePageObject homePage;
    LoginPageObject loginPage;
    RegisterPageObject registerPage;
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
        HomePageObject homePage = new HomePageObject(driver);
        homePage.waitForRegisterLinkToClick();
        homePage.clickToRegisterLink();

        RegisterPageObject registerPage = new RegisterPageObject(driver);
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
        HomePageObject homePage = new HomePageObject(driver);
        homePage.waitForLoginLinkToClick();
        homePage.clickToLoginLink();

        LoginPageObject loginPage = new LoginPageObject(driver);
        loginPage.inputToEmailTextBox(email);
        loginPage.inputToPasswordTextBox(password);
        loginPage.clickToLoginButton();

        Assert.assertTrue(homePage.isDisplayedMyAccountLink());
        homePage.clickToMyAccountLink();
    }

    @Test
    public void User_03_CustomerInfo() {
        CustomerInfoPageObject customerInfoPage = new CustomerInfoPageObject(driver);
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
