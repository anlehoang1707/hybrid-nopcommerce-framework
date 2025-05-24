package com.bankguru99.customer;

import commons.BaseTest;
import org.aspectj.lang.annotation.After;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.bankguru99.LoginPO;
import pageObjects.bankguru99.PageGenerator;
import pageObjects.bankguru99.customer.AddNewCustomerPO;

public class Customer_01 extends BaseTest {
    private WebDriver driver;
    private LoginPO loginPage;
    private AddNewCustomerPO addNewCustomerPage;
    private String username, password;

    @Parameters({"browser","url"})
    @BeforeClass
    public void beforeClass(String browserName, String url) {
        driver = getBrowser(browserName,url);
        loginPage = PageGenerator.getLoginPage(driver);
        username = "mngr623488";
        password = "nYgEqem";

    }

    @Test
    public void Customer_01_Add_New_Employee() {
        loginPage.sendKeyToTextBoxByTdText(driver,"UserID",username);
        loginPage.sendKeyToTextBoxByTdText(driver,"Password",password);
        loginPage.clickToLoginButton();

    }

    @AfterClass
    public void afterClass() {
        closeBrowserDriver();
    }
}
