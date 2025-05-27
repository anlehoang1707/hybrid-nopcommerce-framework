package com.saucelab;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.saucelab.LoginPO;
import pageObjects.saucelab.PageGenerator;
import pageObjects.saucelab.ProductListPO;

public class Product_01_Sort extends BaseTest {
    private WebDriver driver;
    private LoginPO loginPage;
    private ProductListPO productListPage;
    private String username;
    private String password;

    @Parameters({"browser","url"})
    @BeforeClass
    public void beforeClass(String browserName,String url) {
        driver = getBrowser(browserName,url);
        username = "standard_user";
        password = "secret_sauce";

        loginPage = PageGenerator.getLoginPage(driver);

        productListPage = loginPage.loginToSystem(username,password);

    }

    @Test
    public void Product_01_Sort_Asc_By_Product_Name() {
        productListPage.clickToSortByProductNameAsc();

        Assert.assertTrue(productListPage.isProductNameDataSortedAsc());
    }

    @Test
    public void Product_02_Sort_Desc_By_Product_Name() {
        productListPage.clickToSortProductNameDsc();

        Assert.assertTrue(productListPage.isProductNameDataSortedDsc());

    }

    @Test
    public void Product_03_Sort_Asc_By_Price() {
        productListPage.clickToSortPriceAsc();

        Assert.assertTrue(productListPage.isProductPriceDataSortedAsc());

    }

    @Test
    public void Product_03_Sort_Dsc_By_Price() {
        productListPage.clickToSortPriveDsc();

        Assert.assertTrue(productListPage.isProductPriceDataSortedDsc());

    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        closeBrowserDriver();
    }
}
